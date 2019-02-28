package banksystem_phase10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Bank {
	private float balance;

	private ArrayList<Client> clients;

	private Logger logService;

	private static Bank b = new Bank();

	private Bank() {
		this.clients = new ArrayList<Client>();
		this.logService = new Logger("");
	}

	public static Bank getBank() {
		return b;
	}

	public float getBalance() {
		float clientsBalance = 0;
		for (int i = 0; i < clients.size(); i++) {
			Client c = (Client) clients.get(i);
			if (c != null) {
				clientsBalance += c.getFortune();
			}
		}
		return clientsBalance;
	}

	private void setBalance(float amount) {
		this.balance = amount;
	}

	public void addClient(Client newClient) {
		if (newClient != null) {
			boolean added = clients.add(newClient);
			if (added) {
				Log l = new Log(System.currentTimeMillis(), newClient.getId(),
						"Added a new client with his balance", newClient
								.getBalance());
				Logger.log(l);
				this.setBalance(this.getBalance() + newClient.getBalance());
			}
		}
	}

	public void removeClient(Client cl) {
		boolean removed = clients.remove(cl);
		if (removed) {
			Log l = new Log(System.currentTimeMillis(), cl.getId(),
					"Removed a client with his balance", cl.getBalance());
			Logger.log(l);
		}
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void viewLogs() {

	}

	public void startAccountUpdate() {

	}

	public void printClientList() {
		Iterator<Client> i = clients.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}
	
	public void startRemoteTransactions(){
		ServerSocket sk = null;
		try{
			sk = new ServerSocket(5555);			
		}catch(IOException e){}
		
		while(true){
			try{
				Socket s = sk.accept();
				InputStream i = s.getInputStream();
				DataInputStream dis = new DataInputStream(i);
				float wiredAmount = dis.readFloat();
				
				OutputStream o = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(o);				
				balance = balance + wiredAmount;
				dos.writeUTF("Wired amount of " + wiredAmount);
				dis.close();
				dos.close();
				s.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String [] args){
		Bank b = Bank.getBank();
		b.startRemoteTransactions();
	}
}
