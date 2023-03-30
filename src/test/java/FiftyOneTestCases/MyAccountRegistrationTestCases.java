package FiftyOneTestCases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utility.BaseClass2;


public class MyAccountRegistrationTestCases {

//5 TEST CASES


	@BeforeSuite
	public void BeforeMethod() {
        //1) Open the browser
		//2) Enter the URL “http://practice.automationtesting.in/”
		BaseClass2.getDriver();
	}
	//@Ignore
	@Test
	public void RegistrationSignIn() throws InterruptedException {
		// 3) Click on my account Menu
		myAccountClick.myAccountClick();
		// 4) Enter registered Email Address in Email-Address textbox
		WebElement email = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_email']"));
		email.click();
		email.sendKeys("bahar118@yahoo.com");
		// 5) Enter your own password in password textbox
		WebElement password =BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_password']"));
		password.click();
		password.sendKeys("Urumqi@111");
		// 6) Click on Register button
		WebElement register = BaseClass2.getDriver().findElement(By.xpath("//input[@name='register']"));
		register.click();
		// 7) User will be registered successfully and will be navigated to the Home page
        String expected=BaseClass2.getDriver().getTitle();
        String actual="My Account-Automation Practice";
        Assert.assertTrue(actual.equalsIgnoreCase(expected));
        BaseClass2.closeDriver();
        
		}
	@Ignore
	@Test   
	public void RegistrationWithInvalidEmailId() throws InterruptedException {

		// 3) Click on my account Menu
		myAccountClick.myAccountClick();
		// 4) Enter registered Email Address in Email-Address textbox
		WebElement email =BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_email']"));
		email.click();
		email.sendKeys("bahar.yahoo@com");
		// 5) Enter your own password in password textbox
		WebElement password = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_password']"));
		password.click();
		password.sendKeys("Urumqi@111");
		// 6) Click on Register button
		WebElement register = BaseClass2.getDriver().findElement(By.xpath("//input[@name='register']"));
		register.click();
		// 7)  Registration must fail with a warning message(ie You must enter a valid email address)
		WebElement errorMessage= BaseClass2.getDriver().findElement(By.xpath("//li[contains(text(),'Please provide a valid email address.')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass2.closeDriver();
	}
	@Ignore
	@Test
	public void RegistrationWithEmptyEmailId() throws InterruptedException {

		// 3) Click on my account Menu
		myAccountClick.myAccountClick();
		// 4) Enter registered Email Address in Email-Address textbox
		WebElement email = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_email']"));
		email.click();
		email.sendKeys("");
		// 5) Enter your own password in password textbox
		WebElement password = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_password']"));
		password.click();
		password.sendKeys("Urumqi@111");
		// 6) Click on Register button
		WebElement register = BaseClass2.getDriver().findElement(By.xpath("//input[@name='register']"));
		register.click();
		// 7) Registration must fail with a warning message(ie please provide valid email address)
		//WebElement errorMessage= BaseClass2.getDriver().findElement(By.xpath("//*[@id=\'page-36\']/div/div[1]/ul/li/text()"));
		WebElement errorMessage= BaseClass2.getDriver().findElement(By.xpath("//li[contains(text(), 'Please provide a valid email address')]")); 
		String actualErrorMessage=errorMessage.getText();	
		String expectedMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
		//Assert.assertEquals(actualErrorMessage,expectedMessage);
        BaseClass2.closeDriver();
	}
	@Ignore
	@Test
	
     public void RegistrationWithEmptyPassword() throws InterruptedException {

		// 3) Click on my account Menu
		myAccountClick.myAccountClick();	
		// 4) Enter registered Email Address in Email-Address textbox
		WebElement email = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_email']"));
		email.click();
		email.sendKeys("bahar@yahoo.com");
		// 5) Enter your own password in password textbox
		WebElement password = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_password']"));
		password.click();
		password.sendKeys("");
		// 6) Click on Register button
		WebElement register = BaseClass2.getDriver().findElement(By.xpath("//input[@name='register']"));
		register.click();
		// 7) Registration must fail with a warning message(ie please enter an account password)
		WebElement errorMessage= BaseClass2.getDriver().findElement(By.xpath("//li[contains(text(), 'Please enter an account password')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Please enter an account password.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass2.closeDriver();
	}
   @Ignore
	@Test
	public void RegistrationWithEmptyEmailIdAndPassword() throws InterruptedException {

		// 3) Click on my account Menu
	   myAccountClick.myAccountClick();
		// 4) Enter registered Email Address in Email-Address textbox
		WebElement email = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_email']"));
		email.click();
		email.sendKeys("");
		// 5) Enter your own password in password textbox
		WebElement password = BaseClass2.getDriver().findElement(By.xpath("//input[@id='reg_password']"));
		password.click();
		password.sendKeys("");
		// 6) Click on Register button
		WebElement register = BaseClass2.getDriver().findElement(By.xpath("//input[@name='register']"));
		register.click();
		// 7) Registration must fail with a warning message(ie please provide valid email address)
		WebElement errorMessage= BaseClass2.getDriver().findElement(By.xpath("//li[contains(text(), 'Please provide a valid email address')]")); 
		String actualErrorMessage=errorMessage.getText();
		String expectedMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass2.closeDriver();
	
		
	}

}