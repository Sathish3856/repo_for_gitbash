package com.basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Working_With_Synchronization {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("computer");
		driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
//		Webdriver wait is nothing but the Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		WebElement searchPage = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		wait.until(ExpectedConditions.visibilityOf(searchPage));
		driver.quit();
		
		
		
		
	}

}
