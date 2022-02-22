package Rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Rough {

	public AndroidDriver driver;
	public DesiredCapabilities cp = new DesiredCapabilities();

	@Test
	public void TestYoutube() {

		cp.setCapability("deviceName", "RF8NA2HAZST");
		cp.setCapability("platformName", "Android");
		cp.setCapability("unicodeKeyboard", false);
		cp.setCapability("resetKeyboard", false);
		cp.setCapability("appPackage", "com.google.android.youtube");
		cp.setCapability("appActivity", "com.google.android.youtube.app.honeycomb.Shell$HomeActivity");
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cp);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc ='Search']")).click();
		
		driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Salman Khan");
		//driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).sendKeys("Salman Khan");
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);

	}

}
