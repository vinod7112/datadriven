package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonFunction.AddEmpPage;
import commonFunction.AddUserPage;
import commonFunction.LoginPage;
import commonFunction.Logoutpage;

public class TestScript {
WebDriver driver;
@BeforeMethod
public void adminLogin()
{
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com");
	//call login page class
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	login.verifyLogin("Admin", "Qedge123!@#");
}
@Test 
public void ValidateUser()
{
	AddUserPage user = PageFactory.initElements(driver, AddUserPage.class);
	boolean results =user.VerifyLogin("ESS", "Aacadhi higgg Demo", "sdfsd", "ASDasd!@#123", "ASDasd!@#123");
	System.out.println(results);
}
@Test
public void Validateemp()
{
	AddEmpPage emp = PageFactory.initElements(driver, AddEmpPage.class);
	boolean result= emp.verifyaddemp("fdgf", "gdgfd", "ddff");
	System.out.println(result);	
}
@Test
public void validatelogout()
{
	Logoutpage logout= PageFactory.initElements(driver, Logoutpage.class);
	System.out.println(logout);
	
}
@AfterMethod
public void tearDown()
{
	driver.close();
}
}
