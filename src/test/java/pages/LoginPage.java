package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.BaseClass2;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(BaseClass2.getDriver(), this);
	}
	
	
	@FindBy(xpath="//*[@name='username']")
	public WebElement userTextBox;
	
	@FindBy(xpath="//*[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id='app']/div[1]//div[2]/form/div[3]/button")
	public WebElement LoginButton;
	
	
	
	
	public void loginMethod() {
		userTextBox.sendKeys(BaseClass2.getProperty("username"));
		passwordTextBox.sendKeys(BaseClass2.getProperty("password"));
		LoginButton.click();

	}
	
	

}