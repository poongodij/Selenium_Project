package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MbrLoginPOM {
	private WebDriver driver; 
	public MbrLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='memberName']")
	private WebElement memberLoginName;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement grantLoan;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement loanAmount;
	
	@FindBy(xpath="//*[@id=\"description\"]")
	private WebElement loanDescription;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")
	private WebElement loanDtlsSubmit;
	
	@FindBy(xpath="//table[@class='defaultTableContent']/tbody/tr[2]/td[1]/table/tbody/tr[7]/td[1]/input")
	private WebElement loanGrantConf;
	
	@FindBy(xpath="//table[@class='defaultTableContent']/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[2]/input")
	private WebElement viewLoans;
	
	@FindBy(xpath="//li[@id='menu15']")
	private WebElement Logout;
	
	@FindBy(xpath="//li[@id='menu2']")
	private WebElement acctLink ;
	
	@FindBy(xpath="//li[@id='submenu2.3']")
	private WebElement Loanslink;
	
	@FindBy(xpath="//table[@class='defaultTableContent']/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[4]/img")
	private WebElement grantedLoanView;
	
	@FindBy(xpath="//input[@id='amountText']")
	private WebElement amountRepay;
	
	@FindBy(xpath="//*[@id=\"repayForm\"]/table/tbody/tr[3]/td/input")
	private WebElement repayButton;

	//2nd Test case
	@FindBy(xpath="//li[@id='submenu2.4']")
	private WebElement memberPayment;

	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement loginPaymentRecipentName;
	
	@FindBy(xpath="//input[@id='memberName']")
	private WebElement RecipentName;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement memberPymtAmount;
	
	@FindBy(xpath="//*[@id=\"description\"]")
	private WebElement memberPymtDescription ;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement memberPymtSubmit;
	
	@FindBy(xpath="//table[@class='defaultTableContent']/tbody/tr[2]/td[1]/table/tbody/tr[6]/td/input")
	private WebElement memberPymtTxnConfirm;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[1]/td[2]/input")
	private WebElement memberAcctInfoSubmit;
	
	@FindBy(xpath="//li[@id='menu6']")
	private WebElement logoutMbrPymt;
	
	//3rd Test case to read new message
	
	@FindBy(xpath="//li[@id='menu1']")
	private WebElement personalLink;
	
	@FindBy(xpath="//li[@id='submenu1.1']")
	private WebElement messagesSubLink;
	
	@FindBy(xpath="//input[@id='newButton']")
	private WebElement newMsgSbmtBtn;
	
	@FindBy(xpath="//select[@name='sendTo']/option[2]")
	private WebElement msgSendTo;
	
	@FindBy(xpath="//select[@name='message(category)']/option[4]")
	private WebElement msgCategory;
	
	@FindBy(xpath="//input[@id='subjectText']")
	private WebElement msgSubject;
	
	@FindBy(xpath="//iframe[contains(@title,'Rich text editor')]")
	private WebElement messageBody;
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement msgSubmitBtn;
	
	@FindBy(xpath="//li[@id='menu8']")
	private WebElement messagesTab;
	
	@FindBy(xpath="//li[@id='submenu8.0']")
	private WebElement messagesLink;
	
	@FindBy(xpath="//*[@id=\"tdContents\"]/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")
	private WebElement msgUnreadView;
	
	//4th test case
	@FindBy(xpath="//li[@id='submenu2.0']")
	private WebElement accountInfoSublink;
	
	@FindBy(xpath="//li[@id='menu3']")
	private WebElement accountsTab;
	
	@FindBy(xpath="//li[@id='submenu3.6']")
	private WebElement memberPaymentAdmin;
	
	//5th Test case
	@FindBy(xpath="//li[@id='menu9']")
	private WebElement settingsTab;
	
	@FindBy(xpath="//li[@id='submenu9.1']")
	private WebElement alertSettingsSublink;
	
	@FindBy(xpath="//input[@id='modifyButton']")
	private WebElement modifyAlertSetting;
	
	@FindBy(xpath="//input[@name='setting(givenVeryBadRefs)']")
	private WebElement referenceValChange;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement alertSettingSubmit;
	
	@FindBy(xpath="//input[@id='btn']")
	private WebElement backButtonLogin;
	
	public void memberLogin(String mbrName) {
		this.memberLoginName.clear(); 
		this.memberLoginName.sendKeys(mbrName);
		this.memberLoginName.click();
		}
	public void grntLoanSbmt() {
		this.grantLoan.click();
		System.out.println("Grant Loan Submit button");
		}
	public void loanDetails(String amount, String desc) {
		this.loanAmount.click();
		this.loanAmount.sendKeys(amount);
		this.loanDescription.click();
		this.loanDescription.sendKeys(desc);
		}
	public void LoanSbmtDetails() {
		this.loanDtlsSubmit.click();
		System.out.println("Submit clicked for loan\n");
		}

	public void loanConfSubmit() {
		this.loanGrantConf.click();
		System.out.println("Loan details submitted\n");
	}
	
	public void loanGrantAlert() {
		Alert alertLoanGrant = driver.switchTo().alert();				 
        String alertMsg2= driver.switchTo().alert().getText();		      		
        System.out.println("OK clicked for granting loan\n" +alertMsg2);
        System.out.println("Member details page displayed\n");
        alertLoanGrant.accept();
	}
	public void loanView() {
		this.viewLoans.click();
		System.out.println("Submit clicked to view granted loans\n");
	}
	public void logout() {
		this.Logout.click();
	}
	public void logoutAlert() {
		Alert alert = driver.switchTo().alert();				 
        String alertMsg1= driver.switchTo().alert().getText();		      		
        System.out.println("OK clicked for logout alert\n" +alertMsg1);	
        System.out.println("Logged out\n");
        alert.accept();
	}
	public void accountsLink() {
		this.acctLink.click();
		}
	public void loansSubLink() {
		this.Loanslink.click();
		System.out.println("Loans sublink clicked");
		}
	public void grantedViewLoan() {
		this.grantedLoanView.click();
		System.out.println("View button for granted loans clicked");
		}
	public void repay(String amt) {
		this.amountRepay.clear();
		this.amountRepay.sendKeys(amt);
		System.out.println("500 entered in amount");
	}
	public void repayBtn() {
		this.repayButton.click();
		System.out.println("Repay button clicked");
		System.out.println("Amount deducted from loan amount after repaying");
	}
	public void loanRepayAlert() {
		Alert alertLoanRepay = driver.switchTo().alert();				 
        String alertMsg3= driver.switchTo().alert().getText();	
        alertLoanRepay.accept(); 	      		
        System.out.println("OK clicked for Repay loan\n" +alertMsg3);
        String alertMsg4= driver.switchTo().alert().getText();		      		
        System.out.println("OK clicked for Repay loan\n" +alertMsg4);
        alertLoanRepay.accept();
	}
	//2nd Test case
	
	public void AcctTabSubLinks() {
		boolean acctinfo = driver.findElement(By.xpath("//li[@id='submenu2.0']")).isDisplayed();
		System.out.println(acctinfo);
		boolean schedulePymtLink = driver.findElement(By.xpath("//li[@id='submenu2.1']")).isDisplayed();
		System.out.println(schedulePymtLink);
		boolean loansLink = driver.findElement(By.xpath("//li[@id='submenu2.3']")).isDisplayed();
		System.out.println(loansLink);
	}
	
	public void memberPaymentsublink() {
		this.memberPayment.click();
		System.out.println("Member Payment sublink clicked");
	}
	public void pymtToMemberDetails(String loginName, String amount, String Desc) throws InterruptedException {
		this.RecipentName.clear();
		this.RecipentName.sendKeys(loginName);
		Thread.sleep(6000);
		this.RecipentName.click();
		Thread.sleep(3000);
		this.memberPymtAmount.clear();
		this.memberPymtAmount.sendKeys(amount);
		this.memberPymtDescription.clear();
		this.memberPymtDescription.sendKeys(Desc);
		}
	public void mbrPaymtLogout() {
		this.logoutMbrPymt.click();
	}
	public void memberPymtSubmitButton() {
		this.memberPymtSubmit.click();
	}
	public void memberPymtConfirmSubmit() {
		this.memberPymtTxnConfirm.click();
		System.out.println("Transaction confirmation clicked for member payment");
	}
	public void accountInformationView(){
	this.memberAcctInfoSubmit.click();
	}
	
	//3rd test case to read a new unread message
	
	public void linkPersonalClick() {
		this.personalLink.click();
		System.out.println("Personal Link Clicked");
	}
	public void PersonalTabSubLinks() {
		boolean profile = driver.findElement(By.xpath("//li[@id='submenu1.0']")).isDisplayed();
		System.out.println(profile);
		boolean messages = driver.findElement(By.xpath("//li[@id='submenu1.1']")).isDisplayed();
		System.out.println(messages);
		boolean reportsLink = driver.findElement(By.xpath("//li[@id='submenu1.6']")).isDisplayed();
		System.out.println(reportsLink);
	}
	public void sublinkMessageClick() {
		this.messagesSubLink.click();
		System.out.println("Messages Link clicked");
	}
	public void newMessageSubmitclick() {
		this.newMsgSbmtBtn.click();
		System.out.println("Submit clicked for New Message Creation");
		}
	public void messageContentValues() throws InterruptedException{
		this.msgSendTo.click();
		Thread.sleep(2000);
		this.msgCategory.click();
		Thread.sleep(2000);
		}
	public void	msgSubjValue(String subj){
		this.msgSubject.click();
		this.msgSubject.sendKeys(subj);
	}
		
	public void msgBodyValue(String body) {
		//driver.switchTo().frame(0);
		System.out.println("Frames");
		driver.findElement(By.xpath("//iframe[contains(@title,'Rich text editor')]")).sendKeys(body);
		}
		public void sendMsgSubmit() {
		this.msgSubmitBtn.click();	
		System.out.println("submit clicked on Send Message");
	}
	public void msgSentAlert() {
		Alert sentMsgAlert = driver.switchTo().alert();				 
        String alertMsgSent= driver.switchTo().alert().getText();		      		
        System.out.println("OK clicked for Message Sent alert\n" +alertMsgSent);	
        sentMsgAlert.accept();
		}
	public void msgTabnLinkClick() throws InterruptedException {
		this.messagesTab.click();
		Thread.sleep(2000);
		this.messagesLink.click();
		Thread.sleep(2000);
		System.out.println("Messages tab and link Clicked");
	}
	public void UnreadMsgView() {
		this.msgUnreadView.click();
		System.out.println("clicked on Unread Message");
	}
	//4th Test case
	public void AccountsTabClick() {
		this.accountsTab.click();
		System.out.println("Accounts link clicked after logging in as member");
		boolean manageCurrLink = driver.findElement(By.xpath("//li[@id='submenu3.0']")).isDisplayed();
		System.out.println(manageCurrLink);
		boolean manageAccountsLink = driver.findElement(By.xpath("//li[@id='submenu3.1']")).isDisplayed();
		System.out.println(manageAccountsLink);
		boolean systemPaymentLink = driver.findElement(By.xpath("//li[@id='submenu3.5']")).isDisplayed();
		System.out.println(systemPaymentLink);
		this.memberPaymentAdmin.click();
	}
	public void accountInformationSublink() {
		this.accountInfoSublink.click();
		System.out.println("Account Information sublink clicked to view account information");
	}
	
	//5th test case
	public void settingsTabClick() throws InterruptedException {
		this.settingsTab.click();
		Thread.sleep(2000);
		System.out.println("Settings Tab clicked");
		boolean localsettingslink = driver.findElement(By.xpath("//li[@id='submenu9.0']")).isDisplayed();
		System.out.println(localsettingslink);
		boolean mailsettingslink = driver.findElement(By.xpath("//li[@id='submenu9.3']")).isDisplayed();
		System.out.println(mailsettingslink);
		this.alertSettingsSublink.click();
		Thread.sleep(2000);
		System.out.println("Alert Settings sublink clicked");
		this.modifyAlertSetting.click();
		Thread.sleep(2000);
		System.out.println("Change button clicked to change Reference value and the fields are editable now");
	}
	public void AlertValueModify(String refvalue) throws InterruptedException {
		this.referenceValChange.click();
		this.referenceValChange.clear();	
		this.referenceValChange.sendKeys(refvalue);
		Thread.sleep(2000);
		System.out.println(" Clicked on GivenVeryBadRefs TextBox and change from 1 to 2");
		}
	public void AlertValueSubmit() {
		this.alertSettingSubmit.click();
		System.out.println(" Saving reference Value");
		}
	public void AlertSettingChangeAlert() {
		Alert SettingAlert = driver.switchTo().alert();				 
        String SettingsAlertModify= driver.switchTo().alert().getText();		      		
        System.out.println("OK clicked for Alert Setting Modified\n" + SettingsAlertModify);	
        SettingAlert.accept();
		}
	public void backClick() {
		this.backButtonLogin.click();
		System.out.println("Back Button clicked for Invalid credentials");
	}
}


	
