package ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean由IOC管理的生命周期
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean HelloWorld is going through init.");
    }
    public void destroy(){
        System.out.println("Bean HelloWorld will destroy now.");
    }
}