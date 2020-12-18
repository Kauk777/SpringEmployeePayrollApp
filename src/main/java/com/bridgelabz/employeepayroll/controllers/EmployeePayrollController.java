package com.bridgelabz.employeepayroll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.models.EmployeeDO;
import com.bridgelabz.employeepayroll.models.EmployeeEntity;
import com.bridgelabz.employeepayroll.models.ResponseDAO;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8080"})
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	
	 
	 @GetMapping(value="/get")
	 public ResponseEntity<List<EmployeeEntity>> getEmployeeList() {
		 return new ResponseEntity<List<EmployeeEntity>>(employeePayrollService.getEmployeeList(),HttpStatus.OK);
	 }
	 
	 @PostMapping(value = "/add")
	 public ResponseEntity<ResponseDAO> addEmployee(@RequestBody EmployeeDO employeeDO) {
		 return new ResponseEntity<ResponseDAO>(employeePayrollService.addEmployee(employeeDO), HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value = "/delete/{id}")
	    public ResponseEntity<ResponseDAO> deleteEmplyoee(@PathVariable int id) {
	        return new ResponseEntity<ResponseDAO>(employeePayrollService.deleteEmployee(id), HttpStatus.OK);
	 }
	 
	 @GetMapping(value = "/get/{id}")
	    public ResponseEntity<EmployeeDO> getEmployeeById(@PathVariable int id) {
	        return new ResponseEntity<EmployeeDO>(employeePayrollService.getEmployeeByID(id), HttpStatus.OK);
	 }
	 
	@PutMapping(value = "/update/{id}")
	 public ResponseEntity<EmployeeDO> updateEmployeeData(@RequestBody EmployeeDO empData, @PathVariable int id) {
		 return new ResponseEntity<EmployeeDO>(employeePayrollService.updateEmployeeById(empData,id), HttpStatus.OK);
	 }
	 

}
