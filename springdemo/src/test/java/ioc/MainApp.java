package ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class MainApp {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    @Test
    public void testXmlBeanFactory() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();
    }
    @Test
    public void testClassPathXmlApplicationContext() {
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
    @Test
    public void testInitAndDestroyed() {
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }
    @Test
    public void testBeanPost() {
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        context.registerShutdownHook();
    }

}