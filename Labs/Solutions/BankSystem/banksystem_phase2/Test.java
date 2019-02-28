
public class Test {

	public static void main(String[] args) {
		/*Log l=new Log(11111,1,"sdfasdfds",455);
		Log dfsd=new Log(34534,4,"gfhfdhdgfhfg",-786);
		Logger logger=new Logger("mario");
		logger.log(l);
		logger.log(dfsd);

		System.out.println("_____________________________");
		Account a=new Account(1,34.67f);
		System.out.println(a.getId());
		System.out.println(a.getBalance());
		a.setBalance(67.34f);
		System.out.println(a.getBalance());
		*/
		
		Account a1=new Account(1,2000);
		Account a2=new Account(2,3000);
		Client c=new Client(1,"Moshe",10000);
		c.addAccount(a1);
		c.addAccount(a2);
		System.out.println(c.getFortune());
		c.removeAccount(2);
		System.out.println(c.getFortune());
		c.withdraw(3000);
		System.out.println(c.getFortune());
		c.deposit(3000);
		System.out.println(c.getFortune());
		
		//c.withdraw(ammount)
	}

}
