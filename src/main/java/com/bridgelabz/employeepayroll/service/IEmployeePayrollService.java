package com.bridgelabz.employeepayroll.service;

import java.util.List;

import com.bridgelabz.employeepayroll.models.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.EmployeeEntity;
import com.bridgelabz.employeepayroll.models.ResponseDTO;

public interface IEmployeePayrollService {
	
	public ResponseDTO addEmployee(EmployeeDTO employeeDTO);
	public List<EmployeeEntity> getEmployeeList();
	public ResponseDTO deleteEmployee(int id);
	public EmployeeEntity findEmployee(int id);
	public EmployeeEntity updateEmployeeData(int employeeId, EmployeeDTO employeeDTO);

}
