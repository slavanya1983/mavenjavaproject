package NewMaven;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.qacHomePage;
import pageObjects.qacLoginPage;
import resources.BaseClass;

public class qaClickAcademy extends BaseClass{
			
	@Test
	public void basePageNavigation() throws IOException
	{
		driver = setDriver();
		log.info("Driver is initialized");
		String myURL = prop.getProperty("URL");
		driver.get(myURL);
		log.info("WebApplication is open for testing");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		qacHomePage qH = new qacHomePage(driver);
		qH.noThanks().click();
		log.info("Pop-up closed");
		
		//assert.assertEquals(qH.text1().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		//log.info("Assert Passed");
	}
	@Test
	public void validateText()
	{
		qacHomePage qH = new qacHomePage(driver);
		
		String myText1 = qH.text1().getText().toString();
		assertEquals(myText1,"AN ACADEMY TO LEARN EVERYTHING ABOUT TESING");		
	}
	
	@Test (dataProvider="getData")
	public void clickLogin(String unameVal, String pwdVal)
	{
		qacHomePage qH = new qacHomePage(driver);
		
		qH.login().click();

		qacLoginPage qL = new qacLoginPage(driver);
		qL.Email().sendKeys(unameVal);
		qL.Password().sendKeys(pwdVal);
		driver.navigate().back();
		log.info("Login");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[3][2];
		
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=1;j++)
			{
				data[i][j] = "Hello"+i+j;
			}
		}
		return data;
	}
	
	@AfterTest
	public void closeBroser()
	{
		driver.close();
		log.info("Driver is closed");
	}
}
