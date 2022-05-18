package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Logoutpage {
	WebDriver driver;
	public Logoutpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	@FindBy(id="welcome")
	WebElement clickwelcome;
	@FindBy(id="welcome-menu")
	WebElement clicklogout;
	public void logout()
	{
		Actions ac= new Actions(driver);
		ac.moveToElement(clickwelcome).click().perform();
		ac.moveToElement(clicklogout).click().perform();
		String expected= "login";
		String actual=driver.getCurrentUrl();
		if (actual.contains(expected)) {
			Reporter.log("logout success",true);
		}
		else
		{
			Reporter.log("logout fail",true);
		}
	}
}
