/**
 * 
 */
package NITController;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Factory.DataProviderFactory;
import NITModel.RemediationLippincottModel;
import Utility.BaseClass;
import Utility.Library;
import Utility.WaitTool;
import NITModel.CreateQuestionsTestsandReleaseModel;

/**
 * @author Keerthi Anand
 *
 */
public class RemediationLippincottController extends BaseClass {
		WebDriver driver;
		
		public CreateQuestionsTestsandReleaseModel NITRemediation;
		public RemediationLippincottModel CMSRemediationandLippincott;
		
		public RemediationLippincottController(WebDriver driver) {
			this.driver = driver;
			CMSRemediationandLippincott= new RemediationLippincottModel(driver);
			NITRemediation= new CreateQuestionsTestsandReleaseModel(driver);
		}
						
		public void addRemediationLippincott(String uname, String pwd, String title, String lippincotttitle) {
			
			//Steps for the CMS admin user to login
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WaitTool.waitForElementDisplay(driver, By.id("BtnLogIn"), 350);
			NITRemediation.setNITCMSUserName(uname);
			test.log(LogStatus.INFO,"CMS Admin User name entered successfully");
			NITRemediation.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO,"CMS Admin Password entered successfully");
			NITRemediation.clickLogin();
			test.log(LogStatus.INFO,"CMS Admin Login button is clicked");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITRemediation.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "CMS Admin User is able to login successfully");	
			
			//Scroll Down The Page
			Library.scroll(driver, 0, 500);
			NITRemediation.waitFor(2);
			
			//CMS admin user navigates to Add Norming page
			CMSRemediationandLippincott.clickViewEditCMS();
			test.log(LogStatus.INFO, "CMS Admin User navigates to View/Edit CMS page");
			NITRemediation.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Scroll Down The Page
			Library.scroll(driver, 0, 500);
			NITRemediation.waitFor(2);
			
			//CMS admin clicks the add remediation button
			CMSRemediationandLippincott.clickAddRemediation();
			NITRemediation.waitFor(4);
			test.log(LogStatus.INFO, "CMS Admin User navigates to Add Remediation page");			
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Add title for the remediation
			CMSRemediationandLippincott.enterRemediationTitle(title);
			test.log(LogStatus.INFO, "CMS Admin adds title for Remediation");
			
			//Add description for the remediation
			CMSRemediationandLippincott.enterRemediationDesc(title);
			test.log(LogStatus.INFO, "CMS Admin adds description for Remediation");
			
			//CMS admin user clicks on the Save button to create the remediation
			CMSRemediationandLippincott.clickSaveRemediation(title);
			NITRemediation.waitFor(4);
			test.log(LogStatus.PASS, "CMS Admin adds Remediation successfully");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//CMS admin user navigates to the home page
			CMSRemediationandLippincott.clickCMSMainMenu();
			NITRemediation.waitFor(4);
			test.log(LogStatus.INFO, "CMS Admin navigates to home page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Scroll Up Page
			Library.scroll(driver, 0, 500);
			NITRemediation.waitFor(2);
			//CMS admin user navigates to the Add Lippincott page
			CMSRemediationandLippincott.clickAddLippincott();
			NITRemediation.waitFor(4);
			test.log(LogStatus.INFO, "CMS Admin navigates to home page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//CMS admin user selects the remediation created
			CMSRemediationandLippincott.selectRemediationTitle(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", 5, 16));
			
			//CMS admin user enters the description1
			CMSRemediationandLippincott.enterLippincottDesc1(lippincotttitle);
			
			//Scroll Down Page
			Library.scroll(driver, 0, 500);
			NITRemediation.waitFor(2);
			
			//CMS admin user enters the title1
			CMSRemediationandLippincott.enterLippincottTitle1(lippincotttitle);
			
			//CMS admin user enters the description2
			CMSRemediationandLippincott.enterLippincottDesc2();
			
			//CMS admin user enters the title2
			CMSRemediationandLippincott.enterLippincottTitle2();
			
			//CMS admin user creates the lippincott successfully
			CMSRemediationandLippincott.clickLippincottSave();
			NITRemediation.waitFor(5);
			test.log(LogStatus.INFO, "CMS Admin clicks Save button to add Lippincott");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Assert to verify the added lippincott title
			Assert.assertEquals(CMSRemediationandLippincott.getLippincotttitle(),lippincotttitle);
			test.log(LogStatus.PASS, "Lippincott added successfully");
			
			//Logout of the application
			NITRemediation.clickLogout();
			
		}	
}