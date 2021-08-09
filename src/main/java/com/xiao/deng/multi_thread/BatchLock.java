package com.xiao.deng.multi_thread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiao
 * @date 2020/09/09
 */
@Slf4j
public class BatchLock<T> {
    private ConcurrentHashMap<LockKey, ReentrantReadWriteLock.WriteLock> mutexLockMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<LockKey, LockVal> reEntrantLockMap = new ConcurrentHashMap<>();

    private static final Integer INIT_LOCK_CNT = 1;

    /**
     * 批量获取锁
     *
     * @param keys
     * @param type 类别
     * @return 成功获取到锁的列表
     */
    public List<T> defaultBatchTryLock(List<T> keys, String type) {
        if (null == keys || keys.size() == 0 ) {
            return Collections.EMPTY_LIST;
        }
        List<T> successQueue = new ArrayList<>(keys.size());
        keys.forEach(id -> {
            boolean lock = tryLock(id, type);
            if (lock) {
                successQueue.add(id);
            } else {
//                log.error("try lock key failed , lock key :{}, type: {}", id, type);
            }
        });
//        log.info("batch try lock total count: {}, success count:{}, success keys: {}", keys.size(), successQueue.size(),
//                StringUtils.join(successQueue, ","));
        return successQueue;
    }

    public void defaultBatchUnlock(List<T> keys, String type) {
        keys.forEach(id -> unlock(id, type));
    }

    public boolean tryLock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        synchronized (key) {
            ReentrantReadWriteLock.WriteLock lock = getWriteLock(lockKey);
            if (null == lock) {
                return false;
            }
            boolean res = null != lock ? lock.tryLock() : false;
            if (res) {
//                log.info("try lock success, lock key: {}", lockKey.toString());
            } else {
//                log.warn("try lock failed, lock key: {}", lockKey.toString());
            }
            return res;
        }
    }

    public void getLock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        synchronized (key) {
            ReentrantReadWriteLock.WriteLock lock = getWriteLock(lockKey);
            lock.lock();
        }
    }

    public boolean tryReEntrantLock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        synchronized (key) {
            LockVal val = getReEntrantLock(lockKey);
            if (null == val) {
                return false;
            }
            return val.getLock().tryLock();
        }
    }
    public void getReEntrantLock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        synchronized (key) {
            LockVal val = getReEntrantLock(lockKey);
            val.getLock().lock();
        }
    }

    public void reEntrantLockUnlock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        synchronized (key) {
            LockVal val = reEntrantLockMap.get(lockKey);
            if (null != val) {
                if (val.getCnt().get() > INIT_LOCK_CNT) {
                    val.getCnt().decrementAndGet();
                }else {
                    reEntrantLockMap.remove(lockKey);
                }
            }
        }
    }

    public void unlock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        unlock(lockKey);
    }

    private void unlock(LockKey<T> lockKey) {
        synchronized (lockKey.key) {
            ReentrantReadWriteLock.WriteLock lock = getFromMap(lockKey);
            if (null != lock) {
                try {
                    lock.unlock();
//                    log.info("unlock success, lock key: {}", lockKey);
                } catch (Exception e) {
//                    log.warn("unlock error, lock key: {},err msg: ", lockKey, e);
                } finally {
                    mutexLockMap.remove(lockKey);
                }
            }
        }
    }

    private ReentrantReadWriteLock.WriteLock getWriteLock(T key, String type) {
        LockKey<T> lockKey = new LockKey<>(key, type);
        return getWriteLock(lockKey);
    }

    private ReentrantReadWriteLock.WriteLock getWriteLock(LockKey<T> lockKey) {
        if (!mutexLockMap.containsKey(lockKey)) {
            ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            mutexLockMap.put(lockKey, writeLock);
        }
        return mutexLockMap.get(lockKey);
    }

    private LockVal getReEntrantLock(LockKey<T> lockKey) {
        if (!reEntrantLockMap.containsKey(lockKey)) {
            ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            LockVal val = new LockVal();
            val.setLock(writeLock);
            val.setCnt(new AtomicInteger(INIT_LOCK_CNT));
            reEntrantLockMap.put(lockKey, val);
        }else {
            LockVal val = reEntrantLockMap.get(lockKey);
            val.getCnt().incrementAndGet();
            reEntrantLockMap.put(lockKey, val);

        }
        return reEntrantLockMap.get(lockKey);
    }

    private ReentrantReadWriteLock.WriteLock getFromMap(LockKey<T> lockKey) {
        return mutexLockMap.get(lockKey);
    }

    private static class LockKey<T> {
        T key;
        String type;

        LockKey() {
        }

        LockKey(T key, String type) {
            this.key = key;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LockKey)) {
                return false;
            }

            LockKey<?> lockKey = (LockKey<?>) o;

            if (!Objects.equals(key, lockKey.key)) {
                return false;
            }
            return Objects.equals(type, lockKey.type);
        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + type.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "LockKey{" +
                    "key=" + key +
                    ", type='" + type + '\'' +
                    '}';
        }

    }

    private static class LockVal{
       private ReentrantReadWriteLock.WriteLock lock;
       private AtomicInteger cnt;

        public ReentrantReadWriteLock.WriteLock getLock() {
            return lock;
        }

        public void setLock(ReentrantReadWriteLock.WriteLock lock) {
            this.lock = lock;
        }

        public AtomicInteger getCnt() {
            return cnt;
        }

        public void setCnt(AtomicInteger cnt) {
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LockVal)) {
                return false;
            }

            LockVal lockVal = (LockVal) o;

            if (lock != null ? !lock.equals(lockVal.lock) : lockVal.lock != null) {
                return false;
            }
            return cnt != null ? cnt.equals(lockVal.cnt) : lockVal.cnt == null;
        }

        @Override
        public int hashCode() {
            int result = lock != null ? lock.hashCode() : 0;
            result = 31 * result + (cnt != null ? cnt.hashCode() : 0);
            return result;
        }
    }


    public static void main(String[] args) {
//        BatchLock<String> batchLock = new BatchLock<>();
//        LockKey<String> key = new LockKey<>("1", "t");
//
//        batchLock.getReEntrantLock("1", "t");
//        batchLock.getReEntrantLock("1", "t");
//        batchLock.reEntrantLockUnlock("1", "t");
//        batchLock.reEntrantLockUnlock("1", "t");
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.writeLock().lock();
        lock.writeLock().unlock();
        lock.writeLock().getHoldCount();
        lock.writeLock().unlock();

        new Thread();

    }

}
