package banksystem_phase9;

import java.io.Serializable;

public class Account implements Serializable{
	private int id;
	private float balance;
	
	public Account(int id, float balance){
		this.id = id;
		this.balance = balance;
	}
	
	public int getId(){
		return id;
	}
	
	public float getBalance(){
		return balance;
	}
	
	public void setBalance(float newbalance){
		this.balance = newbalance;
		Log l = new Log(System.currentTimeMillis(), id, "Setting a new balance", newbalance);
		Logger.log(l);
	}
	
	public boolean equals(Object o){
		boolean returned = false;
		if(o != null && o instanceof Account){
			Account c = (Account)o;
			if(c.getId()==this.id)
				returned = true;
		}
		return returned;
	}
}
