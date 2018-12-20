package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
		public boolean subLinkDisp1(boolean profileLink) {
			if(driver.findElement(By.xpath("//li[@id='submenu1.0']")).isDisplayed() )                                                                                                         
		{         
			  return true;     
			}    
			else    
			{     
			  return false;   
			}
		
		}
		public boolean subLinkDisp2(boolean changePwd) {
		if(driver.findElement(By.xpath("//li[@id='submenu1.1']")).isDisplayed() )                                                                                                         
		{         
			  return true;     
			}    
			else    
			{     
			  return false;   
			}
		
		}
		public boolean subLinkDisp3(boolean emailNotification) {
			if(driver.findElement(By.xpath("//li[@id='submenu1.2']")).isDisplayed() )                                                                                                         
			{         
				  return true;     
				}    
				else    
				{     
				  return false;   
				}
			
			}
		}
		
		public void changePwd() {
			this.chngPwd.click(); 
		}
			
		public void currPassword(String currPwd) {
			this.currPwd.clear(); 
			this.currPwd.sendKeys(1234); 
		}
		public void NewPassword(String newPwd) {
			this.newPwd.clear(); 
			this.newPwd.sendKeys(123456); 
		}
		public void confirmNewPassword(String confirmNewPassword) {
			this.confirmNewPassword.clear(); 
			this.confirmNewPassword.sendKeys(654321); 
		}
		
		public void clickSubmitBtn() {
			this.SubmitBtn.click(); 
		}
		
		
		
		
		
		
		
		

}
