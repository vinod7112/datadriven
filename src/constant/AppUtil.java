package constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeTest
public void Setup()throws Throwable
{
	config = new Properties();
	config.load(new FileInputStream("C:/eclipse/FrameworkPractice/DDT-Framework/PropertyFile/OrangeHRM.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver(); 
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("Browser value is not matching");
	}
}
@AfterTest
public void TearDown()
{
	driver.close();
}

}
