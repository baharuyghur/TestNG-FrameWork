package package1Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;



public class IgnoreTest {
	
	String message="cool";
	String name="best";
	
	
	@Test(enabled=false)  //this will not run
	   public void testPrint() {
		System.out.print(message);
		
	}
	@Test
	   public void testPrint2() {
		System.out.print("second test"+name);
		
	}
	
	
	
	

}
