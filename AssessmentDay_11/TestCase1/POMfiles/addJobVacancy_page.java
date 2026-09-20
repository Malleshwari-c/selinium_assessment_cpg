package Assessment12;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addJobVacancy12 {
WebDriver driver;
Robot r;
	
	public addJobVacancy12(WebDriver driver) throws AWTException {
		this.driver=driver;
		r=new Robot();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement vacancyName;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	private WebElement selectClick;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private WebElement description;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement hiringManager;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement noPosition;	
	
	@FindBy(css="[type='submit']")
	private WebElement saveClick;

	public void vacanyJob(String VN,String JT,String des,String HM,String Pos) throws InterruptedException {
		System.out.println("filling started");
		vacancyName.sendKeys(VN);
		System.out.println("vaname entered");
		
		selectClick.click();
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
		
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
		
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
		System.out.println("click selection");
		
		description.sendKeys(des);
		System.out.println("descript entered");
		
		hiringManager.sendKeys(HM);
		System.out.println("HM entered");
		
		noPosition.sendKeys(Pos);
		System.out.println("Position entered");

		
		saveClick.click();
		System.out.println("saved succesfully");;
	}

}
