package labs;

public class Ex6sec6 {
	public static void main(String [] args)
	{
		int number = (int)(Math.random()*100101);
		int originalNumber = number;
		int rnum = 0;
		int digit; 
		while (number > 0) // While loop to reverse digits
		{
			rnum *= 10;
			digit = number % 10;
			rnum += digit;
			number /= 10;
		}
		
		System.out.println("number is " + originalNumber + " and reverse number is "+ rnum);
		if(rnum == originalNumber)
			System.out.println("number is palindrome");
		else
			System.out.println("number is not palindrome");
	}
}
