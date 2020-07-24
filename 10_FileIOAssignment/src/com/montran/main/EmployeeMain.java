package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.FileInputStreamUtil;
import com.montran.util.FileOutputStreamUtil;

public class EmployeeMain {

	public static void main(String[] args) {
		
		// Writing data into file
		FileInputStreamUtil fileInputStreamUtil=new FileInputStreamUtil();
		FileOutputStreamUtil fileOutputStreamUtil=new FileOutputStreamUtil();
		Scanner scanner=new Scanner(System.in);
		int tempEmployeeID;
		double temp_salary;
		String employee_name,orgEmp_id,org_salary,filepath="D:/myfile.txt";
		byte[] data;
		File file=new File(filepath);
		
		System.out.print("Enter Employee ID: ");
		tempEmployeeID=scanner.nextInt();
		orgEmp_id="Employee ID: "+tempEmployeeID;
		scanner.nextLine();
		System.out.print("Enter the Employee Name: ");
		employee_name="Employee Name: "+scanner.nextLine();
		System.out.print("Enter Employee Salary: ");
		temp_salary=scanner.nextDouble();
		org_salary="Salary; "+temp_salary;
		data=(orgEmp_id+" "+employee_name+" "+org_salary).getBytes();
		fileOutputStreamUtil.writeDataIntoFile(file, data);
		
		//reading data from file
		data=fileInputStreamUtil.getFilesData(file);
		for(byte byte1:data)
			System.out.print((char) byte1);
		scanner.close();
	}

}
