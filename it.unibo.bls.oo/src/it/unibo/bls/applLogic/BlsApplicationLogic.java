package it.unibo.bls.applLogic;

import it.unibo.bls.interfaces.ILed;

public class BlsApplicationLogic {
	private ILed led;
	
	public BlsApplicationLogic(ILed led){
		this.led = led;
	}
	public void execute( ){
		System.out.println("BlsApplicationLogic ledstate=" + led.getState());
		if( led.getState() ) led.turnOff();
		else led.turnOn();
	}
}
