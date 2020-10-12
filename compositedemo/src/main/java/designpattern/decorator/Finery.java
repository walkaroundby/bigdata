package designpattern.decorator;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/26 22:12
 */
public class Finery extends Person{

    Person person;

    public void decorate(Person person){
        this.person = person;
    }

    @Override
    void show(){
        person.show();
    }
}
