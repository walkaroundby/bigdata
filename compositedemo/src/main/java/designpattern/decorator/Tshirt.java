package designpattern.decorator;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/26 22:15
 */
public class Tshirt extends Finery{

    @Override
    void show() {
        System.out.println("t-shirt");
        super.show();
    }
}
