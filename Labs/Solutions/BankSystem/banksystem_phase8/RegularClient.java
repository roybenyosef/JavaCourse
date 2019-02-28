package banksystem_phase8;

public class RegularClient extends Client{
	public RegularClient(int id, String name, float balance)
	{
		super(id,name,balance);
		this.commissionRate = 3f;
		this.interestRate = 0.1f;
	}
	
	public String toString(){
		return this.getId() + " Regular client";
	}
}
