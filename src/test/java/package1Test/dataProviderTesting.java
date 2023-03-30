package package1Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class dataProviderTesting {
	
	@DataProvider(name = "names")
    public Object[][] dpMethod(){
        return new Object[][] {{"Shafkat"}, {"Ali"}, {false}, {33}, {44.22}};
    }
    
    
    
    
    @Test(dataProvider="names")
    public void myTest(Object val) {
        System.out.println("The Parameter being passed is: --> " + val );
    }



	
	
	
	

}
