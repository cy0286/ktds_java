package com.ktdsuniversity.edu.interfaceexam;

public class SamsungTV {

	public void welcome(RemoteControl signal) {
		signal.powerOn();
		System.out.println("SAMSUNG");
		if (signal instanceof DanawaRemoteCOntrol drc) {
			drc.openDanawaPage();
		}
	}
	
	public void goodbye(RemoteControl signal) {
		signal.powerOff();
	}
}
