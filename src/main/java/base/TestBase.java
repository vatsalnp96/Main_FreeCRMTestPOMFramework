package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;
import util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;       
	public static WebEventListener eventListener;
	//Both references are for creating the objects of WebEventlistener class
	
	public TestBase() {
		FileInputStream fi;
		try {
			fi = new FileInputStream("C:\\Selenium_Workspace\\FreeCRMTestPOMFramework\\src\\main\\java\\config\\config.properties");
			prop = new Properties();
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		
		if(prop.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");  //not having iedriver rightnow; will add in future
			driver = new InternetExplorerDriver();
		}
		
		
		//Following four lines are for Eventlistener
		e_driver = new EventFiringWebDriver(driver); //obj of EventFiringWebDriver
		eventListener = new WebEventListener();      //obj of WebEventListener
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
}
