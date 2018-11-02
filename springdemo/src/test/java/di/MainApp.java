package di;

import ioc.HelloWorld;
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
    public void testConstructionDI() {
        TextEditor obj = (TextEditor) context.getBean("textEditor");
        obj.getAddressList();
        obj.getAddressSet();
        obj.getAddressMap();
        obj.getAddressProp();
    }
}