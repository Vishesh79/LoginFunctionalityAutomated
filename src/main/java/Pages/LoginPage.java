package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private By HomeSignInbutton = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	private By Email = By.xpath("//input[@id = 'ap_email']");
	private By continuebtn = By.xpath("//input[@id = 'continue']");
	private By Password = By.xpath("//input[@id = 'ap_password']");
	private By Signbtn = By.xpath("//input[@id = 'signInSubmit']");
	private By errormessage = By.xpath("//span[@class='a-list-item']");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonHomesignInbutton() {
		WebElement homesigninbutton = driver.findElement(HomeSignInbutton);
		homesigninbutton.click();
	}

	public void enterEmail(String email) {
		WebElement emailinput = driver.findElement(Email);
		emailinput.sendKeys(email);
	}

	public void clickContinuebtn() {
		WebElement continuebutton = driver.findElement(continuebtn);
		continuebutton.click();
	}

	public void enterPassword(String password) {
		WebElement passwordinput = driver.findElement(Password);
		passwordinput.sendKeys(password);
	}

	public void clickonsignInbutton() {
		WebElement signinbutton = driver.findElement(Signbtn);
		signinbutton.click();
	}
	public String checkCurrentpage() {
		return driver.getCurrentUrl();	
	}
	public String confirmerrormessage() {
		return driver.findElement(errormessage).getText();
	}
}