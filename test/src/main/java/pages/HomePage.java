package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



	public class HomePage {

		public RemoteWebDriver driver;

		public  HomePage(RemoteWebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
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
		}

}
