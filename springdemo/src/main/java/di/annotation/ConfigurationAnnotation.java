package di.annotation;

import common.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luowei
 * @date 2018/9/27 23:32
 */
@Configuration
public class ConfigurationAnnotation {
    @Bean(initMethod = "init", destroyMethod = "destroy" )
    public Student student(){
        return new Student();
    }
}
