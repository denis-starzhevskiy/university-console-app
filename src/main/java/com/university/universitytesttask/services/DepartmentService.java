package com.university.universitytesttask.services;

import com.university.universitytesttask.dao.department.DepartmentRepository;
import com.university.universitytesttask.pojo.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public String getHeadOfDepartment(String departmentName) throws Exception {
        try {
           return departmentRepository.getHeadOfDepartment(departmentName);
        } catch (Exception ex){
            throw new Exception("Error while getting a head of department.");
        }
    }

    public Map<String, Integer> getStatisticsByDepartmentName(String departmentName){
        Map<String, Integer> lectorsDegrees;
        try{
             lectorsDegrees = departmentRepository.getStatisticsByDepartmentName(departmentName);
             return lectorsDegrees;
        } catch (Exception e){
            return new HashMap<>();
        }
    }

    public boolean checkIfDepartmentExists(String departmentName){
        try{
            departmentRepository.getDepartmentByName(departmentName);
            return true;
        } catch (Exception e){
//            log.error("Department wasn't found by name");
            return false;
        }
    }

    public int getCountEmployeesByDepartment(String department) throws Exception {
        try{
            return departmentRepository.getCountEmployeesByDepartmentName(department);
        } catch (Exception e){
//            log.error("Error while getting a count of employee");
            throw new Exception("Error while getting a count of employees");
        }
    }

    public int getAverageSalaryForDepartment(String department) throws Exception {
        try{
            return departmentRepository.getAverageSalaryForDepartment(department);
        } catch (Exception e){
//            log.error("Error while getting a count of employee");
            throw new Exception("Error while getting an average salary of department");
        }
    }

    // search the departments is conducted by department name (only)
    public List<Department> getFilteredDepartments(String template){
        return departmentRepository.getFilteredDepartments(template);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.getDepartments();
    }
}
