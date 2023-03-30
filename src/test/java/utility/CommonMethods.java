package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class CommonMethods extends PageInitializer {
	
	/*
     * Method that clears and sends key
     * 
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /*
     * methods checks if radio/checkBox is enabled and clicks on it
     * 
     */
    public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

        String actualValue;

        for (WebElement el : radioOrCheckbox) {
            actualValue = el.getAttribute("value").trim();
            if (actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }
    
    public static void clickRadioOrCheckboxGetText(List<WebElement> radioOrCheckbox, String value) {
        String actualValue;

        for (WebElement el : radioOrCheckbox) {
            actualValue = el.getText().trim();
            if (actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }
    
    // select DropDown value
    public static void selectDropDownValue(WebElement element, String textTobeSelected) {
        try {
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();
            for (WebElement el : options) {
                if (el.getText().equals(textTobeSelected)) {
                    select.selectByValue(textTobeSelected);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }
    
    // select DropDown by index
    public static void selectDropDownIndex(WebElement element, int indexValue) {
        try {
            Select select = new Select(element);

            int size = select.getOptions().size();

                if (size > indexValue) {
                        select.selectByIndex(indexValue);
                }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }
    
    //select dropDown by visible text
    public static void selectDropDownVisibleText(WebElement element, String textVisibleTobeSelected) {
        try {
            Select select = new Select(element);
            // loop option by for each loop
            List<WebElement> options = select.getOptions();
            for (WebElement el : options) {
                if (el.getText().equals(textVisibleTobeSelected)) {
                    select.selectByVisibleText(textVisibleTobeSelected);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }
   
    //alert dismiss
    public static void dismissAlert() {
        try {
            Alert alert = BaseClass2.getDriver().switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    // alerts accept
    public static void acceptAlert() {
        try {
            Alert alert = BaseClass2.getDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    //alerts get text
    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = BaseClass2.getDriver().switchTo().alert();
            alertText = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return alertText;
    }
    
    //alert send text
    public static void alertSendText(String str) {
        try {
            Alert alert = BaseClass2.getDriver().switchTo().alert();
           alert.sendKeys(str);
           alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
   
    // iFrames
    // switch using name or id
    public static void switchToFrame(String nameOrId) {
        try {
            BaseClass2.getDriver().switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    // switch using INDEX
    public static void switchToFrame(int index) {
        try {
            BaseClass2.getDriver().switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    // switch using webElement
    public static void switchToFrame(WebElement element) {
        try {
            BaseClass2.getDriver().switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    // handle windows by switching to child window

    public static void switchtoChildWindow() {
        String mainWindow = BaseClass2.getDriver().getWindowHandle();
        Set<String> allOpenWindows = BaseClass2.getDriver().getWindowHandles();

        for (String eachWindow : allOpenWindows) {
            if (!eachWindow.equals(mainWindow)) {
                BaseClass2.getDriver().switchTo().window(eachWindow);
            }
        }
    }
    
 // declaring explicit wait(webDriver) and initiating it and then returning the object
    
     public static WebDriverWait getWaitObject() {
         WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 30); 
         return wait; 
     }
     //wait for element to be clickable
     public static WebElement waitForClickability(WebElement element) {
         return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
     }
    
     public static WebElement waitForVisibility(WebElement element) {
         return getWaitObject().until(ExpectedConditions.visibilityOf(element));
     }

     public static void clickMethod(WebElement element) {
    	 waitForVisibility(element).click();
 
     }

     
     // JS executer
     // declaring and initializing js object and returning it
     public static JavascriptExecutor getJSObject() {
         JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
         return js;
     }

     // java script click element
     public static void jsClick(WebElement element) {
         getJSObject().executeScript("arguments[0].click()", element);
     }

     // JavaScript sends text
     public static void jsSentText(WebElement element, String text) {
         String valueText = element.getAttribute("value");
         getJSObject().executeScript("arguments[0].value='" + valueText + "'", text);
     }

     // scroll to element using js
     public static void scrollToElement(WebElement element) {
         getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
     }

     // scroll by pixel
     public static void ScrolByPixel(int pixel) {
         // positive -- scroll down
         // negative -- scroll up
         getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
     }

     // getting time stamp
     public static String getTimeStamp() {
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
         return sdf.format(date.getTime());
     }

     // thread .sleep is simplified
     public static void wait(int seconds) {

         try {
             Thread.sleep(seconds * 1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

     // hover over == moving your courser on an element
     public static void hover(WebElement element) {
         Actions actions = new Actions(BaseClass.getDriver());
         actions.moveToElement(element).build().perform();
     }

     // create a method that dragsAndDrops
     public static void dragsAndDrops(WebElement element, WebElement element2) {
         Actions action = new Actions(BaseClass.getDriver());
         action.dragAndDrop(element, element2).build().perform();
     }

     // create a method that doubleClicks
     public static void doubleClicks(WebElement element) {
         Actions action = new Actions(BaseClass.getDriver());
         action.doubleClick(element).build().perform();
     }

    
 //take screen shot
     public static byte[] takeScreenshot(String filename) {
         TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
         byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

         File file = ts.getScreenshotAs(OutputType.FILE);
         String destinationFile = "" + filename + getTimeStamp() + ".png";

         try {
             FileUtils.copyFile(file, new File(destinationFile));
         } catch (Exception ex) {
             System.out.println("Cannot take screenshot!");
         }

         return picBytes;
     }
     
     
 // calendar select date
     public static void selectCalendarDate(List<WebElement> element, String text) {
         for (WebElement pickDate : element) {
             if (pickDate.isEnabled()) {
                 if (pickDate.getText().equals(text)) {
                     pickDate.click();
                     break;
                 }
             }
         }
     }
     
     
     /**
      * return a list of string from a list of elements ignores any element with no
      * text
      * 
      * @param list
      * @return
      */
     public static List<String> getElementsText(List<WebElement> list) {
         List<String> elemTexts = new ArrayList<String>();
         for (WebElement el : list) {
             if (!el.getText().isEmpty()) {
                 elemTexts.add(el.getText());
             }
         }
         return elemTexts;
     }
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
}  
    
