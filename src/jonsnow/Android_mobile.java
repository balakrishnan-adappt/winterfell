package jonsnow;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;





public class Android_mobile {
	protected AndroidDriver<AndroidElement> driver;
	@Test
	public void main() throws MalformedURLException {
		
		File app=new File("C:\\Users\\Bala\\Downloads\\WMR_android1.3_1stmarch_original.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("platformVersion", "6.0.1");
//		cap.setCapability("udid", "459ea85e7d53");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		cap.setCapability("appPackage", "uk.co.adappt.adapptlabs.who.malaria");
		cap.setCapability("appActivity", "uk.co.adappt.adapptlabs.who.malaria.MainActivity");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("app has been launched");
	}

}
