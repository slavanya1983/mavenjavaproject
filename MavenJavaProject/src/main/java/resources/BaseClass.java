package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static WebDriver driver;
	protected Properties prop = new Properties();
	
	public WebDriver setDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\MavenJavaProject\\src\\main\\java\\resources\\MasterProperties.properties");
		prop.load(fis);
		String browserType = prop.getProperty("browserType");
		
		if (browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		else if (browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\eclipse-workspace\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	
	public void generateScreenshot(String result) throws IOException
	{
		log.info("Inside Take Screenshot Block");
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("C:\\Users\\Administrator\\eclipse-workspace\\MavenJavaProject\\screenshots"));
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\screenshots\\"+result+" " + timestamp() + " screenshot.png"));
		
	}

	public String timestamp() 
	{
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
} 