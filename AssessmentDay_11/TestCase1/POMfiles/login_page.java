package Assessment12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class login_page12 {
WebDriver driver;
	
	public login_page12(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//find username using xpath
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	//find password using css selector
	@FindBy(css="[name='password']")
	private WebElement password;
	//find login using css selector
	@FindBy(css="[type='submit']")
	private WebElement login;
	//create loginPage method and pass username and password
	public void lPage(String un,String pw) {
    //send username
		username.sendKeys(un);
    //send password
		password.sendKeys(pw);
    //click on login button
		login.click();
		System.out.println("login executed");
	}
}
