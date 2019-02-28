package labs;

public class Ex7sec1 {
	public static void main(String [] args){
		int [] array10 = new int[10];
		int temp;
		
		//assignment
		for(int i=0; i<array10.length; i++)
		{
			temp = (int)(Math.random()*101);
			array10[i] = temp;
		}
		
		//sum
		double sum = 0;
		for(int i=0; i<array10.length; i++)
		{
			sum =+ array10[i];
		}
		System.out.println("the sum of the number is "+sum);
		
		//average
		double average = sum/array10.length;
		System.out.println("the average of the number is " + average);
		
		
	}
}
