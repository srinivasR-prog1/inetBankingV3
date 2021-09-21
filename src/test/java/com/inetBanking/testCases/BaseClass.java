package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;



public class BaseClass {

	public static WebDriver driver=null;
	public static Logger logger;
	
	ReadConfig readConfig= new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsrName();
	public String password = readConfig.getPwd();
    
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger=Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readConfig.getChroPath());
		driver=new ChromeDriver();
	   }else if(br.equals("firefox"))
	   {
		   
		   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		   
	   }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");
		
		

	}
     
	
	
	@AfterClass
	public void tearDown() {

		driver.quit();

	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png"));
		System.out.println("Screenshot taken");
		
		
	}

}
