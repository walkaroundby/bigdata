package designpattern.strategy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:41
 */
public class CashRebate extends CashSuper {

    private double moneyRebate;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    double algorithm(double money) {
        return money * moneyRebate;
    }
}
