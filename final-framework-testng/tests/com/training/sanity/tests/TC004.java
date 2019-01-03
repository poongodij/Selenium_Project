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

//Inserting new advertisement
public class TC004 {
	
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
		public void newAdvt() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("1234");
		loginPOM.clickLoginBtn();
		System.out.println("Successfully Logged In");
		homePOM.memberLogin("poongodi");
		homePOM.mngeAdvtmt();
		homePOM.insertNewAdvtmt();
		homePOM.advtTitle("new offer");
		homePOM.category();
		Thread.sleep(2000);
		homePOM.priceAdv("7");
		homePOM.notExpired();
		homePOM.descAdvt("new offer for member");
		/*Thread.sleep(2000);
		homePOM.descriptionFrame("new offer for member");*/
		homePOM.advtmtSubmit();
		Thread.sleep(2000);
		homePOM.advtmtSubmitAlert();
		Thread.sleep(2000);
		homePOM.advtmtBackAlert();
		Thread.sleep(2000);
		homePOM.logout();
		Thread.sleep(5000);
		homePOM.logoutAlert();
		System.out.println("Successfully Logged Out");
	}
}


