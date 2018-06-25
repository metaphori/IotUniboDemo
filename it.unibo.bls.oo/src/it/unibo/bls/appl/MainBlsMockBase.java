package it.unibo.bls.appl;
import it.unibo.bls.applLogic.BlsApplicationLogic;
import it.unibo.bls.components.ButtonMock;
import it.unibo.bls.components.Led;
import it.unibo.bls.interfaces.IButton;
import it.unibo.bls.interfaces.ILed;
import it.unibo.bls.utils.UtilsForAkka;
 

/*
 * -----------------------------------------------------------
 * GAOL: show a possible ButtonLed system built by using mock devices
 * -----------------------------------------------------------
 */
public class MainBlsMockBase  {
  	private IButton btn;
 	private ILed led;
   	
  	public static MainBlsMockBase createTheSystem(){
 		return new MainBlsMockBase();
 	}
 	
 	protected MainBlsMockBase( ) {
 		createComponents();
 	}	
	
 	public IButton getButton(){
		return btn;
	}
	public ILed getLed(){
		return led;
	}
 	
 	protected void createComponents(){
  		//Create Led
 		led = Led.createLed(   );
 		//Create the application logic
 		BlsApplicationLogic applLogic = new BlsApplicationLogic(led);
 		btn = ButtonMock.createButton(  applLogic );
 		led.turnOff();
	}
 
 	public void doSomeJob() {
 		System.out.println("doSomeJob starts"   );
 		((ButtonMock)btn).press();
 		UtilsForAkka.delay(1000);
 		((ButtonMock)btn).press();
 		System.out.println("doSomeJob ends"   );
 	}
	public static void main(String[] args) {
		MainBlsMockBase sys = createTheSystem();
		sys.doSomeJob();
 	}
}
