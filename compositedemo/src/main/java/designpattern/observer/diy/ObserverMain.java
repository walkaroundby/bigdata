package designpattern.observer.diy;

/**
 * description:
 *
 * @author luowei
 * @date 2020/10/12 10:30
 */
public class ObserverMain {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        ConcreteObserver x = new ConcreteObserver(s, "x");
        ConcreteObserver y = new ConcreteObserver(s, "y");
        ConcreteObserver z = new ConcreteObserver(s, "z");
        s.attachObserver(x);
        s.attachObserver(y);
        s.attachObserver(z);

        s.setSubjectState("ABC");
        s.notifyObservers();

    }
}
