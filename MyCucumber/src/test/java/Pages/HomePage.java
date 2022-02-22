package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.LoadConfigurtion;
import net.bytebuddy.asm.Advice.Enter;

public class HomePage extends LoadConfigurtion {

	// All webelements repository

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement close;

	@FindBy(name = "q")
	WebElement search_prod;

	WebDriver driver;
	WebDriverWait wait;


	//Parameterized Constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Default Constructor
	public HomePage() {

	}
	
	
	// Method Definition Starts From Here
	public void openURL() {
		driver.get(prop.getProperty("testUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);
		// closing login window
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();

	}

	
	public void searchProduct() {

		search_prod.sendKeys("laptop");
		search_prod.submit();

	}

}
