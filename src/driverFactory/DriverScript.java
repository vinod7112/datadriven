package driverFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunction.FunctionLibrary;
import constant.AppUtil;
import utilities.ExcelUtilities;

public class DriverScript extends AppUtil {
	String inputpath = "C:\\eclipse\\FrameworkPractice\\DDT-Framework\\TestInput\\Logindata.xlsx";
	String outputpath="C:\\eclipse\\FrameworkPractice\\DDT-Framework\\TestOutput\\Outputtest.xlsx";
	@Test
	public void validateLogin() throws Throwable
	{
		//create objject for excelfileutil class
		
		ExcelUtilities xl = new ExcelUtilities(inputpath);
		//count no of rows in a sheet
		int rc=xl.rowcount("Login");
		//count no of cells in a firstrow
		int cc= xl.cellcount("Login");
		Reporter.log("no of rows are::"+rc+"  "+"no of cells are"+cc,true);
		//iterate all rows
		for (int i = 0; i <= rc; i++) 
		{
			driver.get(config.getProperty("Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//read username cell
			String User = xl.getcelldata("Login", i, 0);
			String pass= xl.getcelldata("Login", i, 1);
			boolean res = FunctionLibrary.verifyLogin(User, pass);
			if(res)
			{
			xl.setcelldata("Login", 1, 2,"Login Succes", outputpath);
			xl.setcelldata("Login", 1, 3, "pass", outputpath); 
			}
			else
			{
				File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File(".screens/iteration"+i+"Loginimage.png"));
				xl.setcelldata("login", 1, 2, "Login Fail", outputpath);
				xl.setcelldata("Login", 1, 3, "Fail", outputpath);
			}
		}
	}

	}
