package designpattern.chainofresponsibility;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/18 21:03
 */
public class CommonManager extends Manager {

    public CommonManager(String name) {
        super(name);
    }

    @Override
    void requestApplications(CorRequest request) {
        if(request.getRequestType().equals("请假") && request.getNumber()<=2){
            System.out.println(String.format("{%s}:{%s}数量{%s}被批准", name, request.getRequestContent(), request.getNumber()));
        }else{
            if(superior!=null){
                superior.requestApplications(request);
            }
        }
    }
}
