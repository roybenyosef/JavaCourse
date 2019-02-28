package banksystem_phase9;

import java.util.ArrayList;
import java.util.Enumeration;
import java.sql.*;

public class Logger {

	private String driverName;
	public static Connection c;
	
	public Logger(String driverName)
	{
		this.driverName = driverName;		
	}
	
	public void openConnection(){
		System.setProperty("jdbc.drivers",this.driverName);
		try {
			Enumeration e = DriverManager.getDrivers();
			while(e.hasMoreElements())
			{
				Driver d = (Driver)e.nextElement();
				System.out.println(d);
			}
			c = DriverManager.getConnection("jdbc:odbc:BankDb");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void log(Log log){		
		Statement s = null;
		try{
			s = c.createStatement();
		}catch(SQLException sql){			
			System.out.println("could not establish the connection");
		}
		java.sql.Date d = new java.sql.Date(log.getTimeStamp());
		int id = log.getClientId();
		String desc = log.getDescription();
		float amount = log.getAmount();
		try{
			s.executeUpdate("insert into LOG_TABLE values( " + d + "," + id + ",'" + desc + "'," + amount + ")");
			s.close();
		}catch(SQLException sql){
			System.out.println(sql.getMessage());
			System.out.println("could not insert into the table");
		}		
	}
	
	public static ArrayList<Log> getLogs(){
		Statement s = null;
		ArrayList<Log> al = new ArrayList<Log>();
		try{
			s = c.createStatement();
		}catch(SQLException sql){
			System.out.println("could not establish the connection");
		}		
		try{
			ResultSet rs = s.executeQuery("select * from LOG_TABLE");
			while(rs.next()){
				java.util.Date d = rs.getDate(1);
				int id = rs.getInt(2);
				String desc = rs.getString(3);
				float amount = rs.getFloat(4);
				Log l = new Log(d.getTime(), id, desc, amount);
				al.add(l);
			}
			s.close();
		}catch(SQLException sql){
			System.out.println("could not establish the connection");
		}		
		return al;
	}
}
