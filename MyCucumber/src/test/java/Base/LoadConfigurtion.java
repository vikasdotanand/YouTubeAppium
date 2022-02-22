package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadConfigurtion {
	public static WebDriver driver=null;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public Scenario scenario;
	public LoadConfigurtion() {
		configBrowser();
	}
	public void configBrowser() {
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\Properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver==null)
		{
			
			if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			
			
			
		}
		
	}
	
	

}
