/**
 * 
 */
package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataProvider.ReadConfig;
import Utility.Library;

/**
 * @author SMuppidi
 *
 */
public class LoginPageModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();	
		public LoginPageModel(WebDriver driver){
			this.driver= driver;
			}
		
		public void setNITStudentUserName(String uName){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtUserName']"));
			Library.highLightElement(driver, setName).sendKeys(uName);
		}
			
		public void setNITStudentPwd(String pwd){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtPassword']"));
			Library.highLightElement(driver, setName).sendKeys(pwd);
		}
		
		public void clickStudentLogin(){
			WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='BtnLogIn']"));
			Library.highLightElement(driver, clickLogIn);
			clickLogIn.click();
			}
		
		public String getstudenthomepageurl(){
			String studentgethomepageurl;
			studentgethomepageurl = driver.getCurrentUrl();
		return studentgethomepageurl;

		}
		
		public String getadminhomepageurl(){
			String admingethomepageurl;
			admingethomepageurl = driver.getCurrentUrl();
		return admingethomepageurl;

		}
		
		public void clickStudentSignout(){
			try{
				WebElement clicklogout = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/div[1]/a[4]"));
				Library.highLightElement(driver, clicklogout).click();
			}
			catch (Exception e){
				System.out.println("Manage Account link is not displayed");
			}
			
			try{
				WebElement clicklogout = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/div[1]/a[3]"));
				Library.highLightElement(driver, clicklogout).click();
				}
				catch (Exception e){
					System.out.println("Manage Account link is displayed");
				}		
		}
		
		public void setNITAdminUserName(String uName){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtUserName']"));
			Library.highLightElement(driver, setName).sendKeys(uName);
		}
			
		public void setNITAdminPwd(String pwd){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtPassword']"));
			Library.highLightElement(driver, setName).sendKeys(pwd);
		}
		
		public void clickAdminLogin(){
			WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='BtnLogIn']"));
			Library.highLightElement(driver, clickLogIn).click();
			}
		
		public void clickAdminSignout(){
			WebElement clicklogout = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"));
			Library.highLightElement(driver, clicklogout).click();
		}
			
	//**********************************************************
		
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
	}
