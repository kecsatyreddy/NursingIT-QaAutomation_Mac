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
import NITModel.LoginPageModel;
import NITModel.ScheduleTestsModel;
import Utility.BaseClass;
import Utility.WaitTool;

/**
 * @author Keerthi Anand
 *
 */
public class SchedulingTestsController extends BaseClass
{
		WebDriver driver;

		public LoginPageModel NITloginPage;
		public ScheduleTestsModel NITScheduleTests;
		
		String ITTestName;
		String FRTTestName;
		String NCLEXTestName;
		String ITTestType;
		String FRTTestType;
		String NCLEXTestType;

		public SchedulingTestsController(WebDriver driver)
		{
			this.driver = driver;
			NITloginPage = new LoginPageModel(driver);
			NITScheduleTests = new ScheduleTestsModel(driver);
		}
		
		public void scheduleAllTests(String uname, String pwd, String programofstudy, String testname, String programname, String cohortname)
		{
			//Steps for the admin user to login
			//new WebDriverWait(driver, 30l).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='BtnLogIn']"), 350);
			NITloginPage.setNITAdminUserName(uname);
			test.log(LogStatus.INFO,"Admin User name entered successfully");
			NITloginPage.setNITAdminPwd(pwd);
			test.log(LogStatus.INFO,"Admin Password entered successfully");
			NITloginPage.clickAdminLogin();
			test.log(LogStatus.INFO,"Admin Login button is clicked");
			//new WebDriverWait(driver, 30l).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			Assert.assertEquals(NITloginPage.getadminhomepageurl(),DataProviderFactory.getConfig().getNITAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Admin User is able to login successfully");
			
			//Configuring the test names
			ITTestName=programofstudy + " IT " + testname;
			FRTTestName=programofstudy + " FRT " + testname;
			NCLEXTestName=programofstudy + " NCLEX " + testname;
			
			//Configuring test types
			ITTestType="Integrated Testing";
			FRTTestType="Focused Review Tests";
			NCLEXTestType="NCLEX Prep";
			
			//Navigating to ProgramLists page
			NITScheduleTests.clickViewEditProgram();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			test.log(LogStatus.INFO, "Admin User navigates to Program list page");

			//Selecting the required program of study
			NITScheduleTests.selectProgramofStudy(programofstudy);
			waitFor(2);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			test.log(LogStatus.INFO, "Admin User selects the Program of Study to search a program");
			
			
			//Searching for a program
			NITScheduleTests.searchProgram(programname);
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			test.log(LogStatus.INFO, "Admin User searches for required program");
			
			//Navigating to add tests page for a program
			NITScheduleTests.clickProgramTests();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			test.log(LogStatus.INFO, "Admin User navigates to Program Add Tests page");			
			
			//Selecting the program of study
			if (programofstudy.equalsIgnoreCase("RN"))
			{
			NITScheduleTests.selectAssetType(programofstudy);
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));			
			}		
			
			//Adding an IT test to the program
			NITScheduleTests.selectAssetGroup(ITTestType);
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			NITScheduleTests.selectAssetName(ITTestName);
			waitFor(5);
			NITScheduleTests.clickProgramTestsAdd();
			waitFor(5);
		
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			Assert.assertEquals(NITScheduleTests.messageProgramTestsAdd(), "Program has been updated");
			test.log(LogStatus.PASS, "Admin User added IT Test to the program");
			
			//Adding a FRT test to the program
			NITScheduleTests.selectAssetGroup(FRTTestType);
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			NITScheduleTests.selectAssetName(FRTTestName);
			waitFor(5);
			NITScheduleTests.clickProgramTestsAdd();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			Assert.assertEquals(NITScheduleTests.messageProgramTestsAdd(), "Program has been updated");
			test.log(LogStatus.PASS, "Admin User added IT Test to the program");
			
			//Adding a NCLEX test to the program
			NITScheduleTests.selectAssetGroup(NCLEXTestType);
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			NITScheduleTests.selectAssetName(NCLEXTestName);
			waitFor(5);
			NITScheduleTests.clickProgramTestsAdd();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			Assert.assertEquals(NITScheduleTests.messageProgramTestsAdd(), "Program has been updated");
			test.log(LogStatus.PASS, "Admin User added IT Test to the program");
			
			//Navigating back to home page
			NITScheduleTests.clickMainMenu();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnFacultySvcSite']"))));
			test.log(LogStatus.INFO, "Admin User navigates to home page");
			
			//Navigating to Cohort list page
			NITScheduleTests.clickViewEditCohort();	
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddProgramofStudy"))));
			test.log(LogStatus.INFO, "Admin User navigates to Cohort list page");
			
			//Selecting program of study
			NITScheduleTests.selectCohrotProgramofStudy(programofstudy);
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Search for a cohort
			NITScheduleTests.searchCohort(cohortname);
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO, "Admin User searches for required cohort");
			
			//Navigating to cohort test dates page
			NITScheduleTests.clickCohortTests();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO, "Admin User navigates to Cohort Test Dates page");
			
			//Enter test dates for IT test
			NITScheduleTests.enterTestDateandTime(ITTestName);
			test.log(LogStatus.INFO, "Admin User enters dates for the required IT test");
			
			//Saving the test dates for IT test
			NITScheduleTests.clickCohortTestsSave();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITScheduleTests.messageCohortTestsSchedule(), "Test dates have been saved");
			test.log(LogStatus.PASS, "Admin User schedules the required IT test successfully");
			
			//Enter test dates for FRT test
			NITScheduleTests.enterTestDateandTime(FRTTestName);
			test.log(LogStatus.INFO, "Admin User enters dates for the required FRT test");
			
			//Saving the test dates for FRT test
			NITScheduleTests.clickCohortTestsSave();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITScheduleTests.messageCohortTestsSchedule(), "Test dates have been saved");
			test.log(LogStatus.PASS, "Admin User schedules the required FRT test successfully");			
			
			//Enter test dates for NCLEX test
			NITScheduleTests.enterTestDateandTime(NCLEXTestName);
			test.log(LogStatus.INFO, "Admin User enters dates for the required NCLEX test");
			
			//Saving the test dates for NCLEX test
			NITScheduleTests.clickCohortTestsSave();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITScheduleTests.messageCohortTestsSchedule(), "Test dates have been saved");
			test.log(LogStatus.PASS, "Admin User schedules the required NCLEX test successfully");
			
			NITloginPage.clickAdminSignout();
			test.log(LogStatus.INFO, "Admin User logs out of the application");
			
			}		
		
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
	}