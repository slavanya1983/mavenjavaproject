package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qacLoginPage {
	
	public WebDriver driver;
	
	public qacLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="user_email")
	WebElement email;
	
	@FindBy (id="user_password")
	WebElement password;
	
	public WebElement Email()
	{
		return email;
	}
	
	public WebElement Password()
	{
		return password;
	}	
}
