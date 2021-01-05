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

import com.bridgelabz.employeepayroll.models.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.EmployeeEntity;
import com.bridgelabz.employeepayroll.models.ResponseDTO;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8080"})
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@GetMapping(value = {"/get"})
	public ResponseEntity<List<EmployeeEntity>> getEmployeePayrollData() {
		return new ResponseEntity<>(employeePayrollService.getEmployeeList(), HttpStatus.OK);
	}
	
	@PostMapping(value = {"/add"})
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.addEmployee(employeeDTO), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<ResponseDTO>(employeePayrollService.deleteEmployee(id) , HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.findEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id) {
		return new ResponseEntity<>(employeePayrollService.updateEmployeeData(id, employeeDTO) , HttpStatus.OK);
	}

}
