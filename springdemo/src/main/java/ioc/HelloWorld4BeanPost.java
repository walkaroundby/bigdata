package ioc;

/**
 *
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class HelloWorld4BeanPost {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean helloWorld4BeanPost is going through init.");
    }
    public void destroy(){
        System.out.println("Bean helloWorld4BeanPost will destroy now.");
    }
}