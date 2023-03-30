package FiftyOneTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import PagesFor51TestCases.LoginPage51;
import utility.BaseClass51;
import org.testng.annotations.BeforeMethod;

public class MyAccountTestCases {

	
	LoginPage51 lp51= new LoginPage51();

	@BeforeMethod
	public void BeforeMethod() {
		BaseClass51.getDriver();
		
	}
   @Ignore
	@Test
	public void myAccountsDashBoard() {
		
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		Assert.assertTrue(lp51.dashBoard.isDisplayed());
		BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void myAccountsOrder() {
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		lp51.order.click();
		Assert.assertTrue(lp51.view.isDisplayed());
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void myAccountsOrders() {
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		lp51.order.click();
		Assert.assertTrue(lp51.view.isDisplayed());
		Assert.assertTrue(lp51.orderDetails.isDisplayed());
		Assert.assertTrue(lp51.customerDetails.isDisplayed());
		Assert.assertTrue(lp51.billingDetails.isDisplayed());
		BaseClass51.closeDriver();
		
	}

	 @Ignore
	@Test
	public void myAccountOrder() {
		 lp51.list();
			lp51.refresh();
			lp51.list();
			lp51.loginEmail.click();
			lp51.loginEmail.sendKeys(BaseClass51.getProperty("username2"));
		    lp51.loginPassword.click();
		    lp51.loginPassword.sendKeys(BaseClass51.getProperty("password2"));
			lp51.login.click();
			Assert.assertTrue(lp51.logoElement.isDisplayed());
			lp51.list();
			lp51.order.click();
			Assert.assertTrue(lp51.view.isDisplayed());
	     	Assert.assertTrue(lp51.orderStatus.isDisplayed());
		    BaseClass51.closeDriver();
	}

	//@Ignore
	@Test
	public void myAccountAddressFunctionality() {
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		lp51.address.click();
		Assert.assertTrue(lp51.billingAddress.isDisplayed());
		Assert.assertTrue(lp51.shipAddress.isDisplayed());
		BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void myAccountsAddressFunctionality() {
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		lp51.address.click();
		String edit = "https://practice.automationtesting.in/my-account/edit-address/shipping";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + edit + "']")).click();
		
		lp51.shippingFirstName.sendKeys("bahar");
		lp51.shippingLastName.sendKeys("sidiq");
		lp51.shippingAddress.sendKeys("111 future is good");
		lp51.shippingCity.sendKeys("Mombay");
		lp51.shippingPostCode.sendKeys("21111");
		lp51.save.click();
		String actualErrorMessage=lp51.successMessage.getText();
		String expectedMessage = "Address changed successfully.";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
        BaseClass51.closeDriver();	
	}

	@Ignore
	@Test
	public void myAccountsAccountDetails() throws InterruptedException {
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		lp51.accountDetails.click();
		Assert.assertTrue(lp51.accountDetails.isDisplayed());
		Assert.assertTrue(lp51.passwordChange.isDisplayed());
		lp51.firstName.sendKeys("bahar");
		lp51.lastName.sendKeys("sidiq");
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
		lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.newPassword.sendKeys("Urumqi@322");
		lp51.confirmPassword.sendKeys("Urumqi@322");
		 JavascriptExecutor js = (JavascriptExecutor) BaseClass51.getDriver();
	        js.executeScript("arguments[0].click();", lp51.saveChanges);
	        String actualSuccessMessage=lp51.successMessage.getText();
			String expectedMessage = "Account details changed successfully.";
			Assert.assertTrue(actualSuccessMessage.contains(expectedMessage));
	        BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void myAccountsLogOut() {
		// 3) Click on my account Menu
		lp51.list();
		lp51.refresh();
		lp51.list();
		lp51.loginEmail.click();
		lp51.loginEmail.sendKeys("nurfad@yahoo.com");
	    lp51.loginPassword.click();
	    lp51.loginPassword.sendKeys("Urumqi@425");
		lp51.login.click();
		Assert.assertTrue(lp51.logoElement.isDisplayed());
		lp51.list();
		String logOut = "https://practice.automationtesting.in/my-account/customer-logout/";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + logOut + "']")).click();
		Assert.assertTrue(lp51.login.isDisplayed());
		BaseClass51.closeDriver();
	}

	

	}
	
	


