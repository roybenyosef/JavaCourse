package banksystem_phase8;

public class GoldClient extends Client {
	public GoldClient(int id, String name, float balance)
	{
		super(id,name,balance);
		this.commissionRate = 2f;
		this.interestRate = 0.3f;
	}
	
	public String toString(){
		return this.getId() + " Gold client";
	}

}
