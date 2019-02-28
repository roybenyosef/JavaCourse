import java.util.ArrayList;


public class AutoUpdater implements Runnable {
	
	private ArrayList<Client> clients;
	
	public AutoUpdater(ArrayList<Client> clients){
		this.clients=clients;
	}
	public void run() {
		for(Client c: clients){
			c.autoUpdateAccounts();
			try{Thread.sleep(60*60*24);}catch(Exception e){}
		}

	}

}
