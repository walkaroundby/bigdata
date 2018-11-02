package di.event;

import di.TextEditor;
import di.event.diyevent.CustomEventPublisher;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class MainApp {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    /**
     * 系统事件处理
     */
    @Test
    public void testSystemEvent() {
        context.start();
        context.stop();
    }
    /**
     * 自定义事件处理
     */
    @Test
    public void testCustomEvent() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");
        cvp.publish();
        cvp.publish();
        cvp.publish();
    }
}