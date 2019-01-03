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

public class MbrLoginTests {

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

		/*//1st Test case - Granting Loan as admin and repaying as a member
		@Test
		public void mbrLoanGrantRepay() throws InterruptedException{
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("1234");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully Logged In");
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("JPoongodi");
			mbrtestPOM.memberLogin("JPoongodi"); 
			System.out.println("Member Details entered\n");
			mbrtestPOM.grntLoanSbmt(); //Member Login Page Grant Loan Submit Button
			//mbrtestPOM.grantLoanSubmit();
			mbrtestPOM.loanDetails("100000", "home loan"); //Loan details
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
			mbrtestPOM.repay("500.00");
			mbrtestPOM.repayBtn();
			Thread.sleep(2000);
			mbrtestPOM.loanRepayAlert();
			Thread.sleep(2000);
}			*/
			/*@Test
			public void memberPayment() throws InterruptedException {
					loginPOM.sendUserName("JPoongodi");
					loginPOM.sendPassword("4567");
					loginPOM.clickLoginBtn();
					System.out.println("Successfully Logged In as Manzoor");
					Thread.sleep(3000);
					mbrtestPOM.accountsLink(); 
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
					mbrtestPOM.memberLogin("JPoongodi");
					Thread.sleep(3000);
					System.out.println("Member Details Displayed\n");
					mbrtestPOM.accountInformationView();
					Thread.sleep(3000);
					System.out.println("Account Information displayed");
			}*/
			/*@Test
			public void MsgUnreadView() throws InterruptedException {
				loginPOM.sendUserName("JPoongodi");
				loginPOM.sendPassword("4567");
				loginPOM.clickLoginBtn();
				System.out.println("Successfully Logged In as JPoongodi");
				Thread.sleep(3000);
				mbrtestPOM.linkPersonalClick();
				Thread.sleep(2000);
				mbrtestPOM.sublinkMessageClick();
				Thread.sleep(2000);
				mbrtestPOM.newMessageSubmitclick();
				Thread.sleep(1000);
				mbrtestPOM.messageContentValues();
				Thread.sleep(3000);
				mbrtestPOM.msgSubjValue("hello");
				Thread.sleep(2000);
				mbrtestPOM.msgBodyValue("welcome");
				Thread.sleep(2000);
				mbrtestPOM.sendMsgSubmit();
				Thread.sleep(2000);
				mbrtestPOM.msgSentAlert();
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
				mbrtestPOM.msgTabnLinkClick();
				Thread.sleep(3000);
				mbrtestPOM.UnreadMsgView();
				Thread.sleep(3000);
			}*/
			/*@Test
			public void AcccountInfoView() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("1234");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully Logged In as Manzoor");
			Thread.sleep(3000);
			/*mbrtestPOM.accountsLink(); 
			Thread.sleep(2000);
			mbrtestPOM.memberPaymentsublink(); 
			Thread.sleep(2000);
			mbrtestPOM.pymtToMemberDetails("manzoor","500.00", "welcome"); 
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
			loginPOM.sendUserName("manzoor");
			loginPOM.sendPassword("manzoor");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully Logged in as Manzoor to view Account Information");
			mbrtestPOM.accountsLink(); 
			Thread.sleep(2000);
			mbrtestPOM.accountInformationSublink();
			Thread.sleep(2000);
			System.out.println("Account Information displayed");
			driver.close();
	}*/

			/*@Test
			public void ChangingAlertSettings() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("1234");
			loginPOM.clickLoginBtn();
			System.out.println("Successfully logged In as admin");
			Thread.sleep(3000);
			mbrtestPOM.settingsTabClick();
			mbrtestPOM.AlertValueModify("2");
			mbrtestPOM.AlertValueSubmit();
			mbrtestPOM.AlertSettingChangeAlert();
			Thread.sleep(2000);
			mbrtestPOM.logout();
			mbrtestPOM.logoutAlert();
			Thread.sleep(2000);
			System.out.println("Successfully Logged out from Admin user");	
			loginPOM.sendUserName("JPoongodi");
			loginPOM.sendPassword("selec");
			loginPOM.clickLoginBtn();
			System.out.println("Invalid Login. Please try again");
			mbrtestPOM.backClick();
			System.out.println("Back button clicked for 1st time invalid credentials");
			Thread.sleep(2000);
			loginPOM.sendUserName("JPoongodi");
			loginPOM.sendPassword("selec");
			loginPOM.clickLoginBtn();
			System.out.println("Back button clicked for 2nd time invalid credentials");
			mbrtestPOM.backClick();
			Thread.sleep(2000);
			loginPOM.sendUserName("JPoongodi");
			loginPOM.sendPassword("selec");
			loginPOM.clickLoginBtn();
			System.out.println("Your login is temporarily blocked now");
			mbrtestPOM.backClick();
			driver.close();
	}*/

	
}
