
public abstract class Client {
    private int id;
    private String name;
    private float balance;
    private Account [] accounts=new Account[5];
    protected float commissionRate;
    protected float interestRate;
    
	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
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

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account a){
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]==null){
				accounts[i]=a;
				return;
			}
		}
	}
	
	public Account getAccount(int index){
		return accounts[index];
	}
	
	public void removeAccount(Account a){
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].equals(a)){
				this.balance+=accounts[i].getBalance();
				Log l=new Log(System.currentTimeMillis(),a.getId(),"Account "+accounts[i].getId()+" was closed by client",accounts[i].getBalance());
				accounts[i]=null;
				Logger.log(l);
				return;
			}
		}
	}
	
	public void deposit(float ammount){
		balance+=ammount;
	}
	
	public void withdraw(float ammount) throws WithdrawException{
		float com=commissionRate*ammount/100;
		if(balance-(ammount+com)>0){
			balance-=ammount+com;
			Bank.addCommission(com);
		}
		throw new WithdrawException("Error !",id,balance,ammount);
	}
	
	public void autoUpdateAccounts(){
		for(Account a:accounts){
			if(a!=null){
				a.setBalance(a.getBalance()+0);
			}
		}
	}
	
	public float getFortune(){
		float total=balance;
		for(Account a:accounts){
			if(a!=null){
				total+=a.getBalance();
			}
		}
		return total;
	}

	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Client && ((Client)obj).getId()==this.id){
			return true;
		}
		return false;
	}

	public int hashCode() {
		return this.id;
	}
	
}
