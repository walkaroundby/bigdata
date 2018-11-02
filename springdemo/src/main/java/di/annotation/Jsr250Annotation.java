package di.annotation;

import lombok.libs.com.zwitserloot.cmdreader.Requires;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author luowei
 * @date 2018/9/27 23:19
 */
public class Jsr250Annotation {
    private String message;
    @Required
    public void setMessage(String message){
        this.message  = message;
    }
    public String getMessage(){
        System.out.println("Your Message : " + message);
        return message;
    }
    @PostConstruct
    public void initByJsr250(){
        System.out.println("Jsr250Annotation is going through init.");
    }
    @PreDestroy
    public void destroyByJsr250(){
        System.out.println("Jsr250Annotation will destroy now.");
    }
}
