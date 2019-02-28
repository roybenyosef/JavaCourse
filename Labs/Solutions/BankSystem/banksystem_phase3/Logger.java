
public class Logger {
	
	private String driverName;
	
	public Logger(String driverName) {
		this.driverName = driverName;
	}
	
	public static void log(Log l){
		System.out.println(l);
	}
	
	public Log[] getLogs(){
		//empty
		return null;
	}
	
}
