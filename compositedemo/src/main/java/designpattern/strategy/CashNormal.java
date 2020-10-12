package designpattern.strategy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:41
 */
public class CashNormal extends CashSuper {

    @Override
    double algorithm(double money) {
        return money;
    }
}
