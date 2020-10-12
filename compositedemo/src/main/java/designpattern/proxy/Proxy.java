package designpattern.proxy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/12/9 22:11
 */
public class Proxy extends Subject {
    RealSubject realSubject;
    @Override
    public void request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
