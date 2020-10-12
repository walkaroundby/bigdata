import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description:
 *
 * @author luowei
 * @date 2020/5/20 10:04
 */
public class BusyThread {
    /**
     * 线程死循环
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true);
            }
        }, "testBusyThread");
        thread.start();
    }
    /**
     * 线程等待
     */
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    static class SynAddRunnable implements Runnable{
        int a, b;
        public SynAddRunnable(int a, int b){
            this.a = a;
            this.b = b;
        }
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
        for(int i=0; i<100; i++){
            new Thread(new SynAddRunnable(1,2)).start();;
            new Thread(new SynAddRunnable(2,1)).start();;
        }
    }
}
