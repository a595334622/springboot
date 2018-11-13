package com.wh.core.annotation;

import java.lang.reflect.Method;
/**
 * 注解测试类
 * @ClassName: MySample 
 * @Description: TODO 注释
 * @author: 59533
 * @date: 2018年8月27日 上午7:59:58
 */
@MyClassAnnotation (uri =  "The class name " , desc =  "The class desc" )  
public   class  MySample  
{  
    @MyFieldAnnotation (uri =  "The class field" , desc =  "The class field" )  
    public  String id;  
  
    /**  
     * Description: default constructor  
     */   
    @MyConstructorAnnotation (uri =  "The default constuctor" , desc =  "The default constuctor" )  
    public  MySample()  
    {  
    }  
  
    /**  
     * Description: normal method  
     */   
    @MyMethodAnnotation (uri =  "'test'+#id" , desc =  "The class method" )  
    public   void  setId(String id)  
    {  
        this .id = id;  
    }  
  
    public   static   void  main(String[] args)  throws  SecurityException,  
            NoSuchMethodException, NoSuchFieldException  
    {  
        MySample oMySample = new  MySample();  
        oMySample.setId("123");
        
        // get method annotation   
        Method oMethod = oMySample.getClass().getDeclaredMethod("setId" ,String. class );  
        MyMethodAnnotation oMyMethodAnnotation = oMethod  
                .getAnnotation(MyMethodAnnotation.class );  
        System.out.println("Method's uri: "  + oMyMethodAnnotation.uri()  
                + "; desc: "  + oMyMethodAnnotation.desc());  
  
  
    }  
  
}  
