package banksystem_phase10;

import java.util.ArrayList;
public class MyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		RemoteClient c1 = new RemoteClient(1, "Eytan", 4000);
		System.out.println("the balance of the client is "+c1.getBalance());
		
		c1.wire(1000);
		
		System.out.println("after wiring the balance of the client is "+c1.getBalance());
		
	}
}
