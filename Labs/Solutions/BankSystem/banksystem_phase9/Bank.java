package banksystem_phase9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class Bank {
	private float balance;

	private ArrayList<Client> clients;

	private Logger logService;

	private static Bank b = new Bank();

	private Bank() {		
		this.logService = new Logger("sun.jdbc.odbc.JdbcOdbcDriver");
		this.logService.openConnection();
		this.clients = new ArrayList<Client>();
		this.startAccountUpdate();		
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
	
	public void printClientList() {
		Iterator<Client> i = clients.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}

	public void store() {
		File f = new File("bank.data");
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(f));
			o.writeObject(clients);
			o.close();
		} catch (IOException ioe) {
			Log l = new Log(System.currentTimeMillis(), 0,
					"Could not write to file bank.data", 0);
		} finally {
			try {
				o.close();
			} catch (Exception ioe) {
				System.out.println("ERROR: Could not close the stream");
			}
		}
	}

	
	/*
	 * third option for load
	 */
	private void load3() {
		File f = new File("bank.data");
		ObjectInputStream o = null;
		List<? extends Client> l = null;
		try {
			o = new ObjectInputStream(new FileInputStream(f));
			l = (List<? extends Client>) o.readObject();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			Log lo = new Log(System.currentTimeMillis(), 0,
					"Empty bank system ", 0);
			Logger.log(lo);
		} catch (ClassNotFoundException cnf) {
			Log lo = new Log(System.currentTimeMillis(), 0,
					"Could not convert the object in the file", 0);
			Logger.log(lo);
		} catch (Exception e) {
			Log lo = new Log(System.currentTimeMillis(), 0, e.getMessage(), 0);
			Logger.log(lo);
		}

		if (l != null) {
			ArrayList<Client> ll = new ArrayList<Client>(l);			
			this.clients = new ArrayList<Client>(ll);
		} else
			this.clients = new ArrayList<Client>();
	}
	
	public void startAccountUpdate() {
		Runnable r = new AutoUpdater(this.clients);
		Thread t = new Thread(r);
		t.start();
	}
}
