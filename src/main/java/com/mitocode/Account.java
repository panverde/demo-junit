package com.mitocode;

public class Account {

	private double amount;
	private static final double MIN_AMOUNT = 0.10;


	public Account(double amount) {
		this.amount = amount;
	}

	public boolean transfer(Account destinationAccount, double transferAmount) throws MessageException {

		if (!checkSufficientFunds(transferAmount)) {
			throw new MessageException("Insufficient funds.");
		} else if (!checkMinimumAmount(transferAmount)) {
			throw new MessageException("Minimum amount not allowed.");
		} else {
			this.withdraw(transferAmount);
			destinationAccount.amount += transferAmount;
			return true;
		}
	}

	private boolean checkSufficientFunds(double transferAmount) {
		return transferAmount <= this.amount;
	}

	private boolean checkMinimumAmount(double transferAmount) {
		return transferAmount >= MIN_AMOUNT;
	}
	
	public void withdraw(double transferAmount) {
		this.amount -= transferAmount;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}
	
}
