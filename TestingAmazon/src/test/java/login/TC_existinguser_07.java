package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_existinguser_07 {
	WebDriver cDriver;
	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		cDriver=new ChromeDriver();
	}
	
	@DataProvider
    public static Object[][] loginWrongCredential() {
        Object[][] credentials = new Object[4][2];
        //valid mail invalid pass
        credentials[0][0] = "suryarajan361@gmail.com"; 
        credentials[0][1] = "testss122";
        //inv mail val pass
        credentials[1][0] = "ramya@qe";
        credentials[1][1] = "abcdef";
        //inv mail pass
        credentials[2][0] = "emptypass@12"; 
        credentials[2][1] = "wrff";
        //val email and pass
        credentials[3][0] = "suryarajan361@gmail.com";
        credentials[3][1] = "Feb151998@";
        return credentials;
    }
	@Test(dataProvider = "loginWrongCredential")
	void login(String username,String pass) {

		 cDriver.get("https://www.amazon.in/");
		 cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
		 WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
		 emailidElement1.sendKeys(username);		
		 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
		 WebElement passwordElement2= cDriver.findElement(By.id("ap_password"));
         passwordElement2.sendKeys(pass);
		 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	 		

}
@AfterTest
void tearDown()
{
	cDriver.close();
	cDriver.quit();
}
}

