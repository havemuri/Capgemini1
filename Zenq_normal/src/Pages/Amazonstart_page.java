package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazonstart_page 
{
	WebDriver driver;
	public Amazonstart_page(WebDriver driver)
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//span[text()='Hello. Sign in']")WebElement sign_in_click;
	@FindBy(how=How.XPATH,using="//span[text()='Your Orders']/span")WebElement order_click;
	@FindBy(how=How.XPATH,using="//span[text()='Your Account']")WebElement click_Your_Account;
	@FindBy(how=How.XPATH,using="//input[@value='Go']")WebElement Go;
	@FindBy(how=How.ID,using="twotabsearchtextbox")WebElement searchbox;
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Apple iPhone")List<WebElement> results;
	@FindBy(how=How.XPATH,using="//span[text()='Category']")WebElement Category;
	@FindBy(how=How.XPATH,using="//span[text()='Echo & Alexa']")WebElement ItemName;
	@FindBy(how=How.XPATH,using="//span[text()='All-new Echo Plus']")WebElement Product;
	@FindBy(how=How.TAG_NAME,using="body")WebElement result;
	@FindBy(how=How.XPATH,using="//span[text()='Lists']")WebElement Yourlists;
	@FindBy(how=How.XPATH,using="(//span[contains(text(),'https://www.amazon.in/')])[1]")WebElement drop_link;
	@FindBy(how=How.XPATH,using="//input[@type='submit']")WebElement Submit;
	@FindBy(how=How.XPATH,using="//*[@id=\"anonCarousel1\"]/ol/li[1]/div/a")WebElement dragfrom;
	@FindBy(how=How.ID,using="wfaTextInput")WebElement dropto;
	@FindBy(how=How.LINK_TEXT,using="+Add Idea to List")WebElement Addlist;
	@FindBy(how=How.XPATH,using="//span[text()='Add to list']")WebElement ClickAddList;
	
	
	
	
	
	
	public void sign_in_click() throws InterruptedException
	{
	  this.sign_in_click.click(); 
	}
	public void order_click() 
	
	{
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(order_click));
		
		Actions act=new Actions(driver);
		act.moveToElement(this.order_click).build().perform();
		click_Your_Account.click();
		
	}
	public void searchbox(String search) throws InterruptedException
	{
		this.searchbox.sendKeys(search);
		Thread.sleep(2000);
		this.Go.click();
		Thread.sleep(4000);
 System.out.println("Search results size is" + " " +results.size());

	}
	public String Category() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(this.Category).build().perform();
		act.moveToElement(this.ItemName).build().perform();
		Thread.sleep(3000);
		this.Product.click();
		String item_name=this.ItemName.getText();
		String result=this.result.getText();
		if(result.contains(item_name))
		{
			System.out.println("requested item "+item_name+ " "+ "is displayed");
		}
		return item_name;
	}
	
	public void Drag_Drop() throws InterruptedException
	{
		Yourlists.click();
		Thread.sleep(3000);
		Addlist.click();
		Thread.sleep(4000);
		
		Actions act=new Actions(driver);
		act.dragAndDrop(dragfrom, dropto).build().perform();
		ClickAddList.click();
		
		String draglink=dragfrom.getAttribute("href");
		String droplink=drop_link.getText();
		if(draglink.equals(droplink))
		{
			System.out.println("Draged link and drop link are matching");
		}
		else
		{
			System.out.println("Not matching");
		}
		
	}

}
