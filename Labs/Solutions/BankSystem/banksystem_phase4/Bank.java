
public class Bank {
	private static Bank instance=new Bank();
	private float balance;
	private Client[] clients;
	private Logger logService;
	private static float commissionRate;
	
	public static Bank getBank(){
		return instance;
	}
	
	private Bank(){
		clients=new Client[100];
		logService=new Logger("aaaa");
	}
	
	public void setBalance(){
		balance=0;
		for(Client c:clients){
			if(c!=null){
				balance+=c.getFortune();
			}
		}
		balance+=commissionRate;
	}
	
	public float getBalance(){
		return balance;
	}
	
	public void addClient(Client c){
		for(int i=0;i<clients.length;i++){
			if(clients[i]==null){
				clients[i]=c;
				Log l=new Log(System.currentTimeMillis(),c.getId(),"Client was added",c.getFortune());
				Logger.log(l);
				balance+=c.getFortune();
				return;
			}
		}
	}
	
	public void removeClient(Client c){
		for(int i=0;i<clients.length;i++){
			if(clients[i]!=null&&clients[i].equals(c)){
				balance-=clients[i].getFortune();
				Log l=new Log(System.currentTimeMillis(),c.getId(),"Client "+clients[i].getId()+" was deleted",clients[i].getFortune());
				Logger.log(l);
				clients[i]=null;
			}
		}
	}
	
	public static void addCommission(float com){
		commissionRate+=com;
	}
	
	public Client[] getClients(){
		return clients;
	}
	
	public void viewLogs(){
		
	}
	
	public void startAccountUpdater(){
		
	}
	
	public void printClientList(){
		for(Client c:clients){
			System.out.println(c);
		}
	}
	
}
