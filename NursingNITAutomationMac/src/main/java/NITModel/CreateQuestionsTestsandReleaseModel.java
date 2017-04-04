/**
 * 
 */
package NITModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class CreateQuestionsTestsandReleaseModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();
	String[] qids = new String[5];
	String qtext="Test question ";
	String altqtext="Alternate text for test question ";
	String correctoption="Correct";
	String incorrectoption="Incorrect";
	String altcorrectoption="Correct Answer";
	String altincorrectoption="Incorrect Answer";
	String exptext="Test explanation for test question ";
	
		public CreateQuestionsTestsandReleaseModel(WebDriver driver){
			this.driver= driver;
			}
		
		public void setNITCMSUserName(String uName){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtUserName']"));
			Library.highLightElement(driver, setName).sendKeys(uName);
		}
				
		public void setNITCMSPassword(String pwd){
			WebElement setName = driver.findElement(By.xpath(".//*[@id='TxtPassword']"));
			Library.highLightElement(driver, setName).sendKeys(pwd);
		}
			
		public void clickLogin(){
			WebElement clickLogIn = driver.findElement(By.xpath(".//*[@id='BtnLogIn']"));
			Library.highLightElement(driver, clickLogIn);
			clickLogIn.click();
		}
		
		public String getcmsadminhomepageurl() {
			String getcmsadminhomepageurl;
			getcmsadminhomepageurl = driver.getCurrentUrl();
			return getcmsadminhomepageurl;
		}
		
		public void clickAddQuestion(){
			WaitTool.waitForElement(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink19']"), 350);
			WebElement addQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink19']"));
			Library.highLightElement(driver, addQuestion);
			addQuestion.click();
		}
		
		public void questionIDs(String qid){
			String qid1= qid.substring(6);
			qids[0]=qid;
			System.out.println(qids[0]);
			int questid1 = Integer.parseInt(qid1);
			for (int i=1; i<5; i++)
			{
				questid1++;
				String qid2= qid.substring(0,6);
				qids[i]=qid2+questid1;
			}
		}
		
		public void enterQuestionID(String qid){
			WebElement enterQuestionID = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtQuestionID']"));
			Library.highLightElement(driver, enterQuestionID).clear();
			Library.highLightElement(driver, enterQuestionID).sendKeys(qid);
		}
		
		public void selectProgramofStudy(String programofstudy) {
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"), 350);			WebElement selectProStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"));
			Library.highLightElement(driver, selectProStudy).sendKeys(programofstudy);
			driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[9]/td")).click();
		}
		
		public void selectClientNeeds(String programofstudy, int index) {
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddClientNeeds']"), 350);
			WebElement selectClientNeeds = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddClientNeeds']"));
			if (programofstudy.equalsIgnoreCase("RN"))
			{
				Library.highLightElement(driver, selectClientNeeds).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 1));
				driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[9]/td")).click();
			}
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectClientNeeds).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 1));
				driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[9]/td")).click();
			}			
		}
		
		public void selectClientNeedsCategory(String programofstudy, int index){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddClientNeedsCategory']"), 350);
			WebElement selectClientNeedsCat = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddClientNeedsCategory']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectClientNeedsCat).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 2));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectClientNeedsCat).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 2));
			}			
		}
		
		public void selectNursingProcess(String programofstudy, int index){
			WebElement selectNursingProcess = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddNursingProcess']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectNursingProcess).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 3));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectNursingProcess).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 3));
			}			
		}
		
		public void selectLevelofDifficulty(String programofstudy, int index){
			WebElement selectLevelDiffi = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddLevelOfDifficulty']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectLevelDiffi).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 4));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectLevelDiffi).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 4));
			}				
		}
		
		public void selectDemography(String programofstudy, int index){
			WebElement selectDemography = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddDemography']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectDemography).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 5));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectDemography).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 5));
			}				
		}
		
		public void selectCognitiveLevel(String programofstudy, int index){
			WebElement selectCognitiveLevel = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddCognitiveLevel']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectCognitiveLevel).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 6));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectCognitiveLevel).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 6));
			}				
		}
		
		public void selectSpecialityArea(String programofstudy, int index){
			WebElement selectSpecialityArea = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddSpecialityArea']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectSpecialityArea).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 7));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectSpecialityArea).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 7));
			}				
		}
		
		public void selectSystem(String programofstudy, int index){
			WebElement selectSystem = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddSystem']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectSystem).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 8));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectSystem).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 8));
			}				
		}
		
		public void selectCriticalThinking(String programofstudy, int index){
			WebElement selectCriticalThinking = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddCriticalThinking']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectCriticalThinking).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 9));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectCriticalThinking).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 9));
			}				
		}
		
		public void selectClinicalConcepts(String programofstudy, int index){
			WebElement selectClinicalConcepts = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddClinicalConcepts']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectClinicalConcepts).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 10));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectClinicalConcepts).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 10));
			}				
		}
		
		public void selectAccreditationCategories(int index){
			WebElement selectAccreditationCategories = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddAccreditationCategories']"));			
			Library.highLightElement(driver, selectAccreditationCategories).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 11));				
		}
		
		public void selectQSENKSACompetencies(int index){
			WebElement selectQSENKSACompetencies = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddQSENKSACompetencies']"));		
			Library.highLightElement(driver, selectQSENKSACompetencies).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 12));
		}
		
		public void selectConcepts(String programofstudy, int index){
			WebElement selectConcepts = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddConcepts']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectConcepts).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 13));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectConcepts).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 13));
			}				
		}
		
		public void selectDecisionTree(String programofstudy, int index){
			WebElement selectDecisionTree = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucSubCategories_ddDecisionTree']"));
			if (programofstudy.equalsIgnoreCase("RN"))
				Library.highLightElement(driver, selectDecisionTree).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 14));
			else
			{
				index=index+7;
				Library.highLightElement(driver, selectDecisionTree).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 14));
			}				
		}
		
		public void selectQuestionType(int index){
			WebElement selectQuestionType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddQuestionType"));
			Library.highLightElement(driver, selectQuestionType).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 15));
			//Step to make the selection work in Firefox
			/*WebElement firefoxClick = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[9]/td"));
			firefoxClick.click();*/
			driver.findElement(By.xpath(".//*[@id='Table1']/tbody/tr[1]/td/table/tbody/tr[2]/td[1]")).click();	
		}
		
		public void selectRemediation(int index){
			WebElement selectRemediation = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTopicTitle']"));
			Library.highLightElement(driver, selectRemediation).sendKeys(DataProviderFactory.getExcelConfig().getStringData("CMSQuestionsCategories", index, 16));;		
		}
				
		public void createMCSSQuestion(String qid){			
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"), 350);
			WebElement stemMCSS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"));
			String qtext1=qtext+qid;
			Library.highLightElement(driver, stemMCSS).sendKeys(qtext1);
			WebElement altstemMCSS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_txtAltStem']"));
			String altqtext1=altqtext+qid;
			Library.highLightElement(driver, altstemMCSS).sendKeys(altqtext1);
			WebElement ansoptionMCSS1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_1']"));
			Library.highLightElement(driver, ansoptionMCSS1).sendKeys(incorrectoption);
			WebElement ansoptionMCSS2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_2']"));
			Library.highLightElement(driver, ansoptionMCSS2).sendKeys(incorrectoption);
			WebElement ansoptionMCSS3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_3']"));
			Library.highLightElement(driver, ansoptionMCSS3).sendKeys(correctoption);
			WebElement correctoptionMCSS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_RB_3']"));
			Library.highLightElement(driver, correctoptionMCSS).click();
			WebElement ansoptionMCSS4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_4']"));
			Library.highLightElement(driver, ansoptionMCSS4).sendKeys(incorrectoption);
			WebElement altansoptionMCSS1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_1']"));
			Library.highLightElement(driver, altansoptionMCSS1).sendKeys(altincorrectoption);
			WebElement altansoptionMCSS2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_2']"));
			Library.highLightElement(driver, altansoptionMCSS2).sendKeys(altincorrectoption);
			WebElement altansoptionMCSS3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_3']"));
			Library.highLightElement(driver, altansoptionMCSS3).sendKeys(altcorrectoption);
			WebElement altansoptionMCSS4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_4']"));
			Library.highLightElement(driver, altansoptionMCSS4).sendKeys(altincorrectoption);
			WebElement testexpMCSS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtExplanation']"));
			String testexp1=exptext+qid;
			Library.highLightElement(driver, testexpMCSS).sendKeys(testexp1);
			WebElement clickEditQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickEditQuestion).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='btnReturn']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='btnReturn']"), 350);
			WebElement clickReturntoSearch = driver.findElement(By.xpath(".//*[@id='btnReturn']"));
			Library.highLightElement(driver, clickReturntoSearch).click();
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));			
			System.out.println("MCSS Question");
		}
		
		public void createMCMSQuestion(String qid){
			WebElement stemMCMS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"));
			String qtext2=qtext+qid;
			Library.highLightElement(driver, stemMCMS).sendKeys(qtext2);
			WebElement altstemMCMS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_txtAltStem']"));
			String altqtext2=altqtext+qid;
			Library.highLightElement(driver, altstemMCMS).sendKeys(altqtext2);
			WebElement ansoptionMCMS1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_1']"));
			Library.highLightElement(driver, ansoptionMCMS1).sendKeys(incorrectoption);
			WebElement ansoptionMCMS2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_2']"));
			Library.highLightElement(driver, ansoptionMCMS2).sendKeys(correctoption);
			WebElement correctoptionMCMS1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_CH_2']"));
			Library.highLightElement(driver, correctoptionMCMS1).click();
			WebElement ansoptionMCMS3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_3']"));
			Library.highLightElement(driver, ansoptionMCMS3).sendKeys(correctoption);
			WebElement correctoptionMCMS2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_CH_3']"));
			Library.highLightElement(driver, correctoptionMCMS2).click();			
			WebElement ansoptionMCMS4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_4']"));
			Library.highLightElement(driver, ansoptionMCMS4).sendKeys(incorrectoption);
			WebElement altansoptionMCMS1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_1']"));
			Library.highLightElement(driver, altansoptionMCMS1).sendKeys(altincorrectoption);
			WebElement altansoptionMCMS2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_2']"));
			Library.highLightElement(driver, altansoptionMCMS2).sendKeys(altcorrectoption);
			WebElement altansoptionMCMS3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_3']"));
			Library.highLightElement(driver, altansoptionMCMS3).sendKeys(altcorrectoption);
			WebElement altansoptionMCMS4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_4']"));
			Library.highLightElement(driver, altansoptionMCMS4).sendKeys(altincorrectoption);
			WebElement testexpMCMS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtExplanation']"));
			String testexp2=exptext+qid;
			Library.highLightElement(driver, testexpMCMS).sendKeys(testexp2);
			WebElement clickEditQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickEditQuestion).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='btnReturn']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='btnReturn']"), 350);
			WebElement clickReturntoSearch = driver.findElement(By.xpath(".//*[@id='btnReturn']"));
			Library.highLightElement(driver, clickReturntoSearch).click();
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));				
			System.out.println("MCMS Question");
		}
		
		public void createNumericalQuestion(String qid){
			WebElement stemNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"));
			String qtext3=qtext+qid;
			Library.highLightElement(driver, stemNumFill).sendKeys(qtext3);
			WebElement altstemNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_txtAltStem']"));
			String altqtext3=altqtext+qid;
			Library.highLightElement(driver, altstemNumFill).sendKeys(altqtext3);
			WebElement ansoptionNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tx']"));
			Library.highLightElement(driver, ansoptionNumFill).sendKeys("1");
			WebElement altansoptionNumFillUnits = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_m_tx']"));
			Library.highLightElement(driver, altansoptionNumFillUnits).sendKeys("TestUnits");
			WebElement altansoptionNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_Atx']"));
			Library.highLightElement(driver, altansoptionNumFill).sendKeys("1");
			WebElement testexpMCMS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtExplanation']"));
			String testexp3=exptext+qid;
			Library.highLightElement(driver, testexpMCMS).sendKeys(testexp3);
			WebElement clickEditQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickEditQuestion).click();
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='btnReturn']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='btnReturn']"), 350);
			WebElement clickReturntoSearch = driver.findElement(By.xpath(".//*[@id='btnReturn']"));
			Library.highLightElement(driver, clickReturntoSearch).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			System.out.println("Numerical Question");			
		}
		
		public void createHotspotQuestion(String qid){
			WebElement stemHotSpot = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"));
			String qtext4=qtext+qid;
			Library.highLightElement(driver, stemHotSpot).sendKeys(qtext4);
			WebElement altstemHotSpot = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_txtAltStem']"));
			String altqtext4=altqtext+qid;
			Library.highLightElement(driver, altstemHotSpot).sendKeys(altqtext4);
			WebElement ansoptionNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tx']"));
			Library.highLightElement(driver, ansoptionNumFill).sendKeys("206,173.35,210.5,174.5,216.1,182.35,220.6,186.85,219.5,190.25,217.25,192.5,212.75,192.5,206,186.85,203.75,182.35");
			WebElement altansoptionNumFill = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_Atx']"));
			Library.highLightElement(driver, altansoptionNumFill).sendKeys("206,173.35,210.5,174.5,216.1,182.35,220.6,186.85,219.5,190.25,217.25,192.5,212.75,192.5,206,186.85,203.75,182.35");
			WebElement testexpMCMS = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtExplanation']"));
			String testexp4=exptext+qid;
			Library.highLightElement(driver, testexpMCMS).sendKeys(testexp4);
			WebElement testStimulasHotspot = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStimulus']"));
			String testStimulus="NCQ1002.jpg";
			Library.highLightElement(driver, testStimulasHotspot).sendKeys(testStimulus);
			WebElement clickEditQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickEditQuestion).click();
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='btnReturn']"), 350);
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='btnReturn']"))));
			WebElement clickReturntoSearch = driver.findElement(By.xpath(".//*[@id='btnReturn']"));
			Library.highLightElement(driver, clickReturntoSearch).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			System.out.println("Hotspot Question");
		}
		
		public void createDragDropQuestion(String qid){
			WebElement stemDragDrop = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtStem']"));
			String qtext5=qtext+qid;
			Library.highLightElement(driver, stemDragDrop).sendKeys(qtext5);
			WebElement altstemDragDrop = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_txtAltStem']"));
			String altqtext5=altqtext+qid;
			Library.highLightElement(driver, altstemDragDrop).sendKeys(altqtext5);
			WebElement ansoptionDragDrop1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_1']"));
			Library.highLightElement(driver, ansoptionDragDrop1).sendKeys("Four");
			WebElement ansoptionDragDrop11 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_P1']"));
			Library.highLightElement(driver, ansoptionDragDrop11).sendKeys("4");
			WebElement ansoptionDragDrop2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_2']"));
			Library.highLightElement(driver, ansoptionDragDrop2).sendKeys("Three");
			WebElement ansoptionDragDrop21 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_P2']"));
			Library.highLightElement(driver, ansoptionDragDrop21).sendKeys("3");
			WebElement ansoptionDragDrop3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_3']"));
			Library.highLightElement(driver, ansoptionDragDrop3).sendKeys("Two");
			WebElement ansoptionDragDrop31 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_P3']"));
			Library.highLightElement(driver, ansoptionDragDrop31).sendKeys("2");
			WebElement ansoptionDragDrop4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_4']"));
			Library.highLightElement(driver, ansoptionDragDrop4).sendKeys("One");
			WebElement ansoptionDragDrop41 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TB_P4']"));
			Library.highLightElement(driver, ansoptionDragDrop41).sendKeys("1");
			WebElement altansoptionDragDrop1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_1']"));
			Library.highLightElement(driver, altansoptionDragDrop1).sendKeys("Fourth");
			WebElement altansoptionDragDrop2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_2']"));
			Library.highLightElement(driver, altansoptionDragDrop2).sendKeys("Third");
			WebElement altansoptionDragDrop3 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_3']"));
			Library.highLightElement(driver, altansoptionDragDrop3).sendKeys("Second");
			WebElement altansoptionDragDrop4 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAltEditQuestion_ATB_4']"));
			Library.highLightElement(driver, altansoptionDragDrop4).sendKeys("First");
			WebElement testexpDragDrop = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtExplanation']"));
			String testexp5=exptext+qid;
			Library.highLightElement(driver, testexpDragDrop).sendKeys(testexp5);
			WebElement clickEditQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnEdit']"));
			Library.highLightElement(driver, clickEditQuestion).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='btnReturn']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='btnReturn']"), 350);
			WebElement clickReturntoSearch = driver.findElement(By.xpath(".//*[@id='btnReturn']"));
			Library.highLightElement(driver, clickReturntoSearch).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
			//new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
			System.out.println("DragDrop Question");
		}
		
		public void clickAddTest(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink25']"), 350);
			WebElement clickAddTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink25']"));
			Library.highLightElement(driver, clickAddTest).click();
		}
		
		public void selectTestProgramofStudy(String programofstudy)
		{
			/*WebElement selectTestProgramofStudy = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/select"));
			Library.highLightElement(driver, selectTestProgramofStudy).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td"));
			firefoxClick.click();*/
			WaitTool.waitForElementDisplay(driver, By.id("ctl00_ContentPlaceHolder1_ddlProgramofStudy"), 350);
			WebElement selectTestProgramofStudy = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlProgramofStudy"));
			Library.highLightElement(driver, selectTestProgramofStudy).sendKeys(programofstudy);		
			driver.findElement(By.xpath("//*[@id='cFormHolder']/tbody/tr[2]/td")).click();
		}
		
		public void enterTestName(String testname){
			WaitTool.waitForElementDisplay(driver, By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtTestName']"), 350);
			WebElement enterTestName = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtTestName']"));
			Library.highLightElement(driver, enterTestName).sendKeys(testname);
		}
		
		public void selectTestType(String testtype){
			//ctl00_ContentPlaceHolder1_ddProducts
			/*WebElement selectTestType = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/table/tbody/tr/td[1]/select"));
			Library.highLightElement(driver, selectTestType).sendKeys(testtype);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[2]/td"));
			firefoxClick.click();*/
			
			/*WebElement selectTestType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddProducts"));
			Library.highLightElement(driver, selectTestType);
			new Select(selectTestType).selectByVisibleText(testtype);*/
			WebElement selectTestType = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddProducts"));
			Library.highLightElement(driver, selectTestType).sendKeys(testtype);		
			driver.findElement(By.xpath("//*[@id='cFormHolder']/tbody/tr[2]/td")).click();
		}
		
		public void clickSequence(){
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lnkSequence']")));
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lnkSequence']"), 350);
			WebElement clickSequence = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lnkSequence']"));
			Library.highLightElement(driver, clickSequence).click();
		}
		
		public void clickSave(){
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_btnSave")));
			WaitTool.waitForElementDisplay(driver, By.id("ctl00_ContentPlaceHolder1_btnSave"), 350);
			WebElement clickSave = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
			Library.highLightElement(driver, clickSave).click();
		}
		
		public void clickNewTest(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnNewTest']"), 350);
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnNewTest']")));
			WebElement clickNewTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnNewTest']"));
			Library.highLightElement(driver, clickNewTest).click();
		}
		
		public void selectProgramofStudySearchTest(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"), 350);
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']")));
			WebElement selectProgramofStudySearchTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"));
			Library.highLightElement(driver, selectProgramofStudySearchTest).sendKeys(programofstudy);
			driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[2]/td")).click();
			//Step to make the selection work in Firefox
			/*WebElement firefoxClick = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table[1]/tbody/tr[2]/td"));
			firefoxClick.click();
			Library.highLightElement(driver, selectProgramofStudySearchTest);
			new Select(selectProgramofStudySearchTest).selectByVisibleText(programofstudy);*/
			
		}
		
		public void searchTest(String testname){
			WebElement searchTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_TextBox1']"));
			Library.highLightElement(driver, searchTest).sendKeys(testname);
			WebElement clickSearch = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ibtnSearch']"));
			Library.highLightElement(driver, clickSearch).click();
		}
		
		public void clickQuestions(){
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvCustomTest_ctl02_HyperLink1']")));
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvCustomTest_ctl02_HyperLink1']"), 350);
			WebElement clickQuestions = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvCustomTest_ctl02_HyperLink1']"));
			Library.highLightElement(driver, clickQuestions).click();
		}
		
		public void enterQuestionIDSearch(String qid){
			String qid1= qid.substring(0,9);		
			//new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtQuestionID']")));
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtQuestionID']"), 350);
			WebElement enterQID = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtQuestionID']"));
			Library.highLightElement(driver, enterQID).sendKeys(qid1);
		}
		
		public void searchAddQuestions(){		
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSearch']"), 350);
			WebElement clickSearchQuestion = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSearch']"));
			Library.highLightElement(driver, clickSearchQuestion).click();			
		}
		
		public void clickAddQuestions(){
			for (int i=1; i<=5; i++){
				try
				{
				new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbSelectedQuestions']/option[1]")));
				WebElement clickQuestionID = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbSelectedQuestions']/option[1]"));
				Library.highLightElement(driver, clickQuestionID).click();
				Thread.sleep(3000);
				WebElement clickAddQuestions = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnAddQuestions']"));
				Library.highLightElement(driver, clickAddQuestions).click();
				Thread.sleep(3000);
				new WebDriverWait(driver, 30l).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}							
		}
		
		public void clickDoneQuestions(){
		//	new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDone']")));
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDone']"), 350);
			WebElement clickDoneQuestions = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDone']"));
			Library.highLightElement(driver, clickDoneQuestions).click();			
		}
		
		public void clickReleaseButton(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink6']/img")));
			WebElement clickReleaseButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink6']/img"));
			Library.highLightElement(driver, clickReleaseButton).click();			
		}
		
		public void clickReleaseQuestionsCheckbox(){
			new WebDriverWait(driver, 250).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkContent']")));
			WebElement clickReleaseQuestionsCheckbox = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkContent']"));
			Library.highLightElement(driver, clickReleaseQuestionsCheckbox).click();			
		}
		
		public void clickReleaseContinueButton(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnContinue']")));
			WebElement clickReleaseContinueButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnContinue']"));
			Library.highLightElement(driver, clickReleaseContinueButton).click();			
		}						
		
		public void clickQuestionsCheckbox(String qids[]){
			try
			{
			for (int i=0; i<5; i++){
				String qid1=qids[i];
				System.out.println(qid1);
				WaitTool.waitForElementClickable(driver, By.xpath("//*[text()='"+qid1+"']/../td/*[1]"), 500);
				WebElement clickQuestionsCheckbox = driver.findElement(By.xpath("//*[text()='"+qid1+"']/../td/*[1]"));
				Library.highLightElement(driver, clickQuestionsCheckbox).click();
				Thread.sleep(2000);
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void clickReleaseSaveandContinueButton(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnRelease']")));
			WebElement clickReleaseSaveandContinueButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnRelease']"));
			Library.highLightElement(driver, clickReleaseSaveandContinueButton).click();			
		}
		
		public void clickReleasetoProductionButton(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnReleaseToProd']")));
			WebElement clickReleasetoProductionButton = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnReleaseToProd']"));
			Library.highLightElement(driver, clickReleasetoProductionButton).click();			
		}
		
		public String checkSuccessMessage(){
			WebElement checkSuccessMesssage = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblConfirmReleaseToProd']/b"));
			String successMessage=Library.highLightElement(driver, checkSuccessMesssage).getText();
			return successMessage;
		}
		
		public void clickReleaseTestsCheckbox(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkTests']")));
			WebElement clickReleaseTestsCheckbox = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkTests']"));
			Library.highLightElement(driver, clickReleaseTestsCheckbox).click();			
		}
		
		public void clickITTestCheckbox(String ITTestName){
			WebElement clickReleaseTestsCheckbox = driver.findElement(By.xpath("//*[text()='"+ITTestName+"']/../td/*[1]"));
			Library.highLightElement(driver, clickReleaseTestsCheckbox).click();			
		}
		
		public void clickFRTTestCheckbox(String FRTTestName){
			WebElement clickReleaseTestsCheckbox = driver.findElement(By.xpath("//*[text()='"+FRTTestName+"']/../td/*[1]"));
			Library.highLightElement(driver, clickReleaseTestsCheckbox).click();			
		}
		
		public void clickNCLEXTestCheckbox(String NCLEXTestName){
			WebElement clickReleaseTestsCheckbox = driver.findElement(By.xpath("//*[text()='"+NCLEXTestName+"']/../td/*[1]"));
			Library.highLightElement(driver, clickReleaseTestsCheckbox).click();			
		}
		
		public void clickMainMenu(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']")));
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
		}
		
		public void clickLogout(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"), 350);
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
