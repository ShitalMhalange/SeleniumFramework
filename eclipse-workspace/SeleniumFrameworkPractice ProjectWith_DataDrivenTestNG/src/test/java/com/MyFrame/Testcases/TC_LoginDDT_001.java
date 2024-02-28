package com.MyFrame.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyFrame.pageObject.LoginPage;
import com.MyFrame.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_001 extends Baseclass
{
	@Test(dataProvider="LoginData")
	 public void loginDDT(String uname,String Pwd) throws InterruptedException
	 {
			LoginPage lp=new LoginPage(driver);
			lp.setusername(uname);
			logger.info("User name provided");
			lp.setpassword(Pwd);
			logger.info("password  provided");
			Thread.sleep(10000);
			lp.clickloginbtn();
			logger.info("click on login button");
			System.out.println("Alert");
			//System.out.println(driver.switchTo().alert().getText());
			System.out.println();
			if(IsAlertPresent()==true)
			{
				System.out.println(uname+"		alert present   "+Pwd);
				System.out.println("");
				logger.warn("login failed");
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				
			}
			else 
			{
				System.out.println(uname+" 		not present  "+Pwd);
				System.out.println("");
				logger.info("login passed");
				Thread.sleep(1000);
				Assert.assertTrue(true);
				Thread.sleep(1000);
				
				Thread.sleep(1000);
				lp.clicklogout();
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				
			}
	 }
	
	
public boolean IsAlertPresent()
{
	try {
	driver.switchTo().alert();
	 return true;
	}
	catch (NoAlertPresentException e) {
		return false;
	}
	
}
	
	
	
	
	
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException
	{
		String Path="C:\\Users\\AVINASH\\eclipse-workspace\\AASeleniumFrameworkPractice Project\\src\\test\\java\\com\\MyFrame\\TestData\\SeleniumFramewirkData.xlsx";
		int rownum=XLUtils.getRowCount(Path, "Sheet1");
		int columcount=XLUtils.getcellCount(Path, "Sheet1",1);
		String LOginData [][]=new  String[rownum][columcount];
		String temp[][]= {{},{}};
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columcount;j++)
			{
				LOginData[i-1][j]=XLUtils.getcellData(Path, "sheet1", i, j);
			}
			
		}
		return LOginData;
		
	}
	
	
}
