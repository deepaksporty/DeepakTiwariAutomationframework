/**
 * This project is using Spring 
 */
package frameworkcore.webdriverFactory;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import frameworkcore.frameworkUtils.PropertyFileReader;
import frameworkcore.main.Initialize;

/**
 * @author dtiwa1
 *
 */
public class PhantomJsDriverManager extends DriverManager1 {
	
	private ChromeDriverService chService;
	HashMap<String, String> map = PropertyFileReader.ReadPropertyFile();

    @Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(System.getProperty("user.dir") + map.get("ChromeDriverPath").toString()))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(chService);
    }

}
