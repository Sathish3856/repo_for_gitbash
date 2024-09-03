package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCssSelector {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(" input[ id='small-searchterms']")).sendKeys("bag");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".search-box-text.ui-autocomplete-input")).click();		
	}

}
