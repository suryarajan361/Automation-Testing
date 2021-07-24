package Searching;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;





public class TC_search_12 {
    WebDriver cDriver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browserName) throws Exception
    {
        if (browserName.equalsIgnoreCase("Chrome")) 
        {
             WebDriverManager.chromedriver().setup();
	         cDriver= new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Edge"))
        {
          WebDriverManager.edgedriver().setup();
	      cDriver= new EdgeDriver();
        }
     
     }
           @Test
         void checkSearch_product() throws InterruptedException {
		 cDriver.get("https://www.amazon.in/");
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("ladies watches");
		 cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		 System.out.println("Searched Item Succesfully");
    }

	
	 }