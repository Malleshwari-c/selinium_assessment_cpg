package Assessment_Day9_POMFiles;

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
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginB;
	
	public void login(String UN, String PW) {
		userName.sendKeys(UN);
		password.sendKeys(PW);
		loginB.click();
		System.out.println("Login suucc");
	}
	
}
