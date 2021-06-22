package com.wzx.test;

import com.wzx.bean.FieldWzx;
import com.wzx.bean.TabWzx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 通过反射获取注解测试
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.wzx.bean.Student");

        //通过反射操作注解,用于获取该类中存在的注释,返回存在的注释数组。
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
        //根据相应类的注解获取注解中的值
        TabWzx annotation = aClass.getAnnotation(TabWzx.class);
        String value = annotation.value();
        System.out.println("value = " + value);

        //获取属性字段中的注解值
        Field id = aClass.getDeclaredField("id");
        Annotation[] annotations1 = id.getAnnotations();
        for (Annotation annotation1 : annotations1) {
            System.out.println("annotation1 = " + annotation1);
        }
        //根据相应字段的注解获取注解中的值
        FieldWzx annotation1 = id.getAnnotation(FieldWzx.class);
        System.out.println("annotation1.columnName() = " + annotation1.columnName());
        System.out.println("annotation1.type() = " + annotation1.type());
        System.out.println("annotation1.length() = " + annotation1.length());
    }
}
