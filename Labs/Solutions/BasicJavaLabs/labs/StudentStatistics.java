package labs;

public class StudentStatistics {
	private int [][] matrix;	
	private int numberOfGrades;
	private int numberOfStudents;
	private Object [][] matrix2;
	
	public StudentStatistics(int numberOfStudents, int numberOfGrades)
	{
		this.numberOfGrades = numberOfGrades;
		this.numberOfStudents = numberOfStudents;
	
		matrix = new int[numberOfStudents][numberOfGrades];
		matrix2 = new Object[numberOfStudents][numberOfGrades];
		
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[i].length; j++){
				matrix2[i][j] = new Object();
				System.out.println("the hash is " + matrix2[i][j].hashCode());
				matrix[i][j] = (int)(Math.random()*101);
			}
		
		
	}
	
	public double getStudentAverage(int index){
		double average = 0;
		for(int i=0; i<numberOfGrades; i++)
			average += matrix[index][i];
		average /= numberOfGrades;
		return average; 
	}
	
	public double getClassAverage(){
		double classAvg = 0;
		
		for(int i=0; i<numberOfStudents; i++)
			classAvg += this.getStudentAverage(i);
		
		classAvg /= numberOfStudents;
		return classAvg; 
	}	
	
	public void printStudentGrades(int index){
		System.out.print("{");
		for(int i=0; i<numberOfGrades; i++){
			System.out.print(matrix[index][i]);
			if( i!= numberOfGrades-1)
				System.out.print(",");
		}
		System.out.print("}");
	}
}
