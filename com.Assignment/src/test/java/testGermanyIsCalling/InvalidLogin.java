package testGermanyIsCalling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvalidLogin {

	public String url = "https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F";
	WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

	}

	@Test()
	public void invalidCredentials() {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("zaffar4534@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Zaffar@12345");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		Assert.assertEquals(driver.getTitle(), "Login | Germany Is Calling");
		
		
		
	}
	@Test(enabled=false)
	public void invalidLoginWithBlankCredentials() {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Zaffar@12345");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		Assert.assertEquals(driver.getTitle(), "Login | Germany Is Calling");
	}

	@AfterClass
	public void wrapUpTest() throws InterruptedException {

		driver.quit();

	}

}
