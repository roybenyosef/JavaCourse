package labs;

public class Ex6sec7 {
	public static void main(String [] args)
	{
		int n = (int)(Math.random()*11);
		System.out.println("the number is " + n);
		int k, prod;
		
		prod = 1; 
		for(k=1; k<=n; ++k)
			prod = prod * k;
		
		System.out.println("the fatorial is " + prod);
	}
}
