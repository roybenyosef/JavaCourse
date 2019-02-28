import java.util.ArrayList;


public class Logger {
	
	private String driverName;
	
	public Logger(String driverName) {
		this.driverName = driverName;
	}
	
	public static void log(Log l){
		System.out.println(l);
	}
	
	public ArrayList getLogs(){
		//empty
		return null;
	}
	
}
