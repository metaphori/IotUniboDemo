package it.unibo.bls.akka;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import it.unibo.bls.utils.BlsFactory;
  
public class MainAkkaSystem {

/*
 * The Button is a conventional object that interacts with a  
 * BlsAkkaControl that sends a message to a Led implemented as an actor.
 * The actor Led handles a LedGui in a given env 	
 */
	
private ActorRef led , button ;
private ActorSystem system;
private Frame frame ;
private BorderLayout layout = new BorderLayout();

	public MainAkkaSystem(){
		initFrame();
		initTheSystem();
	}
	public void initTheSystem(){
		system            = ActorSystem.create("blsAkka");
		led               = BlsFactory.createLedAkka(system,frame);
 		button            = BlsFactory.createButtonAkka(system, "PRESS", led,  frame);	
 		led.tell("turnOff", ActorRef.noSender());
	}
	public void initFrame(){
 		frame = new Frame();
 		frame.setSize( new Dimension(400,200) );
 		frame.setLayout(layout);		
 		frame.addWindowListener(new WindowListener() {			
			@Override
			public void windowOpened(WindowEvent e) {}				
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);				
			}			
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		}); 	
		frame.setVisible(true);
 	}
	public ActorRef getButton(){
		return button;
	}
	public ActorRef getLed(){
		return led;
	}
	public ActorSystem getAkkaSystem(){
		return system;
	}
	public static void main(String[] args) {
 		new MainAkkaSystem();
	}
}
