package service;

import entity.Employee;
import repository.EmployeeRepository;
import util.ConnectDBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private Connection connection;

    public EmployeeService() throws Exception {
        connection = ConnectDBUtil.openConnection();
    }

    EmployeeRepository employeeRepository = new EmployeeRepository();


    //8. Cho biết tổng số lương phải trả cho các nhân viên.
    public int request8() throws Exception {
        List<Employee> employeeList = employeeRepository.getListEmployee();;
        int count = 0;
        for (Employee employee: employeeList){
            count+=employee.getSalary();
        }
        return count;
    }
}
