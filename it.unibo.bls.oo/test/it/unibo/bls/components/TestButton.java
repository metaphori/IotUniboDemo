package it.unibo.bls.components;

import static org.junit.Assert.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import org.junit.Test;
 
public class TestButton {
private Button button;
 
/*
 * A ButtonListenerNaive is used to command a button and to inspect the result
 */
 	@Test
	public void testTheButton(){
  		ButtonListenerNaive listener = new ButtonListenerNaive();
		button = new Button("CLICK");
		button.addActionListener(listener);
		assertTrue("testSystemLogic", listener.getNumOfClicks()==0 );	
		ActionEvent ev               = new ActionEvent(button, 0, "CLICK");	//
		listener.actionPerformed(ev);
 		assertTrue("testSystemLogic",  listener.getNumOfClicks()==1 );
 		listener.actionPerformed(ev);
		assertTrue("testSystemLogic",  listener.getNumOfClicks()==2 );
	}

 /*
 * Test the class MainButtonGuiNaive
 */	
// 	@Test
//	public void testTheSys(){
// 		MainButtonGuiNaive sys       = MainButtonGuiNaive.createTheSystem();	
// 		ButtonListenerNaive listener = (ButtonListenerNaive) sys.getActionListener();
// 		assertTrue("testTheSys",  listener.getNumOfClicks()==0 );	
//		ActionEvent ev               = new ActionEvent(sys.getButton(), 0, "PRESS");	//
//		listener.actionPerformed(ev);
//		String evCmd = listener.getLastEvent().getActionCommand();
//		assertTrue("testTheSys", evCmd.equals("PRESS") );
// 		assertTrue("testTheSys", listener.getNumOfClicks()==1 );
// 		listener.actionPerformed(ev);
//		assertTrue("testTheSys", evCmd.equals("PRESS") );
//		assertTrue("testTheSys", listener.getNumOfClicks()==2 );
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
 	
}
