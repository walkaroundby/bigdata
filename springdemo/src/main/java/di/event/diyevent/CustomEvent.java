package di.event.diyevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author luowei
 * @date 2018/9/27 23:55
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
    public String toString(){
        return "My Custom Event";
    }
}