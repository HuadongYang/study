package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface ControllerLogAnnotation {

}
