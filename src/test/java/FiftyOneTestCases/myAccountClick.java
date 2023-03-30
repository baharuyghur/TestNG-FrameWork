package FiftyOneTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseClass51;




public class myAccountClick {
	
	
	public static void myAccountClick() {
		WebElement myAccount = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		BaseClass51.getDriver().navigate().refresh();
		myAccount = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
	}

}
