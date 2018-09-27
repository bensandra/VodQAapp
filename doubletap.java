package vodqaappmodule;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class doubletap {

	public static void main(String[] args) throws IOException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		//For Higher version
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
		try
		{
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap']")));
			driver.findElement(By.xpath("//*[@text='Double Tap']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap Me']")));
			WebElement e=driver.findElement(By.xpath("//*[@text='Double Tap Me']"));
			//Double Tap
			TouchAction ta1=new TouchAction(driver);
			ta1.tap(e);
			TouchAction ta2=new TouchAction(driver);
			ta2.waitAction(Duration.ofMillis(100)).tap(e);
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(ta1).add(ta2).perform();
			try
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Double tap successfully']")));
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
				System.out.println(ex.getMessage());
			}				
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		}}
