package di.event.diyevent;

import org.springframework.context.ApplicationListener;

/**
 * @author luowei
 * @date 2018/9/27 23:56
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}