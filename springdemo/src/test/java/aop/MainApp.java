package aop;

import common.Student;
import di.TextEditor;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luowei
 * @date 2018-09-27 17:57
 */
public class MainApp {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    @Test
    public void testXmlAop() {
        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
//        student.printThrowException();
    }

    /**
     * @Aspect 注解类要在xml中声明启用注解
     */
    @Test
    public void testAnnotationAop() {
        Student student = (Student) context.getBean("student2");
        student.getName();
        student.getAge();
//        student.printThrowException();
    }

}