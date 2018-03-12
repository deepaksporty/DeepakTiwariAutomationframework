/**
 * This project is using Spring 
 */
package frameworkcore.webdriverFactory;

import org.openqa.selenium.WebDriver;



/**
 * @author dtiwa1
 *
 */
public abstract class DriverManager1 {

	protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();
   

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}
