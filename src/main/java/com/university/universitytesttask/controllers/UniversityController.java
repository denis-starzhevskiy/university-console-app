package com.university.universitytesttask.controllers;

import com.university.universitytesttask.helpers.OutputHelper;
import com.university.universitytesttask.helpers.ShellHelper;
import com.university.universitytesttask.pojo.Department;
import com.university.universitytesttask.pojo.Lector;
import com.university.universitytesttask.services.DepartmentService;
import com.university.universitytesttask.services.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class UniversityController {
    @Autowired
    ShellHelper shellHelper;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    LectorService lectorService;


    @ShellMethod("Displays head of the department")
    public String whoIsHeadOfDepartment(@ShellOption({"-N", "--name"}) String departmentName) {
        if(departmentName == null) {
            return shellHelper.getErrorMessage("Please, enter a department name");
        }

        if(!departmentService.checkIfDepartmentExists(departmentName)){
            return shellHelper.getErrorMessage("Please, enter an exist department name");
        }

        try {
            String headOdDepartment = departmentService.getHeadOfDepartment(departmentName);

            return String.format("Head of the %s is %s", departmentName, headOdDepartment);
        } catch (Exception ex){
            return "Something went wrong. Please, try later!";
        }
    }

    @ShellMethod("Get count of lectors of the department by their degrees")
    public String ShowStatistics(@ShellOption({"-N", "--name"}) String departmentName) {


        StringBuilder result = new StringBuilder("\n");
        departmentService.getStatisticsByDepartmentName(departmentName).forEach((key, value) -> {
            result.append(key + " -> " + value + "\n");
        });

        return String.valueOf(result);
    }

    @ShellMethod("Get count of all employees of the department")
    public String ShowCountOfEmployeesOf(@ShellOption({"-N", "--name"}) String departmentName) {
        if (departmentName == null) {
            return shellHelper.getErrorMessage("Please, enter a department name");
        }

        if (!departmentService.checkIfDepartmentExists(departmentName)) {
            return shellHelper.getErrorMessage("Please, enter an exist department name");
        }

        try {
            int countOfEmployee = departmentService.getCountEmployeesByDepartment(departmentName);
            return String.format("Count of employees in the %s is %s", departmentName, countOfEmployee);
        } catch (Exception ex) {
            return "Something went wrong. Please, try later!";
        }
    }

    @ShellMethod("Get an average salary of the department")
    public String ShowTheAverageSalaryForDepartment(@ShellOption({"-N", "--name"}) String departmentName) {
        if(departmentName == null) {
            return shellHelper.getErrorMessage("Please, enter a department name");
        }

        if(!departmentService.checkIfDepartmentExists(departmentName)){
            return shellHelper.getErrorMessage("Please, enter an exist department name");
        }

        try {
            int averageSalaryForDepartment = departmentService.getAverageSalaryForDepartment(departmentName);
            return String.format("An average salary of the %s is %s", departmentName, averageSalaryForDepartment);
        } catch (Exception ex){
            return "Something went wrong. Please, try later!";
        }
    }

    @ShellMethod("Global search of departments and lectors")
    public String GlobalSearchBy(@ShellOption(value = {"-P", "--param"}, defaultValue = ShellOption.NULL) String template) {
        if(template == null) {
            StringBuilder result = new StringBuilder();
            List<Department> departments = departmentService.getAllDepartments();
            OutputHelper<Department> outputDepartmentsHelper = new OutputHelper<>();
            result.append(outputDepartmentsHelper.printOutPutEntities(departments));

            List<Lector> lectors = lectorService.getAllLectors();
            OutputHelper<Lector> outputLectorsHelper = new OutputHelper<>();
            result.append(outputLectorsHelper.printOutPutEntities(lectors));
            return String.format(String.valueOf(result));
        }

        try {
            StringBuilder result = new StringBuilder();
            List<Department> departments = departmentService.getFilteredDepartments(template);
            OutputHelper<Department> outputDepartmentsHelper = new OutputHelper<>();
            result.append(outputDepartmentsHelper.printOutPutEntities(departments));

            List<Lector> lectors = lectorService.getFilteredLectors(template);
            OutputHelper<Lector> outputLectorsHelper = new OutputHelper<>();
            result.append(outputLectorsHelper.printOutPutEntities(lectors));

            if(result.isEmpty()){
                return "\nNothing was found by the request. Change the filter and try later.\n";
            }

            return String.format(String.valueOf(result));

        } catch (Exception ex){
            return "Something went wrong. Please, try later!";
        }
    }



}
