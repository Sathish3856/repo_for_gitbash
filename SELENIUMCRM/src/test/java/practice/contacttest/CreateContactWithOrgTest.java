package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathi\\WorkSpace-Tekpyramid\\Property files\\commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		//Read the common data from property file
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		
		//Read testscript data from the excel file
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\sathi\\WorkSpace-Tekpyramid\\Excel\\exceldata1.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet2");
		Row row = sh.getRow(1);
		Row row1 = sh.getRow(4);

		
		String orgName = row.getCell(2).toString()+randomNum;
		String contactName = row1.getCell(2).toString()+randomNum;
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
		
		//Verify header msg expected result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName+"is created==pass");
		}
		else
		{
			System.out.println(orgName+"is not created==fail");
		}
		

		//Step5:navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='account_name']/follng-sibling::img")).click();
		//switch to child window
		Set<String>set= driver.getWindowHandles();
		Iterator<String>it=set.iterator();
		while(it.hasNext())
		{
			String windowId = it.next();
			driver.switchTo().window(windowId);
			 String actUrl = driver.getCurrentUrl();
			 if(actUrl.contains("module=Accounts"))
			 {
				 break;
			 }
			
		}
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		Set<String>set1= driver.getWindowHandles();
		Iterator<String>it1=set.iterator();
		while(it1.hasNext())
		{
			String windowIds = it1.next();
			driver.switchTo().window(windowIds);
			 String actUrl = driver.getCurrentUrl();
			 if(actUrl.contains("module=Contacts"))
			 {
				 break;
			 }
			
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualContact = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actualContact.trim().equals(contactName))
		{
			System.err.println("Integration test case is pass");
		}
		else
		{
			System.out.println("Integration test case is fail");
		}

		//step6:logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[(@src='themes/softed/images/user.PNG')]"))).perform();
		
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.quit();
	}

}
