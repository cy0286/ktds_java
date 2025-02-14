package com.ktdsuniversity.edu.enumexam;

public class Calculator {

	// public static int calc(String operator, int n1, int n2) {
	public static int calc(OperType operator, int n1, int n2) {	
		return switch (operator) {
//			case "+" -> n1 + n2; 
//			case "-" -> n1 - n2;
//			case "*" -> n1 * n2;
//			case "/" -> n1 / n2;
//			case Operator.ADD -> n1 + n2;
//			case Operator.SUB -> n1 - n2;
//			case Operator.MUL -> n1 * n2;
//			case Operator.DIV -> n1 / n2;		
			case OperType.ADD -> n1 + n2;
			case OperType.SUB -> n1 - n2;
			case OperType.MUL -> n1 * n2;
			case OperType.DIV -> n1 / n2;		
			default -> 0;
		};
	}
	
	public static void main(String[] args) {
		
//		String concat = "+";
//		String negative = "-";
//		String exponents = "*";
//		String slice  = "/";
		
		// int result = calc("+", 1, 2);
//		int result = calc(Operator.ADD, 1, 2);
//		System.out.println(result);
//		
//		result = calc(Operator.SUB, 1, 2);
//		System.out.println(result);
//		
//		result = calc(Operator.MUL, 1, 2);
//		System.out.println(result);
//		
//		result = calc(Operator.DIV, 1, 2);
//		System.out.println(result);
		
		int result = calc(OperType.ADD, 1, 2);
		System.out.println(result);
		
		result = calc(OperType.SUB, 1, 2);
		System.out.println(result);
		
		result = calc(OperType.MUL, 1, 2);
		System.out.println(result);
		
		result = calc(OperType.DIV, 1, 2);
		System.out.println(result);
	}
}
