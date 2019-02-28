package banksystem_phase8;

public class Log {
	private long timestamp;
	private int id;
	private String description;
	private float amount;
	
	public Log(long timestamp, int id, String description, float amount){
		this.timestamp = timestamp;
		this.id = id;
		this.description = description;
		this.amount = amount;
	}
	
	public String getData(){
		String returned = "the timestamp is: "+ new java.util.Date(this.timestamp) + "\n" + 
						  "the id is: " + this.id + "\n" + 
						  "the description is: " + this.description + "\n" +
						  "the amount is: " + this.amount + "\n";  
		return returned;
	}
	
	public String toString()
	{
		return getData();
	}
	
}
