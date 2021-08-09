package com.xiao.deng.base;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiao
 * @date 2020/09/09
 */
@Slf4j
public class LockUtil {
    private static LockUtil instance = new LockUtil();
    private Cache<LockKey, ReentrantReadWriteLock.WriteLock> mutexLockCache = CacheBuilder.newBuilder().build();

    public static LockUtil getInstance() {
        return instance;
    }
    /**
     * 批量获取锁
     *
     * @param keys
     * @param type 类别
     * @return 成功获取到锁的列表
     */
    public List<Long> defaultBatchTryLock(List<Long> keys, String type) {
        if (null == keys ||keys.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Long> successQueue = new ArrayList<>(keys.size());
        keys.forEach(id -> {
            boolean lock = tryLock(id, type, 2000, TimeUnit.MILLISECONDS);
            if (lock) {
                successQueue.add(id);
            } else {
//                log.error("try lock key failed , lock key :{}, type: {}", id, type);
            }
        });
//        log.info("batch try lock total count: {}, success count:{}, success keys: {}", keys.size(), successQueue.size(),
//                StringUtils.join(new List[]{successQueue}, ","));
        return successQueue;
    }

    public void defaultBatchUnlock(List<Long> keys, String type) {
        keys.forEach(id -> {
            mutexUnlock(id, type);
        });
    }

    public boolean tryLock(Long key, String type, long time, TimeUnit unit) {
        LockKey<Long> lockKey = new LockKey<>(key, type);
        ReentrantReadWriteLock.WriteLock lock = getLock(lockKey);
        if (null == lock) {
            return false;
        }
        try {
            boolean res = null != lock ? lock.tryLock(time, unit) : false;
            if (res) {
//                log.info("current thread name: {}, try lock success, lock key: {}, thread name: {}",
//                        Thread.currentThread().getName(), lockKey.toString(), Thread.currentThread().getName());
            } else {
//                log.warn("current thread name: {}, try lock failed, lock key: {}, thread name: {}",
//                        Thread.currentThread().getName(), lockKey.toString(), Thread.currentThread().getName());
            }
            return res;
        } catch (InterruptedException e) {
//            log.warn("current thread name: {}, try lock error, lock key : {}, err msg : {}",
//                    Thread.currentThread().getName(), lockKey.toString(), e.getMessage());
            return false;
        }
    }

    public void mutexUnlock(Long key, String type) {
        LockKey<Long> lockKey = new LockKey<>(key, type);
        mutexUnlock(lockKey);
    }
    public void mutexUnlock(LockKey<Long> lockKey) {
        ReentrantReadWriteLock.WriteLock lock = getLock(lockKey);
        if (null != lock) {
            try {
                lock.unlock();
//                log.info("current thread name: {}, unlock success, lock key: {}, thread name: {}",
//                        Thread.currentThread().getName(), lockKey.toString(), Thread.currentThread().getName());
            } catch (Exception e) {
//                log.warn("current thread name: {}, unlock error, lock key: {}, thread name: {}",
//                        Thread.currentThread().getName(), lockKey.toString(), Thread.currentThread().getName());
            }
            mutexLockCache.invalidate(lockKey);
        }
    }

    private ReentrantReadWriteLock.WriteLock getLock(Long key, String type) {
        LockKey<Long> lockKey = new LockKey<>(key, type);
        return getLock(lockKey);
    }

    private ReentrantReadWriteLock.WriteLock getLock(LockKey<Long> lockKey) {
        try {
            return mutexLockCache.get(lockKey, () -> new ReentrantReadWriteLock().writeLock());
        } catch (ExecutionException e) {
//            log.warn("current thread name: {}, get lock error, lock key:{}, err msg: {}",
//                    Thread.currentThread().getName(), lockKey.toString(), e);
        }
        ReentrantReadWriteLock.WriteLock lock = mutexLockCache.getIfPresent(lockKey);
        if (null == lock) {
//            log.warn("current thread name: {}, get lock error, lock is null, lock key:{}",
//                    Thread.currentThread().getName(), lockKey.toString());
            return null;
        }
//        log.warn("current thread name: {}, get lock success,lock key:{}, lock:{}",
//                Thread.currentThread().getName(), lockKey.toString(), lock);
        return lock;
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

            if (!key.equals(lockKey.key)) {
                return false;
            }
            return type.equals(lockKey.type);
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

}
