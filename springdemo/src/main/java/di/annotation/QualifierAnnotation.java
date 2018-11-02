package di.annotation;

import common.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author luowei
 * @date 2018/9/27 23:06
 */
public class QualifierAnnotation {
    @Autowired
    @Qualifier("student1")
    private Student student;
    public QualifierAnnotation(){
        System.out.println("Inside QualifierAnnotation constructor." );
    }
    public void printAge() {
        System.out.println("Age : " + student.getAge() );
    }
    public void printName() {
        System.out.println("Name : " + student.getName() );
    }
}
