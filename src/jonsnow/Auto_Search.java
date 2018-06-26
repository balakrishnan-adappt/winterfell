package jonsnow;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class Auto_Search {

	@Test
	public  void main() throws InterruptedException, IOException {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bala\\Downloads\\geckodriver.exe");
		   driver = new FirefoxDriver();
	        driver.get("http://www.google.co.in");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.findElement(By.name("q")).sendKeys("java");
	        
	        WebElement table= driver.findElement(By.className("sbsb_b"));
	        List<WebElement> list = table.findElements(By.tagName("li"));
	 
	        for (WebElement options : list) {
	            Thread.sleep(1000);
	            System.out.println(options.getText());
	            if (options.getText().trim().contains("java tutorial")) {
	                Thread.sleep(1000);
	                options.click();
	            }
	        }
	        
	    }	
	}


