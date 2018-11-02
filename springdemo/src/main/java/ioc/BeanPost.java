package ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean初始化之前和之后的处理器
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class BeanPost implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String beanName) throws BeansException {
        System.out.println("BeforeInitialization : " + o);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String beanName) throws BeansException {
        System.out.println("AfterInitialization : " + o);
        return o;
    }
}