package feedback;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_feedback_19 {
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
 @Test(description="User can able to write reviews")
  
void write_Review()  {

cDriver.get("https://www.amazon.in/");
cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Books");
cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
cDriver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")).click();
Set<String> ids = cDriver.getWindowHandles();
Iterator<String> it = ids.iterator();
String parentId = it.next();
String childId = it.next();
cDriver.switchTo().window(childId);
cDriver.findElement(By.xpath("//div[@id='averageCustomerReviews']//span[@id='acrCustomerReviewText']")).click();
cDriver.findElement(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[2]/a/div")).click();
cDriver.findElement(By.id("a-autoid-0-announce")).click();
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
emailidElement1.sendKeys("suryarajan361@gmail.com");		
//cDriver.findElement(By.xpath("//input[@id='continue']")).click();
WebElement passwordElement2= cDriver.findElement(By.xpath("//input[@id='ap_password']"));
passwordElement2.sendKeys("Feb151998@");	
cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
WebElement feedbackElement=cDriver.findElement(By.xpath("//*[@id=\"react-app\"]/div/div/div/div/div/div/span"));
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
//System.out.println("2");
String f=feedbackElement.getText();
//System.out.println("3");
cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
System.out.println("Test case failed");
System.out.println(f);

 }
 @AfterTest
 void tearDown()
 {
 	cDriver.close();
 	cDriver.quit();
 }
 }
