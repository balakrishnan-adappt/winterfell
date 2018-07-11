package jonsnow;

import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bulkmail_import {
	
	WebDriver driver;
	
	@Test
	public void bulk_upload() throws InterruptedException {
		String searchText="Clients";
		WebElement dropdown=driver.findElement(By.xpath("//a[contains(text(),'System Administration')]"));
		dropdown.click();
		List<WebElement> options=driver.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(searchText))
		    {
		        option.click();
		        break;
		    }
		}
		System.out.println("client has been selected");
		Thread.sleep(3000);
		List<WebElement> edit=driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-pencil']"));
		edit.get(0).click();
		System.out.println("edit button is clicked");
		Thread.sleep(3000);
		Random rad = new Random();
		for(int i=0;i<=5;i++) {
			List<WebElement> adduser=driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-plus-sign']"));
			adduser.get(0).click();
			Thread.sleep(3000);
			System.out.println("adduser button is clicked");
			String parentWindowHandler = driver.getWindowHandle(); 
			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles(); 
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); 
			WebElement username=driver.findElement(By.xpath("//input[@id='name']"));
			username.sendKeys(RandomStringUtils.randomAlphabetic(8));
			WebElement email=driver.findElement(By.xpath("//input[@id='emailAddress']"));
			email.sendKeys("usename"+rad.nextInt(100)+"@yopmail.com");
			Thread.sleep(2000);
			WebElement ok_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			ok_button.click();
			Thread.sleep(2000);
			driver.switchTo().window(parentWindowHandler); 
		}
		
		WebElement save_button=driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		save_button.click();
		Thread.sleep(3000);
		System.out.println("Users created");
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://pubtools-dev.curationcorp.com/#/login");
		Thread.sleep(3000);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Dimension screenResolution = new Dimension((int) 
    	                    toolkit.getScreenSize().getWidth(), (int) 
    	                    toolkit.getScreenSize().getHeight());
    	driver.manage().window().setSize(screenResolution);
    	WebElement emailid=driver.findElement(By.id("username"));
		emailid.sendKeys("nandini.d@adappt.co.uk");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Nandini88!!");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		System.out.println(""+driver.getTitle());
		System.out.println("logged in successfully");
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
