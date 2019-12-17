package casestudies;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class search_possibilities {
	WebDriver driver;
	@Given("^user signin into the testmeapp$")
	public void user_signin_into_the_testmeapp() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	//driver=utilityclass.startBrowser("chrome","http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	driver.findElement(By.linkText("SignIn")).click();
    driver.findElement(By.id("userName")).sendKeys("lalitha");
    driver.findElement(By.id("password")).sendKeys("password123");
    driver.findElement(By.xpath("//input[@name='Login']")).click();
    Assert.assertEquals("Home",driver.getTitle());
	System.out.println("Home page");
   
}
@When("^user searches for the  particular product$")
	public void user_searches_for_the_particular_product() throws Throwable {
	driver.findElement(By.id("myInput")).sendKeys("H");
	driver.findElement(By.id("myInput")).sendKeys("e");
	driver.findElement(By.id("myInput")).sendKeys("a");
	driver.findElement(By.id("myInput")).sendKeys("d");
	}

@Given("^user proceeds for payment without adding to the cart$")
public void user_proceeds_for_payment_without_adding_to_the_cart() throws Throwable {
	//Assert.assertTrue(driver.findElements(By.linkText("myLinkText")).size() <1);
	Assert.assertNotSame("View Cart",driver.getTitle());
}

@Then("^TestMeApp doesnt display the cart icon without adding$")
public void testmeapp_doesnt_display_the_cart_icon_without_adding() throws Throwable {
	System.out.println("cart is empty...please add");
	
}@And("^user clicks the search tab & enters the first four letters of the product$")
public void user_clicks_the_search_tab_enters_the_first_four_letters_of_the_product() throws Throwable {
	 driver.findElement(By.id("myInput")).sendKeys("T");
	 driver.findElement(By.id("myInput")).sendKeys("r");
	 driver.findElement(By.id("myInput")).sendKeys("a");
	 driver.findElement(By.id("myInput")).sendKeys("v");
}

@And("^user selects product from the drop down$")
public void user_selects_product_from_the_drop_down() throws Throwable {
	driver.findElement(By.xpath("//*[contains(text(),'Travel')]")).click();
	driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
}

@Then("^user proceeds for payment after adding to the cart$")
public void user_proceeds_for_payment_after_adding_to_the_cart() throws Throwable {
    driver.findElement(By.partialLinkText("Add")).click();
}

@Then("^testmeapp displays the cart icon$")
public void testmeapp_displays_the_cart_icon() throws Throwable {
    Assert.assertEquals("Search", driver.getTitle());
    System.out.println("user is in search page");
}



}
