package com.wh.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

  

/**  
 * 类注解
 */ 
@Target (ElementType.TYPE)
@Retention (RetentionPolicy.RUNTIME) 
//@Target ({ElementType.TYPE,ElementType.METHOD})  
public   @interface  MyClassAnnotation   
{  
    String uri();  
    String desc();  
}  