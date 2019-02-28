package banksystem_phase8;
import java.util.ArrayList;

public class Logger {
	private String driverName;
	
	public Logger(String driverName){
		this.driverName = driverName;
	}
	
	public static void log(Log l){
		System.out.println(l.getData());
	}
	
	public ArrayList<Log> getLogs(){
		return null;
	}	
}
