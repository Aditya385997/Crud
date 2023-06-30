package com.example.Crud.Model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

//Entity is basically Model which Database understand Table the table which we created
@Entity
@Table(name = "employee")
public class Employee {
    //We Mention are empid is primary key so to understand the java spring boot we use this and generated value is basically the auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;
    //CColumn basically we are doing mapping
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "emp_salary")
    private Float emp_salary;
    @Column(name = "emp_age")
    private int emp_age;
    @Column(name = "emp_city")
    private String emp_city;

    public Employee() {
    }

    public Employee(Long empid, String emp_name, Float emp_salary, int emp_age, String emp_city) {
        this.empid = empid;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_age = emp_age;
        this.emp_city = emp_city;
    }

    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Float getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(Float emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_age=" + emp_age +
                ", emp_city='" + emp_city + '\'' +
                '}';
    }
}
