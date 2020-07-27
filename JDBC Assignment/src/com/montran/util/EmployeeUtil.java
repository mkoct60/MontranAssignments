package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeUtil {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement insertPreparedStatement;
	private PreparedStatement updatePreparedStatement;
	private PreparedStatement deletePreparedStatement;
	private List<Employee> employeeList;
	ResultSet resultSet;
	Employee employee;
	
	public EmployeeUtil() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","montran","montran");
			insertPreparedStatement=connection.prepareStatement("insert into employee_master values(?,?,?)");
			updatePreparedStatement=connection.prepareStatement("update employee_master set name=?,salary=? where emp_id=?");
			deletePreparedStatement=connection.prepareStatement("delete from employee_master where emp_id=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean addNewEmployee(Employee employee) throws SQLException {
		insertPreparedStatement.setInt(1, employee.getEmp_id());
		insertPreparedStatement.setString(2, employee.getEmp_name());
		insertPreparedStatement.setDouble(3, employee.getSalary());
		insertPreparedStatement.executeUpdate();
		return true;
	}
	
	public List<Employee> getAllEmployee() throws SQLException{
		employeeList=new ArrayList<Employee>();
		statement=connection.createStatement();
		resultSet=statement.executeQuery("select * from employee_master");
		while (resultSet.next()) {
			employee=new Employee();
			employee.setEmp_id(resultSet.getInt("emp_id"));
			employee.setSalary(resultSet.getDouble("salary"));
			employee.setEmp_name(resultSet.getString("name"));
			employeeList.add(employee);
		}
		return employeeList;
	}
	
	public boolean addAllEmployee(Employee[] employees) throws SQLException {
		for(Employee emp:employees)
			addNewEmployee(emp);
		return true;
	}
	
	public boolean updateEmployee(int emp_id,String emp_name,double salary) throws SQLException {
		updatePreparedStatement.setString(1, emp_name);
		updatePreparedStatement.setDouble(2, salary);
		updatePreparedStatement.setInt(3, emp_id);
		boolean result=updatePreparedStatement.execute();
		if(!result)
			return true;
		return false;
	}
	
	public boolean deleteEmployee(int emp_id) throws SQLException {
		deletePreparedStatement.setInt(1,emp_id);
		boolean result=deletePreparedStatement.execute();
		if(!result)
			return true;
		return false;
	}
	
	public Employee getEmployeeById(int emp_id) throws SQLException {
		for(Employee emp:employeeList) {
			if(emp.getEmp_id()==emp_id) {
				employeeList.remove(emp);
				return emp;
			}
		}
		return null;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
