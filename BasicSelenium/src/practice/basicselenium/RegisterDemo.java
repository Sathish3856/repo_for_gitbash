package com.basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterDemo 
{

	public static void main(String [] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("first");
		driver.findElement(By.id("LastName")).sendKeys("last");
		driver.findElement(By.name("Email")).sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("Password")).sendKeys("Secret@123");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("Secret@123");
		driver.findElement(By.id("register-button")).click();
		driver.close();
		
		
		}
}
