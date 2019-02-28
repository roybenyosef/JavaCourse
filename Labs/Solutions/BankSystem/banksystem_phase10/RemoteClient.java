package banksystem_phase10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemoteClient extends Client{
	public RemoteClient(int id, String name, float balance)
	{
		super(id,name,balance);
	}
	
	public String toString(){
		return this.getId() + " Remote client";
	}
	
	public void wire(float amount){
		Socket s;
		try {
			s = new Socket("127.0.0.1",5555);
			OutputStream o = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(o);
			dos.writeFloat(amount);
			this.setBalance(this.getBalance()-amount);
			InputStream i = s.getInputStream();
			DataInputStream dis = new DataInputStream(i);			 
			Logger.log(new Log(System.currentTimeMillis(), this.getId(), dis.readUTF(),amount));
			dis.close();
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
