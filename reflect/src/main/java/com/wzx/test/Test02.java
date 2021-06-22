package com.wzx.test;

import com.wzx.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 获取方法参数测试
 */
public class Test02 {

    public Map<String, User> test02() {
        System.out.println("Test02.....map");
        return null;
    }

    public void test02(Map<String, User> map, List<User> list) {
        System.out.println("Test02.....void");
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Method test1 = Test02.class.getDeclaredMethod("test02");
        Method test2 = Test02.class.getDeclaredMethod("test02", Map.class, List.class);
        Type[] type1 = test1.getGenericParameterTypes();
        System.out.println("type1 = " + Arrays.toString(type1));
        //在Method方法中使用，返回属于方法对象的参数数组
        Type[] type2 = test2.getGenericParameterTypes();
        System.out.println("type2 = " + Arrays.toString(type2));

        for (int i = 0; i < type2.length; i++) {
            Type genericParameterType = type2[i];
            if (genericParameterType instanceof ParameterizedType) {
                //返回一个Type对象数组，表示该类型的实际类型参数
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (int i1 = 0; i1 < actualTypeArguments.length; i1++) {
                    Type actualTypeArgument = actualTypeArguments[i1];
                    System.out.println("actualTypeArgument = " + actualTypeArgument);
                }

                //Type表示该类型所属类型的对象。如果此类型是顶级类型， null则返回
                Type ownerType = ((ParameterizedType) genericParameterType).getOwnerType();
                System.out.println("ownerType = " + ownerType);
                //Type表示声明此类型的类或接口的对象（interface java.util.Map，interface java.util.List）
                Type rawType = ((ParameterizedType) genericParameterType).getRawType();
                System.out.println("rawType = " + rawType);
            }
        }
    }
}
