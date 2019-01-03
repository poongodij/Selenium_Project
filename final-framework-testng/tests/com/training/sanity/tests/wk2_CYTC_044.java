package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MbrLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class wk2_CYTC_044 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private MbrLoginPOM mbrtestPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		mbrtestPOM = new MbrLoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	/*
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	};*/
	
	@Test 
	public void AcccountInfoView() throws InterruptedException {
	loginPOM.sendUserName("admin");
	loginPOM.sendPassword("1234");
	loginPOM.clickLoginBtn();
	System.out.println("Successfully Logged in as Admin");
	Thread.sleep(3000);
	mbrtestPOM.AccountsTabClick(); 
	Thread.sleep(2000);
	mbrtestPOM.pymtToMemberDetails("PoongodiJ","1.00", "welcome"); 
	Thread.sleep(2000);
	mbrtestPOM.memberPymtSubmitButton(); 
	Thread.sleep(2000);
	mbrtestPOM.memberPymtConfirmSubmit();
	Thread.sleep(2000);
	mbrtestPOM.logout();
	Thread.sleep(2000);
	mbrtestPOM.logoutAlert();
	Thread.sleep(3000);
	System.out.println("Successfully Logged out from member login");
	loginPOM.sendUserName("JPoongodi");
	loginPOM.sendPassword("4567");
	loginPOM.clickLoginBtn();
	System.out.println("Successfully Logged in as Manzoor to view Account Information");
	mbrtestPOM.accountsLink(); 
	Thread.sleep(2000);
	mbrtestPOM.accountInformationSublink();
	Thread.sleep(3000);
	System.out.println("Account Information displayed");
	driver.close();
	}
}
