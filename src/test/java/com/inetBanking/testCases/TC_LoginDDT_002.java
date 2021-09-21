package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws IOException {
     
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.btnLogin();
		
		if(isAlertPresent()==true)
		{
						
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();			
			Assert.assertTrue(false);
			logger.warn("Login failed");
			
		}
		else
		{
			
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.btnLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;

		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";

		int rowNum = XLUtils.getRowCount(path, "loginData");
		int colCount = XLUtils.getCellCount(path, "loginData", 1);

		String logindata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "loginData", i, j);

			}

		}

		return logindata;

	}

}
