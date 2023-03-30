package PagesFor51TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass51;

public class HomePage51 {

	
	public HomePage51() {
		PageFactory.initElements(BaseClass51.getDriver(), this);
	}
	@FindBy(xpath="//a[text()='Home']")
	public WebElement HomeButton;
	
	@FindBy(xpath="//*[contains(@class, 'n2-ss-slider-2')]")
	public WebElement carousel;
	
	@FindBy(xpath="//*[contains(@class, 'n2-ss-slide-background-image')]")
	public List<WebElement> items;
	int numItems = items.size();
	
	
}
