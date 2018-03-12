/**
 * This project is using Spring 
 */
package frameworkcore.main;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import frameworkcore.frameworkUtils.ScreenShotCapture;

/**
 * @author dtiwa1
 *
 */


public class Initialize {

	/**
	 * @param args
	 */
	private static Logger logger = LoggerFactory.getLogger(Initialize.class);
	static String log4jConfPath = "src/main/resources/propertyFiles/Log4j.properties";
	//public static HashMap<String, HashMap<String, HashMap<String, String>>> map ;
	
	public static void main(String[] args) {
		
		//InputDataReaderImpl.ReadExcelInputData();
		//System.out.println(InputDataReaderImpl.GetDataValue("InboxPage.TestCase_1.EMails"));
		//ScreenShotCapture.TakeScreenShot();
		
		PropertyConfigurator.configure(log4jConfPath);
		logger.info("Logger started");
		RunWithTestNG.RunAsTestNG();
		
	}

}
