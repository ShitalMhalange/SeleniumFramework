package com.MyFrame.Testcases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyFrame.pageObject.LoginPage;
public class TC_Loginpage_001 extends Baseclass
{
		@Test
		public void loginTest() throws IOException, InterruptedException
		{
			logger.info("URI lunch successfullyyyyy");
			LoginPage lp=new LoginPage(driver);
			logger.info("Enter username");
			lp.setusername(username);
			logger.info("Enter username");
			lp.setpassword(password);
			logger.info("Enter password");
			lp.clickloginbtn();
			logger.info("click button");
			Thread.sleep(10000);
			//System.out.println(driver.getTitle()+"99999");
			System.out.println("@@@@@@");
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				System.out.println(driver.getTitle()+"shital");
				capturescreenshot(driver, "loginTest");
				Assert.assertTrue(true);
				logger.info("Login successful");
			}
			else
			{
				System.out.println(driver.getTitle()+"shital");
				capturescreenshot(driver,"loginTest");
				Assert.assertTrue(false);			
				logger.info("Login unsuccessful");
			}
			}
}
