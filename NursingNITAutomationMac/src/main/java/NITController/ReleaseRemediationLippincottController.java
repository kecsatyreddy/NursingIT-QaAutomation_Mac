/**
 * 
 */
package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Factory.DataProviderFactory;
import NITModel.CreateQuestionsTestsandReleaseModel;
import NITModel.ReleaseRemediationLippincottModel;
import Utility.BaseClass;
import Utility.Library;

/**
 * @author Keerthi Anand
 *
 */
public class ReleaseRemediationLippincottController extends BaseClass {
		WebDriver driver;
		
		public CreateQuestionsTestsandReleaseModel NITCreateQuestionsTestsandRelease;
		public ReleaseRemediationLippincottModel NITReleaseRemediationandLippincott;
		
		public ReleaseRemediationLippincottController(WebDriver driver) {
			this.driver = driver;
			NITCreateQuestionsTestsandRelease = new CreateQuestionsTestsandReleaseModel(driver);
			NITReleaseRemediationandLippincott = new ReleaseRemediationLippincottModel(driver);
		}
		
		public void releaseRemediationandLippincott(String uname, String pwd, String remediationtitle, String lippincotttitle) {		
			//Steps for the CMS admin user to login
			new WebDriverWait(driver, 90).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITCreateQuestionsTestsandRelease.setNITCMSUserName(uname);
			test.log(LogStatus.INFO,"CMS Admin User name entered successfully");
			NITCreateQuestionsTestsandRelease.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO,"CMS Admin Password entered successfully");
			NITCreateQuestionsTestsandRelease.clickLogin();
			test.log(LogStatus.INFO,"CMS Admin Login button is clicked");
			new WebDriverWait(driver, 90).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "CMS Admin User is able to login successfully");
			
			//Scroll Down Page
			Library.scroll(driver, 0, 500);
			NITReleaseRemediationandLippincott.waitFor(2);
			
			//Navigating to Release page
			NITReleaseRemediationandLippincott.clickReleaseButton();
			test.log(LogStatus.INFO,"CMS Admin user navigates to Release page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));			
			NITReleaseRemediationandLippincott.waitFor(5);
			
			//Selecting the Remediations checkbox on Release and navigating to next page
			NITReleaseRemediationandLippincott.clickReleaseRemediationsCheckbox();
			NITReleaseRemediationandLippincott.waitFor(2);
			NITReleaseRemediationandLippincott.clickReleaseContinueButton();
			test.log(LogStatus.INFO,"CMS Admin navigates to Release Remediations page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			NITReleaseRemediationandLippincott.waitFor(15);
			
			Library.scroll(driver, 0, 500);
			NITReleaseRemediationandLippincott.waitFor(2);
			
			//Selecting the required remediation topic title to release
			String title1= remediationtitle + " is a testing remediation added through automation testing";
			NITReleaseRemediationandLippincott.clickRemlippCheckbox(title1);
			test.log(LogStatus.INFO,"CMS Admin selects the remediation topic to be released");
			
			//Scroll Down The Page
			Library.scroll(driver, 0, 500);
			NITReleaseRemediationandLippincott.waitFor(2);
			
			//Clicking the Save and Continue button
			NITReleaseRemediationandLippincott.clickReleaseSaveandContinueButton();
			NITReleaseRemediationandLippincott.waitFor(15);
			
			test.log(LogStatus.INFO,"CMS Admin navigates to Release to Production page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Clicking the Release to Production button
			NITReleaseRemediationandLippincott.clickReleasetoProductionButton();
			NITReleaseRemediationandLippincott.waitFor(5);
			test.log(LogStatus.INFO,"CMS Admin clicks Release to Production button");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Checkign the success message
			Assert.assertEquals(NITReleaseRemediationandLippincott.checkSuccessMessage(),"Successfully released.");
			test.log(LogStatus.PASS, "Remediation is released successfully");
			
			//Navigate to home page
			NITReleaseRemediationandLippincott.clickMainMenu();
			NITReleaseRemediationandLippincott.waitFor(5);
			test.log(LogStatus.INFO,"CMS Admin navigates to home page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Scroll Down The Page
			Library.scroll(driver, 0, 500);
			NITReleaseRemediationandLippincott.waitFor(2);
			
			//Navigating to Release page
			NITReleaseRemediationandLippincott.clickReleaseButton();
			NITReleaseRemediationandLippincott.waitFor(5);
			test.log(LogStatus.INFO,"CMS Admin user navigates to Release page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));			
			
			//Selecting the Remediations checkbox on Release and navigating to next page
			NITReleaseRemediationandLippincott.clickReleaseLippincottCheckbox();
			NITReleaseRemediationandLippincott.clickReleaseContinueButton();
			test.log(LogStatus.INFO,"CMS Admin navigates to Release Remediations page");
			new WebDriverWait(driver, 90).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			NITReleaseRemediationandLippincott.waitFor(15);
			
			//Selecting the required lippincott title to release
			NITReleaseRemediationandLippincott.clickRemlippCheckbox(lippincotttitle);
			NITReleaseRemediationandLippincott.waitFor(2);
			test.log(LogStatus.INFO,"CMS Admin selects the lippincott to be released");
			
			//Clicking the Save and Continue button
			NITReleaseRemediationandLippincott.clickReleaseSaveandContinueButton1();
			NITReleaseRemediationandLippincott.waitFor(15);
			test.log(LogStatus.INFO,"CMS Admin navigates to Release to Production page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Clicking the Release to Production button
			NITReleaseRemediationandLippincott.clickReleasetoProductionButton();
			NITReleaseRemediationandLippincott.waitFor(10);
			test.log(LogStatus.INFO,"CMS Admin clicks Release to Production button");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Checking the success message
			Assert.assertEquals(NITReleaseRemediationandLippincott.checkSuccessMessage(),"Successfully released.");
			test.log(LogStatus.PASS, "Remediation is released successfully");
			
			//Logout of the application
			NITCreateQuestionsTestsandRelease.clickLogout();
			
		}					
}