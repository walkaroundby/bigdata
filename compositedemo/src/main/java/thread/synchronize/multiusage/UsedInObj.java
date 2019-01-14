package thread.synchronize.multiusage;

/**
 * 输出结果：2000000
 * synchronized修饰的是实例方法increase，在这样的情况下，当前线程的锁便是实例对象instance。
 * @author luowei
 * @date 2019-01-14 10:37
 */
public class UsedInObj implements Runnable{
    /**
     * 共享资源(临界资源)
     */
    static int i=0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        UsedInObj instance=new UsedInObj();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
