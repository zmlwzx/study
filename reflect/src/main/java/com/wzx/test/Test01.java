package com.wzx.test;

import com.wzx.bean.Student;
import com.wzx.bean.User;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * 反射常用方法测试
 */
public class Test01 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取class对象的三种方式
        /**
         * 1、通过调用getClass()方法获取
         * 2、通过Class.forName()方法获取
         * 3、通过类名.Class方式获取
         */

        /* User us = new User();
        Class<? extends User> userClass = us.getClass();*/

        /* Class userClass = Class.forName("com.wzx.bean.User");*/
        Class<User> userClass = User.class;
        User user = (User) userClass.newInstance();
        System.out.println("userClass = " + user);

        //返回对象的所有公有属性数组(包含继承超类(父类)公有属性)
        Field[] fields = userClass.getFields();
        //返回对象的全部属性数组(不包含继承超类属性，只包含自身属性)
        Field[] declaredFields = userClass.getDeclaredFields();
        System.out.println("fields.length = " + fields.length);
        System.out.println("declaredFields.length = " + declaredFields.length);
        //获取对象的公有public属性，(包含继承超类(父类)公有属性)
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"王五");
        System.out.println("user.getName() = " + user.getName());

        //返回对象的所有公有方法(包含超类(父类)公有方法)
        Method[] methods = userClass.getMethods();
        //返回对象的全部方法((不包含继承超类方法，只包含自身方法)
        Method[] declaredMethods = userClass.getDeclaredMethods();
        System.out.println("methods.length = " + methods.length);
        System.out.println("declaredMethods.length = " + declaredMethods.length);

        //返回对象的所有公有构造器
        Constructor<?>[] constructors = userClass.getConstructors();
        //返回对象的全部构造器
        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
        System.out.println("constructors.length = " + constructors.length);
        System.out.println("declaredConstructors.length = " + declaredConstructors.length);

        //通过调用有参构造创建对象
        Constructor<User> userConstructor = userClass.getDeclaredConstructor(String.class, Integer.class, int.class);
        User user1 = userConstructor.newInstance("张三", 28, 1);
        System.out.println("user1 = " + user1);

        //getClasses得到该类及其父类所有的public的内部类。
        System.out.println(Arrays.toString(Student.class.getClasses()));
        //getDeclaredClasses得到该类所有的内部类，除去父类的。
        System.out.println(Arrays.toString(Student.class.getDeclaredClasses()));

        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor(String.class, Integer.class, int.class);
        //在构造器和Method类中，获取参数类型
        Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
        System.out.println("parameterTypes = " + Arrays.toString(parameterTypes));

        //通过反射获取一个方法
        Method getMethod = userClass.getDeclaredMethod("getName", String.class);
        System.out.println("getMethod = " + getMethod);
        //通过方法获取返回值类型
        Class<?> returnType = getMethod.getReturnType();
        System.out.println("returnType = " + returnType);
        Method setMethod = userClass.getDeclaredMethod("setName", String.class);
        //激活方法（对象，方法值）
        setMethod.invoke(user,"李四");
        //传递给定参数，并返回方法的返回值，对于静态方法，把null作为隐式参数传递，如果属性是包装类。此处参数也必须是包装类，如果是基本类型，返回的也必须是未包装的。
        Method setMethod1 = userClass.getDeclaredMethod("setSex", int.class);
        setMethod1.invoke(user,30);
        System.out.println("user.getName() , user.getSex() = " + user.getName() + "," + user.getSex());
        System.out.println("user.getName() = " + user.getName());


        //返回用于描述构造器、方法或属性的修饰符的整型数值，利用Modifier类中的方法分析这个数值。
        int modifiers = userClass.getModifiers();
        User.publicClass publicClass = new User.publicClass();
        int modifiers1 = publicClass.getClass().getModifiers();
        System.out.println("Modifier.toString(modifiers) = " + Modifier.toString(modifiers));//public
        System.out.println("Modifier.toString(modifiers) = " + Modifier.toString(modifiers1));//public static
        System.out.println("Modifier.isStatic(modifiers1) = " + Modifier.isStatic(modifiers1));//true
    }


}
