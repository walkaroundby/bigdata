package designpattern.observer.diy;

import lombok.Data;

/**
 * description:
 *
 * @author luowei
 * @date 2020/10/12 10:24
 */
@Data
public class ConcreteObserver implements Observer{

    ConcreteSubject subject;
    String observerState;
    String observerName;

    public ConcreteObserver(ConcreteSubject subject, String observerName) {
        this.subject = subject;
        this.observerName = observerName;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println(String.format("观察者[%s]的新状态是[%s]", observerName, observerState));
    }
}
