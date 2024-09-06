import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launching_the_browser {
	WebDriver driver;

	@BeforeTest
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.chase.com/");
	}

	@Test
	public void title_test() {
		String expected = "Credit Card, Mortgage, Banking, Auto | Chase Online | Chase.com";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("Page title is : " + driver.getTitle());

	}

	@AfterTest
	public void tearUp() {
		driver.quit();

	}

}
