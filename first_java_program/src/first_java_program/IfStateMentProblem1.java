package first_java_program;

public class IfStateMentProblem1 {

	public static void main(String[] args) {
		
		int korScore = (int) (Math.random() * 100);
		int engScore = (int) (Math.random() * 100);
		int mathScore = (int) (Math.random() * 100);
		int progScore = (int) (Math.random() * 100);
		
//		int korScore = 90;
//		int engScore = 88;
//		int mathScore = 70;
//		int progScore = 80;
		
		int sum = 0;
		int average = 0;
		System.out.println("korScore: " + korScore);
		System.out.println("engScore: " + engScore);
		System.out.println("mathScore: "+ mathScore);
		System.out.println("progScore: "+ progScore);
		
		sum = korScore + engScore + mathScore + progScore;
		System.out.println("sum: " + sum);
		
		average = sum / 4;
		System.out.println("average: " + average);
		
		if (average >= 95) {
			System.out.println("A+"); }
		else if (average >= 90) {
			System.out.println("A"); }
		else if (average >= 85) {
			System.out.println("B+"); }
		else if (average >= 80) {
			System.out.println("B"); }
		else if (average >=70) {
			System.out.println("C"); }
		else {
			System.out.println("F");}
	}
}	
