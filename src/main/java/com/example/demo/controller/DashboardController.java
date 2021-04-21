package com.example.demo.controller;

import com.example.demo.model.EmployeeDashboard;
import com.example.demo.proxy.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private EmployeeProxy employeeProxy;

    @GetMapping(path = "employees", produces = "application/json")
    public Collection<EmployeeDashboard> findAllEmployee() {
        return employeeProxy.findAllEmployee();
    }

    @GetMapping(path = "/employees/{id}")
    public EmployeeDashboard getEmployeeById(@PathVariable("id") Integer id)
    {
        return employeeProxy.getEmployeeById(id);
    }
    @PostMapping(path = "/employees")
    public EmployeeDashboard createEmployee(@RequestBody EmployeeDashboard employeeDashboard)
    {
       return employeeProxy.createEmployee(employeeDashboard);
    }

    @PutMapping(path = "/employees/{id}")
    public EmployeeDashboard updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDashboard employeeDashboard)
    {
       EmployeeDashboard e=employeeProxy.updateEmployee(id, employeeDashboard);
        return e;
    }

    @DeleteMapping(path = "employees/{id}")
    public Map<Integer,Boolean> deleteEmployee(@PathVariable(value="id")Integer id){
        EmployeeDashboard employee=employeeProxy.getEmployeeById(id);
        employeeProxy.deleteEmployee(id);
        Map <Integer,Boolean> response=new HashMap<>();
        response.put(1,Boolean.TRUE);
        return response;
    }





}
