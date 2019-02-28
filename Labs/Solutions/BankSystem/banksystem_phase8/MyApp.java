package banksystem_phase8;

import java.util.ArrayList;

public class MyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = Bank.getBank();
		System.out.println("the initial balance is " + b.getBalance());
		
		int i = getMaxId(b);
		System.out.println("the maximum id is " + i);
		System.out.println("adding 3 new clients!");
		
		Client c1 = new RegularClient(i+1,"Eytan",4000);
		Client c2 = new PlatinumClient(i+2,"Eytan",4000);
		Client c3 = new GoldClient(i+3,"Eytan",4000);		
		
		b.addClient(c1);
		b.addClient(c2);
		b.addClient(c3);
		
		System.out.println("the balance is " + b.getBalance());			
		System.out.println("the balance is " + b.getBalance() + "\n");
	
		
		Account a1 = new Account(111, 400);
		Account a2 = new Account(222, 200);
		Account a3 = new Account(333, 500);
		Account a4 = new Account(444, 600);
		Account a5 = new Account(555, 700);
		Account a6 = new Account(666, 700);
		c1.addAccount(a1);
		c1.addAccount(a2);
		c1.addAccount(a3);
		c1.addAccount(a4);
		c1.addAccount(a5);		
		
		c2.addAccount(a1);
		c2.addAccount(a2);
		c2.addAccount(a3);
		c2.addAccount(a4);
		c2.addAccount(a5);		
		
		c3.addAccount(a1);
		c3.addAccount(a2);
		c3.addAccount(a3);
		c3.addAccount(a4);
		c3.addAccount(a5);
		
		
		System.out.println("the balance of the client is " + c1.getBalance());
		System.out.println("the balance is " + b.getBalance() + "\n");				
		System.out.println("the balance is " + b.getBalance() + "\n");
		
		//will now add account a6 - 700 - adds to bank balance
		c1.addAccount(a6);	    
		//added 700
		System.out.println("the balance is " + b.getBalance() + "\n");
		
		c1.deposit(1000); //added 1000 to client balance and bank balance
		System.out.println("the balance of the client is " + c1.getBalance());
		System.out.println("the balance is " + b.getBalance() + "\n");
		
		
		System.out.println("the number of clients is " + b.getClients().size());
		b.store();
		
	}
	
	public static int getMaxId(Bank b){
		ArrayList<Client> al = b.getClients();
		int maxid = 0;
		for(int i=0; i<al.size(); i++){	
			int curr = al.get(i).getId(); 
			if( maxid < curr )
				maxid =  curr;
		}
		return maxid;
	}
}
