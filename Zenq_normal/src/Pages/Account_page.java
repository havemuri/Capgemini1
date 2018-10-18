package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Account_page 
{
	WebDriver driver;
	public Account_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.LINK_TEXT,using="Photo ID proofs")WebElement Click_PhotoID;
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Add Photo ID Proof")WebElement Click_Addphoto;
	@FindBy(how=How.XPATH,using="//select[@data-a-touch-header='Select ID Type']")WebElement SelectID_Dropdown;
	@FindBy(how=How.XPATH,using="//input[@type='file']")List <WebElement> Frontside_photo;
	@FindBy(how=How.ID,using="holder-name")WebElement IDHolder_Name;
	@FindBy(how=How.XPATH,using="(//input[@type='submit'])[2]")WebElement Save;



	public void Click_PhotoID()
	{
		this.Click_PhotoID.click();
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(Click_Addphoto));
	}

	public void Click_Addphoto()
	{
		this.Click_Addphoto.click();
	}

	public void SelectID_Dropdown(String ID_type,String name)
	{
		Select dropsown=new Select(this.SelectID_Dropdown);
		dropsown.selectByVisibleText(ID_type);
		this.IDHolder_Name.sendKeys(name);
	}

	public void Frontside_photo(String upload_path) throws InterruptedException

	{
		for(int i=0;i<Frontside_photo.size();i++)
		{
			this.Frontside_photo.get(i).sendKeys(upload_path);
			Thread.sleep(3000);
		}

	}
	public void Save() throws InterruptedException
	{
		Thread.sleep(6000);
		this.Save.click();
		//driver.findElement(By.id("kyc-save-button-announce")).click();
	}

}
