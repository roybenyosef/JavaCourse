import java.util.ArrayList;


public class Bank {
	private static Bank instance=new Bank();
	private float balance;
	private ArrayList<Client> clients;
	private Logger logService;
	private static float commissionRate;
	
	public static Bank getBank(){
		return instance;
	}
	
	private Bank(){
		clients=new ArrayList<Client>();
		logService=new Logger("aaaa");
		startAccountUpdater();
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
		clients.add(c);
		Log l=new Log(System.currentTimeMillis(),c.getId(),"Client was added",c.getFortune());
		Logger.log(l);
		balance+=c.getFortune();
	}
	
	public void removeClient(Client c){
		for(int i=0;i<clients.size();i++){
			if(clients.get(i)!=null&&clients.get(i).equals(c)){
				balance-=clients.get(i).getFortune();
				Log l=new Log(System.currentTimeMillis(),c.getId(),"Client "+clients.get(i).getId()+" was deleted",clients.get(i).getFortune());
				Logger.log(l);
				clients.remove(c);
			}
		}
	}
	
	public static void addCommission(float com){
		commissionRate+=com;
	}
	
	public ArrayList<Client> getClients(){
		return clients;
	}
	
	public void viewLogs(){
		
	}
	
	public void startAccountUpdater(){
		Thread t=new Thread(new AutoUpdater(clients));
		t.start();
	}
	
	public void printClientList(){
		for(Client c:clients){
			System.out.println(c);
		}
	}
	
}
