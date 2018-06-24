package aLabDemoIot;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMainFirst {
	@Before
	public void setUp(){
		MainFirst.createTheSystem();
	}
	@Test
	public void testCreation(){
		assertTrue("", MainFirst.getApplCreated() );
	}
	@After
	public void after(){
		System.out.println("End of test");
	}
}