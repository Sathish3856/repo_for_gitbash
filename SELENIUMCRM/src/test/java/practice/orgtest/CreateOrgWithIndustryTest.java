package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryTest {

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
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString()+randomNum;
		String industry= row.getCell(3).toString();
		String type=row.getCell(4).toString();
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
		
		//select the industry dropdown
		WebElement dd=driver.findElement(By.name("industry"));
		Select select = new Select(dd);
		select.selectByVisibleText(industry);
		
		//select the type dropdown
		WebElement dd2 = driver.findElement(By.name("accounttype"));
		Select select1 = new Select(dd2);
		select1.selectByVisibleText(type);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


		//verify the industry and type info
		String verifyIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(verifyIndustry.equals(industry))
		{
			System.out.println(industry+" is displayed as expected ");
		}
		else
		{
			System.out.println("The industry is not displayed as expected");
		}
		 String verifyType = driver.findElement(By.id("dtlview_Type")).getText();
		 if(verifyType.equals(type))
		 {
			 System.out.println(type+" is displayed as expected");
		 }
		 else
		 {
			 System.out.println("Type dropdown is not selected as expected");
		 }
		
		
		//step5:logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[(@src='themes/softed/images/user.PNG')]"))).perform();
		
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.quit();
		
	}

}
