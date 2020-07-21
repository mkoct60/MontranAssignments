package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Current;
import com.montran.pojo.Savings;

public class AccountMainV7 {
	
	protected String name;
	protected double balance;
	protected int account_number;
	static AccountMainV7 accountMainV7=new AccountMainV7();
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int acc_choice;
		boolean saving_choice;
		
		
		System.out.println("Enter select account type");
		System.out.println("1. Saving");
		System.out.println("2. Current");
		System.out.print("Enter your choice: ");
		acc_choice=scanner.nextInt();
		
		switch (acc_choice) {
		case 1:
			System.out.print("Do you want to open salary account(true/false)?: ");
			saving_choice=scanner.nextBoolean();
			accountMainV7.saving(saving_choice);
			break;
		
		case 2:
			accountMainV7.current();
			break;
		default:
			System.out.println("Invalid Option Selected");
			main(args);
			break;
		}
		
		
		System.out.print("=======Thanks for Visiting. Please Visit Again ============-=");
		scanner.close();
		
	}
	
	public void saving(boolean Is_saving) {
		
		int choice;
		String decision;
		Scanner scanner=new Scanner(System.in);
		boolean isSalary=false;
		if(Is_saving==true)
			isSalary=true;
		accountMainV7.accountBasicDetails();
		Savings savings=new Savings(account_number, name, balance, isSalary);
		System.out.println(savings);
		do {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Exit");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double deposit=scanner.nextDouble();
				boolean depositflag=savings.deposit(deposit);
				if(depositflag) {
					System.out.println("Transaction Successfull!!.");
					System.out.println(savings);
				}
				if(!depositflag)
					System.out.println("Transaction Failed!!.");
				
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdraw=scanner.nextDouble();
				boolean withdrawflag=savings.withdraw(withdraw);
				if(withdrawflag) {
					System.out.println("Transaction Successfull !!.");
					System.out.println(savings);
				}
				if(!withdrawflag)
					System.out.println("Transaction Failed!");
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please select Valid Option");
				break;
			}
			System.out.println("Do you want to continue?(yes/no)");
			decision=scanner.next();
			
		}while(decision.toLowerCase().equals("yes"));
	}
	
	public void accountBasicDetails() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("1. Enter Account Number: ");
		account_number=scanner.nextInt();
		System.out.print("2. Enter Cusomer Name: ");
		name=scanner.next();
		System.out.print("3. Enter Balance: ");
		balance=scanner.nextDouble();
	}
	
	public void current() {
		Scanner scanner=new Scanner(System.in);
		String decision;
		int choice;
		double overdraftBalance;
		System.out.print("Enter Overdraft Balance: ");
		overdraftBalance=scanner.nextDouble();
		accountMainV7.accountBasicDetails();	
		Current current=new Current(account_number, name, balance, overdraftBalance);
		System.out.println(current);
		do {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Exit");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double deposit=scanner.nextDouble();
				boolean depositflag=current.deposit(deposit);
				if(depositflag) {
					System.out.println("Transaction Successfull!!.");
					System.out.println(current);
				}
				if(!depositflag)
					System.out.println("Transaction Failed!!.");
				
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdraw=scanner.nextDouble();
				boolean withdrawflag=current.withdraw(withdraw);
				if(withdrawflag) {
					System.out.println("Transaction Successfull !!.");
					System.out.println(current);
				}
				if(!withdrawflag)
					System.out.println("Transaction Failed!");
				break;
				
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please select Valid Option");
				break;
			}
			System.out.println("Do you want to continue?(yes/no)");
			decision=scanner.next();
			
		}while(decision.toLowerCase().equals("yes"));
	}
	
}
