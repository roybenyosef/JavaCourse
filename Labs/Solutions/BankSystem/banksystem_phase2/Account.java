
public class Account {
	
	private int id;
	private float balance;
	
	public Account(int id, float balance) {
		this.id = id;
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		Log l=new Log(System.currentTimeMillis(),id,"this account balance was updated",balance);
		Logger logger=new Logger("aaa");
		logger.log(l);
	}

	public int getId() {
		return id;
	}
	
	
}
