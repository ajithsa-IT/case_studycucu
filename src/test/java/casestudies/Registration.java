package casestudies;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {
	WebDriver driver;
	@Given("Enter the URL")
	public void enter_the_URL() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
	}

	@When("User enters his name as {string}")
	public void user_enters_his_name_as(String string) {
		driver.findElement(By.id("userName")).sendKeys(string);
	}

	@When("FirstName as {string}")
	public void firstname_as(String string) {
		driver.findElement(By.id("firstName")).sendKeys(string);
	}

	@When("LastName as {string}")
	public void lastname_as(String string) {
		driver.findElement(By.id("lastName")).sendKeys(string);
	}

	@When("Password as {string}")
	public void password_as(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	@When("Confirms as {string}")
	public void confirms_as(String string) {
		driver.findElement(By.id("pass_confirmation")).sendKeys(string);
	}

	@When("select Gender as Male")
	public void select_Gender_as_Male() {
		driver.findElement(By.xpath("//input[@value='Male']")).click();
	}

	@When("EmailID as {string}")
	public void emailid_as(String string) {
		driver.findElement(By.id("emailAddress")).sendKeys(string);
	}

	@When("Mobile Number as {string}")
	public void mobile_Number_as(String string) {
		driver.findElement(By.id("mobileNumber")).sendKeys(string);
	}

	@When("DOB is entered as {string}")
	public void dob_is_entered_as(String string) {
		driver.findElement(By.name("dob")).sendKeys(string);
	}

	@When("Address is entered as {string}")
	public void address_is_entered_as(String string) {
		driver.findElement(By.id("address")).sendKeys(string);
	}

	@Then("Security Question is selected as What is your favour color?")
	public void security_Question_is_selected_as_What_is_your_favour_color() {
		WebElement dropdown=driver.findElement(By.id("securityQuestion"));
		Select drop=new Select(dropdown);
		drop.selectByIndex(1);
	}

	@Then("Answer as {string}")
	public void answer_as(String string) {
		driver.findElement(By.id("answer")).sendKeys("Yellow");
	}

	@Then("User Clicks on Register Button")
	public void user_Clicks_on_Register_Button() {
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
	}

	@Then("User Registration is Successful")
	public void user_Registration_is_Successful() {
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'User Registered Succesfully!!! Please login')]")));
		Assert.assertEquals("Login", driver.getTitle());
		driver.close();
		System.out.println("User Registered Succesfully");
	}



}
