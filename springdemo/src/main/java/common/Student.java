package common;
/**
 * @author luowei
 * @date 2018/9/27 23:07
 */
public class Student {
    private Integer id;
    private Integer age;
    private String name;
    public void init(){
        System.out.println("Student is going through init.");
    }
    public void destroy(){
        System.out.println("Student will destroy now.");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}