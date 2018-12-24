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

public class HomePOM {
		private WebDriver driver; 
		
		public HomePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//li[@id='menu1']")
		private WebElement personalLink;
		
		@FindBy(xpath="//li[@id='submenu1.0']")
		private WebElement profile;
		
		@FindBy(xpath="//li[@id='submenu1.1']")
		private WebElement chngPwd;
		
		@FindBy(xpath="//li[@id='submenu1.2']")
		private WebElement eMailNote;
		
		@FindBy(xpath="//input[@name='oldPassword']")
		private WebElement oldPwd;
		
		@FindBy(xpath="//input[@name='newPassword']")
		private WebElement newPwd;

		@FindBy(xpath="//input[@name='newPasswordConfirmation']")
		private WebElement newPwdConf;
		
		@FindBy(xpath="//input[@class='button']")
		private WebElement submitPwdReset;
		
		@FindBy(xpath="//li[@id='menu15']")
		private WebElement Logout;
		
		//Member Login Starts
		@FindBy(xpath="//input[@id='memberUsername']")
		private WebElement mbrName;
		
		@FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[1]/td[2]/input")
		private WebElement manageLogin;
		
		@FindBy(xpath="//input[@name='newPassword']")
		private WebElement mgNewPwd;
		
		@FindBy(xpath="//input[@name='newPasswordConfirmation']")
		private WebElement mgNewPwdConf;
		
		@FindBy(xpath="//input[@name='forceChange']")
		private WebElement frcChange;
		
		@FindBy(xpath="//input[@id='resetAndSendButton']")
		private WebElement resetSendMail;
		
		@FindBy(xpath="//input[@id='backButton']")
		private WebElement backMbrLogin;
		
		//Manage Advertisement Starts(4th TC)
		
		@FindBy(xpath="//table[@class='defaultTable']/tbody/tr[4]/td[1]//input")
		private WebElement manageAdvt;
		
		@FindBy(id ="newButton")
		private WebElement insertNewAdvt;
		
		@FindBy(xpath="//input[@name='ad(title)']")
		private WebElement advtTitle;
		
		@FindBy(xpath="//select[@name='ad(category)']")
		private WebElement advtCategory;
		
		@FindBy(xpath="//select[@name='ad(category)']/option")
		private List<WebElement> advtCategorySel;
		
		@FindBy(xpath="//input[@name='ad(price)']")
		private WebElement price;
		
		@FindBy(xpath="//input[@id='notExpirableCheck']")
		private WebElement notExpired;
		
		@FindBy(xpath="//iframe[contains(@title,'Rich text editor')]")
		private WebElement descriptionAdvt;
		
		@FindBy(xpath="//input[@id='saveButton']")
		private WebElement advtSubmit;
		
		@FindBy(xpath="//input[@id='backButton']")
		private WebElement advtBack ;//Ends 4thTC
		
		//5th Tc 
		@FindBy(xpath="//table[@class='defaultTable']/tbody/tr[2]/td[6]/img[2]")
		private WebElement removeAdvtButton ;
					
		public boolean subLinkDisp1() {
			if (this.profile.isDisplayed())                                                                                                     
		{         
			  return true;
			  
		}    
			else    
			{     
			  return false;   
			}
		
		}
		public boolean subLinkDisp2() {
		if(this.chngPwd.isDisplayed())                                                                                                         
		{         
			  return true;
			}    
			else    
			{     
			  return false;   
			}
		
		}
		public boolean subLinkDisp3() {
			if(this.eMailNote.isDisplayed())                                                                                                         
			{         
				  return true;     
				}    
				else    
				{     
				  return false;   
				}
			}	
		
		public void ClickPersonalLink() {
			this.personalLink.click(); 
		}
		public void changePwd() {
			this.chngPwd.click(); 
		}
		public void PwdReset(String oldPwd, String newPwd, String CPwd) {
			this.oldPwd.clear(); 
			this.oldPwd.sendKeys(oldPwd);
			this.newPwd.clear(); 
			this.newPwd.sendKeys(newPwd);
			this.newPwdConf.clear(); 
			this.newPwdConf.sendKeys(CPwd);			
			this.submitPwdReset.click(); 
		} 
		public void pwdChangeAlert() {
			Alert alert = driver.switchTo().alert();				 
	        String alertMsg= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Pwdreset alert\n" +alertMsg);	      		
	        alert.accept();
		}  
		
		//3rd TC
		public void memberLogin(String mbrName) {
			this.mbrName.clear(); 
			this.mbrName.sendKeys(mbrName);
			this.mbrName.click();
			
		}
		
		public void manageLoginPwd() {
			this.manageLogin.click();
			System.out.println("Submit button clicked for Manage Login Password\n");
			}
		public void ChngMbrLoginPwd(String nwPwd, String cNwPwd) {
			this.mgNewPwd.clear(); 
			this.mgNewPwd.sendKeys(nwPwd);
			this.mgNewPwdConf.clear(); 
			this.mgNewPwdConf.sendKeys(cNwPwd);
			this.frcChange.click(); 
			System.out.println("Checkbox clicked for Force Change on Next login\n");
			this.resetSendMail.click();
			System.out.println("Submit clicked for Reset password & send by e-mail button\n");
		} 
		public void resetPwdAlert() {
			Alert alert = driver.switchTo().alert();				 
	        String alrtMsg1= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Reset Password alert\n" +alrtMsg1);	      		
	        alert.accept();
		}
		public void resetSentPwdAlert() {
			Alert alert = driver.switchTo().alert();
	        String alrtMsg2= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Sent to Member alert\n" +alrtMsg2);	      		
	        alert.accept();
		}
		public void clkBackMbrLogin() {
			this.backMbrLogin.click();
			System.out.println("Back button clicked\n");
		}//3rd TC
		
		public void mngeAdvtmt() {
			this.manageAdvt.click();
			System.out.println("Submit button clicked for Manage Advertisement\n");
		}
		public void insertNewAdvtmt() {
			this.insertNewAdvt.click();
			System.out.println("Submit button clicked for Insert new advertisement\n");
		}
		public void advtTitle (String Title) {
			this.advtTitle.clear();
			this.advtTitle.sendKeys(Title);
			}
		public void category() {
			this.advtCategory.click();
			this.advtCategorySel.get(1).click();
			/*Select categorySelection = new Select(this.advtCategory);
			List <WebElement> advList = categorySelection.getOptions();
			Actions action = new Actions(driver);
			action.keyDown(Keys.ARROW_DOWN).build().perform();
			//action.keyDown(Keys.CONTROL).click(advList.get(1)
			//categorySelection.selectByVisibleText("Example ad Category");  
			//System.out.println("Category Selected\n");*/
		}
		public void priceAdv(String priceAdvt) {
			this.price.clear();
			this.price.sendKeys(priceAdvt);
		}
		public void notExpired() {
			this.notExpired.click();
			System.out.println("Not Expirable check box clicked\n");
		}
		public void descAdvt(String desc) {
			//driver.switchTo().frame(0);
			System.out.println("Frames");
			driver.findElement(By.xpath("//iframe[contains(@title,'Rich text editor')]")).sendKeys(desc);
			}
		//5th TC
		public void removeAdvt() {
			Actions act = new Actions(driver);
			act.moveToElement(removeAdvtButton).click().build().perform();
			System.out.println("Remove Icon clicked\n");
		}
		public void advtRemovalAlert(){
			Alert alertRemove = driver.switchTo().alert();				 
	        String alertMsgRemove= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Advertisement Removal alert\n" +alertMsgRemove);	      		
	        alertRemove.accept();
		}
		public void advtRemovedAlert(){
			Alert alertRemoved = driver.switchTo().alert();				 
	        String alertMsgRemoved= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Advertisement Removed alert\n" +alertMsgRemoved);	      		
	        alertRemoved.accept();
		}   //5th TC
		
		public void advtmtSubmit() {
			this.advtSubmit.click();
			System.out.println("Advertisement insertion by Submit Button\n");
		}
		public void advtmtSubmitAlert(){
			Alert alertAdvtSubmit = driver.switchTo().alert();				 
	        String alertMsg2= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for Advertisement Inserted alert\n" +alertMsg2);	      		
	        alertAdvtSubmit.accept();
		}
		public void advtmtBackAlert(){
			this.advtBack.click();
			System.out.println("OK clicked on Advertisement BACK button");
		}
		
		public void logout() {
			this.Logout.click();
		}
		public void logoutAlert() {
			Alert alert = driver.switchTo().alert();				 
	        String alertMsg1= driver.switchTo().alert().getText();		      		
	        System.out.println("OK clicked for logout alert\n" +alertMsg1);	      		
	        alert.accept();
		}
}


		
		
		
		
		
		
		
		


