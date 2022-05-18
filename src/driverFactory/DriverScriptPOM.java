package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonFunction.AddUserPage;
import commonFunction.LoginPage;

public class DriverScriptPOM {
	WebDriver driver;
	String inputpath="C:/eclipse/FrameworkPractice/DDT-Framework/TestInput/Userdata.xlsx";
	String outputpath="C:/eclipse/FrameworkPractice/DDT-Framework/TestOutput/Userresults.xlsx";
	@BeforeTest
	public void adminLogin(){
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("");
		LoginPage login= PageFactory.initElements(driver, LoginPage.class);
		login.verifyLogin("Admin", "Qedge123!@#");
	}
	@Test
	public void validateUser()
	{
		AddUserPage users =PageFactory.initElements(driver, AddUserPage.class);
		
	}

}
