/**
 * 
 */
package NITController;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.TakingTestandCompareResultsModel;
import Utility.BaseClass;

/**
 * @author Keerthi Anand
 *
 */
public class TakingTestandCompareResultsController extends BaseClass {
		WebDriver driver;
			   
		public LoginPageModel NITloginPage;
		public TakingTestandCompareResultsModel NITFRTTestandCompare;
		
		String [] studentpercentcorrect;
		
		public String studentapppercentcorrect11;
		public String studentapppercentcorrect12;
		public String studentapppercentcorrect13;
		
		String ITTestName;
		String FRTTestName;
		String NCLEXTestName;
		String ITTestType;
		String FRTTestType;
		String NCLEXTestType;
		
		public TakingTestandCompareResultsController(WebDriver driver) {
			this.driver = driver;
			NITloginPage = new LoginPageModel(driver);
			NITFRTTestandCompare = new TakingTestandCompareResultsModel(driver);
		}
		
		public void TakingTestNIT(String uname, String pwd, String programofstudy, String testname) {
			
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			//Logging into the student application			
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITStudentUserName(uname);
			test.log(LogStatus.INFO,"Student User name entered successfully");
			NITloginPage.setNITStudentPwd(pwd);
			test.log(LogStatus.INFO,"Student Password entered successfully");
			NITloginPage.clickStudentLogin();
			test.log(LogStatus.INFO,"Student Login button is clicked");
			waitFor(5);
			
			List<WebElement> Agree_Buttons = driver.findElements(By.xpath("//input[@name='BtnEnrollmentAgreementSave']"));
			for(WebElement Agree_Button : Agree_Buttons)
			{
				if(Agree_Button.isDisplayed())
				{
					System.out.println("Agree Button Available");
					Agree_Button.click();
					waitFor(5);
					break;
				}else
				{
					System.out.println("Agree Button Not Available");
				}
			}
			
			new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Head11_IbIntegratedTest']")));
			Assert.assertEquals(NITloginPage.getstudenthomepageurl(),DataProviderFactory.getConfig().getstudenthomepageurl(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Student User is able to login successfully");
			
			//Configuring the test names
			ITTestName=programofstudy + " IT " + testname;
			FRTTestName=programofstudy + " FRT " + testname;
			NCLEXTestName=programofstudy + " NCLEX " + testname;
			
			//Navigating to IT tab
			NITFRTTestandCompare.clickITtab();
			new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/span[text()='Integrated Testing']")));
			test.log(LogStatus.INFO,"User navigates to the Integrated Testing tab");
			
			//Taking the IT Test
			NITFRTTestandCompare.clickTaketheTestLink(ITTestName);
			waitFor(3);
			NITFRTTestandCompare.clickIAgreeButton();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
			test.log(LogStatus.INFO,"User clicks the Take the test link of the mentioned IT test");
			
			//Answering all types of questions in IT Test
			NITFRTTestandCompare.answerQuestions();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ibIntroStart']"))));
			test.log(LogStatus.INFO,"User answers all the type of questions available for the IT test successfully");
			
			//Completing the IT Test
			NITFRTTestandCompare.clickEndTest();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"))));
			test.log(LogStatus.PASS,"User clicks End Test button from last page and successfully completes the IT test");					
			
			NITFRTTestandCompare.clickHomePage();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Head11_LbLogout']"))));
			NITFRTTestandCompare.waitFor(5);
			
			//Navigating to FRT tab
			NITFRTTestandCompare.clickFRTtab();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Head11_LbLogout']"))));
			test.log(LogStatus.INFO,"User navigates to the Focussed review test tab");
			
			//Taking the FRT test			
			NITFRTTestandCompare.clickTaketheTestLink(FRTTestName);			
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));			
			test.log(LogStatus.INFO,"User clicks the Take the test link of the mentioned FRT test");
			
			//Answering all types of questions
			NITFRTTestandCompare.answerQuestions();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ibIntroStart']"))));
			test.log(LogStatus.INFO,"User answers all the type of questions available for the FRT test successfully");
			
			//Completing the Test
			NITFRTTestandCompare.clickEndTest();
			NITFRTTestandCompare.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"))));
			test.log(LogStatus.PASS,"User clicks End Test button from last page and successfully completes the FRT test");
			
			NITFRTTestandCompare.clickHomePage();
			//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Head11_LbLogout']"))));
			NITFRTTestandCompare.waitFor(5);
			
			//Navigating to NCLEX tab
			NITFRTTestandCompare.clickNCLEXlink();
			NITFRTTestandCompare.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Lb21']"))));
			test.log(LogStatus.INFO,"User navigates to the NCLEX Prep tab");
			
			NITFRTTestandCompare.clickNCLEXQTrainer();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"))));
			test.log(LogStatus.INFO,"User navigates to the NCLEX Question Trainer landing page");
			
			//Taking the NCLEX test			
			NITFRTTestandCompare.clickTaketheTestLink(NCLEXTestName);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
			test.log(LogStatus.INFO,"User clicks the Take the test link of the mentioned NCLEX test");
			
			//Answering all types of questions
			NITFRTTestandCompare.answerQuestions();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ibIntroStart']"))));
			test.log(LogStatus.INFO,"User answers all the type of questions available for the NCLEX test successfully");
			
			//Completing the Test
			NITFRTTestandCompare.clickEndTest();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"))));
			test.log(LogStatus.PASS,"User clicks End Test button from last page and successfully completes the NCLEX test");			
			
			NITFRTTestandCompare.waitFor(5);
			
			NITloginPage.clickStudentSignout();
		
			}
		
		public void comparePercentWithAdminReport(String stusname, String stpwd, String aduname, String adpwd, String programofstudy,String testname) {
			
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			
			String studentInstitution;
			String StudentCohort;
			String StudentFirstName;
			String StudentLastName;
			String StudentName;
			String reportPercentCorrect;
			String studentapppercentcorrect1[];
			String StudentPercentCorrect;
			
			//Configuring the test names
			ITTestName=programofstudy + " IT " + testname;
			FRTTestName=programofstudy + " FRT " + testname;
			NCLEXTestName=programofstudy + " NCLEX " + testname;
			
			//Configuring test types
			ITTestType="Integrated Testing";
			FRTTestType="Focused Review Tests";
			NCLEXTestType="NCLEX Prep";
			
			//Logging into the student application			
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITStudentUserName(stusname);
			test.log(LogStatus.INFO,"Student User name entered successfully");
			NITloginPage.setNITStudentPwd(stpwd);
			test.log(LogStatus.INFO,"Student Password entered successfully");
			NITloginPage.clickStudentLogin();
			test.log(LogStatus.INFO,"Student Login button is clicked");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Head11_IbFocusedReview']"))));
			Assert.assertEquals(NITloginPage.getstudenthomepageurl(),DataProviderFactory.getConfig().getstudenthomepageurl(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Student User is able to login successfully");
			
			NITFRTTestandCompare.clickTestResults();
			waitFor(2);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"))));
			
			//Getting the percentage scored by the student for IT Test
			studentapppercentcorrect11=NITFRTTestandCompare.getStudentPercentCorrect(ITTestName);
			System.out.println("Percent Correct of IT test for the student is " + studentapppercentcorrect11);
			
			//Getting the percentage scored by the student for FRT Test
			studentapppercentcorrect12=NITFRTTestandCompare.getStudentPercentCorrect(FRTTestName);
			System.out.println("Percent Correct of FRT test for the student is " + studentapppercentcorrect12);
			
			//Getting the percentage scored by the student for NCLEX Test
			studentapppercentcorrect13=NITFRTTestandCompare.getStudentPercentCorrect(NCLEXTestName);
			System.out.println("Percent Correct of NCLEX test for the student is " + studentapppercentcorrect13);
			
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			
			//Logging into the admin application			
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITAdminUserName(aduname);
			test.log(LogStatus.INFO,"Admin User name entered successfully");
			NITloginPage.setNITAdminPwd(adpwd);
			test.log(LogStatus.INFO,"Admin Password entered successfully");
			NITloginPage.clickAdminLogin();
			test.log(LogStatus.INFO,"Admin Login button is clicked");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.PASS, "Admin User is able to login successfully");
			
			//Navigate to edit student page and get the necessary info for generating report
			NITFRTTestandCompare.navigateStudentViewEdit();
			waitFor(2);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"))));
			test.log(LogStatus.INFO,"Navigated to Student View Edit page");
			NITFRTTestandCompare.selectStudentListProgramofStudy(programofstudy);
			waitFor(2);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"))));
			test.log(LogStatus.INFO,"Select students' program of study");
			NITFRTTestandCompare.searchstudent(stusname);
			NITFRTTestandCompare.clickstudentsearch();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers']/tbody/tr[2]/td[7]/a"))));
			studentInstitution=NITFRTTestandCompare.getStudentInstitution();
			StudentCohort=NITFRTTestandCompare.getStudentCohort();
			NITFRTTestandCompare.clickeditlink();
			waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btSave']"))));
			StudentFirstName=NITFRTTestandCompare.getStudentFN();
			StudentLastName=NITFRTTestandCompare.getStudentLN();
			StudentName = StudentLastName+","+StudentFirstName;
			NITFRTTestandCompare.clickMainMenu();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Navigate to student report card
			NITFRTTestandCompare.navigateStudentReportCard();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.waitFor(3);
			
			//Select Program of study
			NITFRTTestandCompare.selectStudentProgramofStudy(programofstudy);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			
			
			//Generate the report for IT Test
			NITFRTTestandCompare.selectStudentInstitution(studentInstitution);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectTestType();
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectTestType(ITTestType);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentCohort(StudentCohort);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentName(StudentName);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentTest(ITTestName);
			NITFRTTestandCompare.waitFor(3);
			NITFRTTestandCompare.clickReportSubmit();
			NITFRTTestandCompare.waitFor(3);
			
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvResult_ctl02_lnkbuttonPerformance']"))));
			test.log(LogStatus.PASS,"Report generated successfully for IT Test");
			
			//Comparing the percent correct for the IT test
			reportPercentCorrect=NITFRTTestandCompare.getPercentCorrectReport();
			studentapppercentcorrect1=studentapppercentcorrect11.split("%");
			StudentPercentCorrect=studentapppercentcorrect1[0];
			Assert.assertEquals(StudentPercentCorrect,reportPercentCorrect);
			test.log(LogStatus.PASS,"Percentage displayed properly for IT Test");
			
			//Generate the report for FRT Test
			NITFRTTestandCompare.selectTestType();
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectTestType(FRTTestType);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentCohort(StudentCohort);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentName(StudentName);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentTest(FRTTestName);
			NITFRTTestandCompare.clickReportSubmit();
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvResult_ctl02_lnkbuttonPerformance']"))));
			test.log(LogStatus.PASS,"Report generated successfully for FRT Test");
			
			//Comparing the percent correct for the FRT test
			reportPercentCorrect=NITFRTTestandCompare.getPercentCorrectReport();
			studentapppercentcorrect1=studentapppercentcorrect12.split("%");
			StudentPercentCorrect=studentapppercentcorrect1[0];
			Assert.assertEquals(StudentPercentCorrect,reportPercentCorrect);
			test.log(LogStatus.PASS,"Percentage displayed properly for FRT Test");
			
			//Generate the report for NCLEX Test
			NITFRTTestandCompare.selectTestType();
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectTestType(NCLEXTestType);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentCohort(StudentCohort);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentName(StudentName);
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"))));
			NITFRTTestandCompare.selectStudentTest(NCLEXTestName);
			NITFRTTestandCompare.waitFor(3);
			NITFRTTestandCompare.clickReportSubmit();
			NITFRTTestandCompare.waitFor(3);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvResult_ctl02_lnkbuttonPerformance']"))));
			test.log(LogStatus.PASS,"Report generated successfully for NCLEX Test");
			
			//Comparing the percent correct for the NCLEX test
			reportPercentCorrect=NITFRTTestandCompare.getPercentCorrectReport();
			studentapppercentcorrect1=studentapppercentcorrect13.split("%");
			StudentPercentCorrect=studentapppercentcorrect1[0];
			Assert.assertEquals(StudentPercentCorrect,reportPercentCorrect);
			test.log(LogStatus.PASS,"Percentage displayed properly for NCLEX Test");
			
		}
		
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		
	}