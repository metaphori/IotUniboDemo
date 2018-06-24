package it.unibo.bls.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;

import it.unibo.bls.interfaces.ILed;
 
/*
 * A Led that USES a GUI Panel into a given a Frame
 */
public class LedWithGui extends Led{

private Panel p ; 
 
private final Dimension sizeOn  = new Dimension(100,100);
private final Dimension sizeOff = new Dimension(10,10);

public static ILed createLed( Frame frame){
	LedWithGui led = new LedWithGui(frame);
 	return led;
}
	public LedWithGui( Frame frame ) {
		super();
 		configure(frame);
  	}	
	public void configure(Frame frame){
		p = new Panel();
		p.setBackground(Color.red);
		p.setSize( sizeOff );
		frame.add(BorderLayout.CENTER,p);
  	}		    
	@Override
	public void turnOn(){
		super.turnOn();
		p.setSize( sizeOn );
		p.validate();
	}
	@Override
	public void turnOff() {
		super.turnOff();
		p.setSize( sizeOff );
		p.validate();
	}
}
