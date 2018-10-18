package utility;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.Amazonstart_page;
import utility.ExcelUtility;



public class Commonclass 
{
	public static WebDriver driver;
	public static  String path="D:\\Users\\hvemuri\\Documents\\zenq.xlsx";
  @BeforeSuite
  public void Intialize() throws Exception 
  {
	  
	  ExcelUtility.setExcelFile(path, "TestData");
	  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get(ExcelUtility.getCellData(1, 0));
	  driver.manage().window().maximize(); 
  }
	/*@AfterSuite
	 public void Quit() 
	  {
		  driver.quit();
	  }*/


}
