/**
 * This project is using Spring 
 */
package frameworkcore.projectA.moduleA.featureA;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import frameworkcore.ReportingClass.ListenersImpl;
import frameworkcore.ReportingClass.Reporting;
import frameworkcore.webdriverFactory.DriverManager;
import frameworkcore.webdriverFactory.DriverManager1;

/**
 * @author dtiwa1
 *
 */
public class FeatureATest {

	private static Logger logger = LoggerFactory.getLogger(FeatureATest.class);
	private ExtentTest  childTest;
    static WebDriver driver;
	
	@BeforeTest @Parameters ({"BrowserName"})
	public static void InitializeTest(String BrowserName) throws InvocationTargetException, IllegalAccessException{
		logger.info("Inside class FeatureATest");
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
		public void testfeatureA1() throws IOException, InvocationTargetException{
			logger.info("inside Class FeatureATests. Inside method testfeatureA1");
			childTest = ListenersImpl.parentTest.createNode("My First Child Test");
			childTest.info(MarkupHelper.createLabel("Running Step 1 for First Child Test", ExtentColor.GREEN));
			childTest.pass(MarkupHelper.createLabel("Step 2 is Passed for First Child Test", ExtentColor.GREEN));
			childTest.fail(MarkupHelper.createLabel("Step 3 is Failed for First Child Test", ExtentColor.RED));
			
			childTest = ListenersImpl.parentTest.createNode("My Second Child Test");
			childTest.info(MarkupHelper.createLabel("Running Step 1 for Second Child Test", ExtentColor.GREEN));
			childTest.pass(MarkupHelper.createLabel("Step 2 is Passed for Second Child Test", ExtentColor.GREEN));
			childTest.fail(MarkupHelper.createLabel("Step 3 is Failed for Second Child Test", ExtentColor.RED));
			String path = Reporting.CaptureScreenShot(driver);
			childTest.fail("Step 3 is Failed for Second Child Test", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		
		@Test
		public void testfeatureA2(){
			logger.info("inside Class FeatureATests. Inside method testfeatureA2");
			
		}
		
		@Test
		public void testfeatureA3(){
			logger.info("inside Class FeatureATests. Inside method testfeatureA3");
			
		}
}
