package thread.synchronize;

/**
 * 执行结果：
 开始执行线程t1
 obj开始执行wait()方法
 开始执行线程T2
 obj执行了notify()方法
 线程T2执行结束
 obj结束执行wait()方法
 线程t1执行结束
 * wait和notify的生产消费模式
 * @author luowei
 * @date 2019-01-11 19:25
 */
public class WaitAndNotify{
    static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
    public static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("开始执行线程t1");
            synchronized(obj){
                try {
                    System.out.println("t1中obj开始执行wait()方法");
                    //线程t1执行wait()方法，释放资源锁obj，等待其他线程的唤醒；
                    obj.wait();
                    System.out.println("t1中obj结束执行wait()方法");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程t1执行结束");
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            System.out.println("开始执行线程T2");
            synchronized (obj) {
                try {
                    //唤醒obj的等待线程。但此时还在synchronized里，等方法体内走完5s才释放锁。
                    obj.notify();
                    System.out.println("obj执行了notify()方法");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程T2执行结束");
        }
    }
}
