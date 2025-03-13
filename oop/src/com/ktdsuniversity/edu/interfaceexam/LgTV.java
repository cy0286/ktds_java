package com.ktdsuniversity.edu.interfaceexam;

public class LgTV {

	public void on(RemoteControl signal) {
		signal.powerOn();
		System.out.println("Life is Good");
		if (signal instanceof DanawaRemoteControl drc) {
			drc.openDanawaPage();
		}
	}
	
	public void off(RemoteControl signal) {
		signal.powerOff();
	}
}
