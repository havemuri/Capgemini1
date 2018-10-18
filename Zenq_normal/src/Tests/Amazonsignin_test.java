package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Account_page;
import Pages.Amazonstart_page;
import Pages.Signin_page;
import utility.ExcelUtility;
import utility.Commonclass;

public class Amazonsignin_test extends Commonclass
{
	
	/*sign in click*/
	@Test(priority=0,description="launching Amazon Url")
	 public void startpagetest() throws Exception
	 {
		Amazonstart_page page0=new Amazonstart_page(driver);
		 ExcelUtility.setExcelFile(path, "TestData");
		 Thread.sleep(3000);
		 page0.sign_in_click();
	 }
	/*Testing the Email Feild warning message*/
	/*Here Using Data Driven(Taking Data from excel*/
	@Test(priority=1,description=" trying to click continue button withput Username, field should show warning message")
	public void Signin_page() throws Exception
	{
		Signin_page page1=new Signin_page(driver);
		page1.Continue();
		String experror ="Enter your email or mobile phone number";
		String actual=driver.findElement(By.xpath("(//div[@class='a-box-inner a-alert-container'])[2]")).getText();
		if(actual.equals(experror))
		{
			System.out.println("Username field is passed");
		}
		Thread.sleep(3000);
		 page1.Username(ExcelUtility.getCellData(1, 1));
		 Thread.sleep(1000);
		 page1.Continue();
		 page1.Password(ExcelUtility.getCellData(1, 2));
		 page1.Login();	 	
	}
	
	/*File UPload Test*/
	@Test(priority=2,description="Test script for files are uploaded successfully")
	public void uploadTest() throws Exception 
	{
		Amazonstart_page page0=new Amazonstart_page(driver);
		Account_page page2=new Account_page(driver);
		
		page0.order_click();
		page2.Click_PhotoID();
		page2.Click_Addphoto();
		page2.SelectID_Dropdown("Voter Identity Card",ExcelUtility.getCellData(1, 2));
		page2.Frontside_photo(ExcelUtility.getCellData(1, 3));
		String status=driver.findElement(By.tagName("body")).getText();
		if(status.contains("Uploaded"))
		{
			System.out.println("File has uploaded successfully");
		}
		page2.Save();
		Thread.sleep(5000);
	}
	
	@Test(priority=3,description="test script for searchbox should display multiple items ",enabled=false)
	public void search() throws InterruptedException 
	{
		Amazonstart_page page0=new Amazonstart_page(driver);
		page0.searchbox("bags");
        System.out.println("system displpayed multiple related items");		
	}
	/*Mouse Over Operations*/
	@Test(priority=4,description="Mouse over operations")
	public void mouseover() throws InterruptedException
	{
		Amazonstart_page page0=new Amazonstart_page(driver);
		page0.Category();	
	}
	
	/*Drag and Drop in amazon*/
	@Test(priority=5,description="Drag and drop")
	public void Drag_Drop() throws InterruptedException
	{
		Amazonstart_page page0=new Amazonstart_page(driver);
		page0.Drag_Drop();
		
	}
	
}
