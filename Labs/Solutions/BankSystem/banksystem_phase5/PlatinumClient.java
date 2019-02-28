
public class PlatinumClient extends Client {
	
	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		interestRate=0.1f;
		commissionRate=1;
	}
	
	public String toString(){
		return "ID: "+getId()+" Type: Platinum Client";
	}
}