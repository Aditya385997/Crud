package com.example.Crud.service;

import com.example.Crud.Model.Employee;
import com.example.Crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public boolean insertEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }
    public List<Employee>getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
        {
            Employee emp = employee.get();
            return emp;
        }
        else
            return null;
    }

    public Employee updateEmp(Long empid, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(empid);
        if(employee1.isPresent())
        {
            Employee existEmp = employee1.get();
            existEmp.setEmp_name(employee.getEmp_name());
            existEmp.setEmp_age(employee.getEmp_age());
            existEmp.setEmp_salary(employee.getEmp_salary());
            existEmp.setEmp_city(employee.getEmp_city());
            employeeRepository.save(existEmp);
            return existEmp;
        }
        else
            return null;
    }

    public boolean remove(Long empid) {
        Optional<Employee> employee = employeeRepository.findById(empid);
        if(employee.isPresent())
        {
            Employee exist = employee.get();
            employeeRepository.delete(exist);
            return true;
        }
        else
            return false;
    }
}
