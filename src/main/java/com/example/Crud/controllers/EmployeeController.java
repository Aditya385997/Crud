package com.example.Crud.controllers;

import com.example.Crud.Model.Employee;
import com.example.Crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> createNewEmployee(@RequestBody Employee employee)
    {
        boolean status = employeeService.insertEmployee(employee);
        if(status)
            return new ResponseEntity<String>(HttpStatus.OK);
        return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);

    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.getAllEmployee();
        if(employeeList!=null)
            return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/employee/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
        Employee employee = employeeService.getEmployeeById(empid);
        if(employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<Employee>(employee,HttpStatus.OK);

    }

    @PutMapping("/employee/{empid}")
    public ResponseEntity<Employee> editEmpDetails(@PathVariable Long empid,@RequestBody Employee employee){

        Employee employee1 = employeeService.updateEmp(empid,employee);
        if(employee1!=null)
        {
            return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/employee/{empid}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long empid){
        boolean status  = employeeService.remove(empid);
        if(status)
            return  new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
