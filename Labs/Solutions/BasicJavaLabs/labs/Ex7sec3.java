package labs;

public class Ex7sec3 {
	public static void main(String[] args) {
		int[] array10 = new int[10];
		
		System.out.print("{");
		for (int i = 0; i < array10.length; i++) {
			int num = ((int) (Math.random() * 11));
			array10[i] = num;
			System.out.print(array10[i]);
			if(i != array10.length-1)
				System.out.print(",");
		}		
		
		System.out.println("}");
		
		int numOfDups = 0;
		int i = 1;
		while (i < 11) { //mark duplicates and count duplicate numbers
			int numOfTimes = 0;
			for (int j = 0; j < array10.length; j++) {
				if (i == array10[j]) { // found a number
					numOfTimes++;
					if (numOfTimes > 1){ // found a duplicate
						array10[j] = -1;
						numOfDups++;
					}
				}				
			}				
			i++;
		}
		
		int[] noDups = new int[10-numOfDups];
		int k=0;
		for(i=0; i<array10.length; i++){
			if(array10[i] != -1){
				noDups[k] = array10[i];
				k++;
				
			}			
		}		
		
		System.out.print("{");
		for(i=0; i<noDups.length;i++){
			System.out.print(noDups[i]);
			if(i != noDups.length-1)
				System.out.print(",");			
		}
		System.out.print("}");		
		
	}
}
