package casestudies;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Searchfunction {
	WebDriver driver; 
	@Given("Alex Open the Browser and enters testmeapp")
	public void alex_Open_the_Browser_and_enters_testmeapp() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	    driver.manage().window().maximize();
	}

	@Given("Alex Enters {string} and {string}")
	public void alex_Enters_and(String string, String string2) {
	   driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	   driver.findElement(By.id("userName")).sendKeys(string);
	   driver.findElement(By.id("password")).sendKeys(string2);
	   driver.findElement(By.name("Login")).click();
	}

	@Given("Alex types {string} in search bar")
	public void alex_types_in_search_bar(String string) {
	    driver.findElement(By.id("myInput")).sendKeys("H");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("myInput")).sendKeys("e");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("myInput")).sendKeys("a");
	    driver.findElement(By.id("myInput")).sendKeys("d");
	}

	@When("Headphone appears for search and clicked")
	public void headphone_appears_for_search_and_clicked() {
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Headphone']")));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[contains(text(),'Headphone')]")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("Alex add the product to cart")
	public void alex_add_the_product_to_cart() {
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
	    driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	}

	@When("Checkout from cart")
	public void checkout_from_cart() {
		 driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		 driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	}

	@Then("Proceed with payment")
	public void proceed_with_payment() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    WebElement wb=driver.findElement(By.xpath("//*[contains(text(),'Andhra Bank')]"));
	    wb.click();
	    driver.findElement(By.id("btn")).click();
	}

	@Then("Alex types {string} and {string} for payment")
	public void alex_types_and_for_payment(String string, String string2) {
	    driver.findElement(By.name("username")).sendKeys(string);
	    driver.findElement(By.name("password")).sendKeys(string2);
	    driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	}

	@Then("transaction is made by entering {string}")
	public void transaction_is_made_by_entering(String string) {
	    driver.findElement(By.xpath("//input[@value='PASSWORD']")).sendKeys(string);
	    driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	}
	
	@Then("Alex purchase the product succesfully")
	public void alex_purchase_the_product_succesfully() {
		//WebDriverWait wait=new WebDriverWait(driver, 10);
	/*	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'\r\n" + 
				"				Goods will be delivered to the below address\r\n" + 
				"				')]")));*/
		Assert.assertEquals("Order Details", driver.getTitle());
		driver.close();
		System.out.println("Alex Purchased Successfully");
	}


}
