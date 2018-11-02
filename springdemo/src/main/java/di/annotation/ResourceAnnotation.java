package di.annotation;

import common.Student;

import javax.annotation.Resource;

/**
 * @author luowei
 * @date 2018/9/27 23:16
 */
public class ResourceAnnotation {
    @Resource(name="student2")
    private Student student;
    public ResourceAnnotation(){
        System.out.println("Inside ResourceAnnotation constructor." );
    }
    public void printAge() {
        System.out.println("Age : " + student.getAge() );
    }
    public void printName() {
        System.out.println("Name : " + student.getName() );
    }
}
