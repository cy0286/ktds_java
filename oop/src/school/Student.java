package school;

public class Student {

	int java;
	int python;
	int cpp;
	int csharp;
	
	public Student(int java, int python, int cpp, int csharp) {
		this.java = java;
		this.python = python;
		this.cpp = cpp;
		this.csharp = csharp;
	}
	
	public int getSumAllScores() {
		return java + python + cpp + csharp;
	}
	
	public double getAverage() {
		int average =  (int) (getSumAllScores() / 4.0 * 100);
		return average / 100.0;
	}
	// 4.0 으로 나눠서 실수 계산을 함
	// * 100 을 해주어 소수점 이하 두 자리 얻음
	// int로 형변환 해서 소수점 이하 버림
	// 100.0으로 나누어 소수점 두자리 값으로 변환 
	
	public double getCourseCredit() {
		int courseCredit = (int) (Math.abs(getAverage() - 55) / 10.0 * 100);
		return courseCredit / 100.0;
	}
	
	public String getABCDEF() {
		if (getCourseCredit() >= 4.1) {
			return "A+";
		}
		else if (getCourseCredit() >= 3.6) {
			return "A";
		}
		else if (getCourseCredit() >= 3.1) {
			return "B+";
		}
		else if (getCourseCredit() >= 2.6) {
			return "B";
		}
		else if (getCourseCredit() >= 1.6) {
			return "C";
		}
		else if (getCourseCredit() >= 0.6) {
			return "D";
		}
		else {
			return "F";
		}
	}
}
