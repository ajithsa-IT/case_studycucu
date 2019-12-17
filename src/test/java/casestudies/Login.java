package casestudies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Login {

	WebDriver driver;


	@Given("click on the URL")
	public void click_on_the_URL() {
		  System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@And("click on the signIn")
	public void click_on_the_signIn() {
		driver.findElement(By.linkText("SignIn")).click();
	}

	@And("enter the {string} and {string}")
	public void enter_the_and(String string, String string2) {
		driver.findElement(By.id("userName")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
		
	}

	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.name("Login")).click();
	}

	@Then("open home page")
	public void open_home_page() {
	}


}

