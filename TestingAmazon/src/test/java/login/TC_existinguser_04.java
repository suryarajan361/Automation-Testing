package login;

import login.ExcelUtility;

import java.io.IOException;

import javax.xml.stream.Location;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_existinguser_04 {

	WebDriver cDriver;
	@BeforeTest
	void setUp()
	{

		
		WebDriverManager.chromedriver().setup();
		cDriver= new ChromeDriver();
	
	}
	
	
@DataProvider
String[][] LoginDataInputFromExcel() throws IOException
{

	String path = ".\\datafiles\\dataLogin.xlsx";//Location ofLocation Thefile
	ExcelUtility eUtility= new ExcelUtility(path);
			
	int r= eUtility.getRowCount("Sheet5");
	int c= eUtility.getCellCount("Sheet5",r);
	System.out.println("no of rows"+r);
	System.out.println("no of cols"+c);
	
	String userdata[][]  = new String[r][c] ;// declaring array
	

	//addingvalues
	for(int i =1; i<=r;i++)//reading rows  data from excel file
	{ 
		for(int j=0; j<c;j++ )//reading cols data from excel file
		{ 
			
			userdata[i-1][j]=  eUtility.getCellData("Sheet5", i, j);
			System.out.print("["+i+"]["+j+"] value of userdata check = "+userdata[i-1][j]);
			
		}
		System.out.println();
	}
	
	 return userdata;
	
		 
}

@Test(dataProvider ="LoginDataInputFromExcel",description="It will not login")
void invalid_login(String username,String pass){
	

	 cDriver.get("https://www.amazon.in/");
	 cDriver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	 cDriver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);	
	 cDriver.findElement(By.xpath("//input[@id='continue']")).click();
	 cDriver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);	

	 cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	 WebElement feedbackElement=cDriver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div"));
	//System.out.println("2");
	String f=feedbackElement.getText();
	//System.out.println("3");
	System.out.println("Should not login..because of invalid credential");
	System.out.println(f);
	 		

}
@AfterTest
void tearDown()
{
	cDriver.close();
	cDriver.quit();
}
}
