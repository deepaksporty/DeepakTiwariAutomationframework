/**
 * This project is using Spring 
 */
package frameworkcore.projectA.moduleA.featureA;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameworkcore.webdriverFactory.DriverManager;
import frameworkcore.webdriverFactory.DriverManager1;

/**
 * @author dtiwa1
 *
 */
public class FeatureBTest {

	private static Logger logger = LoggerFactory.getLogger(FeatureBTest.class);
    static WebDriver driver;
    
    @BeforeTest @Parameters ({"BrowserName"})
	public static void InitializeTest(String BrowserName) throws InvocationTargetException, IllegalAccessException{
				
		logger.info("Inside class FeatureBTest");
		try{
			driver = DriverManager.getDriver(BrowserName);
			}catch(Exception e){
				logger.error("not able to initialize Webdriver. Please check the logs");
				logger.error(e.toString());
			}
	}

	    @AfterTest
	    public void afterMethod() {
	        DriverManager.quitDriver();
	    }
	
		@Test
		public void testfeatureB1(){
			logger.info("inside Class FeatureBTests. Inside method testfeatureB1");
			
		}
		
		@Test
		public void testfeatureB2(){
			logger.info("inside Class FeatureBTests. Inside method testfeatureB2");
			
		}
		
		@Test
		public void testfeatureB3(){
			logger.info("inside Class FeatureBTests. Inside method testfeatureB3");
			
		}
}
