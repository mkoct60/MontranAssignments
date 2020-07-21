package com.montran.pojo;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean deposit(double deposit) {
		if(deposit>0) {
			balance=balance+deposit;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(double withdraw) {
		if(withdraw>0 && withdraw<balance) {
			balance=balance-withdraw;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
