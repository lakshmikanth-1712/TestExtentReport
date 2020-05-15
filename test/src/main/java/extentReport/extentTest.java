package extentReport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentTest {
	
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public static RemoteWebDriver driver;
	
	@BeforeMethod //BS
	public void  setUpReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/extent.html");
		htmlReporter.config().setDocumentTitle("ExtentReports - Mobile Appium");
		htmlReporter.config().setReportName("ExtentReports - Lakshmikanth");
		htmlReporter.config().setTheme(Theme.DARK);

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");
																//extent = extent != null ? extent : new ExtentReports();
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "lakshmi");
		
		
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
	}
	
	

}
