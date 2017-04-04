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
import NITModel.NormingTestCategoriesProbabilityModel;
import Utility.BaseClass;
import Utility.Library;
import NITModel.CreateQuestionsTestsandReleaseModel;

/**
 * @author Keerthi Anand
 *
 */
public class NormingTestCategoriesProbabilityController extends BaseClass {
		WebDriver driver;
		
		public CreateQuestionsTestsandReleaseModel NITUpdateTestsforNorming;
		public NormingTestCategoriesProbabilityModel NITCMSNormingandTestCategories;
		
		//Variable to store test names
		String[] testnames = new String[3];
		
		String ITTestName;
		
		public NormingTestCategoriesProbabilityController(WebDriver driver) {
			this.driver = driver;
			NITCMSNormingandTestCategories = new NormingTestCategoriesProbabilityModel(driver);
			NITUpdateTestsforNorming = new CreateQuestionsTestsandReleaseModel(driver);
		}
						
		public void addNormingProbability(String uname, String pwd, String programofstudy, String testname) {
			
			//Steps for the CMS admin user to login
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITUpdateTestsforNorming.setNITCMSUserName(uname);
			test.log(LogStatus.INFO,"CMS Admin User name entered successfully");
			NITUpdateTestsforNorming.setNITCMSPassword(pwd);
			test.log(LogStatus.INFO,"CMS Admin Password entered successfully");
			NITUpdateTestsforNorming.clickLogin();
			test.log(LogStatus.INFO,"CMS Admin Login button is clicked");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITUpdateTestsforNorming.getcmsadminhomepageurl(),DataProviderFactory.getConfig().getNITCMSAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "CMS Admin User is able to login successfully");
			
			//Scroll Up The Page
			Library.scroll(driver, 0, 500);
			NITUpdateTestsforNorming.waitFor(2);
			
			//CMS admin user navigates to Add Norming page
			NITCMSNormingandTestCategories.clickAddNorming();
			NITUpdateTestsforNorming.waitFor(5);
			test.log(LogStatus.INFO, "CMS Admin User navigates to Add Norming page");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			//Selects Program of Study for the test
			NITCMSNormingandTestCategories.selectProgramofStudy(programofstudy);
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User selects program of study for the IT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			
			//Selecting the test type
			NITCMSNormingandTestCategories.selectTestType();
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User enters IT Test Type");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
						
			//Configuring the test names
			ITTestName=programofstudy + " IT " + testname;
						
			//Selecting the test name
			NITCMSNormingandTestCategories.selectTestName(ITTestName);
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin User selects IT test");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
						
			//Selecting the ClientNeeds category for the test
			NITCMSNormingandTestCategories.selectCategory("ClientNeeds");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Client Needs");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Setting the Overall norming data for the test
			NITCMSNormingandTestCategories.setOverallNorming();
			test.log(LogStatus.PASS,"Adding overall norming for the test");
			
			//Getting the number of rows after selecting the category
			int rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Client Needs");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Client Needs successfully");
			
			//Selecting the NursingProcess category for the test
			NITCMSNormingandTestCategories.selectCategory("NursingProcess");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Nursing Process");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Nursing Process");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Nursing Process successfully");
			
			//Selecting the CriticalThinking category for the test
			NITCMSNormingandTestCategories.selectCategory("CriticalThinking");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Critical Thinking");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Critical Thinking");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Critical Thinking successfully");
			
			//Selecting the ClinicalConcept category for the test
			NITCMSNormingandTestCategories.selectCategory("ClinicalConcept");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Clinical Concepts");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Clinical Concepts");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Clinical Concepts successfully");
			
			//Selecting the Demographic category for the test
			NITCMSNormingandTestCategories.selectCategory("Demographic");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Demographic");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Demographic");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Demographic successfully");
			
			//Selecting the CognitiveLevel category for the test
			NITCMSNormingandTestCategories.selectCategory("CognitiveLevel");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Cognitive Level");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Cognitive Level");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Cognitive Level successfully");
			
			//Selecting the SpecialtyArea category for the test
			NITCMSNormingandTestCategories.selectCategory("SpecialtyArea");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Speciality Area");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Speciality Area");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Speciality Area successfully");
			
			//Selecting the Systems category for the test
			NITCMSNormingandTestCategories.selectCategory("Systems");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Systems");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Systems");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Systems successfully");
			
			//Selecting the LevelOfDifficulty category for the test
			NITCMSNormingandTestCategories.selectCategory("LevelOfDifficulty");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Level of Difficulty");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Level of Difficulty");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Level of Difficulty successfully");
			
			//Selecting the ClientNeedCategory category for the test
			NITCMSNormingandTestCategories.selectCategory("ClientNeedCategory");
			NITUpdateTestsforNorming.waitFor(3);
			test.log(LogStatus.INFO, "CMS Admin selects the category Client Needs Category");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Client Needs Category");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Client Needs Category successfully");
			
			
			if (programofstudy.equalsIgnoreCase("RN"))
			{
			
			//Selecting the AccreditationCategories category for the test
			NITCMSNormingandTestCategories.selectCategory("AccreditationCategories");
			NITUpdateTestsforNorming.waitFor(5);
			test.log(LogStatus.INFO, "CMS Admin selects the category Accrediation Categories");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Accrediation Categories");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Accrediation Categories successfully");
			
			//Selecting the QSENKSACompetencies category for the test
			NITCMSNormingandTestCategories.selectCategory("QSENKSACompetencies");
			NITUpdateTestsforNorming.waitFor(5);
			test.log(LogStatus.INFO, "CMS Admin selects the category QSENKSA Compentencies");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of QSENKSA Compentencies");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of QSENKSA Competencies successfully");
			}
			
			//Selecting the Concepts category for the test
			NITCMSNormingandTestCategories.selectCategory("Concepts");
			NITUpdateTestsforNorming.waitFor(4);
			test.log(LogStatus.INFO, "CMS Admin selects the category Concepts");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Concepts");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Concepts successfully");
			
			//Selecting the DecisionTree category for the test
			NITCMSNormingandTestCategories.selectCategory("DecisionTree");
			NITUpdateTestsforNorming.waitFor(4);
			test.log(LogStatus.INFO, "CMS Admin selects the category Decision Tree");
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));				
			
			//Getting the number of rows after selecting the category
			rows = NITCMSNormingandTestCategories.rowCount();
			
			//Entering the norming data for all the sub categories
			NITCMSNormingandTestCategories.enterNormingData(rows);
			test.log(LogStatus.INFO,"Setting norming data for all sub categories of Decision Tree");
			
			//Clicking the Save button
			NITCMSNormingandTestCategories.clickSave();
			NITUpdateTestsforNorming.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"))));			
			test.log(LogStatus.PASS,"Saving norming data for all available sub categories of Decision Tree successfully");
			
			//Navigating to the admin home page
			NITCMSNormingandTestCategories.clickMainMenu();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Navigating to the home page");
			
			//Scroll Down Page
			Library.scroll(driver, 0, 500);
			NITUpdateTestsforNorming.waitFor(2);
			
			//Clicking Edit link of Test Categories
			NITCMSNormingandTestCategories.clickEditTestCategories();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Navigating to the Edit Categories page");
			
			//Selecting the program of study 
			NITCMSNormingandTestCategories.selectTestCategoriesProgofStudy(programofstudy);
			NITUpdateTestsforNorming.waitFor(10);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting Program of Study on Test Categories page");
			
			//Selecting the required test type
			NITCMSNormingandTestCategories.selectTestCategoriesTestType();
			NITUpdateTestsforNorming.waitFor(10);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting Test type on Test Categories page");
			
			//Select the required test
			NITCMSNormingandTestCategories.selectTestCategoriesTest(ITTestName);
			NITUpdateTestsforNorming.waitFor(10);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting the required Test on Test Categories page");
			
			//Select all the categories available for the test
			NITCMSNormingandTestCategories.selectTestCategories();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting all the categories displayed for the selected test");
			
			//Save the categories selected
			NITCMSNormingandTestCategories.clickTestCategoriesAssign();
			NITUpdateTestsforNorming.waitFor(10);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.PASS,"Saving the categories selected for the test");
			
			//Navigating to the admin home page
			NITCMSNormingandTestCategories.clickMainMenu();
			NITUpdateTestsforNorming.waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Navigating to the home page");
			
			//Scroll Down Page
			Library.scroll(driver, 0, 500);
			NITUpdateTestsforNorming.waitFor(3);
			
			//Navigating to the Add Probability page
			NITCMSNormingandTestCategories.clickViewEditProbability();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Navigating to the add probability page");
			
			//Selecting the program of study
			NITCMSNormingandTestCategories.selectProbabilityProgofStudy(programofstudy);
			NITUpdateTestsforNorming.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting the program of study for adding Probability");
			
			//Selecting the test type 
			NITCMSNormingandTestCategories.selectProbabilityTestType();
			NITUpdateTestsforNorming.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting the test type for adding Probability");
			
			//Selecting the test
			NITCMSNormingandTestCategories.selectProbabilityTest(ITTestName);
			NITUpdateTestsforNorming.waitFor(4);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.INFO,"Selecting the test name for adding Probability");
			
			//Adding Probability for the test
			NITCMSNormingandTestCategories.addProbabilityTest();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			test.log(LogStatus.PASS,"Adding probability for the test successfully");
			
			//Logout of the application
			NITUpdateTestsforNorming.clickLogout();						
			
		}	
}