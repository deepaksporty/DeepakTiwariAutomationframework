/**
 * This project is using Spring 
 */
package frameworkcore.webdriverFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import frameworkcore.projectA.moduleA.featureA.FeatureATest;

/**
 * @author dtiwa1
 *
 */
public class ChromeDriverManager  {
	
	private static Logger logger = LoggerFactory.getLogger(ChromeDriverManager.class);
	private static WebDriver driver;
	private static ChromeOptions options;
    
	public static WebDriver createDriver() throws InvocationTargetException, IllegalAccessException{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
        //driver = new ChromeDriver(GetOptions());
		driver = new ChromeDriver();
        return driver;
    }
    
    private static ChromeOptions GetOptions() {
    	
    	options = new ChromeOptions();
    	//options.setBinary(new File(System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe"));
		//options.addArguments("--silent");
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		//options.setHeadless(true);
		//options.addArguments("--disable-gpu");
    	
		//DesiredCapabilities ChromeCapabilities = DesiredCapabilities.chrome();
    	//ChromeCapabilities.setPlatform(Platform.WINDOWS);
    	
    	//options.merge(ChromeCapabilities);
    	return options;
       
    }

}
