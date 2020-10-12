package designpattern.chainofresponsibility;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/18 20:57
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        CommonManager commonManager = new CommonManager("经理");
        MajordomoManager majordomoManager = new MajordomoManager("总监");
        GeneralManager generalManager = new GeneralManager("总经理");

        commonManager.setSuperior(majordomoManager);
        majordomoManager.setSuperior(generalManager);

        CorRequest request1 = new CorRequest("请假", "小菜请假", 2);
        commonManager.requestApplications(request1);

        CorRequest request2 = new CorRequest("请假", "小菜请假", 5);
        commonManager.requestApplications(request2);

        CorRequest request3 = new CorRequest("加薪", "小菜加薪", 500);
        commonManager.requestApplications(request3);

        CorRequest request4 = new CorRequest("加薪", "小菜加薪", 1000);
        commonManager.requestApplications(request4);
    }
}
