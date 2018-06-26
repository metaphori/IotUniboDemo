package it.unibo.bls.appl;
import it.unibo.bls.applLogic.BlsApplicationLogic;
import it.unibo.bls.devices.ButtonAsGui;
import it.unibo.bls.devices.LedAsGui;
import it.unibo.bls.interfaces.IButton;
import it.unibo.bls.interfaces.ILed;
import it.unibo.bls.utils.Utils;
import java.awt.Frame;

/*
 * -----------------------------------------------------------
 * A ButtonLed system built in a technology-dependent way
 * -----------------------------------------------------------
 */
public class MainBlsGui  {
	private Frame frame ;
   	private ButtonAsGui btn;
 	private ILed led;
  	private final String cmd = "LEDCONTROL";
 	
 	public static MainBlsGui createTheSystem(){
 		return new MainBlsGui();
 	} 	
 	protected MainBlsGui( ) {
 		frame = Utils.initFrame();
		createComponents();
 	}		
 	protected void createComponents(){
  		//Create Led
 		led = LedAsGui.createLed( frame );
 		//Create the application logic
 		BlsApplicationLogic applLogic = new BlsApplicationLogic(led);
 		//Create Button
 		btn = ButtonAsGui.createButton(frame, cmd, applLogic);		 
 		led.turnOff();
	}	
 	public IButton getButton(){
		return btn;
	}
	public ILed getLed(){
		return led;
	}	
  	public static void main(String[] args) {
		createTheSystem();
 	}
}
