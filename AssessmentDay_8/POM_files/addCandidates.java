package assess_8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addCandidates {
//create driver as global variable
WebDriver driver;
	//constructor call and pass driver as argument
	public addCandidates(WebDriver driver) {
		this.driver=driver;
    //initiate all the variables using PageFactory
		PageFactory.initElements(driver, this);
	}
	//find firstname using css selector
	@FindBy (css="[name='firstName']")
	public WebElement firstName;
	//find middlename using css selector
	@FindBy (css="[name='middleName']")
	public WebElement middleName;
	//find lastname using css selector
	@FindBy (css="[name='lastName']")
	public WebElement lastName;
	//find select dropdown using css selector
	@FindBy(css="[class='oxd-select-text--after']")
	public WebElement select;
	//find email using xpath
	@FindBy(xpath="//label[text()='Email']/parent::div/following-sibling::div/child::input")
	private WebElement email;
	//find select vacany from the dropdown using xpath
	@FindBy(xpath="//div[@role='option' and normalize-space()='Junior Account Assistant']")
	private WebElement vacany;
	//find save button using css selector
	@FindBy(css="[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement saveB;
	//find candiatate button using xpath
	@FindBy(xpath="//a[text()='Candidates']")
	private WebElement candi;
	
	//create a method to enter all the parameters and perdorm actions
	public void enterName(String FN,String MN,String LN,String EM) throws InterruptedException {
		firstName.sendKeys(FN);
		middleName.sendKeys(MN);
		lastName.sendKeys(LN);
		select.click();
		vacany.click();
		email.sendKeys(EM);
		saveB.click();
		candi.click();
	}
	
}
