package labs;

public class Ex7sec4 {
	public static void main(String [] args){
		int[] array10 = new int[10];	
		
		for (int i = 0; i < array10.length; i++) {
			int num = ((int) (Math.random() * 11));
			array10[i] = num;			
		}		
		print(array10);
		
		for(int i=0; i<Math.floor(array10.length/2); i++)			
	         swap(array10, i, (array10.length-1)-i);
		print(array10);
	}
	
	public static void swap(int[] a, int source,int dest)
	{
		int temp = a[source];
		a[source] = a[dest];
		a[dest] = temp;
	}
	
	public static void print(int[] a)
	{
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i != a.length-1)
				System.out.print(",");
		}
		System.out.println("}");
	}
}
