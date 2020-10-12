package designpattern.simplefactory;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:29
 */
public class MulOperation extends Operation {

    @Override
    public double getResult() {
        return getNumA()*getNumB();
    }
}
