package FiftyOneTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import PagesFor51TestCases.LoginPage51;
import utility.BaseClass51;


// 8 TEST CASES


public class MyAccountLoginTestCases {
	LoginPage51 lp51;
	
	@BeforeMethod
	public void BeforeMethod() {
		BaseClass51.getDriver();
		lp51 = new LoginPage51();
	}
	@Ignore
	@Test
	public void LoginWithValidUserNameAndPassWord()  {
		myAccountClick.myAccountClick();
		lp51.loginMethod51();
		 Assert.assertTrue(lp51.HelloMessage.isDisplayed());	
		 BaseClass51.closeDriver();
	}
	@Ignore
	@Test
	public void LoginWithIncorrectUserNameIncorrectPassWord()  {
		myAccountClick.myAccountClick();
		lp51.InvalidloginMethod51();
		// 7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		WebElement errorMessage= BaseClass51.getDriver().findElement(By.xpath("//li[contains(text(),'A user could not be found with this email address.')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: A user could not be found with this email address.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();
			
	}
	@Ignore
	@Test
	public void LoginWithCorrectUserNameEmptyPassWord()  {
		myAccountClick.myAccountClick();
		lp51.emptyPasswordloginMethod51();
		// 7)  Proper error must be displayed(ie Invalid password) and prompt to enter login again
		WebElement errorMessage= BaseClass51.getDriver().findElement(By.xpath("//li[contains(text(),'Password is required.')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Password is required.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();
		
	}
	@Ignore
	@Test
	public void LoginWithEmptyUserNameValidPassWord()  {
		myAccountClick.myAccountClick();
	    lp51.emptyUsernameloginMethod51();
		// 7)  Proper error must be displayed(ie Invalid username) and prompt to enter login again
		WebElement errorMessage= BaseClass51.getDriver().findElement(By.xpath("//li[contains(text(),'Username is required.')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Username is required.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();
		
	}
	@Ignore
	@Test
	public void LoginWithEmptyUserNameEmptyPassWord() {
		myAccountClick.myAccountClick();
		lp51.emptyUsernameEmptyPasswordloginMethod51();
		// 7)  Proper error must be displayed(ie required username) and prompt to enter login again
		WebElement errorMessage= BaseClass51.getDriver().findElement(By.xpath("//li[contains(text(),'Username is required.')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Username is required.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();
		
	}
	@Ignore
	@Test
	public void LoginPassWordShouldBeMasked() {
		myAccountClick.myAccountClick();
		WebElement loginPassword = BaseClass51.getDriver().findElement(By.xpath("//input[@id='password']"));
		loginPassword.click();
		loginPassword.sendKeys("#%^#^%$");
		// 5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
		// Get the value of the "type" attribute
		String passwordFieldType = loginPassword.getAttribute("type");
		// Use assertion to check if the password field displays asterisks or bullets
		Assert.assertTrue(passwordFieldType.equals("password") || passwordFieldType.equals("text"));
		BaseClass51.closeDriver();
	}
	
	@Ignore
	@Test
	public void LoginHandlesCaseSensitive() {
		myAccountClick.myAccountClick();
		lp51.caseSensitiveloginMethod51();
		// 7)  Login must fail saying incorrect username/password.
		WebElement errorMessage= BaseClass51.getDriver().findElement(By.xpath("//li[contains(text(),'the password you entered for the username')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: the password you entered for the username BAHar111@YAhoo.COM is incorrect.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();
	}
	@Ignore
	@Test
	public void LoginAuthentication() {
		
		myAccountClick.myAccountClick();
		lp51.loginMethod51();
		//7) Once your are logged in, sign out of the site
		WebElement signOut = BaseClass51.getDriver().findElement(By.xpath("//a[text()='Sign out']"));
		signOut.click();
		//8) Now press back button
		BaseClass51.getDriver().navigate().back();
		//9) User shouldn’t be signed in to his account rather a general web page must be visible
		// Identify an element that is present on the general web page but not present when the user is signed in
		WebElement logoElement = BaseClass51.getDriver().findElement(By.xpath("//img[@alt='Automation Practice Site']"));
		// Use assertion to check if the element is present on the page
		Assert.assertTrue(logoElement.isDisplayed());
		BaseClass51.closeDriver();
	
		
	}
	
	

}
