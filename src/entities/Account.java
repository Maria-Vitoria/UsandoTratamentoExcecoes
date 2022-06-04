package entities;

import exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) throws DomainException{
		if (getBalance() == 0) {
			throw new DomainException("Não é possivel efetuar saque com saldo zerado!");
		}
		if(amount > getWithdrawLimit()) {
			throw new DomainException("O valor de saque é superior ao limite!");
		}	
		if (amount > getBalance()) {
			throw new DomainException("O valor de saque é superior ao saldo!");
		}
		this.balance -= amount;
	}

	public Account() {
	};

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
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

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

}
