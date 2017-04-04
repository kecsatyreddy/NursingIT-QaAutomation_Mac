package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {
	public static void captureScreenshot(WebDriver ldriver)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			}
		
	}
	public static void captureScreenshotwithTC(WebDriver ldriver, String tc_name)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path="./Screenshots/"+tc_name+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			//return e.getMessage();
		}
		}
	public static String captureScreenshotwithpath(WebDriver ldriver)
	{
		
			TakesScreenshot ts=(TakesScreenshot)ldriver;
			File screen_src=ts.getScreenshotAs(OutputType.FILE);
			String path= UIData.startupPath+"\\ScreenShots\\nursing"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try
			{
			FileUtils.copyFile(screen_src,destination);
			System.out.println("Screenshot Taken");
			//return dest;
		}
		catch (Exception e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
			//return e.getMessage();
		}
			return path;
	}
	public static WebElement highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; boarder:2px solid red;');",element);
		
		try{
			Thread.sleep(500);
		}catch (InterruptedException e){
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style', 'boarder: solid 2px white');", element);
		return element;
	}
		
	public static String getDay(String mydate)
	{
		   Date mydate1;
		try {
			SimpleDateFormat format = new SimpleDateFormat();
			   mydate1 = new Date(mydate);
			   return new SimpleDateFormat("EE").format(mydate1);
		} catch (Exception e) {
			System.out.println("Exception while coverting to day"+e.getMessage());
			return e.getMessage();
		}
	}
	/**
	 * This method is to select a particular value from drop down.
	 * 
	 * @param driver
	 * @param dropDownLocator
	 * @param optionLocator
	 * @param optionSelect
	 */
	public static void selectValueFromDropDown(WebDriver driver,
			By dropDownLocator, By optionLocator, String optionSelect) {
		List<WebElement> elements = driver.findElement(dropDownLocator)
				.findElements(optionLocator);
		for (WebElement option : elements) {
			if (optionSelect.equalsIgnoreCase(option.getText())) {
				option.click();
				break;
			}
		}
	}
	
	public static void scroll(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy("+ x + "," + y + ")");
	}
}
