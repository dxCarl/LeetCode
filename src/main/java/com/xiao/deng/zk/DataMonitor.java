package com.xiao.deng.zk;

/**
 * @author xiao
 * @date 2020/05/19
 */
import java.util.Arrays;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.data.Stat;

/**
 * 另一方面，DataMonitorListener接口不是ZooKeeper API的一部分。 它是一个完全定制的界面，专为此示例应用程序而设计。
 * DataMonitor对象使用它来回传给它的容器，它也是Executor对象。
 */
public class DataMonitor implements  StatCallback {
    //Executor或一些类似Executor的对象“拥有”ZooKeeper连接，但可以将事件委托给其他事件到其他对象。
    ZooKeeper zk;

    String znode;

    Watcher chainedWatcher;

    boolean dead;
    //简单地将这些事件转发到DataMonitor来决定如何处理它们
    DataMonitorListener listener;

    byte prevData[];
    // 它主要是异步和事件驱动
    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher,
                       DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;
        // Get things started by checking if the node exists. We are going
        // to be completely event driven
        zk.exists(znode, true, this, null);
    }
    /**
     * 该接口在DataMonitor类中定义，并在Executor类中实现。 当调用Executor.exists（）时，执行器根据要求决定是启动还是关闭。
     * 当znode不再存在时，需要说的是杀死可执行文件。
     */
    public interface DataMonitorListener {
        /**
         * The existence status of the node has changed.
         */
        void exists(byte data[]);

        /**
         * The ZooKeeper session is no longer valid.
         *
         * @param rc
         *                the ZooKeeper reason code
         */
        void closing(int rc);
    }
    //响应ZooKeeper状态的更改
    public void process(WatchedEvent event) {
        String path = event.getPath();
        if (event.getType() == Watcher.Event.EventType.None) {
            // We are are being told that the state of the
            // connection has changed
            switch (event.getState()) {
                case SyncConnected:
                    // In this particular example we don't need to do anything
                    // here - watches are automatically re-registered with
                    // server and any watches triggered while the client was
                    // disconnected will be delivered (in order of course)
                    break;
                case Expired:
                    // It's all over
                    dead = true;
                    listener.closing(KeeperException.Code.SessionExpired);
                    break;
            }
        } else {
            if (path != null && path.equals(znode)) {
                // Something has changed on the node, let's find out
                zk.exists(znode, true, this, null);
            }
        }
        if (chainedWatcher != null) {
            chainedWatcher.process(event);
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
/**
 * 首先检查znode存在，致命错误和可恢复错误的错误代码。
 * 如果文件（或znode）存在，它将从znode获取数据，然后调用Executor的exists（）回调，
 * 如果状态已更改。 注意，它不必对getData调用执行异常处理，因为它具有挂起的任何可能导致错误的监视器：
 * 如果节点在调用ZooKeeper.getData（）之前被删除，则由ZooKeeper设置的监视事件 .exists（）触发回调;
 *如果发生通信错误，连接回显将触发连接监视事件。
 */
        boolean exists;
        switch (rc) {
            case Code.Ok:
                exists = true;
                break;
            case Code.NoNode:
                exists = false;
                break;
            case Code.SessionExpired:
            case Code.NoAuth:
                dead = true;
                listener.closing(rc);
                return;
            default:
                // Retry errors
                zk.exists(znode, true, this, null);
                return;
        }
        //文件（或znode）存在
        byte b[] = null;
        if (exists) {
            try {
                b = zk.getData(znode, false, null);
            } catch (KeeperException e) {
                // We don't need to worry about recovering now. The watch
                // callbacks will kick off any exception handling
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }
        if ((b == null && b != prevData)
                || (b != null && !Arrays.equals(prevData, b))) {
            listener.exists(b);
            prevData = b;
        }
    }
}
