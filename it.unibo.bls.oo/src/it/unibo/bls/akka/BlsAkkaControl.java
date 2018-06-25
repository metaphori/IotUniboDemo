package it.unibo.bls.akka;
import java.awt.event.ActionEvent;
import akka.actor.ActorRef;
import it.unibo.bls.components.ButtonListenerNaive;
  
public class BlsAkkaControl extends ButtonListenerNaive {
private ActorRef led;

	public BlsAkkaControl(  ActorRef led ){
 		this.led        = led;
	}	
 	@Override
	public void actionPerformed(ActionEvent e) {
 		led.tell("switch", ActorRef.noSender());
 	}
 	//Called by ButtonAkka
 	public void execAction(String cmd) {
 		led.tell("switch", ActorRef.noSender());
	}
}
