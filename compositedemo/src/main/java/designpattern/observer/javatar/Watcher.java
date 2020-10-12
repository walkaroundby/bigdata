package designpattern.observer.javatar;

import java.util.Observable;
import java.util.Observer;

/**
 * description:
 *
 * @author luowei
 * @date 2020/10/12 15:09
 */
public class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int number = (Integer) arg;
        System.out.println(number);
    }
}
