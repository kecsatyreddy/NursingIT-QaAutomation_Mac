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
import Factory.DataProviderFactory;
import Utility.Library;
import Utility.WaitTool;

/**
 * @author Keerthi Anand
 *
 */
public class RemediationLippincottModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();
	
		public RemediationLippincottModel(WebDriver driver){
			this.driver= driver;
		}
		
		public void clickViewEditCMS(){
			WebElement clickViewEditCMS = driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink1']"));
			Library.highLightElement(driver, clickViewEditCMS).click();
		}	
		
		public void clickAddRemediation(){
			WebElement clickAddRemediation = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ucSearchQuestionCriteria_btnAddRemediation']"));
			Library.highLightElement(driver, clickAddRemediation).click();
		}	
		
		public void enterRemediationTitle(String title){
			WaitTool.waitForElementDisplay(driver, By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtTitle']"), 350);
			WebElement enterRemediationTitle = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtTitle']"));
			Library.highLightElement(driver, enterRemediationTitle).sendKeys(title);
		}
		
		public void enterRemediationDesc(String title){
			String title1= title + " is a testing remediation added through automation testing";
			WebElement enterRemediationDesc = driver.findElement(By.xpath("//textarea[@id='ctl00_ContentPlaceHolder1_txtRem']"));
			Library.highLightElement(driver, enterRemediationDesc).sendKeys(title1);
		}
		
		public void clickSaveRemediation(String title){			
			WebElement clickRemediationSave = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickRemediationSave).click();	
			DataProviderFactory.getExcelConfig().setExcelData("CMSQuestionsCategories", 5, 16, title);
		}
		
		public void printRemediation(){			
			System.out.println(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", 5, 16));
		}
		
		public void clickCMSMainMenu(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickCMSMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickCMSMainMenu).click();
		}
		
		public void clickAddLippincott(){
			WebElement clickAddLippincott = driver.findElement(By.xpath("//a[contains(@href, 'NewLippincott.aspx')]"));
			Library.highLightElement(driver, clickAddLippincott).click();
		}
		
		public void selectRemediationTitle(String remtitle){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlRemediation']"), 350);
			WebElement selectRemediationTitle = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlRemediation']"));
			Library.highLightElement(driver, selectRemediationTitle).sendKeys(remtitle);
		}
		
		public void enterLippincottTitle1(String lippincotttitle){
			WebElement enterLippincottTitle1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLippincottTitle1']"));
			Library.highLightElement(driver, enterLippincottTitle1).sendKeys(lippincotttitle);
		}
		
		public void enterLippincottDesc1(String lippincotttitle){
			String desc1=lippincotttitle + " is a testing lippincott added through automation testing";
			WebElement enterLippincottDesc1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLippincottExplanation1']"));
			Library.highLightElement(driver, enterLippincottDesc1).sendKeys(desc1);
		}
		
		public void enterLippincottTitle2(){
			WebElement enterLippincottTitle1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLippincottTitle2']"));
			Library.highLightElement(driver, enterLippincottTitle1).sendKeys("Lippincott Title2");
		}
		
		public void enterLippincottDesc2(){			
			WebElement enterLippincottDesc1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLippincottExp2']"));
			Library.highLightElement(driver, enterLippincottDesc1).sendKeys("Lippincott Description2");
		}
		
		public void clickLippincottSave(){
			WebElement clickLippincottSave = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSave']"));
			Library.highLightElement(driver, clickLippincottSave).click();
		}
		
		public String getLippincotttitle(){
			WebElement getLippincotttitle = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/div/table/tbody/tr[2]/td[2]"));
			String lippincotttitle=Library.highLightElement(driver, getLippincotttitle).getText();
			return lippincotttitle;
		}
	}
