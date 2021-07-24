package registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_newuser_04 {

	WebDriver cDriver;
	
        @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
        
        @Test(description="User cannot register without providing values")
	 void validate_Newuser() throws InterruptedException
	 {
		    cDriver.get("https://www.amazon.in/");
			
			cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
			cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

			cDriver.findElement(By.id("createAccountSubmit")).click();
		    WebElement nameElement=cDriver.findElement(By.id("ap_customer_name"));
			nameElement.sendKeys("Surya");
			WebElement emailidElement=cDriver.findElement(By.id("ap_email"));
			emailidElement.sendKeys("suryarajangmail.com");
		    WebElement feedbackElement=cDriver.findElement(By.xpath("//*[@id=\"auth-email-invalid-email-alert\"]/div/div"));
			String f=feedbackElement.getText();
			System.out.println(f);
		    WebElement phoneElement=cDriver.findElement(By.xpath("//input[@id='ap_phone_number']"));
			phoneElement.sendKeys("8766665556");	
			WebElement passwordElement= cDriver.findElement(By.xpath("//input[@id='ap_password']"));
			passwordElement.sendKeys("feb151998");	    
			cDriver.findElement(By.id("continue")).click();
			cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
			System.out.println("Test Case Passed");
			System.out.println("Cannot register without values.");
	 }
	
	 
	 /* @AfterMethod
		 void tearDown()
		 {
		cDriver.close();
	}*/
	}

