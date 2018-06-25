package it.unibo.bls.akka;

import static org.junit.Assert.*;
import org.junit.Test;
import akka.actor.ActorRef;
import it.unibo.bls.utils.UtilsForAkka;

public class TestBlsAkka {
 	private ActorRef led , button;
	private String cmd = "PRESS";
	
	 /*
	 * Test the class MainBlsUniboEnv
	 */		
	@Test
	public void testSystemLogic(){
		MainAkkaSystem sys = new MainAkkaSystem();
		sys.initTheSystem();
		led     = sys.getLed();
		button  = sys.getButton();		
		String answer = UtilsForAkka.ask(led, "getState",1000);
		System.out.println("testSystemLogic " + answer);
		assertTrue("testSystemLogic",  answer.equals("false") );
		
		button.tell(cmd, ActorRef.noSender() );
 		UtilsForAkka.delay(100);
		answer = UtilsForAkka.ask(led, "getState",1000);
		System.out.println("testSystemLogic " + answer);
		assertTrue("testSystemLogic",  answer.equals("true") );
		
		button.tell("cmd", ActorRef.noSender() );
 		UtilsForAkka.delay(100);
		answer = UtilsForAkka.ask(led, "getState",1000);
		System.out.println("testSystemLogic " + answer);
		assertTrue("testSystemLogic",  answer.equals("false") );
  	}
 	
 }
