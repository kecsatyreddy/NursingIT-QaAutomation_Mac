package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.CohortModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class CohortController extends BaseClass
{
		WebDriver driver;
			   
		public LoginPageModel NITloginPage;
		public CohortModel NITViewEditCohort;

	
		public CohortController(WebDriver driver) {
			
			this.driver = driver;
			NITViewEditCohort = new CohortModel(driver);
			NITloginPage = new  LoginPageModel(driver);
	
		}
		
		
		public void Cohort(String uname, String pwd, String cname, String clname, String pname, String Iname, String sdate, String edate, String newcname) 
		{
		
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITAdminUserName(uname);
			test.log(LogStatus.INFO,"Entered Username");
			
			NITloginPage.setNITAdminPwd(pwd);
			test.log(LogStatus.INFO,"Entered Password");
			
			NITloginPage.clickAdminLogin();
			test.log(LogStatus.INFO,"Clicking on login button");
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(DataProviderFactory.getConfig().getNITAdminHomePageURL()));
			Assert.assertEquals(NITloginPage.getadminhomepageurl(),DataProviderFactory.getConfig().getNITAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Admin User is able to login successfully");
			
			NITViewEditCohort.clickAddCohort();
			test.log(LogStatus.INFO,"Clicking on the link Add cohort.");
			
			NITViewEditCohort.enterCohortName(cname);
			test.log(LogStatus.INFO,"Entered cohort name.");
			
			NITViewEditCohort.enterClassCode(clname);
			test.log(LogStatus.INFO,"Entered class code.");
					
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			
			NITViewEditCohort.selectProgramOfStudy(pname);
			test.log(LogStatus.INFO,"selecting the POS from data table");
				
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']"))));
			NITViewEditCohort.selectInstituition(Iname);
			test.log(LogStatus.INFO,"Selecting institution name from the dropdown.");
					
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSD']"))));
			NITViewEditCohort.enterCohortStartDate(sdate);
			test.log(LogStatus.INFO,"Entered startdate");
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtED']"))));
			NITViewEditCohort.enterCohortEndDate(edate);
			test.log(LogStatus.INFO,"Entered endtdate");
			
			NITViewEditCohort.clickSaveCohort();
			Assert.assertEquals("Cohort successfully updated",NITViewEditCohort.verifySuccessMessage());
			test.log(LogStatus.PASS, "New Cohort Successfully Created: "+cname);
			
			NITViewEditCohort.clickLinkMainMenu();
			test.log(LogStatus.INFO,"Clicking on main menu");
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(DataProviderFactory.getConfig().getNITAdminHomePageURL()));
			NITViewEditCohort.clickViewEditCohort();
			test.log(LogStatus.INFO,"Clicking on ViewEdit link of cohort");
		
					
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			NITViewEditCohort.selectProgramOfStudy(pname);
			test.log(LogStatus.INFO,"Clicked on Program of Study.");
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbInstitution']"))));
          	NITViewEditCohort.selectInstituitionview(Iname);
          	test.log(LogStatus.INFO,"selecting the institutionname from the dropdown");
			
          	NITViewEditCohort.searchCohortName(cname);
			test.log(LogStatus.INFO,"searching for the newly created cohort");
			
			NITViewEditCohort.clickSearchBtn();
			test.log(LogStatus.INFO,"Clicking on search button");
			
			NITViewEditCohort.waitFor(2);
			Assert.assertEquals(cname,NITViewEditCohort.validateCohortLbl());
			test.log(LogStatus.PASS,"Able to search the newly created Cohort "+cname);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridCohorts']/tbody/tr[2]/td[9]/a"))));
			
			NITViewEditCohort.clickEditLink();
			test.log(LogStatus.INFO,"Clicking on Edit link of the searched cohort");
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtCohortName']"))));
		}
}