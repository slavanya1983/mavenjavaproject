package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qacHomePage {
	
	public WebDriver driver;
	
	public qacHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[contains(text(),'NO THANKS')]")
	WebElement NoThanks;
	public WebElement noThanks()
	{
		return NoThanks;
	}

	@FindBy (xpath="//span[contains(text(),'Login')]")
	WebElement Login;
	public WebElement login()
	{
		return Login;
	}
	
	@FindBy (xpath="//div[@class='carousel-caption']//h3[contains(text(),'An Academy to learn Everything')]")
	WebElement Text1;
	
	public WebElement text1()
	{
		return Text1;
	}
}
