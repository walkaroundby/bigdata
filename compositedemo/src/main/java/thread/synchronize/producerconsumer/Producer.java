package thread.synchronize.producerconsumer;

/**
 * @author luowei
 * @date 2019-01-14 11:48
 */
public class Producer implements Runnable {
    ProducerAndConsumer pc;
    boolean flag = true;
    public Producer(ProducerAndConsumer pc){
        this.pc = pc;
    }
    @Override
    public void run() {
        while(flag){
            synchronized(pc){
                if(!pc.hasResource){
                    pc.pid++;
                    System.out.println("==生产=="+pc.pid);
                    try {
                        //线程t1执行wait()方法，释放资源锁obj，等待其他线程的唤醒；
                        pc.hasResource = true;
                        pc.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
