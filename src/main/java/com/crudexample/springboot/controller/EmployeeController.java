package com.crudexample.springboot.controller;

import com.crudexample.springboot.model.Employee;
import com.crudexample.springboot.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Api(tags = "Employee Controller Class", description ="Simple CRUD Operations on Employee table")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Add a employee")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Fetch all Employees."),
            @ApiResponse(code=401, message = "Un-authorized."),
            @ApiResponse(code=403, message = "Request Forbidden."),
            @ApiResponse(code=404, message = "NOT FOUND!")
    })
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.updateEmployee(emp, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
