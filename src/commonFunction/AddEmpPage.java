package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver;
	public AddEmpPage(WebDriver driver)
	{
		this.driver=driver;
	}
@FindBy(id="menu_pim_viewPimModule")
WebElement clickPIM;
@FindBy(id="menu_pim_addEmployee")
WebElement clicktoaddempbtn;
@FindBy(name="firstName")
WebElement fname;
@FindBy(name="middleName")
WebElement mname;
@FindBy(name="lastName")
WebElement lname;
@FindBy(name="employeeId")
WebElement empid;
@FindBy(id="btnSave")
WebElement savebtn;
public boolean verifyaddemp(String Enterfname,String Entermname,String Enterlname)
{
	Actions ac = new Actions(driver);
	ac.moveToElement(clickPIM).click().perform();
	ac.moveToElement(clicktoaddempbtn).click().perform();
	fname.sendKeys(Enterfname);
	mname.sendKeys(Entermname);
	lname.sendKeys(Enterlname);
	String beforeempid= empid.getAttribute("value");
	ac.moveToElement(savebtn).click().perform();
	String afterempid=empid.getAttribute("value");
	if(beforeempid.equals(afterempid)){
		Reporter.log("add emp success",true);
		return true;
	}
	else
	{
		Reporter.log("add emp fail",true);
		return false;
	}
}
}
