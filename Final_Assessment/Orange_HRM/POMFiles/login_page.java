package final_ass_POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	WebDriver driver;
	public login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	@FindBy(css="[name='password']")
	private WebElement password;
	@FindBy(css="[type='submit']")
	private WebElement login;
	public void lPage(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		System.out.println("login executed");
	}

}
