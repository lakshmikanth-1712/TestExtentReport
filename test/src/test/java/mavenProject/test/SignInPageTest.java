package mavenProject.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;



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
			test.info("Test case Success");
			try
			{
//				test.log(Status.INFO, "Google Page opened "+test.addScreenCaptureFromPath(captureScreen()));
//				test.log(Status.PASS, "Passed test "+test.addScreenCaptureFromPath(captureScreen()));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
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