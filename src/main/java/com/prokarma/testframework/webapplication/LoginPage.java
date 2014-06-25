package com.prokarma.testframework.webapplication;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import jxl.Sheet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prokarma.testframework.common.ReadExcel;
import com.prokarma.testframework.common.WebDriverFactory;



public class LoginPage {

	WebDriverFactory webDriverFactory =  new WebDriverFactory();
	
	//static WebDriver driver;
	 // = new WebDriverWait(driver, 30);
	WebDriver driver = null;
			
	ReadExcel readData = new ReadExcel();
	//PageObjects LoginPage = PageFactory.initElements(driver, PageObjects.class);
	LoginElements LoginPage;
	
	
	public void openBrowser(Sheet data, int iRowNumber) {
		System.out.println("In the openBrowser Method ");
		driver = WebDriverFactory.getBrowser(readData.fnGetFieldValue(data, "Browser Name", iRowNumber));
		LoginPage = PageFactory.initElements(driver, LoginElements.class);
	}
	
	
	public void openWiki(Sheet data, int iRowNumber) {
		System.out.println("In the openWiki Method ");
		driver.get(readData.fnGetFieldValue(data, "URL", iRowNumber));
		driver.manage().window().maximize();

	}
	
	public void loginWiki(Sheet data, int iRowNumber) {
		LoginPage.setUserName(readData.fnGetFieldValue(data, "Username", iRowNumber));
		LoginPage.setPassword(readData.fnGetFieldValue(data, "Password", iRowNumber));
		LoginPage.clickOnLoginButton();
	}
		
	public void logoutWiki() {
		//captureScreenShot();
		LoginPage.LogoutLinkNavigator();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.logoutLink));
		LoginPage.ClickOnLogout();
		driver.close();
		driver = null;
		//driver.quit();
	}

	public void captureScreenShot() throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("D:\\Workspace1\\webdriverTestFramework\\ScreenShots\\ScreenShot_"+GetTimeStampValue()+".png"));
	}
	
	public String GetTimeStampValue()throws IOException{
         Calendar cal = Calendar.getInstance();       
         Date time=cal.getTime();
         String timestamp=time.toString();
            System.out.println(timestamp);
            String systime=timestamp.replace(":", "-");
            System.out.println(systime);
        return systime;

    }
	
}
