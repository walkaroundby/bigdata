package designpattern.observer.javatar;

import java.util.Observable;
import java.util.Observer;

/**
 * description:
 *
 * @author luowei
 * @date 2020/10/12 15:09
 */
public class Client {
    public static void main(String[] args) {
        Watched watched = new Watched();
        Observer watcher1 = new Watcher();
        Observer watcher2 = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                int number = (Integer) arg;
                if (0 == number) {
                    System.out.println("done");
                }
            }
        };
        watched.addObserver(watcher1);
        watched.addObserver(watcher2);
        watched.count(10);
    }
}
