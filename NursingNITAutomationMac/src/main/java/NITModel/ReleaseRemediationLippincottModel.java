/**
 * 
 */
package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import DataProvider.ReadConfig;
import Factory.DataProviderFactory;
import Utility.Library;
import Utility.WaitTool;

/**
 * @author Keerthi Anand
 *
 */
public class ReleaseRemediationLippincottModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();
	
		public ReleaseRemediationLippincottModel(WebDriver driver){
			this.driver= driver;
			}
		
		public void clickReleaseButton(){
			WebElement clickReleaseButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink6']/img"));
			Library.highLightElement(driver, clickReleaseButton).click();			
		}
		
		public void clickReleaseRemediationsCheckbox(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkContent']"), 350);
			WebElement clickReleaseQuestionsCheckbox = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkContent']"));
			Library.highLightElement(driver, clickReleaseQuestionsCheckbox).click();			
		}
		
		public void clickReleaseLippincottCheckbox(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkLippincot']"), 350);
			WebElement clickReleaseLippincottCheckbox = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkLippincot']"));
			Library.highLightElement(driver, clickReleaseLippincottCheckbox).click();			
		}
		
		public void clickReleaseContinueButton(){
			WebElement clickReleaseContinueButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnContinue']"));
			Library.highLightElement(driver, clickReleaseContinueButton).click();			
		}	
		
		public void clickRemlippCheckbox(String remlipptitle){
				WaitTool.waitForElementDisplay(driver, By.xpath("//*[text()='"+remlipptitle+"']/../td/*[1]"), 350);
				WebElement clickRemediationCheckbox = driver.findElement(By.xpath("//*[text()='"+remlipptitle+"']/../td/*[1]"));
				Library.highLightElement(driver, clickRemediationCheckbox).click();
		}
		
		public void clickReleaseSaveandContinueButton(){
			WebElement clickReleaseSaveandContinueButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnRelease']"));
			Library.highLightElement(driver, clickReleaseSaveandContinueButton).click();			
		}
		
		public void clickReleaseSaveandContinueButton1(){
			WebElement clickReleaseSaveandContinueButton1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr/td[1]/input[2]"));
			Library.highLightElement(driver, clickReleaseSaveandContinueButton1).click();			
		}
		
		public void clickReleasetoProductionButton(){
			WebElement clickReleasetoProductionButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnReleaseToProd']"));
			Library.highLightElement(driver, clickReleasetoProductionButton).click();			
		}
		
		public String checkSuccessMessage(){
			WebElement checkSuccessMesssage = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblConfirmReleaseToProd']/b"));
			String successMessage=Library.highLightElement(driver, checkSuccessMesssage).getText();
			return successMessage;
		}
		
		public void clickMainMenu(){
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
		}
		
		
		
		public void clickLogout(){
			WebElement clickLogOut = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"));
			Library.highLightElement(driver, clickLogOut).click();
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
