package com.wzx.bean;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor //此注解配合判断非空使用
@ToString
public class User {

    @Getter
    @Setter
    @NonNull
    private String name;
    @Getter
    @Setter
    @NonNull
    private Integer age;
    @Getter
    @Setter
    @NonNull
    public int sex;
    @Getter
    @Setter
    protected String address;
    @Getter
    @Setter
    public Student student;

    private static class privateClass{

    }

    public static class publicClass{

    }

    public String getName(String name){
        return this.name;
    }

}


