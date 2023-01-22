package com.university.universitytesttask.dao.department;

import com.university.universitytesttask.pojo.Department;
import com.university.universitytesttask.pojo.Lector;
import com.university.universitytesttask.pojo.enums.LectorDegree;

import java.util.List;
import java.util.Map;

public interface DepartmentRepository {

    Department getDepartmentByName(String departmentName);

    String getHeadOfDepartment(String departmentName);

    Department getDepartmentById(int departmentId);

    Map<String, Integer> getStatisticsByDepartmentName(String department);

    int getCountEmployeesByDepartmentName(String department);

    int getAverageSalaryForDepartment(String departmentName);

    List<Department> getFilteredDepartments(String template);

    List<Department> getDepartments();
}
