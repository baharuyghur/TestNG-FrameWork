package testCases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.BaseClass2;
import utility.CommonMethods;


public class LoginTestCases extends CommonMethods{
	
	
	
	@BeforeMethod
	public void beforeTest() {
		BaseClass2.getDriver();
		
	}
	@Test
	public void loginSuccessfully()  {
		
//		lp.userTextBox.sendKeys(BaseClass.getProperty("username"));
//		lp.passwordTextBox.sendKeys(BaseClass.getProperty("password"));
//		lp.LoginButton.click();
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass2.getProperty("admin"));
		ap.systemUsersUsernameTextBox.sendKeys(BaseClass2.getProperty("SystemUserUsername"));
        ap.userRoleDropDownToExpand.click();
        ap.chooseUserRoleOption(BaseClass2.getProperty("SystemRole"));
        ap.statusDropDownToExpand.click();
        ap.chooseUserRoleOption(BaseClass2.getProperty("enabled"));
        ap.SearchButton.click();
      
        Assert.assertTrue(ap.recordsTable.size()==1);
        	
       ap.nationalitiesButton.click();
        String nationality = "bahaIsland";
        ap.addNationality(nationality);
	  
		ap.deleteNationality(nationality);
	
	}
		
		
	}
	
	
	
	
	
	
	
	
	
