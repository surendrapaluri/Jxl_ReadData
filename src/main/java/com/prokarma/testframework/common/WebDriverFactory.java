package com.prokarma.testframework.common;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	
	
	
	//private static Map<String, WebDriver> driverList = new HashMap<String, WebDriver>();

	public static WebDriver getBrowser(String browserName) {
		//WebDriver driver = driverList.get(browserName);
		WebDriver driver=null;
		if (driver == null) {
			driver = getWebDriver(browserName);
			//driverList.put(browserName, driver);
			System.out.println("Creating a Browser for " + browserName);
		}
		return driver;
	}

	private static WebDriver getWebDriver(String browserName) {
		WebDriver driver = null;
		/*switch (browserName.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\Workspace1\\webdriver\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "internet explorer":
			System.setProperty("webdriver.ie.driver",
					"D:\\Workspace1\\webdriver\\src\\main\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}*/
		driver = new FirefoxDriver();
		return driver;
	}

}
