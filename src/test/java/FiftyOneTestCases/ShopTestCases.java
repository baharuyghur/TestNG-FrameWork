package FiftyOneTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utility.BaseClass2;
import utility.BaseClass51;

public class ShopTestCases {

	Select select;

	@BeforeSuite
	public void BeforeMethod() {

		BaseClass51.getDriver();
	}

	@Ignore
	@Test
	public void shopFilterbyPriceFunctionality() {

		shopClick.shopClick();
		WebElement from = BaseClass51.getDriver()
				.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
		Actions action = new Actions(BaseClass51.getDriver());
		action.dragAndDropBy(from, -28, 0).perform();
		String filterByPriceUrl = "https://practice.automationtesting.in/shop/?min_price=150&max_price=451";
		String actualUrl = BaseClass51.getDriver().getCurrentUrl();
		Assert.assertTrue(filterByPriceUrl.startsWith(actualUrl));
		BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void shopProductCatagoriesFunctionality() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(5000);
		WebElement productLink = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/ul/li[7]/a[1]"));
		productLink.click();
		String onlyProductPageUrl = "https://practice.automationtesting.in/product/selenium-ruby/";
		String actualUrl = BaseClass51.getDriver().getCurrentUrl();
		Assert.assertTrue(onlyProductPageUrl.startsWith(actualUrl));
		BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void shopDefaultSortingFunctionality() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(2000);
		select = new Select(BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/form/select")));
		Thread.sleep(3000);
		select.selectByVisibleText("Sort by popularity");
		String popularProductsUrl = "https://practice.automationtesting.in/shop/?orderby=popularity";
		String actualUrl = BaseClass51.getDriver().getCurrentUrl();
		Assert.assertTrue(popularProductsUrl.startsWith(actualUrl));
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void shopDefaultSortingFunctionality2() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		select = new Select(BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/form/select")));
		select.selectByVisibleText("Sort by average rating");
		String avarageRatingOnlyUrl = "https://practice.automationtesting.in/shop/?orderby=rating";
		String actualUrl = BaseClass51.getDriver().getCurrentUrl();
		Assert.assertTrue(avarageRatingOnlyUrl.startsWith(actualUrl));
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void shopDefaultSortingFunctionality3() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		select = new Select(BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/form/select")));
		select.selectByIndex(3);
		String newestProductUrl = "https://practice.automationtesting.in/shop/?orderby=date";
		String actualUrl = BaseClass51.getDriver().getCurrentUrl();
		Assert.assertTrue(newestProductUrl.startsWith(actualUrl));
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void shopDefaultSortingFunctionality4() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		select = new Select(BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/form/select")));
		select.selectByIndex(4);
		WebElement lowToHigh = BaseClass51.getDriver().findElement(By.xpath("//select[@class='orderby']/option[5]"));
		Assert.assertTrue(lowToHigh.isDisplayed());
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void shopDefaultSortingFunctionality5() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		select = new Select(BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/form/select")));
		select.selectByIndex(5);
		WebElement highToLow = BaseClass51.getDriver().findElement(By.xpath("//select[@class='orderby']/option[6]"));
		Assert.assertTrue(highToLow.isDisplayed());
		
		BaseClass51.closeDriver();
	}

	@Ignore
	@Test
	public void shopReadMoreFunctionality() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		WebElement home = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/nav/a"));
		home.click();
		String readMore = "https://practice.automationtesting.in/product/selenium-ruby/";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + readMore + "']")).click();
		WebElement outOfStock = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'product-160\']/div[2]/p"));
		Assert.assertTrue(outOfStock.isDisplayed());
		BaseClass51.closeDriver();

	}

	@Ignore
	@Test
	public void shopSaleFunctionality() throws InterruptedException {
		shopClick.shopClick();
		Thread.sleep(3000);
		WebElement home = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'content\']/nav/a"));
		home.click();
		String sale = "https://practice.automationtesting.in/product/thinking-in-html/";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + sale + "']")).click();
		WebElement price = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\'product-163\']/div[2]/div[1]/p"));
		Assert.assertTrue(price.isDisplayed());
	}

	
	@Test(priority=1)
	public void shopAddToBasketViewBasketFunctionality() throws InterruptedException {

		shopClick.shopClick();
		WebElement addToBasket = BaseClass51.getDriver().findElement(By.cssSelector("a[href^='/shop/?add-to-cart=165']"));
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass51.getDriver();
		executor.executeScript("arguments[0].click();", addToBasket);
		Thread.sleep(5000);
		WebElement viewItemButton = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/i"));
		viewItemButton.click();
		WebElement menuItemLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[3]"));
		Assert.assertTrue(menuItemLocator.isDisplayed());
		WebElement priceLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[4]"));
		Assert.assertTrue(priceLocator.isDisplayed());
		String viewBasket = "https://practice.automationtesting.in/basket/";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + viewBasket + "']")).click();

		WebElement subtotal = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']"));
		Assert.assertTrue(subtotal.isDisplayed());
		WebElement total = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='order-total']"));
		Assert.assertTrue(total.isDisplayed());
		WebElement subtotalAmount = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']/td/span"));
		WebElement totalAmount = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='order-total']/td/strong/span"));
		double subtotal2 = Double.parseDouble(subtotalAmount.getText().substring(1));
		double total2 = Double.parseDouble(totalAmount.getText().substring(1));
		double taxAmount = total2 - subtotal2;
		if (taxAmount <= 0) {
			System.out.println("Error: tax amount is not greater than zero");
		}
		double expectedTotal = subtotal2 + taxAmount;
		if (total2 <= expectedTotal) {
			System.out.println("Error: total is not greater than subtotal plus tax amount");
		}
		WebElement checkout = BaseClass51.getDriver().findElement(By.cssSelector("a[href^='https://practice.automationtesting.in/checkout/']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) BaseClass51.getDriver();
		executor2.executeScript("arguments[0].click();", checkout);

		WebElement billingdetails = BaseClass51.getDriver().findElement(By.tagName("h3"));
		String actualErrorMessage = billingdetails.getText();
		String expectedMessage = "Billing Details";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
		// 11) Now user can fill his details in billing details form and can opt any
		// payment in the payment gateway like Direct bank transfer,cheque,cash or
		// paypal.
		WebElement firstname = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_first_name']"));
		firstname.sendKeys("bahar");
		WebElement lastname = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_last_name']"));
		lastname.sendKeys("sidiq");
		WebElement email = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_email']"));
		email.sendKeys("nurfad@yahoo.com");
		WebElement phone = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_phone']"));
		phone.sendKeys("404_000_3737");
		//WebElement Country = BaseClass51.getDriver().findElement(By.xpath("//div[@class='select2-container country_to_state country_select']"));
		WebElement Country = new WebDriverWait(BaseClass51.getDriver(),10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='s2id_billing_country']")));
		Country.click();
		
        WebElement CountryInput = BaseClass51.getDriver().findElement(By.xpath("//*[@id='s2id_autogen1_search']"));
        CountryInput.clear();
        CountryInput.sendKeys("United States(US)");
        WebElement CountryInput1 = BaseClass51.getDriver().findElement(By.xpath("//*[contains(@id, 'select2-result-label-238')]"));
        CountryInput1.click();
		

		
		// WebElement countryInput = new WebDriverWait(BaseClass51.getDriver(),10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select2-search'])[1]")));
		// countryInput.sendKeys("United States(US)");
		// countryInput.sendKeys(Keys.ENTER);
		
				// *[@id='s2id_autogen1_search']
				// 12) Now click on Place Order button to complete process

				// 13) On clicking place order button user completes his process where the page
				// navigates to Order confirmation page with order details,bank details,customer
				// details and billing details.*/
			}
		
	

   @Ignore
	@Test
	public void shopAddToBasketViewBasketThroughItemLink() throws InterruptedException {
		shopClick.shopClick();
		WebElement addToBasket = BaseClass51.getDriver().findElement(By.cssSelector("a[href^='/shop/?add-to-cart=165']"));
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass51.getDriver();
		executor.executeScript("arguments[0].click();", addToBasket);
		Thread.sleep(5000);
		WebElement menuItemLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[3]"));
		Assert.assertTrue(menuItemLocator.isDisplayed());
		WebElement priceLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[4]"));
		Assert.assertTrue(priceLocator.isDisplayed());
		WebElement viewItemButton = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/i"));
		viewItemButton.click();
		WebElement subtotal = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']"));
		Assert.assertTrue(subtotal.isDisplayed());
		WebElement total = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='order-total']"));
		Assert.assertTrue(total.isDisplayed());
		WebElement subtotalAmount = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']/td/span"));
		WebElement totalAmount = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='order-total']/td/strong/span"));
		double subtotal2 = Double.parseDouble(subtotalAmount.getText().substring(1));
		double total2 = Double.parseDouble(totalAmount.getText().substring(1));
		double taxAmount = total2 - subtotal2;
		if (taxAmount <= 0) {
			System.out.println("Error: tax amount is not greater than zero");
		}
		double expectedTotal = subtotal2 + taxAmount;
		if (total2 <= expectedTotal) {
			System.out.println("Error: total is not greater than subtotal plus tax amount");
		}
		WebElement checkout = BaseClass51.getDriver().findElement(By.cssSelector("a[href^='https://practice.automationtesting.in/checkout/']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) BaseClass51.getDriver();
		executor2.executeScript("arguments[0].click();", checkout);
		WebElement billingdetails = BaseClass51.getDriver().findElement(By.tagName("h3"));
		String actualErrorMessage = billingdetails.getText();
		String expectedMessage = "Billing Details";
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage));
		// 11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
		WebElement firstname = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_first_name']"));
		firstname.sendKeys("bahar");
		WebElement lastname = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_last_name']"));
		lastname.sendKeys("sidiq");
		WebElement email = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_email']"));
		email.sendKeys("nurfad@yahoo.com");
		WebElement phone = BaseClass51.getDriver().findElement(By.xpath("//input[@id='billing_phone']"));
		phone.sendKeys("404_000_3737");

//12) Now click on Place Order button to complete process
//13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details
	}
   @Ignore
	@Test
	public void shopAddToBasketViewBasketTaxFunctionality() throws InterruptedException{
		shopClick.shopClick();
		WebElement addToBasket = BaseClass51.getDriver()
				.findElement(By.cssSelector("a[href^='/shop/?add-to-cart=165']"));
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass51.getDriver();
		executor.executeScript("arguments[0].click();", addToBasket);
		Thread.sleep(5000);
		WebElement viewItemButton = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/i"));
		viewItemButton.click();
		WebElement menuItemLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[3]"));
		Assert.assertTrue(menuItemLocator.isDisplayed());
		WebElement priceLocator = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart_item']/td[4]"));
		Assert.assertTrue(priceLocator.isDisplayed());
		String viewBasket = "https://practice.automationtesting.in/basket/";
		BaseClass51.getDriver().findElement(By.cssSelector("a[href*='" + viewBasket + "']")).click();
		WebElement subtotal = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='cart-subtotal']"));
		Assert.assertTrue(subtotal.isDisplayed());
		WebElement total = BaseClass51.getDriver().findElement(By.xpath("//tr[@class='order-total']"));
		Assert.assertTrue(total.isDisplayed());
		WebElement subtotalAmount = BaseClass51.getDriver()
				.findElement(By.xpath("//tr[@class='cart-subtotal']/td/span"));
		WebElement totalAmount = BaseClass51.getDriver()
				.findElement(By.xpath("//tr[@class='order-total']/td/strong/span"));
		double subtotal2 = Double.parseDouble(subtotalAmount.getText().substring(1));
		double total2 = Double.parseDouble(totalAmount.getText().substring(1));
		double taxAmount = total2 - subtotal2;
		if (taxAmount <= 0) {
			System.out.println("Error: tax amount is not greater than zero");
		}
		double expectedTotal = subtotal2 + taxAmount;
		if (total2 <= expectedTotal) {
			System.out.println("Error: total is not greater than subtotal plus tax amount");
		}
		
//9)The tax rate variers for India compared to other countries
//10) Tax rate for indian should be 2% and for abroad it should be 5%
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
