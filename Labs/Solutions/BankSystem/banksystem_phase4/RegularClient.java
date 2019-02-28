
public class RegularClient extends Client {
	
	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		interestRate=0.1f;
		commissionRate=3;
	}
	
	public String toString(){
		return "ID: "+getId()+" Type: Regular Client";
	}
}
