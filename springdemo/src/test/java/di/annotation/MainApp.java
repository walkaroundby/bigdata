package di.annotation;

import common.Student;
import di.TextEditor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class MainApp {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    /**
     * @Required required在xml中注入对应属性，否则报错
     */
    @Test
    public void testRequiredAnnotation() {
        RequiredAnnotation obj = (RequiredAnnotation) context.getBean("requiredAnnotation");
        System.out.println(obj.getAge());
        System.out.println(obj.getName());
    }
    /**
     * @Autowired autowired根据类型byType来注入引用
     */
    @Test
    public void testAutowiredAnnotation() {
        AutowiredAnnotation obj = (AutowiredAnnotation) context.getBean("autowiredAnnotation");
        obj.spellCheck();
    }
    /**
     * @Qualified qualified根据具体的id来注入应用，多个具有相同类型的 bean 时，并且想要用一个属性只为它们其中的一个进行装配
     */
    @Test
    public void testQualifiedAnnotation() {
        QualifierAnnotation obj = (QualifierAnnotation) context.getBean("qualifierAnnotation");
        obj.printAge();
        obj.printName();
    }
    /**
     * @Resource resource根据bean的名称注入引用
     */
    @Test
    public void testResourceAnnotation() {
        ResourceAnnotation obj = (ResourceAnnotation) context.getBean("resourceAnnotation");
        obj.printAge();
        obj.printName();
    }
    /**
     * @PostConstruct @PreDestroy 两个注解，就不用在xml中配置声明周期的方法
     */
    @Test
    public void testJsr250Annotation() {
        Jsr250Annotation obj = (Jsr250Annotation) context.getBean("jsr250Annotation");
        obj.getMessage();
        context.registerShutdownHook();
    }
    /**
     * @Configuration 相当于xml文件，可以直接在类里启动容器
     * @Bean 从容器中猪肉引用
     */
    @Test
    public void testConfigurationAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationAnnotation.class);
        Student obj = context.getBean(Student.class);
        obj.getAge();
        obj.getName();
    }
}