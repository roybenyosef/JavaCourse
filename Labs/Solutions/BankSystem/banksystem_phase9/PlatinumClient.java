package banksystem_phase9;

public class PlatinumClient extends Client {
	public PlatinumClient(int id, String name, float balance)
	{
		super(id,name,balance);
		this.commissionRate = 1f;
		this.interestRate = 0.5f;
	}
	
	public String toString(){
		return this.getId() + " Platinum client";
	}

}
