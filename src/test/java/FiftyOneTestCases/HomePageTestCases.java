package FiftyOneTestCases;

import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import PagesFor51TestCases.HomePage51;
import utility.BaseClass51;



public class HomePageTestCases {
	HomePage51 hp51;
	
	@BeforeSuite
	public void BeforeMethod() {
		BaseClass51.getDriver();
		hp51= new HomePage51();
	}
	@Ignore
	@Test
	public void HomePageWithThreeSlidersOnly() {
		
		shopClick.shopClick();
		hp51.HomeButton.click();
		//hp51.carousel;
		//hp51.items;
		// 5)Test whether the Home page has Three Sliders only
		//Find the items in the carousel (3 images in this case)
		//List<WebElement> items = carousel.findElements(By.xpath("//*[contains(@class, 'n2-ss-slide-background-image')]"));
		//int numItems = items.size();
		//System.out.println("number of carousel items: " + numItems);
		//6) The Home page must contains only three sliders
		//Assert.assertEquals(3, numItems);
		BaseClass51.closeDriver();
	}
    
    @Ignore
    @Test
	public void HomePageWithThreeArrivalsOnly() {
		// 3) Click on Shop Menu
		shopClick.shopClick();
		// 4)click on 'Home' menu button
		hp51.HomeButton.click();
		//5) Test whether the Home page has Three Arrivals only
        WebElement newArrival=BaseClass51.getDriver().findElement(By.tagName("h3"));
		List<WebElement>arrivals= newArrival.findElements(By.xpath("//ul[@class='products']"));
			int numberOfNewArrivals= arrivals.size();
			System.out.println("Number of New Arrivals: "+numberOfNewArrivals);
			//6) The Home page must contains only three Arrivals
			Assert.assertEquals(3, numberOfNewArrivals);
			BaseClass51.closeDriver();
    }
    @Ignore
    @Test
    public void  homePageImagesInArrivalsShouldNavigate() {
    	// 3) Click on Shop Menu
    	shopClick.shopClick();
    // 4)click on 'Home' menu button
    	hp51.HomeButton.click();
  //5) Test whether the Home page has Three Arrivals only
    WebElement newArrival=BaseClass51.getDriver().findElement(By.tagName("h3"));
	List<WebElement>arrivals= newArrival.findElements(By.xpath("//ul[@class='products']"));
		int numberOfNewArrivals= arrivals.size();
		System.out.println("Number of New Arrivals: "+numberOfNewArrivals);
		//6) The Home page must contains only three Arrivals
		Assert.assertEquals(3, numberOfNewArrivals);
		BaseClass51.closeDriver();
		//7) Now click the image in the Arrivals
		Actions act = new Actions(BaseClass51.getDriver());
		//act.moveToElement("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]").click().build().perform();
		//8) Test whether it is navigating to next page where the user can add that book into his basket.
		//9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
    	
    	
    }
    
    @Test

	public void Tester3_ImageArrivalsNavigates() throws InterruptedException {

		WebElement shopButon = BaseClass51.getDriver().findElement(By.xpath("//*[@id='menu-item-40']/a"));
		shopButon.click();
		BaseClass51.getDriver().navigate().refresh();
		shopButon = BaseClass51.getDriver().findElement(By.xpath("//*[@id='menu-item-40']/a"));
		shopButon.click();
		



		// Iframe ?????

		//Thread.sleep(3000);
		WebElement homeButton = BaseClass51.getDriver().findElement(By.xpath("//*[@id='content']/nav/a"));
		homeButton.click();

		List<WebElement> ariavalList = BaseClass51.getDriver().findElements(By.xpath("//*[@class='woocommerce']/ul/li"));

		int actualResult = ariavalList.size();
		int expectedResult = 3;

		Assert.assertEquals(expectedResult, actualResult);

		System.out.println("Number of New arrival : " + actualResult);

		
//
//		WebElement arraival1 = BaseClass51.getDriver().findElement(By.xpath("//*[@title='Selenium Ruby']"));
//		arraival1.click();
//
//		BaseClass51.getDriver().navigate().back();
//		WebElement arraival2 = BaseClass51.getDriver().findElement(By.xpath("//*[@title='Thinking in HTML']"));
//		arraival2.click();
//		Thread.sleep(3000);
//		BaseClass51.getDriver().navigate().back();
//		WebElement arraival3 = BaseClass51.getDriver().findElement(By.xpath("//*[@title='Mastering JavaScript']"));
//		arraival3.click();		
//		Thread.sleep(3000);
		
//		WebElement arraival3AddBusket = driver
//				.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
		
		for (int i = 0; i <ariavalList.size(); i++) {
            System.out.println(i);
            
              WebElement item = ariavalList.get(i);
              System.out.println(item);
              
              if (item.getText().contains("ADD TO BASKET")) {
                  
                 // String homeUrl = BaseClass51.getDriver().getCurrentUrl();
            	  String homeUrl = BaseClass51.getDriver().getCurrentUrl();
                  item.click();    
                  
                 // System.out.println(BaseClass51.getDriver().getTitle());  
                  System.out.println(BaseClass51.getDriver().getTitle()); 
                  
                 // String newUrl = BaseClass51.getDriver().getCurrentUrl();
                  String newUrl = BaseClass51.getDriver().getCurrentUrl();
                  Assert.assertFalse(homeUrl.equals(newUrl), "did not navigate to a new page");
                  
               // WebElement addToBasket = BaseClass51.getDriver().findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
                  WebElement addToBasket = BaseClass51.getDriver().findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
                  
                  Assert.assertTrue(addToBasket.isDisplayed());
                  
                 // BaseClass51.getDriver().navigate().back();
                  BaseClass51.getDriver().navigate().back();
                  }        
              
             // arrivalItems = BaseClass51.getDriver().findElements(By.xpath("//ul[contains(@class, 'products')]/li"));
              ariavalList = BaseClass51.getDriver().findElements(By.xpath("//ul[contains(@class, 'products')]/li"));
              
      } 
		

//
//		for(WebElement arivalList2: ariavalList) {
//			//System.out.println(arivalList2.getText());
//	            if(arivalList2 != null ) {
//	            	arivalList2.click();
//	            	
//	            	Thread.sleep(3000);
//	            	//arraival3AddBusket.isDisplayed();
//	            	
//		    	   BaseClass51.getDriver().navigate().back();
//		    	   Thread.sleep(3000);
//		    	   System.out.println(arivalList2.getText());
//	            }
//	            
//	            }
		
//		
//		Iterator<WebElement> iterator = ariavalList.iterator();
//		
//		while (iterator.hasNext()) {
//		    WebElement arrival = iterator.next();
//		    
//		   // System.out.println(arrival.getText());
//		    
//		    if (iterator.hasNext()) {
//		    	arrival.click();
//		    	BaseClass51.getDriver().navigate().back();
//		    	
//		        // Do something if there is another element in the iterator
//		    }
//		}
//		
		
		
		
		
//		WebElement arraival3ViewBusket = BaseClass51.getDriver().findElement(By.xpath("//*[@class='button wc-forward']"));
//		arraival3ViewBusket.click();
//		Thread.sleep(3000);
//
//		BaseClass51.getDriver().navigate().back();

		//BaseClass51.getDriver().get(url);
//		WebElement newArriaval = BaseClass51.getDriver().findElement(By.xpath("//*[@data-product_id='160']"));
//		newArriaval.click();

		//Assert.assertTrue(arraival3AddBusket.isDisplayed());
		
		//System.out.println("ArriavelImage3 'AddBascket' button is dispalyed ");
		

	}

    
    
    
    
    
    
    
    
    
    
    
    

	
}
