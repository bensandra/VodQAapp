package vodqaappmodule;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class draganddrop {

	public static void main(String[] args) throws IOException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		//For higher version
		dc.setCapability("deviceName","47db12770104");
		dc.setCapability("platformName","android");
		dc.setCapability("platformversion","7.0");
		// For lower version
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
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Drag & Drop']")).click();
			Thread.sleep(5000);
			WebElement e1=driver.findElement(By.xpath("//*[@text='Drag me!']"));
			WebElement e2=driver.findElement(By.xpath("//*[@text='Drop here.']"));
			TouchAction ta=new TouchAction(driver);
			Duration d=Duration.of(10,ChronoUnit.SECONDS);
			ta.press(e1).waitAction(d).moveTo(e2).release().perform();
			
				if(driver.findElement(By.xpath("//*[@text='Circle dropped']")).isDisplayed())
				{
					System.out.println("operation was finished");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}				
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		}}
