package com.wzx.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@TabWzx("db_student")
public class Student extends User {

    @Getter
    @Setter
    @FieldWzx(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Getter
    @Setter
    @FieldWzx(columnName = "db_aliasName", type = "varchar", length = 10)
    private String aliasName;

    private class privateClass {

    }

    public class publicClass {

    }
}
