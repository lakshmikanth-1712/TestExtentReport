package mavenProject.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.HomePage;


public class SignInPageTest extends base{

	public ExtentReports extent;
	//public ExtentTest test;
	
	
	//public TestBaseManager TbaseMgr;
	//public static Logger log = Logger.getLogger(base.class.getName());
	
	@Test
	public void signIn()
	{
		try {
		//test = report.startTest("TC001 is executing").assignAuthor("Lakshmi");
		driver.get("");
		//TbaseMgr = new TestBaseManager(driver);
		HomePage hp = new HomePage(driver);
		
		//log.info("first method");
		System.out.println("enter signIn method");
		
		System.out.println("initialized and move down");
		hp.login();
		//test.log(LogStatus.PASS,"Sign In TC passed");
		
		}catch(Exception e) {
			e.printStackTrace();}
		
		
	}	
}