package labs;

public class Ex7sec2 {
	public static void main(String [] args){
		int[] array50 = new int[50];
		int temp;
		for(int i=0; i<array50.length; i++)
		{
			temp = (int)(Math.random()*101);
			array50[i] = temp;
			System.out.println("the " + (i+1) + "th number is " + array50[i]);
		}			
		
		int max = 0;
		for(int i=0; i<array50.length; i++)
		{
			if(array50[i] > max)
				max = array50[i];
		}
		
		System.out.println("the maximum is "+ max);
	}
	
		
}
