package designpattern.simplefactory;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:29
 */
public class SubOperation extends Operation {

    @Override
    public double getResult() {
        return getNumA()-getNumB();
    }
}
