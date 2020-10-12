package designpattern.decorator;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/26 22:15
 */
public class Sneakers extends Finery{

    @Override
    void show() {
        System.out.println("sneakers");
        super.show();
    }
}
