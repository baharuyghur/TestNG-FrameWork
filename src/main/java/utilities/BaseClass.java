package utilities;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
private static WebDriver driver;
    
//driver instantiation function
//create re-usable method which will return same driver instance when we call it 
    public static WebDriver getDriver() {
//if the driver is null, it will go open the browser, if not bull, it will also return existing driver
        if (driver == null) {
//depending on the browserType that will be return from configuration.properties file
        	//switch statement will determine the case, and open the matching browser
            switch (BaseClass.getProperty("browser")) {
            
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "firefox-headless":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            case "edge":
                if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                    throw new WebDriverException("Your OS doesn't support EDGE");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                    throw new WebDriverException("Your OS doesn't support Safari");
                }
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
                break;

            }
            
            driver.get(BaseClass.getProperty("url3"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            

        }

        return driver;
    }
//driver close function
    public static void closeDriver() {
    	if(driver!=null) {
    		driver.quit();
    		driver=null;
    	}
    }


    //configuration Reader function
    
   //1.create Properties class object
    private static Properties configFile;

    static {
        
        try {
        	//2.create FileInputStream object to open file as a stream in java memory
            String filePath = "src/test/resources/files/config.properties";
            FileInputStream file = new FileInputStream(filePath);
            
           //3.load "properties"object with the "file" we opened using FileInputStream
          
           configFile= new Properties();
            configFile.load(file);
            
            
           file.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    //use properties.getProperty method to read from the file we loaded 
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName); //we pass keyName, it returns value
    }
    
	
	
	
	
	
	

}
