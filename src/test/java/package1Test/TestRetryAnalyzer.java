package package1Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetryAnalyzer {
	
	
	
	
	
	
	
	 @Test(retryAnalyzer = RetryAnalyzer.class)
	    public void test2() {
	        Assert.assertEquals(true, false);
	    }
	    
	    
	    @Test
	    public void test1() {
	        Assert.assertEquals(false, true);

	    }

	


}
