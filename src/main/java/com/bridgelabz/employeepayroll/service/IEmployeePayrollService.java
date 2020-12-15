package com.bridgelabz.employeepayroll.service;

import java.util.List;

import com.bridgelabz.employeepayroll.models.EmployeeDO;
import com.bridgelabz.employeepayroll.models.ResponseDAO;

public interface IEmployeePayrollService {
	
	public ResponseDAO addEmployee(EmployeeDO employeeRequestDAO);
	public List<EmployeeDO> getEmployeeList();
	public ResponseDAO deleteEmployee(int id);
	public EmployeeDO getEmployeeByID(int id);
	public EmployeeDO updateEmployeeById(EmployeeDO empData, int id);

}
