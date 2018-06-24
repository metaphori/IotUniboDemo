package it.unibo.bls.akka;
import java.awt.Frame;
import akka.actor.UntypedActor;
import it.unibo.bls.interfaces.ILed;
import it.unibo.bls.utils.BlsFactory;

/*
 * An actor that handles a LedGui in a given environment
 */
public class LedAkka extends UntypedActor {
	private  ILed led;
 	
	public LedAkka( Frame frame ){
		led = BlsFactory.createLed( frame   );
 	}
	@Override
	public void onReceive(Object msg) throws Throwable {
//		System.out.println("LedAkka onReceive=" + msg);
		System.out.println("LedAkka onReceive=" + msg + " " + getSender() );		
		String msgStr = msg.toString();
		if( msgStr.equals("turnOff"))  {
			led.turnOff();
		}else if( msgStr.equals("turnOn"))  {
			led.turnOn();
		}else if( msgStr.equals("switch"))  {
			if( led.getState() ) led.turnOff(); else led.turnOn();		
		}else if( msgStr.equals("getState"))  {
			this.getSender().tell(""+led.getState(), getSelf() );
//			getContext().stop(getSelf());
		}
	}
}
