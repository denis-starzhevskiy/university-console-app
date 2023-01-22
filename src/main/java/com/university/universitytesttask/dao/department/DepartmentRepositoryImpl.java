package com.university.universitytesttask.dao.department;


import com.university.universitytesttask.mapper.DepartmentMapper;
import com.university.universitytesttask.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Department> getDepartments() {
        String SQL = "SELECT * FROM department";
        return jdbcTemplate.query(SQL, new DepartmentMapper());
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        String SQL = "SELECT * FROM department WHERE department_name = ?";
        return (Department) jdbcTemplate.queryForObject(SQL, new DepartmentMapper(), new Object[]{departmentName});
    }

    @Override
    public String getHeadOfDepartment(String departmentName) {
        String SQL = "SELECT head_of_department as result FROM department WHERE department_name = ?";
        return jdbcTemplate.queryForObject(SQL, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("result");
            }
        }, departmentName);
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        String SQL = "SELECT * FROM department WHERE id = ?";
        return (Department) jdbcTemplate.queryForObject(SQL, new DepartmentMapper(), new Object[]{departmentId});
    }
    @Override
    public Map<String, Integer> getStatisticsByDepartmentName(String department) {
        String SQL = "SELECT lector_degree, COUNT(*) FROM lector " +
                "JOIN departments_lectors dl on lector.id = dl.lector_id " +
                "JOIN department d on d.id = dl.department_id WHERE department_name = ? GROUP BY lector_degree";
        return jdbcTemplate.queryForObject(SQL, new RowMapper<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
                HashMap<String, Integer> values = new HashMap<>();
                values.put(rs.getString("lector_degree"), rs.getInt("count"));
                while(rs.next()){
                    values.put(rs.getString("lector_degree"), rs.getInt("count"));
                }
                return values;
            }
        }, department);
    }
    @Override
    public int getCountEmployeesByDepartmentName(String department) {
        String SQL = "SELECT COUNT(*) FROM department " +
                "JOIN departments_lectors dl on department.id = dl.department_id " +
                "WHERE department_name = ?";
        int result;
        try{
            result = jdbcTemplate.queryForObject(SQL, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("count");
                }
            }, department);
            return result;
        } catch (NullPointerException ex){
            return 0;
        }
    }

    @Override
    public int getAverageSalaryForDepartment(String departmentName) {
        String SQL = "SELECT avg(salary) as average_salary FROM lector " +
                "JOIN departments_lectors dl on lector.id = dl.lector_id " +
                "JOIN department d on d.id = dl.department_id WHERE department_name = ?";
        int result;
        try{
            result = jdbcTemplate.queryForObject(SQL, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("average_salary");
                }
            }, departmentName);
            return result;
        } catch (NullPointerException ex){
            return 0;
        }
    }

    @Override
    public List<Department> getFilteredDepartments(String template) {
        String SQL = "SELECT * FROM department WHERE lower(department_name) ~ lower(?)";

        List<Department> filteredDepartments;
        try{
            filteredDepartments = jdbcTemplate.query(SQL, new DepartmentMapper(), template);

            return filteredDepartments;
        } catch (Exception ex){
            return new ArrayList<>();
        }
    }
}
