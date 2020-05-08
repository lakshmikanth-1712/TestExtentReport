package mavenProject.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import extentReport.extentTest;

public class base extends extentTest{
	
	public static RemoteWebDriver driver;
	public static Properties prop;
	 
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	
	
	
	
	
	
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
	*/
	
//--------------------------------	
	public base(){
				try {
	
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/extentReport/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest //BM
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", get_path("Drivers") + "/chromedriver");
			//System.setProperty("webdriver.chrome.driver", "/Users/luckyshiney/eclipse-workspace/com/src/test/resources/drivers/chromedriver");
			//System.setProperty("webdriver.chrome.driver", "/Users/luckyshiney⁩/⁨Downloads⁩/chromedriver");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			//System.setProperty("webdriver.chrome.driver", get_path("drivers") + "/geckodriver");
			//System.setProperty("webdriver.gecko.driver", "/Users/luckyshiney/eclipse-workspace/com/src/test/resources/drivers/geckodriver");
			System.setProperty("webdriver.gecko.driver", "/Users/luckyshiney⁩/⁨Downloads⁩/geckodriver");
			driver = new FirefoxDriver(); 
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println("url launched successfully");
		
	}


	public static String get_path(String fileName) {
		// TODO Auto-generated method stub
		File f = new File(fileName);
		return f.getAbsolutePath();
	}
	
	public String captureScreen() throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		//String dest="./screenshots/"+getcurrentdateandtime()+".png"; ///It Doesn't work
		///(Only Absolute path works, Not Relative Path...)
		String dest="./Screenshots"+getcurrentdateandtime()+".png";
		File target=new File(dest);
		// FileUtils.copyFile(src,target); //Works for older version of selenium like "selenium-server-standalone-3.14.0"
		//For new version of selenium like "selenium-server-standalone-3.141.59" use the below line.
		FileHandler.copy(src, target);
		return dest;
	}

	@AfterTest
	public void aftertest()
	{
		driver.quit();
		extent.flush();
	}
	
	



}
