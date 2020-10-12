package designpattern.simplefactory;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:36
 */
public class SimpleFactoryMain {
    public static void main(String[] args) throws Exception {
        Operation operation = OperationFactory.getOperation('+');
        operation.setNumA(43);
        operation.setNumB(23);
        System.out.println(operation.getResult());
    }
}
