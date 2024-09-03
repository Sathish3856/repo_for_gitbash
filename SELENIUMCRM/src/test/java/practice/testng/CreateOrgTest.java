package practice.testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgTest
{
	@Test
	public void createOrgTest(XmlTest test) throws EncryptedDocumentException, IOException
	{
	
		//Read the common data from xmlfile
		String browser =test.getParameter("browser");
		String url = test.getParameter("url");
		String username = test.getParameter("username");
		String password = test.getParameter("password");
		
		//Read testscript data from the excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\sathi\\WorkSpace-Tekpyramid\\Excel\\exceldata1.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		String orgName = row.getCell(2).toString()+randomNum;
		wb.close();
		
		
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		//step1:login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Step2:navigate to navigation module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3:click on create organization button
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization...')]")).click();
		
		//step4:create organization and enter all the details from the excel
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
		//step5:logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[(@src='themes/softed/images/user.PNG')]"))).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		
		driver.quit();
		
		
		
		
	}


	}



