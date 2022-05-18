package May16;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Dataprovider {
	WebDriver driver;
	
	 @BeforeTest
	  public void setup() {
		 driver=new FirefoxDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  }
  @Test(dataProvider = "supplydata")
  public void verifylogin(String username, String password) 
  {
	  driver.get("http://orangehrm.qedgetech.com/");
	  driver.findElement(By.name("txtUsername")).sendKeys(username);
	  driver.findElement(By.name("txtPassword")).sendKeys(password);
	  driver.findElement(By.name("Submit")).click();
	  String expected= "dashboard";
	  String actual= driver.getCurrentUrl();
	  try{
	  Assert.assertTrue(actual.contains(expected), "login Fail");
	  }catch(Throwable t)
	  {
		  System.out.println(t.getMessage());
	  }
  }

  @DataProvider
  public Object[][] supplydata() {
	  Object login[][]=new Object[4][2];
	  login[0][0]="Admin";
	  login[0][1]="Qedge123!@#";
	  login[1][0]="Admin";
	  login[1][1]="Qedge";
	  login[2][0]="admin";
	  login[2][1]="Qedge123!@#";
	  login[3][0]="Admin";
	  login[3][1]="Qedge123!@#";
	return login;
	  
   
    }
  
 

  @AfterTest
  public void afterTest() {
  }

}
