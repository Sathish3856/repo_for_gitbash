package com.basic_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithFindElements {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		List<WebElement>radio_button = driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement elements:radio_button)
		{
			elements.click();
			System.out.println(elements.isSelected());
		}
		
	}

}
