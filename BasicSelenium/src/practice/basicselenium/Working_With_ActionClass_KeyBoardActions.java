package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_With_ActionClass_KeyBoardActions {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"));
		
		Actions action = new Actions(driver);
//		action.moveToElement(search).click().sendKeys("Sathish").perform();
		action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("sathish").keyUp(Keys.SHIFT).perform();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
