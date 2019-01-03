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

public class wk2_CYTC_042 {
	
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
	public void memberPayment() throws InterruptedException {
			loginPOM.sendUserName("manzoor");
			loginPOM.sendPassword("manzoor");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully Logged In as Manzoor(Member)");
			Thread.sleep(3000);
			mbrtestPOM.accountsLink(); 
			Thread.sleep(2000);
			mbrtestPOM.AcctTabSubLinks();
			Thread.sleep(2000);
			mbrtestPOM.memberPaymentsublink(); 
			Thread.sleep(2000);
			mbrtestPOM.pymtToMemberDetails("selenium","1.00", "birthday gift"); 
			Thread.sleep(2000);
			mbrtestPOM.memberPymtSubmitButton(); 
			Thread.sleep(2000);
			mbrtestPOM.memberPymtConfirmSubmit();
			Thread.sleep(2000);
			mbrtestPOM.mbrPaymtLogout();
			Thread.sleep(2000);
			mbrtestPOM.logoutAlert();
			Thread.sleep(3000);
			System.out.println("Successfully Logged out from member login");
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("1234");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully Logged in as Admin");
			mbrtestPOM.memberLogin("manzoor mehadi");
			Thread.sleep(3000);
			System.out.println("Member Details Displayed\n");
			mbrtestPOM.accountInformationView();
			Thread.sleep(5000);
			System.out.println("Account Information displayed");
			Thread.sleep(3000);
			mbrtestPOM.logout();
			mbrtestPOM.logoutAlert();
			Thread.sleep(3000);
			System.out.println("Logged out");
			driver.close();
	}

}
