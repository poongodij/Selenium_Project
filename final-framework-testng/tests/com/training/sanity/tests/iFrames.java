package com.training.sanity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\Desktop\\New folder\\Selenium Jar Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/");
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
		driver.findElement(By.xpath("//table[@class='nested']/tbody/tr[3]/td/input")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("poongodi");
		driver.findElement(By.id("memberUsername")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"newButton\"]")).click();
		int size = driver.findElements(By.tagName("iframe")).size();
	    for(int i=0; i<=size; i++){
		WebDriver driver1 = null;
		driver1.switchTo().frame(i);
		int total=driver1.findElements(By.xpath("//iframe[contains(@title,'Rich text editor')]")).size();
		System.out.println(total);
	    driver1.switchTo().defaultContent();
	    }
	    
}



	}


