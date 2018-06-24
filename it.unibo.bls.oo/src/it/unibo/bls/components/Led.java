package it.unibo.bls.components;

import it.unibo.bls.interfaces.ILed;

public class Led implements ILed{
private boolean state = false;

//Factory method
public static ILed createLed(){
	return new Led();
}
@Override
public void turnOn(){
	state = true;
}
@Override
public void turnOff() {
	state = false;
}
@Override
public boolean getState(){
	return state;
}

}
