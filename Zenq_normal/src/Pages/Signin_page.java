package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Signin_page 
{
	WebDriver driver;
	public Signin_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@type='email']")WebElement Username;
	@FindBy(how=How.ID,using="continue")WebElement Continue;
	@FindBy(how=How.XPATH,using="//input[@type='password']")WebElement Password;
	@FindBy(how=How.ID,using="signInSubmit")WebElement Login;
	
	
	public void Username(String Username)
	{
		this.Username.sendKeys(Username);
	}
	public void Password(String Password)
	{
		this.Password.sendKeys(Password);
	}
	public void Continue()
	{
		this.Continue.click();
	}
	public void Login()
	{
		this.Login.click();
	}
}
