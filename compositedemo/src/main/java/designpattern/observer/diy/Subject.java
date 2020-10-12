package designpattern.observer.diy;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 主题、抽象通知者
 *
 * @author luowei
 * @date 2020/10/12 9:28
 */
public abstract class Subject {
    List<Observer> observers = new ArrayList();
    void attachObserver(Observer observer){
        observers.add(observer);
    }

    void detachObserver(Observer observer){
        observers.remove(observer);
    }

    void notifyObservers(){
        observers.forEach(o->o.update());
    }
}
