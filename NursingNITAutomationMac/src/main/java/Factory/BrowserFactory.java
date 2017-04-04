/**
 * 
 */
package Factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import Utility.BaseClass;

/**
 * @author SMuppidi
 *
 */
	public class BrowserFactory extends BaseClass {
		//static WebDriver driver;
			
			public WebDriver getBrowser(String browserName){
				
				if(driver==null){
					if(browserName.equalsIgnoreCase("Firefox"))
					{
						/*ProfilesIni init=new ProfilesIni();
						FirefoxProfile profile=init.getProfile("default");
						System.setProperty("webdriver.firefox.marionette",DataProviderFactory.getConfig().getFFPath());*/
						System.setProperty("webdriver.gecko.driver", FFDRIVER_EXE);
						//System.setProperty("webdriver.gecko.driver", "D:\\gecko_drivers\\geckodriver.exe");
						DesiredCapabilities capabilities=DesiredCapabilities.firefox();
					    capabilities.setCapability("marionette", true);
					    driver = new FirefoxDriver(capabilities);
						//driver=new FirefoxDriver();
					}
					if(browserName.equalsIgnoreCase("chrome"))
					{
						System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
						driver=new ChromeDriver();
					}
					if(browserName.equalsIgnoreCase("IE")){
						DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
						cap.setCapability("ignoreProtectedModeSettings", true);
						File file = new File(IEDRIVER_EXE);
						System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
						//cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
						//System.setProperty("webdriver.ie.driver", IEDRIVER_EXE);
						driver=new InternetExplorerDriver(cap);
					}
					if (browserName.contentEquals("Safari"))
					{
						System.out.println("*****************************");
						System.setProperty("webdriver.safari.noinstall", "true");
						driver = new SafariDriver();
					} 
				}
				return driver;
			}
	
	/*public static void closeBrowser()
	{
		driver.quit();
	}*/
}

