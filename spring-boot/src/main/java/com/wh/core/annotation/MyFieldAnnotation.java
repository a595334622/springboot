package com.wh.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**  
 * 字段注解
 */ 
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)   
public   @interface  MyFieldAnnotation   
{  
    String uri();  
    String desc();  
}  
