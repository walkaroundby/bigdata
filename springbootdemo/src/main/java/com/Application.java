package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author luowei
 * @date 2018-09-14 14:18
 */
@SpringBootApplication
@EnableWebMvc
@EnableAsync
@EnableScheduling
@ComponentScan("com")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
    }

}