package mavenProject.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.HomePage;



public class SignInPageTest extends base {

	
	
	
//	public ExtentReports extent;
//	public ExtentTest test;
	
	
	/*@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.chrome.driver", get_path("Drivers") + "/chromedriver");
		driver=new ChromeDriver();
		htmlextent=new ExtentHtmlReporter("./Reports/extentreport.html");
		report=new ExtentReports();
	}
	@BeforeMethod
	public void beforemethod()
	{
		report.attachReporter(htmlextent);
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@class='inputtext login_form_input_box'])[1]")
	@CacheLookup
	public WebElement email;

	@FindBy(how = How.XPATH, using = "(//input[@class='inputtext login_form_input_box'])[2]")
	@CacheLookup
	public WebElement password;

	public void login() {
		email.sendKeys("abd");
		password.sendKeys("asd");
	}*/
	
	
	
	@Test
	public void signIn()
	{
		
		    test=extent.createTest("testcase");
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			try
			{
				test.log(Status.INFO, "Google Page opened "+test.addScreenCaptureFromPath(captureScreen()));
				test.log(Status.PASS, "Passed test "+test.addScreenCaptureFromPath(captureScreen()));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
	}	
	
	public String captureScreen() throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		//String dest="./screenshots/"+getcurrentdateandtime()+".png"; ///It Doesn't work
		///(Only Absolute path works, Not Relative Path...)
		String dest="/Users/luckyshiney/git/TestExtentReport/test/Screenshots"+getcurrentdateandtime()+".png";
		File target=new File(dest);
		// FileUtils.copyFile(src,target); //Works for older version of selenium like "selenium-server-standalone-3.14.0"
		//For new version of selenium like "selenium-server-standalone-3.141.59" use the below line.
		FileHandler.copy(src, target);
		return dest;
	}
	
	/*@AfterTest
	public void aftertest()
	{
		driver.quit();
		report.flush();
	}
	
	public String captureScreen() throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		//String dest="./screenshots/"+getcurrentdateandtime()+".png"; ///It Doesn't work
		///(Only Absolute path works, Not Relative Path...)
		String dest="/Users/luckyshiney/git/TestExtentReport/test/Screenshots"+getcurrentdateandtime()+".png";
		File target=new File(dest);
		// FileUtils.copyFile(src,target); //Works for older version of selenium like "selenium-server-standalone-3.14.0"
		//For new version of selenium like "selenium-server-standalone-3.141.59" use the below line.
		FileHandler.copy(src, target);
		return dest;
	}

	public String getcurrentdateandtime()
	{
		String str=null;
		try
		{
			DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date=new Date();
			str=dateFormat.format(date);
			str=str.replace(" ","").replaceAll("/","").replaceAll(":","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}*/
}