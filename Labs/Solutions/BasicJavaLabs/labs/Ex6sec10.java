package labs;

public class Ex6sec10 {
	public static void main(String [] args){
		int num=1000,curr=0;
		outer: for(int i=0;i<=num;i++){
			if(i%7==0){
				System.out.println("Boom !");
				continue;
			}
			curr=i;
			int digit=0;
			while(curr>0){
				digit=curr%10;
				curr/=10;
				if(digit==7){
					System.out.println("Boom !");
					continue outer;
				}
			}
			System.out.println(i);
		}
	}
}
