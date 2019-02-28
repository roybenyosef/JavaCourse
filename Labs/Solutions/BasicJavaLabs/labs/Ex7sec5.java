
package labs;
import java.text.DecimalFormat;

public class Ex7sec5 {	
	public static void main(String [] args)
	{
		int studentNum = 20;
		int gradeNum = 10;
		StudentStatistics s = new StudentStatistics(studentNum,gradeNum);
		
		for(int i=0; i<studentNum; i++){
			System.out.print("Average of student " + (i+1) + " ");
			s.printStudentGrades(i);		
		System.out.println(" is " + s.getStudentAverage(i));
		}
		
		DecimalFormat df = new DecimalFormat(".##");
		System.out.println("Average of class is: " +df.format(s.getClassAverage()));
	}	
}
