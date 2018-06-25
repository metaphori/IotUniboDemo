package it.unibo.bls.utils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class UtilsForAkka {
	/*
	 * SUPPORT OPERATIONS IN FUNCTIONAL STYLE
	 */
	public static ActorSystem createAkkaSystem(String systemName) {
		ActorSystem system = ActorSystem.create(systemName);
		return system;
	}
 	public static Object receiveInbox(Inbox inbox, int timeSec) {
		try {
			Object obj = inbox.receive(Duration.create(timeSec, TimeUnit.MILLISECONDS));
			return obj;
		} catch (TimeoutException e) {
			// System.out.println("receiveInbox WARNING; " + e.getMessage() );
			return null;
		}
	}
 	
 	public static String ask( ActorRef actor, String query, int timeout){
		try {
			Future<Object> f1 = Patterns.ask(actor, query, timeout);
			Timeout tout      = new Timeout(Duration.create(timeout, "milliseconds"));
			String answer     = (String) Await.result(f1,tout.duration());
 			return answer;
 		} catch (Exception e) {
 			e.printStackTrace();
 			return "error";
		} 		
 	}
	public static void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
