package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class AddUserPage {
WebDriver driver;
public AddUserPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(id="menu_admin_viewAdminModule")
WebElement clickAdmin;
@FindBy(name="menu_admin_UserManagement")
WebElement Usermgnt;
@FindBy(id="menu_admin_viewSystemUsers")
WebElement clickuser;
@FindBy(name="btnAdd")
WebElement clickadd;
@FindBy(id="systemUser_userType")
WebElement Userrole;
@FindBy(name="systemUser[employeeName][empName]")
WebElement Empname;
@FindBy(name="systemUser[userName]")
WebElement Username;
@FindBy(name="systemUser[password]")
WebElement Password;
@FindBy(name="systemUser[confirmPassword]")
WebElement Cpassword;
@FindBy(id="btnSave")
WebElement savebtn;
public boolean VerifyLogin(String selectRole,String EnterEmpname,String EnterUsername,String EnterPass,String EnterCpass )
{
	Actions ac = new Actions(driver);
	ac.moveToElement(clickAdmin).perform();
	ac.moveToElement(Usermgnt).perform();
	ac.moveToElement(clickuser).click().perform();
	ac.moveToElement(clickadd).click().perform();
	new Select(Userrole).selectByVisibleText(selectRole);
	Empname.sendKeys(EnterEmpname);
	Username.sendKeys(EnterUsername);
	Password.sendKeys(EnterPass);
	Cpassword.sendKeys(EnterCpass);
	savebtn.click();
	String expected ="viewSystemUsers";
	String actual = driver.getCurrentUrl();
	if (actual.contains(expected)) {
		Reporter.log("Add user pass",true);
		return true;
		
	}
	else
	{
		Reporter.log("Add user Fail",true);
		return false;	
	}
}
}
