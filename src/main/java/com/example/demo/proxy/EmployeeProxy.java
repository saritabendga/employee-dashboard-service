package com.example.demo.proxy;


import com.example.demo.model.EmployeeDashboard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@FeignClient(name = "employee-service", url = "${employee_service_URI:http://localhost:9091}")
public interface EmployeeProxy {

    @PostMapping(path = "/dashboard/employees")
    EmployeeDashboard createEmployee(@RequestBody EmployeeDashboard employeeDashboard);

    @GetMapping(path = "dashboard/employees/{id}")
    EmployeeDashboard getEmployeeById(@PathVariable("id") Integer id);

    @GetMapping(path = "dashboard/employees")
    Collection<EmployeeDashboard> findAllEmployee();

    @PutMapping(path = "dashboard/employees/{id}")
    EmployeeDashboard updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDashboard employeeDashboard);

    @DeleteMapping(path = "dashboard/employees/{id}")
    public Map<Integer,Boolean> deleteEmployee(@PathVariable(value="id")Integer id);




}
