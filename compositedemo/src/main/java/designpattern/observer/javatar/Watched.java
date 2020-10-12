package designpattern.observer.javatar;

import java.util.Observable;

/**
 * description:
 *
 * @author luowei
 * @date 2020/10/12 15:09
 */
public class Watched extends Observable {
    int i=43;
    public void count(int number) {
        for (; number >= 0; number--) {
            try {
                Thread.sleep(1000);
                setChanged();
                notifyObservers(number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
