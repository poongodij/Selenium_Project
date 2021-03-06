package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Changing Member Login password
public class TC003 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	//Change of Admin Password(Member Login)
	@Test
	public void mbrLogin() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("1234");
		loginPOM.clickLoginBtn();
		System.out.println("Successfully Logged In");
		homePOM.memberLogin("poongodi");
		homePOM.manageLoginPwd();
		Thread.sleep(2000);
		homePOM.ChngMbrLoginPwd("manzoor", "manzoor");
		Thread.sleep(2000);
		homePOM.resetPwdAlert();
		Thread.sleep(2000);
		homePOM.resetSentPwdAlert();
		Thread.sleep(2000);
		homePOM.clkBackMbrLogin();
		homePOM.logout();
		Thread.sleep(3000);
		homePOM.logoutAlert();
		System.out.println("Successfully Logged Out");
	}
	
}
