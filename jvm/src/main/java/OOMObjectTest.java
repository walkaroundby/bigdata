import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author luowei
 * @date 2020/5/20 9:29
 */
public class OOMObjectTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }
    static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList();
        for(int i = 0; i<num; i++){
            Thread.sleep(20);
            list.add(new OOMObject());
        }
        System.gc();
    }
    public static void main(String[] args) throws InterruptedException {
        fillHeap(100000);
    }
}
