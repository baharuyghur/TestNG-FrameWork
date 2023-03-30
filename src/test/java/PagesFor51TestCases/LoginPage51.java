package PagesFor51TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass51;




public class LoginPage51 {
	
	public LoginPage51() {
		PageFactory.initElements(BaseClass51.getDriver(), this);
	}
	
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement loginEmail;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement loginPassword;
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement login;
	
	@FindBy(xpath="//img[@alt='Automation Practice Site']")
	public WebElement logoElement;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/nav/ul/li[1]/a")
	public WebElement dashBoard;
	
	@FindBy(tagName="p")
	public WebElement HelloMessage;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/nav/ul/li[2]/a")
	public WebElement order;
	
	@FindBy(xpath="//a[@class='button view']")
	public WebElement view;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/div/h2")
	public WebElement orderDetails;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/div/header[1]/h2")
	public WebElement customerDetails;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/div/header[2]/h3")
	public WebElement billingDetails;
	
	@FindBy(xpath="//*[@id='page-36']/div/div[1]/div/p")
	public WebElement orderStatus;
	
	@FindBy(xpath="//div[@class='woocommerce']/nav/ul/li[4]/a")
	public WebElement address;
	
	@FindBy(xpath="//*[text()='Billing Address']")
	public WebElement billingAddress;
	
	@FindBy(xpath="//*[text()='Shipping Address']")
	public WebElement shipAddress;
	
	@FindBy(xpath="//input[@id='shipping_first_name']")
	public WebElement shippingFirstName;
	
	@FindBy(xpath="//input[@id='shipping_last_name']")
	public WebElement shippingLastName;
	
	@FindBy(xpath="//input[@id='shipping_address_1']")
	public WebElement shippingAddress;
	
	@FindBy(xpath="//input[@id='shipping_city']")
	public WebElement shippingCity;
	
	@FindBy(xpath="//input[@id='shipping_postcode']")
	public WebElement shippingPostCode;
	
	@FindBy(xpath="//input[@class='button']")
	public WebElement save;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	public WebElement successMessage;
	
	@FindBy(xpath="//a[text()='Account Details']")
	public WebElement accountDetails;
	
	@FindBy(xpath="//legend[text()='Password Change']")
	public WebElement passwordChange;
	
	@FindBy(id="account_first_name")
	public WebElement firstName;
	
	@FindBy(id="account_last_name")
	public WebElement lastName;
	
	@FindBy(id="password_1")
	public WebElement newPassword;
	
	@FindBy(id="password_2")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='save_account_details']")
	public WebElement saveChanges;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void loginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username2"));
		loginPassword.sendKeys(BaseClass51.getProperty("password2"));
		login.click();
	}
	
	public void InvalidloginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username3"));
		loginPassword.sendKeys(BaseClass51.getProperty("password3"));
		login.click();
	}
	
	public void emptyPasswordloginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username4"));
		loginPassword.sendKeys(BaseClass51.getProperty("password4"));
		login.click();
	}
	
	public void emptyUsernameloginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username5"));
		loginPassword.sendKeys(BaseClass51.getProperty("password5"));
		login.click();
	}
	
	public void emptyUsernameEmptyPasswordloginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username6"));
		loginPassword.sendKeys(BaseClass51.getProperty("password6"));
		login.click();
	}
	
	public void maskedPasswordloginMethod51()  {
		loginPassword.sendKeys(BaseClass51.getProperty("password7"));
	}
	public void caseSensitiveloginMethod51()  {
		loginEmail.sendKeys(BaseClass51.getProperty("username8"));
		loginPassword.sendKeys(BaseClass51.getProperty("password8"));
		login.click();
	}
	
	public void list() {
        List<WebElement> options = BaseClass51.getDriver().findElements(By.xpath("//ul[@id='main-nav']/li"));
        
        for (WebElement option : options) {
            if (option.getText().equals("My Account")) {
                option.click();
                break;
            }}}
	public void refresh() {
		 BaseClass51.getDriver().navigate().refresh();
	}
	
	
	
}