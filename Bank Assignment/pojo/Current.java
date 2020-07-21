package com.montran.pojo;

public class Current extends Account {

	private double overdradtBalance;
	private double overdraftopy;
	
	public double getOverdraftopy() {
		return overdraftopy;
	}

	public void setOverdraftopy(double overdraftopy) {
		this.overdraftopy = overdraftopy;
	}

	public Current() {
		// TODO Auto-generated constructor stub
	}

	public Current(int accountNumber, String name, double balance, double overdradtBalance) {
		super(accountNumber, name, balance);
		this.overdradtBalance = overdradtBalance;
		overdraftopy = overdradtBalance;
	}

	public double getOverdradtBalance() {
		return overdradtBalance;
	}

	public void setOverdradtBalance(double overdradtBalance) {
		this.overdradtBalance = overdradtBalance;
	}

	@Override
	public boolean withdraw(double withdraw) {
		// TODO Auto-generated method stub
		if (withdraw > 0 && withdraw <= getBalance() && getBalance() > 0) {
			setBalance(getBalance() - withdraw);
			return true;
		}

		if (withdraw > 0 && withdraw > getBalance() && overdradtBalance > 0) {
			double temp = withdraw - getBalance();
			setBalance(getBalance() - (withdraw - temp));
			overdradtBalance = overdradtBalance - temp;
			return true;
		}

		return false;
	}

	@Override
	public boolean deposit(double deposit) {
		if(overdradtBalance+deposit>overdraftopy && deposit>=0) {
			double temp=overdradtBalance+deposit-overdraftopy;
			overdradtBalance=overdraftopy;
			setBalance(getBalance()+temp);
			return true;
		}
		if(overdradtBalance+deposit<overdraftopy && deposit>=0) {
			overdradtBalance=overdradtBalance+deposit;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Current [overdradtBalance=" + overdradtBalance + ", AccountNumber=" + getAccountNumber() + ", Name="
				+ getName() + ", Balance=" + getBalance() + "]";
	}

}
