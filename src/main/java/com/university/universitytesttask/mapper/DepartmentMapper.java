package com.university.universitytesttask.mapper;

import com.university.universitytesttask.pojo.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setDepartmentName(rs.getString("department_name"));
        department.setHeadOfDepartment(rs.getString("head_of_department"));
        return department;
    }
}
