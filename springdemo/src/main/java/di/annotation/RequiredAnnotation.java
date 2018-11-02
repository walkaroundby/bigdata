package di.annotation;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author luowei
 * @date 2018/9/27 22:54
 */
public class RequiredAnnotation {
    private Integer age;
    private String name;
    @Required
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    @Required
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
