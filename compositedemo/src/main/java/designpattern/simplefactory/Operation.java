package designpattern.simplefactory;

import lombok.Data;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:28
 */
@Data
public class Operation {
    private double numA;
    private double numB;

    /**
     * xxx
     * @return
     * @throws Exception
     */
    public double getResult() throws Exception{
        return 0;
    }
}
