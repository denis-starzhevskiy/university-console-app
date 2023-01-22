package com.university.universitytesttask.pojo;

import com.university.universitytesttask.pojo.enums.LectorDegree;
import lombok.Data;

@Data
public class Lector {

    private int id;

    private String firstName;

    private String secondName;

    private String fatherName;

    private LectorDegree degree;

    private int salary;

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + fatherName;
    }
}
