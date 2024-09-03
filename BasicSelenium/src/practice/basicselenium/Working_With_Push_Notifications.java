package com.basic_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Working_With_Push_Notifications {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		Actions actions = new Actions(driver);
		
		
		

	}

}
