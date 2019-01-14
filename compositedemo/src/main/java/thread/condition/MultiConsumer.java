package thread.condition;

/**
 * @author luowei
 * @date 2019-01-14 09:59
 */
public class MultiConsumer implements Runnable {
    private ResourceByCondition r;
    private boolean flag = true;
    MultiConsumer(ResourceByCondition r) {
        this.r = r;
    }
    @Override
    public void run() {
        while (flag) {
            r.consume();
        }
    }
}
