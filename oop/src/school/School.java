package school;

public class School {

	public static void main(String[] args) {
		
		Student student = new Student(); 
		
		student.java = (int) (Math.random() * 100);
		student.python = (int) (Math.random() * 100);
		student.cpp = (int) (Math.random() * 100);
		student.csharp = (int) (Math.random() * 100);
		
		int sum = student.getSumAllScores();
		System.out.println(sum);
		
		double average = student.getAverage();
		System.out.println(average);
		
		double average_score = student.getCourseCredit();
		System.out.println(average_score);
		
		String grade = student.getABCDEF();
		System.out.println(grade);
	}
}
