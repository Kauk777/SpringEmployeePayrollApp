package com.bridgelabz.employeepayroll.models;


public class EmployeeDO {
	public int id;
	public String name;
	public String gender;
	public String department;
	public long salary;
	public String startDate;
	public String imgPath;
	public String notes;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", gender=" + gender + ", department=" + department + ", salary="
				+ salary + ", startDate=" + startDate + ", imgPath=" + imgPath + ", notes=" + notes + "]";
	}
	
	
}
