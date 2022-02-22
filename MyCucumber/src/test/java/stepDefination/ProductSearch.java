package stepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.LoadConfigurtion;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductSearch extends LoadConfigurtion {

	Scenario scenario;

	@Given("Open URL")
	public void open_url() {

		new HomePage(driver).openURL();

	}

	@Then("Search Product")
	public void search_product() {
		new HomePage(driver).searchProduct();
	}

	@After
	public void attachScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed Screenshot");

		}
	}
}
