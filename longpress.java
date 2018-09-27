package vodqaappmodule;


import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class longpress {

	public static void main(String[] args) throws IOException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		//For higher version
		dc.setCapability("deviceName","47db12770104");
		dc.setCapability("platformName","android");
		dc.setCapability("platformversion","7.0");
		//For lower version
		//dc.setCapability("deviceName","emulator-5554");
		//dc.setCapability("platformName","android");
		//dc.setCapability("platformversion","4.2.2");
		dc.setCapability("appPackage","com.vodqareactnative");
		dc.setCapability("appActivity","com.vodqareactnative.MainActivity");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver driver;
		while(2>1)
		{
			try {
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
			}}
		//automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Long Press']")));
			driver.findElement(By.xpath("//*[@text='Long Press']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Long Press Me']")));
			driver.findElement(By.xpath("//*[@text='Long Press Me']")).click();
			WebElement e=driver.findElement(By.xpath("//*[@class='android.widget.TextView']"));

	            //long press 
	            new TouchAction(driver).longPress(e);
	            Thread.sleep(5000);
	            try
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='you pressed me hard:P']")));
					System.out.println("operation was finished");
				}
				catch(Exception ex)
				{
					System.out.println("operation was not finished");
				}
				driver.closeApp();

	        }
		catch(Exception ex) 
		{
	            System.out.println(ex.toString());
	        }
	}
}
