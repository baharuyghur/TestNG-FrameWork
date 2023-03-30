package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass2;

public class AdminPage {
	
	public AdminPage() {
        PageFactory.initElements(BaseClass2.getDriver(), this);
    }
    
    
    @FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]//input")
    public WebElement systemUsersUsernameTextBox;
    
    
    @FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div[2]/div/div")
    public WebElement userRoleDropDownToExpand;
    
    @FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]/div/div[2]/div/div")
    public WebElement statusDropDownToExpand;
    
    
    @FindBy(xpath="//div[@class='oxd-select-dropdown --positon-bottom']/div")
    public List<WebElement> userRoleAndStatusDropDownOptions;
    
    @FindBy(xpath="//button[@type='submit']")
    public WebElement SearchButton;
    
    @FindBy(xpath="//div[@class='oxd-table-card']/div")
    public List<WebElement> recordsTable;
    
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/a")
    public WebElement nationalitiesButton;
    
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
   public WebElement addButton;
    
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[1]")
   public WebElement addTextBox;
    
   @FindBy(xpath="//button[@type='submit']")
   public WebElement saveButton;
   
   @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]//div/div[3]//div[2]/div[15]//div[3]/div/button[1]/i")
  public WebElement deleteButton;
   
   @FindBy(xpath="//*[@id=\"app\"]/div[3]//div[3]/button[2]/i")
   public WebElement confirmButton;
   
   public void chooseUserRoleOption(String menuValue) {
       for (WebElement userRoleOption : userRoleAndStatusDropDownOptions) {
           if (userRoleOption.getText().equalsIgnoreCase(menuValue)) {
               userRoleOption.click();
               break;
           }
       }
       }
   public void addNationality(String nationality) {
       List<WebElement> nationalityOptions = nationalitiesButton.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']"));
       boolean nationalityExists = false;
       for (WebElement option : nationalityOptions) {
           if (option.getText().equals("bahaIsland")) {
               nationalityExists = true;
               break;
           }
       }
       if (!nationalityExists) {
    	  addButton.click();  
         addTextBox.click();
         addTextBox.sendKeys(nationality); 
          saveButton.click(); 	 
       }
   }
   public void deleteNationality(String nationality) {
	    List<WebElement> nationalityOptions = nationalitiesButton.findElements(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']"));
	    for (WebElement option : nationalityOptions) {
	        if (option.getText().equals(nationality)) {
	       
	            deleteButton.click();
	            
	        
	         // Switch to the confirmation dialog window
	            String mainWindowHandle = BaseClass2.getDriver().getWindowHandle();
	            for (String handle : BaseClass2.getDriver().getWindowHandles()) {
	                if (!handle.equals(mainWindowHandle)) {
	                	BaseClass2.getDriver().switchTo().window(handle);
	                    break;
	                }
	            }
	            
	            // Click the "Yes, delete" button
	          
	            confirmButton.click();
	            
	            // Switch back to the main window
	            BaseClass2.getDriver().switchTo().window(mainWindowHandle);
	            
	            break;
	        }}
	    }}