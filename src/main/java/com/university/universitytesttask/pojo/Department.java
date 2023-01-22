package com.university.universitytesttask.pojo;

import lombok.Data;

@Data
public class Department {

    private int id;

    private String departmentName;

    private String headOfDepartment;

    @Override
    public String toString() {
        return "DepartmentName : '" + departmentName + '\'' +
                ", Head of Department : '" + headOfDepartment + '\'';
    }
}
