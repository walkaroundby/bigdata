package thread.synchronize.producerconsumer;

/**
 * @author luowei
 * @date 2019-01-14 11:44
 */
public class Consumer implements Runnable{
    ProducerAndConsumer pc;
    boolean flag = true;
    public Consumer(ProducerAndConsumer pc){
        this.pc = pc;
    }
    @Override
    public void run() {
        while(flag){
            synchronized (pc) {
                if(pc.hasResource){
                    System.out.println("==消费=="+ pc.pid);
                    pc.hasResource = false;
                    //唤醒obj的等待线程。但此时还在synchronized里，等方法体内走完5s才释放锁。
                    pc.notify();
                }
            }
        }
    }
}
