package it.unibo.bls.utils;
import java.awt.Frame;
import java.awt.event.ActionListener;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import it.unibo.bls.akka.ButtonAkka;
import it.unibo.bls.akka.LedAkka;
import it.unibo.bls.components.ButtonWithGui;
import it.unibo.bls.components.LedWithGui;
import it.unibo.bls.interfaces.IButton;
import it.unibo.bls.interfaces.ILed;

public class BlsFactory {
	/*
	 * BLS components low Level	
	 */
	public static IButton createButton(Frame frame, String label, ActionListener listener) {
		return new ButtonWithGui(frame, label,listener);	
 	}
	public static ILed createLed( Frame frame ){
		LedWithGui led = new LedWithGui(frame);
 		led.turnOff();
	 	return led;
	}
	/*
	 * BLS akka
	 */
	public static ActorRef createLedAkka(ActorSystem system, Frame frame  ){	
	 	return system.actorOf(Props.create(LedAkka.class, frame), "ledAkka");
	}
	public static ActorRef createButtonAkka(ActorSystem system, String cmd, ActorRef led, Frame frame){	
	 	return system.actorOf(Props.create(ButtonAkka.class, frame, cmd, led), "buttonAkka");
	}
 	
}
