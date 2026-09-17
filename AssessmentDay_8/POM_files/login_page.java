package assess_8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class login_page {
  //create driver as global variable
	WebDriver driver;
	//constructor call and pass driver as argument
	public login_page(WebDriver driver) {
		this.driver=driver;
    //initiate all the variables using PageFactory
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
	public void loginPage(String un,String pw) {
    //send username
		username.sendKeys(un);
    //send password
		password.sendKeys(pw);
    //click on login button
		login.click();
	}
	
	
}
