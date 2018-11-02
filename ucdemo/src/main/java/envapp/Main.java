package envapp;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author luowei
 * @date 2018-10-29 10:21
 */
public class Main {

    public static void main(String[] args) {
        final List<DeployThread> deployThreadList = getDevApp();
//        final List<DeployThread> deployThreadList = getDebugApp();
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,32,
                30, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                for(DeployThread deployThread : deployThreadList){
                    poolExecutor.submit(deployThread);
                }
            }
        }, 0,30, TimeUnit.SECONDS);
    }
    public static List<DeployThread> getDevApp(){
        return DevelopApp.getDeployAppList();
    }
    public static List<DeployThread> getDebugApp(){
        return DebugApp.getDeployAppList();
    }

}
