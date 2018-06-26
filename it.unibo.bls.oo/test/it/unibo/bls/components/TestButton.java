package it.unibo.bls.components;

import static org.junit.Assert.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import org.junit.Test;

import it.unibo.bls.applLogic.BlsApplicationLogic;
import it.unibo.bls.devices.ButtonListenerNaive;
import it.unibo.bls.devices.ButtonMock;
import it.unibo.bls.utils.UtilsForAkka;
 
public class TestButton {
private Button button;
 
/*
 * A ButtonListenerNaive is used to command a button and to inspect the result
 */
 	@Test
	public void testTheButtonMock(){
 		//Create the application logic
 		BlsApplicationLogic applLogic = new BlsApplicationLogic(null);
 		ButtonMock button = ButtonMock.createButton(applLogic);
 		button.press();
 		assertTrue("testTheButtonMock", applLogic.getNumOfActivations()==1 );	
 	}

 
 	@Test
	public void testTheButtonGui(){
  		ButtonListenerNaive listener = new ButtonListenerNaive();
		button = new Button("CLICK");
		button.addActionListener(listener);
		assertTrue("testTheButtonGui", listener.getNumOfClicks()==0 );	
		ActionEvent ev = new ActionEvent(button, 0, "CLICK");	
		listener.actionPerformed(ev);
 		assertTrue("testTheButtonGui",  listener.getNumOfClicks()==1 );
 		UtilsForAkka.delay(1000);
 		listener.actionPerformed(ev);
		assertTrue("testTheButtonGui",  listener.getNumOfClicks()==2 );
	}

 	
}
