package thread.condition;

/**
 * @author luowei
 * @date 2019-01-14 09:58
 */
public class MultiProducer implements Runnable {
    private ResourceByCondition r;
    private boolean flag = true;
    MultiProducer(ResourceByCondition r) {
        this.r = r;
    }
    @Override
    public void run() {
        while (flag) {
            r.product("北京烤鸭");
        }
    }
}
