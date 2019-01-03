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

//Checking error message for changing password when new and confirm password are different 
public class TC001 {
	
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
	
	@Test
	public void changePwdTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("1234");
		loginPOM.clickLoginBtn();
		System.out.println("Successfully Logged In");
		Thread.sleep(6000);
		homePOM.ClickPersonalLink();
		homePOM.subLinkDisp1();
		System.out.println("Profile Link Displayed");
		homePOM.subLinkDisp2();
		System.out.println("Change Password Link Displayed");
		homePOM.subLinkDisp3();
		System.out.println("EMailNotifications Link Displayed");
		homePOM.changePwd();
		Thread.sleep(3000);
		homePOM.PwdReset("1234","123456", "654321");
		Thread.sleep(2000);
		homePOM.pwdChangeAlert();
		Thread.sleep(2000);
		homePOM.logout();
		Thread.sleep(3000);
		homePOM.logoutAlert();
		System.out.println("Successfully Logged Out");
		}
		
}
