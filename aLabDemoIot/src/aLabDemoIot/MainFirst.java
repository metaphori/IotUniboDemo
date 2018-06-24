package aLabDemoIot;
/*
 * -----------------------------------------------------------
 * A first application
 * -----------------------------------------------------------
 */
public class MainFirst  {
private static boolean applCreated  = false;
 	public static MainFirst createTheSystem(){
 		System.out.println("MainFirst created");
 		applCreated = true;
 		return new MainFirst();
 	}
 	
 	public static boolean getApplCreated() {
 		return applCreated;
 	}
 	
 	public static void main(String[] args) {
		createTheSystem();
 	}
}

 