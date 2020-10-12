package designpattern.proxy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/12/9 22:11
 */
public class RealSubject extends Subject {

    @Override
    public void request() {
        System.out.println("real request");
    }
}
