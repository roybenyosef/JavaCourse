package banksystem_phase9;

import java.util.ArrayList;


public class AutoUpdater implements Runnable {
	ArrayList<Client> al;
	
	public AutoUpdater(ArrayList<Client> al)
	{
		this.al = al;		
	}
	
	public void run() {		
		// TODO Auto-generated method stub
		for(int i=0; i<al.size(); i++)
		{	
			System.out.println("the size is " + al.size());
			System.out.println("updating accounts of client "+al.get(i).getId());
			al.get(i).autoUpdateAccounts();			
			try {
				Thread.sleep(1000*2);
			}catch(InterruptedException ie){
				
			}
		}
		
			
	}

}
