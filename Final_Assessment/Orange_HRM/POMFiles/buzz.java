package final_ass_POMFiles;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class buzz {
	WebDriver driver;
	
	
	public buzz(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class='oxd-buzz-post-input']")
	private WebElement message;
	
	@FindBy(css="[class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")
	private WebElement fetch_message;
	
	@FindBy(css="[type='submit']")
	private WebElement post;
	
	@FindBy(css="[class='oxd-userdropdown-name']")
	private WebElement dropdown;
	
	@FindBy(xpath="//a[text()='Logout' and @role='menuitem']")
	private WebElement logOut;
	
	public void message(String MESSAGE) {
		message.sendKeys(MESSAGE);
		System.out.println("message sent");
		post.click();
		System.out.println("post clicked");

	}
	
	public void fetch(String MESSAGE) {
		String FETCHMESSAGE=fetch_message.getText();
		System.out.println(FETCHMESSAGE);
		Assert.assertEquals(FETCHMESSAGE, MESSAGE);
	}
	
	public void logout() throws InterruptedException {
		dropdown.click();
		Thread.sleep(1000);
		logOut.click();
	}

	
}
