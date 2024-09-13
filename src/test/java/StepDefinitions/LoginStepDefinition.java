package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.LoginPage;

public class LoginStepDefinition {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
	@Given("I am on the Amazon page")
	public void i_am_on_the_Amazon_page(){
		driver.get("https://www.amazon.in/");
		loginPage = new LoginPage(driver);
		loginPage.clickonHomesignInbutton();
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() throws InterruptedException {
		loginPage.enterEmail("validemail@gmail.com");
		loginPage.clickContinuebtn();
		Thread.sleep(3000);
		loginPage.enterPassword("admin123");
	}

	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) throws InterruptedException {
		loginPage.enterEmail(username);
		loginPage.clickContinuebtn();
		Thread.sleep(3000);
		loginPage.enterPassword(password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		loginPage.clickonsignInbutton();
		Thread.sleep(3000);
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assert.assertEquals(loginPage.checkCurrentpage(), "https://www.amazon.com/?ref_=nav_signin");
	}

	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String errorMessage) {
		Assert.assertEquals(loginPage.confirmerrormessage(), errorMessage);
	}
}
