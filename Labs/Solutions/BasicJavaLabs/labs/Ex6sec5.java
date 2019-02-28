package labs;

public class Ex6sec5 {
	public static void main(String[] args) {
		int number = (int)(Math.random()*10001);
		System.out.println("the number is " + number);
		int counter = 0;
		while (number > 0) {
			counter++;
			number /= 10;
		}
		System.out.println("the number of digits is " + counter);		

		int number2 = (int)(Math.random()*10001);
		System.out.println("the number is " + number2);		
		while (number2 > 10) {
			number2 /= 10;
		}
		System.out.println("the first left digit is " + number2);

		
		int number3 =(int)(Math.random()*10001);
		System.out.println("the number is " + number3);
		int digits = 0;
		while (number3 > 0) {
			digits += (number3 % 10);
			number3 /= 10;
		}
		System.out.println("the sum of digits is " + digits);

		int number4 = (int)(Math.random()*10001);
		System.out.println("the number is " + number4);
		int rnum = 0; // Variable to hold reversed number
		int digit; // Holds number extracted by % function to be added to rnum

		String zero = "";
		while (number4 > 0) // While loop to reverse digits
		{
			rnum *= 10;
			digit = number4 % 10;
			if(digit==0 && rnum==0)
				zero = "0";
			rnum += digit;
			number4 /= 10;
		}
		System.out.println("the digits reversed are " + zero + rnum);
				
		
	}
}
