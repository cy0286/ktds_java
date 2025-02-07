package com.ktdsuniversity.edu.interfaceexam;

public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * RemoteControl(interface)
		 * 	-> (extends) DanawaTvSignal(interface)
		 * 	
		 * StandardTvRemoteControl (class)
		 * 	-> (implements) RemoteControl (interface)
		 * 
		 * DanawaRemoteControl (class)
		 * 	-> (implements) DanawaTvSignal (interface)
		 * 		-> (extends) RemoteControl (interface)
		 * 
		 * DanawaTvSignal (interface) is a RemoteControl (interface)
		 * StandardTvRemoteControl (class)  is a RemoteControl (interface)
		 * DanawaRemoteControl (class) is a DanawaTvSignal (interface)
		 * DanawaRemoteControl (class) is a RemoteControl (interface) 
		 * because DanawaTvSignal is a RemoteControl
		 */
		
		
		// LgTvRemoteControl lgRemoteControl = new LgTvRemoteControl();
		RemoteControl godRemoteControl = new StandardTvRemoteControl();
		
		SamsungTV qhdTV = new SamsungTV();
		qhdTV.welcome(godRemoteControl);
		qhdTV.goodbye(godRemoteControl);
		// qhdTV.goodbye(lgRemoteControl);
		

		System.out.println("=====================");
		LgTV oledTv = new LgTV();
		// oledTv.on(lgRemoteControl);
		oledTv.on(godRemoteControl);
		oledTv.off(godRemoteControl);
		
		/**
		 *  상속의 의미 1. 확장 2. is a
		 *  인터페이스를 구현하는 것도 is a 가 성립함
		 *  (StandardTv)RemoteControl is a RemoteControl
		 *  LgRemoteControl은 REtmoeControl 이라는 표준을 지키지 않음
		 */

		System.out.println("=====================");
		RemoteControl danawaRemoteControl= new DanawaRemoteCOntrol();
		oledTv.on(godRemoteControl);
		oledTv.off(danawaRemoteControl);
		
		// SAMSUNG, LG TV 둘 다 다나와의 표준 기능을 사용 가능함
		System.out.println("=====================");
		qhdTV.welcome(danawaRemoteControl);
		qhdTV.goodbye(danawaRemoteControl);
		
		oledTv.on(godRemoteControl);
		oledTv.off(godRemoteControl);
		
		System.out.println("=====================");
		oledTv.on(danawaRemoteControl);
		oledTv.off(danawaRemoteControl);
	}
}
