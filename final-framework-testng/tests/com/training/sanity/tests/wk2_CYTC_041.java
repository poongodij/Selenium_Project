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


public class wk2_CYTC_041 {
	
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

	//1st Test case - Granting Loan as admin and repaying as a member
	@Test
	public void mbrLoanGrantRepay() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("1234");
		loginPOM.clickLoginBtn();
		System.out.println("Successfully Logged In");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("JPoongodi");
		mbrtestPOM.memberLogin("poongodi"); 
		System.out.println("Member Details entered");
		mbrtestPOM.grntLoanSbmt(); //Member Login Page Grant Loan Submit Button
		//mbrtestPOM.grantLoanSubmit();
		mbrtestPOM.loanDetails("100000.00", "home loan"); //Loan details
		Thread.sleep(2000);
		mbrtestPOM.LoanSbmtDetails();
		Thread.sleep(2000);
		mbrtestPOM.loanConfSubmit();
		Thread.sleep(2000);
		System.out.println("Loan submitted for granting\n");
		Thread.sleep(2000);
		mbrtestPOM.loanGrantAlert();//for loan granted loan alert
		Thread.sleep(1000);
		mbrtestPOM.loanView();
		Thread.sleep(3000);
		mbrtestPOM.logout();
		mbrtestPOM.logoutAlert();
		Thread.sleep(2000);
		System.out.println("Successfully Logged out");
		loginPOM.sendUserName("JPoongodi");
		loginPOM.sendPassword("4567");
		loginPOM.clickLoginBtn();
		System.out.println("Successfully Logged in as JPoongodi(Member)");
		mbrtestPOM.accountsLink();
		Thread.sleep(2000);
		mbrtestPOM.loansSubLink();
		Thread.sleep(2000);
		mbrtestPOM.grantedViewLoan();
		Thread.sleep(1000);
		mbrtestPOM.repay("500.00");//repay amount as 500.00
		mbrtestPOM.repayBtn();
		Thread.sleep(2000);
		mbrtestPOM.loanRepayAlert();
		Thread.sleep(4000);
		driver.close();
}			

}
