package testCases;

import pages.LoginPage;
import utility.BaseClass2;
import utility.CommonMethods;

public class testingCommonMethods {
	
static LoginPage lp;

	public static void main(String[] args) {
		lp= new LoginPage();
		CommonMethods.sendText(lp.userTextBox, BaseClass2.getProperty("username"));
		
		CommonMethods.waitForClickability(lp.LoginButton).click();
		
		CommonMethods.clickMethod(lp.LoginButton);
	}

}
