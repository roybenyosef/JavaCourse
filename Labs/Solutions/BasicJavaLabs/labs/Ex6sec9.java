package labs;

public class Ex6sec9 {
	
	public static void main(String [] args)
	{
		int f = (int)(Math.random()*51);
		System.out.println("number is " + f);
		fib(f);
	}
	
	public static void fib(int n)
	{
		System.out.print("[");
		int fibminus2=0;
		int fibminus1=1;
		int fib=0;

		if (n==0 || n==1){
			System.out.print(n);
			return;
		}

		for(int i=2;i<=n;i++)
		{
			fib=fibminus1+fibminus2;
			fibminus2=fibminus1;
			fibminus1=fib;
			System.out.print(" " + fib);
		}
		System.out.print("]");
	}
}
