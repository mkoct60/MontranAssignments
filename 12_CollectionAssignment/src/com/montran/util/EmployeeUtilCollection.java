package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeUtilCollection {
	
	private List<Employee> employeeList=new ArrayList<Employee>();
	
	public boolean addNewEmployee(Employee employee) {
		employeeList.add(employee);
		return true;
	}
	
	public List<Employee> getAllEmployee(){
		return employeeList;
	}
	
	public boolean addAllEmployee(Employee[] employees) {
		for(Employee emp:employees)
			addNewEmployee(emp);
		return true;
	}
	
	public boolean updateEmployee(int emp_id,String emp_name,double salary) {
		for(Employee emp:employeeList) {
			if(emp.getEmp_id()==emp_id) {
				emp.setEmp_name(emp_name);
				emp.setSalary(salary);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEmployee(int emp_id) {
		for(Employee emp:employeeList) {
			if(emp.getEmp_id()==emp_id) {
				employeeList.remove(emp);
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeById(int emp_id) {
		for(Employee emp:employeeList) {
			if(emp.getEmp_id()==emp_id) {
				employeeList.remove(emp);
				return emp;
			}
		}
		return null;
	}
}
