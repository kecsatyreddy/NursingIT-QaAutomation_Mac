/**
 * 
 */
package NITController;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Factory.DataProviderFactory;
import NITModel.CreateQuestionsTestsandReleaseModel;
import Utility.BaseClass;
import Utility.Library;
import Utility.WaitTool;

/**
 * @author Keerthi Anand / Satyanarayana reddy T
 *
 */
public class CreateQuestionsTestsandReleaseController extends BaseClass 
{
		WebDriver driver;
		public CreateQuestionsTestsandReleaseModel NITCreateQuestionsTestsandRelease;
		
		//Variable to store Question id's 
		String[] qids = new String[5];
		
		//Variable to store test names
		String[] testnames = new String[3];		
		String ITTestName;
		String FRTTestName;
		String NCLEXTestName;
		String ITTestType;
		String FRTTestType;
		String NCLEXTestType;
		
		public CreateQuestionsTestsandReleaseController(WebDriver driver)
		{
			this.driver = driver;
			NITCreateQuestionsTestsandRelease = new CreateQuestionsTestsandReleaseModel(driver);
		}
		
		public String[] createQuestions(String uname, String pwd, String programofstudy, String qid)
		{
			//Steps for the CMS admin user to login
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WaitTool.waitForElementDisplay(driver, By.id("BtnLogIn"), 350);
			NITCreateQuestionsTestsandRelease.setNITCMSUserName(uname);
			test.log(LogStatus.INFO,"CMS Admin User name entered successfully");
			NITCreateQuestionsTestsandRelease.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO,"CMS Admin Password entered successfully");
			NITCreateQuestionsTestsandRelease.clickLogin();
			test.log(LogStatus.INFO,"CMS Admin Login button is clicked");
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']")));
			WaitTool.waitForElementDisplay(driver, By.id("ctl00_ucAdminMainRightMenu_btnLogout"), 350);
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "CMS Admin User is able to login successfully");	
			NITCreateQuestionsTestsandRelease.waitFor(1);
			
			//function to save the questions ids in an array
			String qid1= qid.substring(6);
			qids[0]=qid;
			int questid1 = Integer.parseInt(qid1);
			for (int i=1; i<5; i++)
			{
				questid1++;
				String qid2= qid.substring(0,6);
				qids[i]=qid2+questid1;
			}
				
			//Loop to create all 5 different types of questions
			for (int i=1; i<=5; i++)
			{
				//Scroll Up The Page
				Library.scroll(driver, 0, 500);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				
				//CMS admin user navigates to the Add Questions page
				NITCreateQuestionsTestsandRelease.clickAddQuestion();
				//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"))));
				WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"), 350);
				test.log(LogStatus.INFO, "CMS Admin User is navigated to Add Questions page");
				
				//Entering the question id
				if (i==1)
					NITCreateQuestionsTestsandRelease.enterQuestionID(qids[0]);
				else
				{
					int x=i-1;
					NITCreateQuestionsTestsandRelease.enterQuestionID(qids[x]);
				}
				
				//Selecting Program of study
				NITCreateQuestionsTestsandRelease.selectProgramofStudy(programofstudy);
				NITCreateQuestionsTestsandRelease.waitFor(5);
				new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"))));
				test.log(LogStatus.INFO, "CMS Admin User has selected the program of study for "+i+" question");
				int index=i;
	
				//Selecting all different categories for the question
				NITCreateQuestionsTestsandRelease.selectClientNeeds(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(5);
				test.log(LogStatus.INFO, "CMS Admin User has selected client needs for "+i+" question");
				new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
				int clientneedscat=1;
				NITCreateQuestionsTestsandRelease.selectClientNeedsCategory(programofstudy,clientneedscat);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected client needs category for "+i+" question");
				if (programofstudy.equalsIgnoreCase("PN"))
				{
					NITCreateQuestionsTestsandRelease.selectNursingProcess(programofstudy,index);		
					NITCreateQuestionsTestsandRelease.waitFor(1);
				}
				else
				{
					NITCreateQuestionsTestsandRelease.selectNursingProcess(programofstudy,index);
					NITCreateQuestionsTestsandRelease.waitFor(1);
				}
				
				test.log(LogStatus.INFO, "CMS Admin User has selected nursing process for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectLevelofDifficulty(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected level of difficulty for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectDemography(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected demography for "+i+" question");				
				NITCreateQuestionsTestsandRelease.selectCognitiveLevel(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected cognitive level for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectSpecialityArea(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected speciality area for "+i+" question");
				
				//Scroll Up The Page
				Library.scroll(driver, 0, 250);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				
				NITCreateQuestionsTestsandRelease.selectSystem(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected system for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectCriticalThinking(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected critical thinking for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectClinicalConcepts(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected clinical concept for "+i+" question");
				if (programofstudy.equalsIgnoreCase("RN")){
					NITCreateQuestionsTestsandRelease.selectAccreditationCategories(index);
					NITCreateQuestionsTestsandRelease.waitFor(1);
					test.log(LogStatus.INFO, "CMS Admin User has selected accrediation categories for "+i+" question");
					NITCreateQuestionsTestsandRelease.selectQSENKSACompetencies(index);
					NITCreateQuestionsTestsandRelease.waitFor(1);
					test.log(LogStatus.INFO, "CMS Admin User has selected QSENKSA competencies for "+i+" question");	
				}
				NITCreateQuestionsTestsandRelease.selectConcepts(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected concepts for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectDecisionTree(programofstudy,index);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				test.log(LogStatus.INFO, "CMS Admin User has selected decision tree for "+i+" question");
				NITCreateQuestionsTestsandRelease.selectQuestionType(index);
				NITCreateQuestionsTestsandRelease.waitFor(3);
				test.log(LogStatus.INFO, "CMS Admin User has selected question type for "+i+" question");
				//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"))));				
				
				//Scroll Up The Page
				Library.scroll(driver, 0, 500);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				
				
				//Selecting remediation for the question
				NITCreateQuestionsTestsandRelease.waitFor(1);
				NITCreateQuestionsTestsandRelease.selectRemediation(index);
				test.log(LogStatus.INFO, "CMS Admin User has selected remediation for "+i+" question");
				
				
				//Scroll Down The Page
				Library.scroll(driver, 0, -250);
				NITCreateQuestionsTestsandRelease.waitFor(1);
				
				//Entering the question stem and answer choices for different types of question
				switch (i) {
				case 1:
					NITCreateQuestionsTestsandRelease.createMCSSQuestion(qids[0]);
					test.log(LogStatus.PASS, "Multi Choice Single Select question is created successfully");
					break;
				case 2:
					NITCreateQuestionsTestsandRelease.createMCMSQuestion(qids[1]);
					test.log(LogStatus.PASS, "Multi Choice Multi Select question is created successfully");
					break;
				case 3:
					NITCreateQuestionsTestsandRelease.createHotspotQuestion(qids[2]);					
					test.log(LogStatus.PASS, "HotSpot question is created successfully");
					break;
				case 4:
					NITCreateQuestionsTestsandRelease.createNumericalQuestion(qids[3]);
					test.log(LogStatus.PASS, "Numerical Fill In question is created successfully");
					break;
				case 5:
					NITCreateQuestionsTestsandRelease.createDragDropQuestion(qids[4]);
					test.log(LogStatus.PASS, "Drag and Drop question is created successfully");
					break;						

				default:
					System.out.println("Questions not created");
					
				}					
			}
			
			//Logging out of the applciation
			NITCreateQuestionsTestsandRelease.clickLogout();
			
			return qids;
		}
		
		public String[] createTests(String uname, String pwd, String programofstudy, String qid, String testname) {
			//Steps for the CMS admin user to login
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='BtnLogIn']"), 350);
			NITCreateQuestionsTestsandRelease.setNITCMSUserName(uname);
			test.log(LogStatus.INFO,"CMS Admin User name entered successfully");
			NITCreateQuestionsTestsandRelease.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO,"CMS Admin Password entered successfully");
			NITCreateQuestionsTestsandRelease.clickLogin();
			test.log(LogStatus.INFO,"CMS Admin Login button is clicked");
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']")));
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "CMS Admin User is able to login successfully");
			
			//CMS admin user navigates to Add Tests page
			Library.scroll(driver, 0, 500);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.clickAddTest();
			test.log(LogStatus.INFO, "CMS Admin User navigates to Add Test page");
			NITCreateQuestionsTestsandRelease.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selects Program of Study for the test
			NITCreateQuestionsTestsandRelease.selectTestProgramofStudy(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study for the IT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Configuring the test names
			ITTestName=programofstudy + " IT " + testname;
			FRTTestName=programofstudy + " FRT " + testname;
			NCLEXTestName=programofstudy + " NCLEX " + testname;
			
			ITTestType="Integrated Testing";
			FRTTestType="Focused Review Tests";
			NCLEXTestType="NCLEX Prep";
			
			//Entering the test name
			NITCreateQuestionsTestsandRelease.enterTestName(ITTestName);
			test.log(LogStatus.INFO, "CMS Admin User enters IT test name");
			
			//Selecting the test type
			NITCreateQuestionsTestsandRelease.selectTestType(ITTestType);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User enters IT Test Type");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Clicking sequence link for IT test
			NITCreateQuestionsTestsandRelease.clickSequence();
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User clicks Sequence link for IT Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Saving the test
			NITCreateQuestionsTestsandRelease.clickSave();
			test.log(LogStatus.PASS, "IT Test created successfully");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//CMS admin user navigates back to Add Tests page
			NITCreateQuestionsTestsandRelease.clickNewTest();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selecting Program of study
			NITCreateQuestionsTestsandRelease.selectTestProgramofStudy(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study for the FRT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Entering the test name
			NITCreateQuestionsTestsandRelease.enterTestName(FRTTestName);
			test.log(LogStatus.INFO, "CMS Admin User enters FRT test name");
			
			//Selecting the test type
			NITCreateQuestionsTestsandRelease.selectTestType(FRTTestType);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User enters FRT Test Type");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Saving the test
			NITCreateQuestionsTestsandRelease.clickSave();
			test.log(LogStatus.PASS, "FRT Test created successfully");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//CMS admin user navigates back to Add Tests page
			NITCreateQuestionsTestsandRelease.clickNewTest();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selecting Program of study
			NITCreateQuestionsTestsandRelease.selectTestProgramofStudy(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study for the NCLEX test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Entering the test name
			NITCreateQuestionsTestsandRelease.enterTestName(NCLEXTestName);
			test.log(LogStatus.INFO, "CMS Admin User enters NCLEX test name");
			
			//Selecting the test type
			NITCreateQuestionsTestsandRelease.selectTestType(NCLEXTestType);
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User enters NCLEX Test Type");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Clicking sequence link for NCLEX test
			NITCreateQuestionsTestsandRelease.clickSequence();
			NITCreateQuestionsTestsandRelease.waitFor(7);
			test.log(LogStatus.INFO, "CMS Admin User clicks Sequence link for NCLEX Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Saving the test			
			NITCreateQuestionsTestsandRelease.clickSave();
			test.log(LogStatus.PASS, "NCLEX Test created successfully");						
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));					
			
			//Selecting Program of study to search the test
			NITCreateQuestionsTestsandRelease.selectProgramofStudySearchTest(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study to search the IT test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Searching IT test
			NITCreateQuestionsTestsandRelease.searchTest(ITTestName);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User searches for IT Test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Navigating to Adding questions to test page
			NITCreateQuestionsTestsandRelease.clickQuestions();
			test.log(LogStatus.INFO, "CMS Admin User navigates to add question page for IT Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Entering question id to search questions to be added to the test
			//Scroll Up Page
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.enterQuestionIDSearch(qid);
			
			//Searching questions to be added to the test
			NITCreateQuestionsTestsandRelease.searchAddQuestions();
			NITCreateQuestionsTestsandRelease.waitFor(3);
			
			test.log(LogStatus.INFO, "CMS Admin User searches questions for IT Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Adding searched questions to the test
			//Scroll Up Page
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			
			NITCreateQuestionsTestsandRelease.clickAddQuestions();
			test.log(LogStatus.INFO, "CMS Admin User adds questions to IT Test");						
			
			//Completing the adding questions process
			NITCreateQuestionsTestsandRelease.clickDoneQuestions();
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.PASS, "Required questions are added properly to the IT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selecting Program of study to search the test again
			NITCreateQuestionsTestsandRelease.selectProgramofStudySearchTest(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study to search the FRT test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Searching FRT test
			NITCreateQuestionsTestsandRelease.searchTest(FRTTestName);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User searches for FRT Test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Navigating to Adding questions to test page
			NITCreateQuestionsTestsandRelease.clickQuestions();
			test.log(LogStatus.INFO, "CMS Admin User navigates to add question page for FRT Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Entering question id to search questions to be added to the test
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.enterQuestionIDSearch(qid);
			
			//Searching questions to be added to the test
			NITCreateQuestionsTestsandRelease.searchAddQuestions();
			test.log(LogStatus.INFO, "CMS Admin User searches questions for FRT Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Adding searched questions to the test
			//Scroll Up Page
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.clickAddQuestions();
			test.log(LogStatus.INFO, "CMS Admin User adds questions to FRT Test");
			
			//Completing the adding questions process
			NITCreateQuestionsTestsandRelease.clickDoneQuestions();
			test.log(LogStatus.PASS, "Required questions are added properly to the FTT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selecting Program of study to search the test again
			NITCreateQuestionsTestsandRelease.selectProgramofStudySearchTest(programofstudy);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study to search the NCLEX test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Searching NCLEX test
			NITCreateQuestionsTestsandRelease.searchTest(NCLEXTestName);
			NITCreateQuestionsTestsandRelease.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User searches for NCLEX Test to add questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Navigating to Adding questions to test page
			NITCreateQuestionsTestsandRelease.clickQuestions();
			test.log(LogStatus.INFO, "CMS Admin User navigates to add question page for NCLEX Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Entering question id to search questions to be added to the test
			//Scroll Up Page
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.enterQuestionIDSearch(qid);
			
			//Searching questions to be added to the test
			NITCreateQuestionsTestsandRelease.searchAddQuestions();
			test.log(LogStatus.INFO, "CMS Admin User searches questions for NCLEX Test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Adding searched questions to the test
			//Scroll Up Page
			Library.scroll(driver, 0, 250);
			NITCreateQuestionsTestsandRelease.waitFor(1);
			NITCreateQuestionsTestsandRelease.clickAddQuestions();			
			test.log(LogStatus.INFO, "CMS Admin User adds questions to NCLEX Test");
			
			//Completing the adding questions process
			NITCreateQuestionsTestsandRelease.clickDoneQuestions();
			test.log(LogStatus.PASS, "Required questions are added properly to the NCLEX test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));			
			
			//Logout of the application
			NITCreateQuestionsTestsandRelease.clickLogout();
			
			return testnames;
		}
		
		public void releaseQuestionsandTests(String uname, String pwd, String programofstudy, String qid, String testname) {

			//Steps for the CMS admin user to login
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='BtnLogIn']"), 350);
			NITCreateQuestionsTestsandRelease.setNITCMSUserName(uname);
			test.log(LogStatus.INFO," Admin User name entered successfully");
			NITCreateQuestionsTestsandRelease.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO," Admin Password entered successfully");
			NITCreateQuestionsTestsandRelease.clickLogin();
			test.log(LogStatus.INFO," Admin Login button is clicked");
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']")));
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, " Admin User is able to login successfully");
			
			//Configuring question id's and tests
			String qid1= qid.substring(6);
			qids[0]=qid;
			int questid1 = Integer.parseInt(qid1);
			for (int i=1; i<5; i++)
			{
				questid1++;
				String qid2= qid.substring(0,6);
				qids[i]=qid2+questid1;
			}
			
			ITTestName=programofstudy + " IT " + testname;
			FRTTestName=programofstudy + " FRT " + testname;
			NCLEXTestName=programofstudy + " NCLEX " + testname;
			testnames[0]=ITTestName;
			testnames[1]=FRTTestName;
			testnames[2]=NCLEXTestName;	
			
			//Scroll Up The Page
			Library.scroll(driver, 0, 500);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			
			//Navigating to Release page
			NITCreateQuestionsTestsandRelease.clickReleaseButton();
			test.log(LogStatus.INFO,"CMS Admin user navigates to Release page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));			
			NITCreateQuestionsTestsandRelease.waitFor(3);
			
			//Selecting the Questions checkbox on Release and navigating to next page
			NITCreateQuestionsTestsandRelease.clickReleaseQuestionsCheckbox();
			NITCreateQuestionsTestsandRelease.clickReleaseContinueButton();
			NITCreateQuestionsTestsandRelease.waitFor(10);
			test.log(LogStatus.INFO,"CMS Admin navigates to Release Questions page");
			new WebDriverWait(driver, 500).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selecting all the questions created
			NITCreateQuestionsTestsandRelease.clickQuestionsCheckbox(qids);
			test.log(LogStatus.INFO,"CMS Admin selects the questions created to be released");
			
			//Scroll Up Page
			Library.scroll(driver, 0, 500);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			
			//Saving and navigating to release questions page
			NITCreateQuestionsTestsandRelease.clickReleaseSaveandContinueButton();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Releasing the questions to live site
			NITCreateQuestionsTestsandRelease.clickReleasetoProductionButton();
			test.log(LogStatus.INFO,"CMS Admin clicks release button to release the selected questions");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Verifying the success message after successful release
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.checkSuccessMessage(),"Successfully released.");			
			test.log(LogStatus.PASS, "Questions are released successfully");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Navigating to home page
			NITCreateQuestionsTestsandRelease.clickMainMenu();
			NITCreateQuestionsTestsandRelease.waitFor(2);
			test.log(LogStatus.INFO,"CMS Admin user navigates back to home page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Scroll Up Page
			Library.scroll(driver, 0, 500);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			//Navigating to Release page
			NITCreateQuestionsTestsandRelease.clickReleaseButton();
			test.log(LogStatus.INFO,"CMS Admin user navigates to Release page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			NITCreateQuestionsTestsandRelease.waitFor(5);
			
			//Selecting the Tests checkbox on Release and navigating to next page
			NITCreateQuestionsTestsandRelease.clickReleaseTestsCheckbox();
			NITCreateQuestionsTestsandRelease.clickReleaseContinueButton();
			test.log(LogStatus.INFO,"CMS Admin navigates to Release Questions page");
			NITCreateQuestionsTestsandRelease.waitFor(5);
			
			ITTestName=testnames[0];
			FRTTestName=testnames[1];
			NCLEXTestName=testnames[2];
			
			//Selectign the tests to be released
			NITCreateQuestionsTestsandRelease.clickITTestCheckbox(ITTestName);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			NITCreateQuestionsTestsandRelease.clickFRTTestCheckbox(FRTTestName);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			NITCreateQuestionsTestsandRelease.clickNCLEXTestCheckbox(NCLEXTestName);
			NITCreateQuestionsTestsandRelease.waitFor(2);
			test.log(LogStatus.INFO,"CMS Admin selects the Tests created to be released");
			
			//Saving and navigating to release tests page
			NITCreateQuestionsTestsandRelease.clickReleaseSaveandContinueButton();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Releasing the tests to live site
			NITCreateQuestionsTestsandRelease.clickReleasetoProductionButton();
			test.log(LogStatus.INFO,"CMS Admin clicks release button to release the selected tests");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Verifying the success message after successful release
			Assert.assertEquals(NITCreateQuestionsTestsandRelease.checkSuccessMessage(),"Successfully released.");			
			test.log(LogStatus.PASS, "Tests are released successfully");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Logout of the application
			NITCreateQuestionsTestsandRelease.clickLogout();
			
		}					
}