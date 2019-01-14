package thread.condition;

/**
 * @author luowei
 * @date 2019-01-14 09:58
 */
public class MultiProducerConsumerByCondition {

    public static void main(String[] args) {
        ResourceByCondition r = new ResourceByCondition();
        MultiProducer pro = new MultiProducer(r);
        MultiConsumer con = new MultiConsumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
