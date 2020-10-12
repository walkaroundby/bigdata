package designpattern.chainofresponsibility;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/18 21:03
 */
public class GeneralManager extends Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    void requestApplications(CorRequest request) {
        if(request.getRequestType().equals("请假")){
            System.out.println(String.format("{%s}:{%s}数量{%s}被批准", name, request.getRequestContent(), request.getNumber()));
        }else if(request.getRequestType().equals("加薪")&&request.getNumber()<=500){
            System.out.println(String.format("{%s}:{%s}数量{%s}被批准", name, request.getRequestContent(), request.getNumber()));
        }else if(request.getRequestType().equals("加薪")&&request.getNumber()>500){
            System.out.println(String.format("{%s}:{%s}数量{%s}再说吧", name, request.getRequestContent(), request.getNumber()));
        }
    }
}
