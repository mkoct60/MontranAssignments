package com.montran.pojo;

public class Employee {
	private int emp_id;
	private double salary;
	private String emp_name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, double salary, String emp_name) {
		super();
		this.emp_id = emp_id;
		this.salary = salary;
		this.emp_name = emp_name;
	}
	
	public int getEmp_id() {
		return emp_id;
	}

	public double getSalary() {
		return salary;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		return "Employee ID=" + emp_id + ", Employee Name=" + emp_name + ", Salary=" + salary;
	}
	
}
