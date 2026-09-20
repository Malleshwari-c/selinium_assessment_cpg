package Assess12_testcase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM {
WebDriver driver;
	public String first_name,middle_name,last_name,employee_id;
	
	public PIM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="[name='firstName']")
	private WebElement firstName;
	
	@FindBy (css="[name='middleName']")
	private WebElement middleName;
	
	@FindBy (css="[name='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")
	private WebElement employeeId;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement saveB;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(css="[class='oxd-userdropdown-tab']")
	private WebElement user;

	public void enterDetails(String FN,String MN, String LN,String EI) {
		firstName.sendKeys(FN);
		middleName.sendKeys(MN);
		lastName.sendKeys(LN);
		employeeId.sendKeys(EI);
		saveB.click();
		user.click();
	}

	
	public void verify() {
		first_name=firstName.getText();
		middle_name=middleName.getText();
		last_name=lastName.getText();
		employee_id=employeeId.getText();
	}

	public void logOut() {
		logout.click();
		
	}
}
