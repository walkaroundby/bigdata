package thread.synchronize.producerconsumer;

/**
 * 执行结果：
 ==生产==1259
 ==消费==1259
 * @author luowei
 * @date 2019-01-11 19:25
 */
public class ProducerAndConsumer {
    public Boolean hasResource = false;
    public int pid = 0;
    public static void main(String[] args) {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Consumer consumer = new Consumer(pc);
        Producer producer = new Producer(pc);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}