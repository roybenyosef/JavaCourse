
public class GoldClient extends Client{

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		interestRate=0.1f;
		commissionRate=2;
	}

	public String toString(){
		return "ID: "+getId()+" Type: Gold Client";
	}
}
