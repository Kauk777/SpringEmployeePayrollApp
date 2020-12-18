package com.bridgelabz.employeepayroll.service.impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayroll.exception.BadRequestException;
import com.bridgelabz.employeepayroll.exception.NotFoundException;
import com.bridgelabz.employeepayroll.models.EmployeeDO;
import com.bridgelabz.employeepayroll.models.ResponseDAO;
import com.bridgelabz.employeepayroll.models.EmployeeEntity;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{
	
	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public ResponseDAO addEmployee(EmployeeDO employeeRequestDAO) {
		if (employeeRequestDAO == null) {
			throw new BadRequestException("Name is not Proper");
		}
		EmployeeEntity empEntity=new EmployeeEntity();
		empEntity.setName(employeeRequestDAO.getName());
		empEntity.setGender(employeeRequestDAO.getGender());
		empEntity.setImgPath(employeeRequestDAO.getImgPath());
		empEntity.setNotes(employeeRequestDAO.getNotes());
		empEntity.setStartDate("");
		empEntity.setSalary(employeeRequestDAO.getSalary());
		empEntity.setDepartment(employeeRequestDAO.getDepartment());
		empEntity = employeeRepository.save(empEntity);
		if(empEntity != null) {
			return new ResponseDAO("Success");
		} else {
			return new ResponseDAO("Failed");
		}
	}

	@Override
	public List<EmployeeEntity> getEmployeeList() {
		return employeeRepository.findAll();
		/*List<EmployeeEntity> empList=employeeRepository.findAll();
		if(empList==null || empList.isEmpty()) {
			throw new NotFoundException("No Data Found of any employee");
		}
		return empList.stream().map(employee -> {
			EmployeeDO emp = convertobj(employee);
			return emp;
		}).collect(Collectors.toList());*/
			
	}
	
	@Override
	public ResponseDAO deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return new ResponseDAO("Employee Deleteed Successfully..!!");
	}
	
	@Override
	public EmployeeDO getEmployeeByID(int id) {
		EmployeeEntity employee = employeeRepository.findById(id);
		if(employee == null) {
			throw new NotFoundException("No Data Found for the id:"+id);
		}
		EmployeeDO emp = convertobj(employee);
		return emp;
	}
	
	@Override
	public EmployeeDO updateEmployeeById(EmployeeDO empData, int id) {
		EmployeeEntity employeeEntity=employeeRepository.findById(id);
		employeeEntity.setName(empData.getName());
		employeeEntity.setDepartment(empData.getDepartment());
		employeeEntity.setSalary(empData.getSalary());
		employeeEntity.setImgPath(empData.getImgPath());
		employeeEntity.setGender(empData.getGender());
		employeeEntity.setNotes(empData.getNotes());
		employeeEntity.setStartDate(empData.getStartDate());
		employeeEntity=employeeRepository.save(employeeEntity);
		if(employeeEntity == null) {
			throw new NotFoundException("No Data Found for the id:"+id);
		}
		EmployeeDO emp=convertobj(employeeEntity);
		return emp;
	}
	
	private EmployeeDO convertobj(EmployeeEntity employee) {
		EmployeeDO emp = new EmployeeDO();
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setDepartment(employee.getDepartment());
		emp.setSalary(employee.getSalary());
		emp.setGender(employee.getGender());
		emp.setImgPath(employee.getImgPath());
		emp.setStartDate("");
		emp.setNotes(employee.getNotes());
		return emp;
	}

}
