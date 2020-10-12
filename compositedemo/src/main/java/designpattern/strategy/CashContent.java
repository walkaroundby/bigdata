package designpattern.strategy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:51
 */
public class CashContent {
    CashSuper cashSuper = null;

    public CashContent(int type){
        switch (type){
            case 1:
                cashSuper = new CashNormal();
                break;
            case 2:
                cashSuper = new CashReturn(300, 100);
                break;
            case 3:
                cashSuper = new CashRebate(0.8);
                break;
            default:
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.algorithm(money);
    }
}
