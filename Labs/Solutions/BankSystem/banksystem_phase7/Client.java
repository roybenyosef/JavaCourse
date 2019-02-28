import java.util.ArrayList;


public abstract class Client {
    private int id;
    private String name;
    private float balance;
    private ArrayList<Account> accounts=new ArrayList<Account>();
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account a){
		accounts.add(a);
	}
	
	public Account getAccount(int index){
		return accounts.get(index);
	}
	
	public void removeAccount(Account a){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i)!=null&&accounts.get(i).equals(a)){
				this.balance+=accounts.get(i).getBalance();
				Log l=new Log(System.currentTimeMillis(),a.getId(),"Account "+accounts.get(i).getId()+" was closed by client",accounts.get(i).getBalance());
				accounts.remove(a);
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
				float toAdd=a.getBalance()*interestRate/100;
				((Account)a).setBalance(((Account)a).getBalance()+toAdd);
			}
		}
	}
	
	public float getFortune(){
		float total=balance;
		for(Object a:accounts){
			if(a!=null){
				total+=((Account)a).getBalance();
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
