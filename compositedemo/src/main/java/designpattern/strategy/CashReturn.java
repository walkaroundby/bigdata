package designpattern.strategy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:41
 */
public class CashReturn extends CashSuper {

    private double moneyCondition;
    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    double algorithm(double money) {
        double result = money;
        if(money>moneyCondition){
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
        }
        return result;
    }
}
