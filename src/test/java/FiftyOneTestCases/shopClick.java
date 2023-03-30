package FiftyOneTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseClass51;





public class shopClick {
	        
	// 3) Click on Shop Menu
			public static void shopClick() {
	        WebElement shop = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"menu-item-40\"]/a"));
			shop.click();
			BaseClass51.getDriver().navigate().refresh();
			shop = BaseClass51.getDriver().findElement(By.xpath("//*[@id=\"menu-item-40\"]/a"));
			shop.click();
	
			}

	
}
