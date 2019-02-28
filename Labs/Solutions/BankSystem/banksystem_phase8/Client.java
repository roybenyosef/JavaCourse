package banksystem_phase8;

import java.io.Serializable;
import java.util.*;

public abstract class Client implements Serializable{
	private int id;

	private String name;

	private float balance;

	private ArrayList<Account> accounts = new ArrayList<Account>(5);

	protected float commissionRate;

	protected float interestRate;

	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float newbalance) {
		this.balance = newbalance;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public Account getAccount(int index) {
		if (index < 0 || index > accounts.size() - 1)
			return null;
		return accounts.get(index);
	}

	public void addAccount(Account acc) {
		if (acc != null) {
			boolean added = accounts.add(acc);
			if (added) {
				Log l = new Log(System.currentTimeMillis(), this.id, "Adding a new account", acc
						.getBalance());
				Logger.log(l);

			}
		}
	}

	public void removeAccount(Account acc) {
		boolean removed = accounts.remove(acc);
		if (removed) {
			Log l = new Log(System.currentTimeMillis(), acc.getId(), "Removed an account", acc
					.getBalance());
			Logger.log(l);
		}
	}

	public void deposit(float amount) {
		// comission rate is in whole numbers - for example 4 is 4%
		amount = (amount * (100 - commissionRate)) / 100;
		balance += amount;
	}

	public void withdraw(float amount) throws WithdrawException {
		if (amount > this.balance)
			throw new WithdrawException(
					"Tried to withdraw amount greater than balance", this.id,
					this.balance, amount);
		// comission rate is in whole numbers - for example 4 is 4%
		amount += (amount * commissionRate) / 100;
		balance -= amount;
	}

	public void autoUpdateAccounts() {
		float amountToAdd = 0;
		for (int i = 0; i < accounts.size(); i++) {
			Account c = accounts.get(i);
			float currentAmount = c.getBalance();
			amountToAdd = (currentAmount * this.interestRate) / 100;
			float newBalance = currentAmount + amountToAdd;
			c.setBalance(newBalance);
			Log l = new Log(System.currentTimeMillis(), this.id, "Updated account with new balance",
					newBalance);
			Logger.log(l);
		}
	}

	public float getFortune() {
		float sum = 0;
		for (int i = 0; i < accounts.size(); i++) {
			sum += accounts.get(i).getBalance();
		}
		return sum + this.balance;
	}

	public boolean equals(Object o) {
		boolean returned = false;
		if (o != null && o instanceof Client) {
			Client c = (Client) o;
			if (c.getId() == this.id)
				returned = true;
		}
		return returned;
	}
}
