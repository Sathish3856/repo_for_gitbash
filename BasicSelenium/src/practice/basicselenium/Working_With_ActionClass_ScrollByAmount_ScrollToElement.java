package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_ActionClass_ScrollByAmount_ScrollToElement {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
//		action.scrollByAmount(0, 300).perform();
		WebElement fb = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
		action.scrollToElement(fb).build().perform();
		Thread.sleep(3000);
		driver.quit();
	}

}
