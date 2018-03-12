package frameworkcore.webdriverFactory;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
	
	private static Logger logger = LoggerFactory.getLogger(DriverManager.class);
	private static WebDriver driver = null;
	 
		public static WebDriver getDriver(String PlatformName) throws InvocationTargetException, IllegalAccessException {
			
	        switch (PlatformName) {
	            case "Chrome":
	            	logger.info("Running Test on Chrome");
	            	driver = ChromeDriverManager.createDriver();
	                break;
	                
	            case "Firefox":
	            	logger.info("Running Test on FireFox");
	                driver = FirefoxDriverManager.createDriver();
	                break;
	                
	            case "IE":
	            	logger.info("Running Test on IE");
	                driver = IEDriverManager.createDriver();
	                break;
	                
	            case "Safari":    
	            	logger.info("Running Test on Safari");
	                driver = SafariDriverManager.createDriver();
	                break;
	                
	            case "Android":
	            	logger.info("Running Test on Safari");
	                driver = AndroidDriverManager.createDriver();
	                break;
	            	
	            case "iOS":
	            	logger.info("Running Test on Safari");
	                driver = iOSDriverManager.createDriver();
	                break;
	                
	            default:
	            	logger.info("No browser specified. Defaulting to Chrome");
	            	driver = ChromeDriverManager.createDriver();
	                break;
	        }
	        return driver;

	    }
		
		public static void quitDriver(){
			if (null != driver) {
	            driver.quit();
	            driver = null;
	        }
		}
}
