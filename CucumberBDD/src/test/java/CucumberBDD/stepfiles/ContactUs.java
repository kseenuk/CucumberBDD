package CucumberBDD.stepfiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class ContactUs {

	private static WebDriver driver;
	
	@Before
	public static void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	@After
	public static void TearDownBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	
	@Given("^User navigates to the Contact Us screen in Webdriver university$")
	public void user_navigates_to_the_Contact_Us_screen_in_Webdriver_university() throws Throwable {
		driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@And("^User enters the First Name$")
	public void user_enters_the_First_Name() throws Throwable {
		driver.findElement(By.name("first_name")).sendKeys("First Name");
	}

	@And("^User enters the Last Name$")
	public void user_enters_the_Last_Name() throws Throwable {
		driver.findElement(By.name("last_name")).sendKeys("Last Name");
	}

	@And("^User enters the email address$")
	public void user_enters_the_email_address() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("abc@abbba.com");
	}

	@And("^User enters the comments$")
	public void user_enters_the_comments() throws Throwable {
		driver.findElement(By.name("message")).sendKeys("Message that will be typed");
	}

	@When("^User clicks on submit button$")
	public void User_clicks_on_submit_button() throws Throwable {

		driver.findElement(By.xpath("//input[@value='SUBMIT']")).submit();
			}

	
	@Then("^User should be taken to Thanks screen$")
	public void user_should_be_taken_to_Thanks_screen() throws Throwable {
		WebElement textSuccess =  driver.findElement(By.id("contact_reply"));
		Assert.assertEquals(true, textSuccess.isDisplayed());
		}


}
