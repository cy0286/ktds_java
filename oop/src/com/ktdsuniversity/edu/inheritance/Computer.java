package com.ktdsuniversity.edu.inheritance;

public class Computer {

	public static void calculateAndDraw(Cpu cpu) {
		System.out.println("==============");
		cpu.calculate();
		if ( cpu instanceof Apu apu) {
			apu.draw();
		}
	}
	
	public static void main(String[] args) {
		Cpu intelChip = new Cpu("intel", "i9");
		// intelCHip.calculate();
		
		/**
		 * Cpu 클래스를 확장한 Apu
		 * Cpu 클래스의 멤버변수와 메소드에 접근이 가능함 (마치 내것처럼)
		 * 
		 * Apu amdChip = new Apu("AMD", "Rizen7");
		 * amdChip.calculate();
		 * amdChip.draw();
		 */
		
		/**
		 * 상속이 가지는 다형성의 장점
		 * SubClass는 SuperClass의 instance에 들어갈 수 있음
		 * SubClass is a SuperClass로 인해 가능함
		 * 
		 * Cpu amdChip = new Apu("AMD", "Rizen7");
		 * amdChip.calculate();
		 * Apu 는 draw 의 존재를 알지만 Cpu 는 draw 의 존재를 모름 -> 호출 못 함
		 * amdChip.draw -> error !
		 */

		/**
		 * is a
		 * Sub class is a Super Class
		 * Super class isnt a sub class
		 * => Super class is a Sub class (Type casting)
		 * 
		 * 정수 -> 정수
		 * int -> long (int is a long -> 묵시적 형변환 가능)
		 * long -> int (x) ( 가능하게 하려면 (int) longvalue, but overflow 발생 )
		 * 
		 *  type casting -> is a 관계가 성립할 때만 사용 가능
		 *  String -> int (x)
		 *  int -> String (x)
		 */
		
		/**
		 * Apu is a Cpu
		 * Cpu isnt a Apu
		 * Cpu is a Apu => 가능하려면 (Apu) cpu
		 */
		Cpu amdChip = new Apu("AMD", "Rizen7");
		// amdChip.calculate();
		
		// amdChip이 Apu의 instance가 맞다면 amdChip을 Apu amdChip으로 변환시켜서 tempAmdChip에 넣어라
		if(amdChip instanceof Apu tempAmdChip ) {
			// ((Apu) amdChip).draw();
			tempAmdChip.draw();
		}
		
		// is a 관계를 확인하는 코드
		String tempString = "asdfsadf";
		System.out.println("amdChip is a Apu: " + (amdChip instanceof Apu));
		System.out.println("tempString is a Apu: " + ((Object) tempString instanceof Apu));
		
		calculateAndDraw(intelChip);
		calculateAndDraw(amdChip);
	}
}
