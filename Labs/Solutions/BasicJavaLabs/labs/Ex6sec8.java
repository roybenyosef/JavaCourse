package labs;

public class Ex6sec8 {
		
		public static void main(String [] args)
		{
			int f = (int)(Math.random()*51);
			System.out.println("index is " + f);
			int result = fib(f);
			System.out.println("fibonacci number for index is " + result);
		}
		
		public static int fib(int n)
		{
			int fibminus2=0;
			int fibminus1=1;
			int fib=0;

			if (n==0 || n==1){
				return n;
			}

			for(int i=2;i<=n;i++)
			{
				fib=fibminus1+fibminus2;
				fibminus2=fibminus1;
				fibminus1=fib;
			}
			return fib;
		}
}
