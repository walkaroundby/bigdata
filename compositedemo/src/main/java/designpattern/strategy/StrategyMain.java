package designpattern.strategy;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:55
 */
public class StrategyMain {
    public static void main(String[] args) {
        CashContent cashContent = new CashContent(3);
        System.out.println(cashContent.getResult(300));

    }
}
