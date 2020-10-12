package designpattern.simplefactory;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/20 22:29
 */
public class DivOperation extends Operation {

    @Override
    public double getResult() throws Exception {
        if(getNumB()<0){
            throw new Exception("除数不可为0");
        }
        return getNumA()/getNumB();
    }
}
