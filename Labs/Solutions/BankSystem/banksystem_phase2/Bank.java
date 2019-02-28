
public class Bank {
	private float balance;
	private Client[] clients;
	private Logger logService;
	
	public Bank(){
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
	}
	
	public float getBalance(){
		return balance;
	}
	
	public void addClient(Client c){
		for(int i=0;i<clients.length;i++){
			if(clients[i]==null){
				clients[i]=c;
				Log l=new Log(System.currentTimeMillis(),c.getId(),"Client was added",c.getFortune());
				logService.log(l);
				balance+=c.getFortune();
				return;
			}
		}
	}
	
	public void removeClient(int id){
		for(int i=0;i<clients.length;i++){
			if(clients[i]!=null&&clients[i].getId()==id){
				balance-=clients[i].getFortune();
				Log l=new Log(System.currentTimeMillis(),id,"Client "+clients[i].getId()+" was deleted",clients[i].getFortune());
				logService.log(l);
				clients[i]=null;
			}
		}
	}
	
	public Client[] getClients(){
		return clients;
	}
	
	public void viewLogs(){
		
	}
	
	public void startAccountUpdater(){
		
	}
	
}
