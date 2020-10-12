package designpattern.decorator;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/26 22:19
 */
public class DecorateMain {
    public static void main(String[] args) {
        BigTrouser bigTrouser = new BigTrouser();
        Sneakers sneakers = new Sneakers();
        Tshirt tshirt = new Tshirt();
        Person person = new Person("abc");
        bigTrouser.decorate(person);
        sneakers.decorate(bigTrouser);
        tshirt.decorate(sneakers);
        tshirt.show();
    }
}
