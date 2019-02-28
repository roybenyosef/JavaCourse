package banksystem_phase9;

import java.util.ArrayList;
import java.sql.*;
public class MyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = Bank.getBank();
		
		Client c1 = new RegularClient(1,"Eytan",4000);
		Client c2 = new PlatinumClient(2,"Eytan",4000);
		Client c3 = new GoldClient(3,"Eytan",4000);		
		
		b.addClient(c1);
		b.addClient(c2);
		b.addClient(c3);	
		
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
		
		//will now add account a6 - 700 - adds to bank balance
		c1.addAccount(a6);	    		
		c1.deposit(1000); 	
		
		System.out.println("***************** LOGS FROM DATABASE***************************");
		
		b.viewLogs();
		
		try{
			Logger.c.close();
		}catch(SQLException sql){
			System.out.println("could not close connection");
		}
	}	
}
