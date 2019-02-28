package banksystem_phase8;

public class WithdrawException extends Exception {
	private int clientId;
	private float currentBalance;
	private float withdrawAmount;
	
	public WithdrawException(String message, int clientId, float currnetBalance, float withdrawAmount)
	{
		super(message);
		this.clientId = clientId;
		this.currentBalance = currnetBalance;
		this.withdrawAmount = withdrawAmount;
	}
	
	public int getClientId(){
		return this.clientId;
	}
	
	public float getCurrentBalance(){
		return this.currentBalance;
	}
	
	public float getWithdrawAmount(){
		return this.withdrawAmount;
	}
}
