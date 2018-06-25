package it.unibo.bls.akka;
import java.awt.Frame;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import it.unibo.bls.utils.BlsFactory;
 
public class ButtonAkka extends UntypedActor {
/*
 * GOAL: build a button GUI that sends a message to a Led
 */
 private String cmd;
 private BlsAkkaControl control;
 
	public ButtonAkka(Frame frame, String cmd, ActorRef led){
		this.cmd = cmd;
		control  = new BlsAkkaControl( led );  
		BlsFactory.createButton( frame, cmd, control );   
	}
	@Override
	public void onReceive(Object msg) throws Throwable { 	
		//USED FOR TESTING ONLY
		System.out.println("ButtonAkka onReceive=" + msg + " " + getSender() );		
//		String msgStr = msg.toString();
//		if( msgStr.equals( cmd ))   
			control.execAction(cmd);
	}

	
}