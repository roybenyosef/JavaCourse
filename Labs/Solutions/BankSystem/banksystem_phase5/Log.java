import java.util.Date;


public class Log {
	
	private long timestamp;
	private int clientId;
	private String description;
	private float amount;
	
	public Log(long timestamp, int clientId, String description, float amount) {
		this.timestamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}
	
	public String toString(){
		return new Date(timestamp)+" "+clientId+" "+description+" "+amount;
	}
	
	
}
