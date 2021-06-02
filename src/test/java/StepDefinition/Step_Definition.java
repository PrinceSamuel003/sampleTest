package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Step_Definition {
	
	WebDriver driver;
	
	@Given("^User is on the Application Home Page$")
	public void user_is_on_the_Application_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/home");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //throw new PendingException();
	}

	@When("^Application Page Title is PHP Travels$")
	public void application_Page_Title_is_PHP_Travels() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = driver.getTitle();
	    String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    //throw new PendingException();
	}

	@Then("^user clicks MY ACCOUNT$")
	public void user_clicks_MY_ACCOUNT() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")).click();
	    //throw new PendingException();
	}

	@Then("^user clicks on Sign Up Link$")
	public void user_clicks_on_Sign_Up_Link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Sign Up")).click();
	    //throw new PendingException();
	}

	@When("^User navigate to Sign Up page$")
	public void user_navigate_to_Sign_Up_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 String actualTitle = driver.findElement(By.xpath("//h3[contains(text(),'Sign')]")).getText();
		 String expectedTitle = "Sign Up";
		 Assert.assertEquals(expectedTitle, actualTitle);
	   // throw new PendingException();
	}

	@Then("^user enters personal data and the entered values are validated$")
	public void user_enters_personal_data_and_the_entered_values_are_validated(DataTable data) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>>  formData = data.raw();
		   driver.findElement(By.name("firstname")).sendKeys(formData.get(0).get(0));
		   driver.findElement(By.name("lastname")).sendKeys(formData.get(0).get(1));
		   driver.findElement(By.name("phone")).sendKeys(formData.get(0).get(2));
		   driver.findElement(By.name("email")).sendKeys(formData.get(0).get(3));
		   driver.findElement(By.name("password")).sendKeys(formData.get(0).get(4));
		   driver.findElement(By.name("confirmpassword")).sendKeys(formData.get(0).get(5));
		   
		   String fname=driver.findElement(By.name("firstname")).getAttribute("value");
		   String lname=driver.findElement(By.name("lastname")).getAttribute("value");
		   String phone= driver.findElement(By.name("phone")).getAttribute("value");
		   String email=driver.findElement(By.name("email")).getAttribute("value");
		   String pswd=driver.findElement(By.name("password")).getAttribute("value");
		   String cpswd=driver.findElement(By.name("confirmpassword")).getAttribute("value");
		   
		   Assert.assertEquals(fname,formData.get(0).get(0));
		   Assert.assertEquals(lname,formData.get(0).get(1));
		   Assert.assertEquals(phone,formData.get(0).get(2));
		   Assert.assertEquals(email,formData.get(0).get(3));
		   Assert.assertEquals(pswd,formData.get(0).get(4));
		   Assert.assertEquals(cpswd,formData.get(0).get(5));
	   //throw new PendingException();
	}

	@Then("^click on Sign Up button$")
	public void click_on_Sign_Up_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id='headersignupform']/div[8]/button")).click();
	   // throw new PendingException();
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    //throw new PendingException();
	}



}
