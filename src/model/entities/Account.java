package model.entities;

import javax.security.auth.login.AccountException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withdraw(Double amount) throws AccountException {
		if (balance == 0) {
			throw new AccountException("Your account isn't balance.");
		} else if (amount > withdrawLimit) {
			throw new AccountException("Your withdraw value is bigger than your widtdraw limit.");
		} else if (balance < amount) {
			throw new AccountException("Your balance is smaller than your withdraw value.");
		} else {
			balance -= amount;
		}
	}

}
