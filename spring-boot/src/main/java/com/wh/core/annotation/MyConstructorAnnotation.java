package com.wh.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

   
/**  
 * 构造函数注解
 */ 
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.CONSTRUCTOR)   
public   @interface  MyConstructorAnnotation   
{  
    String uri();  
    String desc();  
}  
