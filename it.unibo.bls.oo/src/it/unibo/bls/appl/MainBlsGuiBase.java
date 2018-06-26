package it.unibo.bls.appl;

import it.unibo.bls.applLogic.BlsApplicationLogic;
import it.unibo.bls.devices.ButtonListener;
import it.unibo.bls.devices.ButtonAsGuiBasic;
import it.unibo.bls.devices.LedAsGui;
import it.unibo.bls.interfaces.IButton;
import it.unibo.bls.interfaces.ILed;
import it.unibo.bls.utils.Utils;
import java.awt.Frame;

/*
 * -----------------------------------------------------------
 * GAOL: show a possible ButtonLed system built in a very
 * technology-dependent way
 * -----------------------------------------------------------
 */
public class MainBlsGuiBase  {
	private Frame frame ;
	private ButtonListener buttonListener ; 
 	private IButton btn;
 	private ILed led;
  	private final String cmd = "LEDCONTROL";
 	
 	public static MainBlsGuiBase createTheSystem(){
 		return new MainBlsGuiBase();
 	}
 	
 	protected MainBlsGuiBase( ) {
 		frame = Utils.initFrame();
		createComponents();
 	}	
	
	public ButtonListener getActionListener(){
		return buttonListener;
	}
	public IButton getButton(){
		return btn;
	}
	public ILed getLed(){
		return led;
	}
	public String getCmd(){
		return cmd;
	}
	
 	protected void createComponents(){
  		//Create Led
 		led = LedAsGui.createLed( frame );
 		//Create the application logic
 		BlsApplicationLogic applLogic = new BlsApplicationLogic(led);
 		//Create Button
		buttonListener = new ButtonListener( applLogic, cmd ); 
		btn            = ButtonAsGuiBasic.createButton(frame, cmd, buttonListener);
 		led.turnOff();
	}
 
 	public static void main(String[] args) {
		createTheSystem();
 	}
}
