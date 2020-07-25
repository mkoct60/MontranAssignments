package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeUtilCollection;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner scanner = new Scanner(System.in);
		EmployeeUtilCollection employeeUtil = new EmployeeUtilCollection();
		Employee employee;
		Employee[] arrayofemp;
		List<Employee> emplsit = new ArrayList<Employee>();
		int emp_id;
		double salary;
		String emp_name,yesorno;
		boolean result;

		do {
			emplsit = employeeUtil.getAllEmployee();
			for (Employee emp : emplsit) {
				if (emp != null)
					System.out.println(emp);
			}
			System.out.println("1. Add Single Employee.");
			System.out.println("2. Add Multiple Employee.");
			System.out.println("3. Update Existing Employee.");
			System.out.println("4. Delete Existing Employee.");
			System.out.println("5. Print Single Employee Detail.");
			System.out.println("6. Exit.");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.print("Enter Employee name: ");
				emp_name = scanner.nextLine();
				System.out.print("Enter Employee Salary: ");
				salary = scanner.nextDouble();
				employee = new Employee(0, salary, emp_name);
				result = employeeUtil.addNewEmployee(employee);
				if (result)
					System.out.println("Employee Added!");
				else {
					System.out.println("Failed");
				}
				break;

			case 2:
				System.out.print("How Many Employee do you want to Enter: ");
				int nof_emp = scanner.nextInt();
				arrayofemp = new Employee[nof_emp];
				for (int i = 0; i < nof_emp; i++) {
					scanner.nextLine();
					System.out.print("Enter Employee name: ");
					emp_name = scanner.nextLine();
					System.out.print("Enter Employee Salary: ");
					salary = scanner.nextDouble();
					employee = new Employee(0, salary,emp_name);
					arrayofemp[i] = employee;
				}
				result = employeeUtil.addAllEmployee(arrayofemp);
				if (result)
					System.out.println("Employee Added Successfully!.");
				else {
					System.out.println("Failed!");
				}
				break;
			case 3:
				System.out.print("Enter the Employee id: ");
				emp_id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter new Employee name");
				emp_name = scanner.nextLine();
				System.out.print("Enter new Salary: ");
				salary = scanner.nextDouble();
				result = employeeUtil.updateEmployee(emp_id, emp_name, salary);
				if (result)
					System.out.println("Employee Updated Successfully");
				else {
					System.out.println("Book ID not found.");
				}
				break;

			case 4:
				System.out.print("Enter Employee id: ");
				emp_id = scanner.nextInt();
				result = employeeUtil.deleteEmployee(emp_id);
				if (result)
					System.out.println("Employee Deleted Successfully");
				else {
					System.out.println("Employee ID not found");
				}
				break;
			case 5:
				System.out.print("Enter Employee id: ");
				emp_id = scanner.nextInt();
				employee = employeeUtil.getEmployeeById(emp_id);
				System.out.println(employee);
				break;
			case 6:
				System.out.print("Thank You!!!");
				System.exit(0);
				break;
			default:
				break;
			}
			System.out.print("Do you want to continue(Yes/no)?: ");
			yesorno = scanner.next();
		} while (yesorno.toLowerCase().equals("yes"));

		scanner.close();
	}
}
