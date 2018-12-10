package com.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SdpServiceHandler {
    String value() default "";
}
