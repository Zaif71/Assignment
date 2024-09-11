package testGermanyIsCalling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
	public String url="https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F";
	WebDriver driver;
	
@Test(enabled=false)
public void SignUp(){
     driver.findElement(By.xpath("//a[contains(text(),'New to Germany Is Calling')]")).click();
     driver.findElement(By.id("first_name")).sendKeys("Zaffar");
     driver.findElement(By.id("username")).sendKeys("zaffar4534@gmail.com");
     driver.findElement(By.id("password")).sendKeys("Zaffar@123");
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     Reporter.log("SignUp Succesfull",true);
     
}

    @Test(priority=1)     
       public void LoginWithValidCredentials() {
    	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("zaffar4534@gmail.com");
         driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Zaffar@123");
         driver.findElement(By.xpath("//button[text()='Log In']")).click();
         Assert.assertEquals(driver.getTitle(), "Upload your CV | Germany Is Calling");
         Reporter.log("Login Succesfull",true);
      
    }
	
	@BeforeClass
	public void setup() {
		
		 driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     driver.get(url);
		
		
	}
	@AfterClass
	public void wrapUpTest() throws InterruptedException {
		
		
		
		driver.quit();
		
	}

}
