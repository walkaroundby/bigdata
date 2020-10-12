package designpattern.decorator;


import lombok.Data;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/26 22:11
 */
@Data
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    void show(){
        System.out.println(String.format("decorate name：%s", name));
    }
}
