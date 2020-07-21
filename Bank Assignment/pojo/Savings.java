package com.montran.pojo;

public class Savings extends Account {
	private boolean isSalary = false;

	
	public boolean isSalary() {
		return isSalary;
	}

	public void setSalary(boolean isSalary) {
		this.isSalary = isSalary;
	}

	public Savings() {
		
	}

	public Savings(int accountNumber, String name, double balance, boolean isSalary) {
		super(accountNumber, name, balance);
		this.isSalary = isSalary;
	}

	@Override
	public boolean withdraw(double withdraw) {
		// TODO Auto-generated method stub
		if (isSalary && withdraw <= getBalance()) {
			setBalance(getBalance() - withdraw);
			return true;
		}
		if (isSalary == false && getBalance() - withdraw >= 1500) {
			setBalance(getBalance() - withdraw);
			return true;
		}
		return false;
	}

	@Override
	public boolean deposit(double deposit) {
		// TODO Auto-generated method stub
		if(deposit>0) {
			setBalance(getBalance()+deposit);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Savings [isSalary=" + isSalary + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + "]";
	}

}
