package designpattern.chainofresponsibility;

import lombok.Data;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/18 20:58
 */
@Data
public abstract class Manager {
    protected String name;
    protected Manager superior;
    public Manager(String name){
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    abstract void requestApplications(CorRequest request);
}
