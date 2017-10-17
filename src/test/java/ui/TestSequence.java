package ui;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



@RunWith(Suite.class)
@Suite.SuiteClasses({
LoginPage.class,
SignInPage.class,
HelpPage.class,
DealPage.class,
ContactUsPage.class
})

/**
 * This is Test Runner class.
 * @author gauravp.jain
 *
 */

public class TestSequence {


	
	public static WebDriver webDriver;
	
	
	/**
	 * This method will set pre-requisite for browser launch before any class executed.
	 */
	
	@BeforeClass
	public static void beforeStories() {
	
	
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver
				.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		String webDriverKey = "webdriver.ie.driver";
		String webDriverPath = "F:\\IEDriver\\IEDriverServer.exe";
		System.setProperty(webDriverKey,webDriverPath);
		
		
//		String webDriverValue=System.getProperty("user.dir")+"//drivers//internetexplorerdriver-windows-64bit.exe";
//		System.setProperty(webDriverKey, webDriverValue);

		TestSequence.webDriver = new InternetExplorerDriver(capabilities);
		TestSequence.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		TestSequence.webDriver.findElement(
				By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		TestSequence.webDriver.manage().window().maximize();

	}

	/**
	 * This method will run after all classes execution completed and will close browser.
	 */
	
	@AfterClass
	public static void afterStories() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			
			ex.printStackTrace();
		}
		webDriver.quit();
	}
}
