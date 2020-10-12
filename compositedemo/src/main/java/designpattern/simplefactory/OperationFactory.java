package designpattern.simplefactory;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:32
 */
public class OperationFactory {
    public static Operation getOperation(char operate){
        Operation operation = null;
        switch (operate){
            case '+':
                operation = new AddOperation();
                break;
            case '-':
                operation = new SubOperation();
                break;
            case '*':
                operation = new MulOperation();
                break;
            case '/':
                operation = new DivOperation();
                break;
            default:
                break;
        }
        return operation;
    }
}
