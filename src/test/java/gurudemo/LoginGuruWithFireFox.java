package gurudemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxProfile;

import Util.constants;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginGuruWithFireFox {
	static WebDriver driver;

public static void main(String[] args) {
	    //ProfilesIni profile = new ProfilesIni();
	    //FirefoxProfile myprofile = profile.getProfile("geetaProfile");
	FirefoxOptions firefoxOptions = new FirefoxOptions();
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver(firefoxOptions);
	    WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver(myprofile);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(constants.baseURI);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text' ]")).sendKeys(constants.userName);
		driver.findElement(By.xpath("//input[@type='password' ]")).sendKeys(constants.password);
		driver.findElement(By.xpath("//input[@type='submit' ]")).click();
		
		String actualTitle = driver.getTitle();
		if (actualTitle.contains(constants.EXPECT_TITLE)) {
		    System.out.println("Test case: Passed");
} 
else {
		    System.out.println("Test case : Failed");
}
		
		System.out.println("Page title is : " + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
		
}

}
