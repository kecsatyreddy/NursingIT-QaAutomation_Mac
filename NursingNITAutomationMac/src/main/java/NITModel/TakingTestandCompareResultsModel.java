/**
 * 
 */
package NITModel;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
import Utility.Library;
import Utility.WaitTool;

/**
 * @author SMuppidi
 *
 */
public class TakingTestandCompareResultsModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();
	
		public TakingTestandCompareResultsModel(WebDriver driver){
			this.driver= driver;
			}
		
		public void clickITtab(){
			WebElement clickITtab = driver.findElement(By.xpath(".//*[@id='Head11_IbIntegratedTest']"));
			Library.highLightElement(driver, clickITtab).click();
			}
		
		public void clickFRTtab(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='Head11_IbFocusedReview']"), 350);
			WebElement clickFRTtab = driver.findElement(By.xpath(".//*[@id='Head11_IbFocusedReview']"));
			Library.highLightElement(driver, clickFRTtab).click();
			}
		
		public void clickNCLEXlink(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='LinkButton2']"), 350);
			WebElement clickNCLEXlink = driver.findElement(By.xpath(".//*[@id='LinkButton2']"));
			Library.highLightElement(driver, clickNCLEXlink).click();
			}
		
		public void clickNCLEXQTrainer(){
			WebElement clickNCLEXQTrainer = driver.findElement(By.xpath(".//*[@id='Lb21']"));
			Library.highLightElement(driver, clickNCLEXQTrainer).click();
			}
		
		public void clickHomePage(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='topbutton']/a[2]/img"), 350);
			WebElement clickHomePage = driver.findElement(By.xpath(".//*[@id='topbutton']/a[2]/img"));
			Library.highLightElement(driver, clickHomePage).click();
			}
		
		public void clickTaketheTestLink1(String testName)
		{
			for (int i = 2; i < 200; i++) {
				int testNameconf = driver.findElements(By.xpath(".//*[@id='GridViewAllTest']")).size();
				String ilen;
				if (testNameconf > 0) {
					waitFor(3);
					WebElement testNameText = driver.findElement(By.xpath(".//*[@id='GridViewAllTest']/tbody/tr[" +i + "]/td[1]"));
					String testNameVal = testNameText.getText();
					if(testName.equalsIgnoreCase(testNameVal)){
						System.out.println("Test name matched :" +testNameVal);
						if (i<10){
							ilen="0"+i;
						}
						else{
							ilen=i+"";
						}
						WebElement selecttestName = driver.findElement(By.xpath(".//*[@id='GridViewAllTest_ctl"+ilen+"_GridViewAllTestLinkButton']"));
						Library.highLightElement(driver, selecttestName).click();
						break;
					}
				} else {
					System.out.println("Element Not found !!!!");
					break;
				}
			}
		}
		
		public void clickTaketheTestLink(String testName){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[contains(.,'"+testName+"')]/../td[5]/a"), 350);
			WebElement clickTaketheTestLink = driver.findElement(By.xpath(".//*[contains(.,'"+testName+"')]/../td[5]/a"));
			Library.highLightElement(driver, clickTaketheTestLink).click();
		}	
		
		public void clickIAgreeButton()
		{
			ArrayList<WebElement> Agree_Buttons = (ArrayList<WebElement>) driver.findElements(By.id("AcceptHonorCode"));
			for(WebElement agree_button : Agree_Buttons)
			{
				if(agree_button.isDisplayed())
				{
					System.out.println("Agree Button Avialable");
					Library.highLightElement(driver, agree_button).click();
				}else
				{
					System.out.println("Agree Button Not Avialable");
				}
			}
		}
		
		public void answerQuestions()
		{
			int x = 0;
			WebElement questions = driver.findElement(By.xpath(".//*[@id='lblQNumber']"));
			String questionscount1 = questions.getText();
			String questionspart[]= questionscount1.split(" ");
			int questionscount = Integer.parseInt(questionspart[2]);
			for (int i=1; i<=questionscount; i++)
			{	
				try{	
					new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
					if (driver.findElement(By.xpath("//*[@type='text']")).isDisplayed())
					{
						WebElement textField = driver.findElement(By.id("tx"));
						textField.clear();
						Library.highLightElement(driver, textField).sendKeys("1");
						WebElement nextButton = driver.findElement(By.id("btnNext"));
						Library.highLightElement(driver, nextButton).click();
						x++;
						System.out.println(x+" The question type is Numerical Fill In");
					}
				}
				catch(Exception e)
				{
					System.out.println("The question type is not text");
				}
				
				try{
					new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
					if (driver.findElement(By.xpath("//*[@type='radio']")).isDisplayed())
					{
						WebElement textField = driver.findElement(By.xpath(".//*[@id='RB_2']"));
						Library.highLightElement(driver, textField).click();
						WebElement nextButton = driver.findElement(By.id("btnNext"));
						Library.highLightElement(driver, nextButton).click();
						x++;
						System.out.println(x+" The question type is Multi Choice Multi Select");
					}
				}
				catch(Exception e)
				{
					System.out.println("The question type is not multi choice single select");
				}
				
				try{
					new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
					WebElement noofoptions1 = driver.findElement(By.xpath(".//*[@id='sortable1']"));
					String[] noofoptions2 = Library.highLightElement(driver, noofoptions1).getText().split("\n");
					int noofoptions = noofoptions2.length;
					System.out.println(noofoptions);
					
					if (driver.findElement(By.xpath("//*[@class='connectedSortable ui-sortable']")).isDisplayed())
					{
						int j;
						for (j=1; j<= noofoptions; j++)
						{
							waitFor(5);
							WebElement option = driver.findElement(By.xpath(" .//*[@id='sortable1']/li[1]/div"));
							Library.highLightElement(driver, option).click();
							waitFor(5);
							WebElement rightArrow = driver.findElement(By.xpath(".//*[@id='btnRight']"));
							Library.highLightElement(driver, rightArrow).click();							
						}
						WebElement nextButton = driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/div[5]/table/tbody/tr/td[2]/input"));
						Library.highLightElement(driver, nextButton).click();
						x++;
						System.out.println(x+" The question type is Drag and Drop");
					}
				}
				catch(Exception e)
				{
					System.out.println("The question type is not drag and drop");
				}
				
				try{
					new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
					if (driver.findElement(By.xpath("//*[@type='checkbox']")).isDisplayed())
					{
						WebElement option1 = driver.findElement(By.xpath(".//*[@id='CH_1']"));
						Library.highLightElement(driver, option1).click();
						WebElement option2 = driver.findElement(By.xpath(".//*[@id='CH_3']"));
						Library.highLightElement(driver, option2).click();
						WebElement nextButton = driver.findElement(By.id("btnNext"));
						Library.highLightElement(driver, nextButton).click();
						x++;
						System.out.println(x+" The question type is Multi Choice Multi Select");
					}
				}
				catch(Exception e)
				{
					System.out.println("The question type is not multi choice multi select");
				}
				
				try{
					new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='timer']"))));
					if (driver.findElement(By.xpath(".//*[@id='resumeCanvasResponse']")).isDisplayed())
					{
						Robot robot = new Robot();
						Actions builder = new Actions(driver);
						/*int newcoordinates1 = 450;
						int newcoordinates2 = 450;*/
						
						int newcoordinates1 = 50;
						int newcoordinates2 = 50;
						/*robot.mouseMove(newcoordinates1,newcoordinates2); 
						robot.mousePress(InputEvent.BUTTON3_MASK);
						robot.mouseRelease(InputEvent.BUTTON3_MASK);*/
						builder.moveToElement(driver.findElement(By.xpath(".//*[@id='resumeCanvasResponse']"))).moveByOffset(newcoordinates1, newcoordinates2).click().perform();
						waitFor(5);
						WebElement nextButton = driver.findElement(By.id("btnNext"));
						Library.highLightElement(driver, nextButton).click();
						x++;
						System.out.println(x+" The question type is HotSpot");
					}
				}
				catch(Exception e)
				{
					System.out.println("The question type is not hotspot");
				}
			}			
		}
		
		public void clickEndTest(){
			WebElement clickTestEnd = driver.findElement(By.xpath(".//*[@id='ibIntroStart']"));
			Library.highLightElement(driver, clickTestEnd).click();
		}
		
		public String getStudentPercentCorrect(String testName)
		{
			String percentcorrect="";
			int i;
			for (i = 2; i < 200; i++) {
				int testNameconf = driver.findElements(By.xpath(".//*[@id='gvList']")).size();
				if (testNameconf > 0) {
					waitFor(3);
					WebElement testNameText = driver.findElement(By.xpath(".//*[@id='gvList']/tbody/tr[" +i + "]/td[1]"));
					String testNameVal = testNameText.getText();
					if(testName.equalsIgnoreCase(testNameVal)){
						System.out.println("Test name matched :" +testNameVal);
						WebElement percorrect = driver.findElement(By.xpath(".//*[@id='gvList']/tbody/tr[" +i + "]/td[3]"));
						percentcorrect=percorrect.getText();
						break;
					}
				} else {
					System.out.println("Element Not found !!!!");
					break;
				}
			}
			WebElement percorrect = driver.findElement(By.xpath(".//*[@id='gvList']/tbody/tr[" +i + "]/td[3]"));
			percentcorrect=percorrect.getText();
			return percentcorrect;
		}
		
		public void clickTestResults(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='Head11_IbResults']"), 350);
			WebElement clickTestResults = driver.findElement(By.xpath(".//*[@id='Head11_IbResults']"));
			Library.highLightElement(driver, clickTestResults).click();
		}
		
		public void navigateStudentViewEdit()
		{
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewUserList']"), 350);
			WebElement studentvieweditd= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewUserList']"));
			Library.highLightElement(driver, studentvieweditd).click();
		}

		public void selectStudentListProgramofStudy(String programofstudy)
		{
			WebElement selectStudentListProgramofStudy= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"));
			Library.highLightElement(driver, selectStudentListProgramofStudy).sendKeys(programofstudy);
		}
		
		public void searchstudent(String uname)
		{
			WebElement studentsearch= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
			Library.highLightElement(driver, studentsearch).sendKeys(uname);
		}
		
		public void clickstudentsearch()
		{
			WebElement studentsearch= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
			Library.highLightElement(driver, studentsearch).click();
		}
		
		public String getStudentInstitution()
		{
			String StudentInstitutionName;
			WebElement studentins= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers_ctl02_InstitutionName']"));
			StudentInstitutionName=studentins.getText();
			return StudentInstitutionName;
		}
		
		public String getStudentCohort()
		{
			String StudentCohortName;
			WebElement studentcoh= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers_ctl02_cohortName']"));
			StudentCohortName=studentcoh.getText();
			return StudentCohortName;
		}
		
		public void clickeditlink()
		{
			WebElement studentedit= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers']/tbody/tr[2]/td[7]/a"));
			Library.highLightElement(driver, studentedit).click();
		}
		
		public String getStudentFN()
		{
			String StudentFirstName;
			WebElement studentfn= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtFirstName']"));
			StudentFirstName=studentfn.getAttribute("value");
			System.out.println(StudentFirstName);
			return StudentFirstName;
		}
		
		public String getStudentLN()
		{
			String StudentLastName;
			WebElement studentln= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLastName']"));
			StudentLastName=studentln.getAttribute("value");
			System.out.println(StudentLastName);
			return StudentLastName;
		}
		
		public void clickMainMenu()
		{
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement mainmenu= driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, mainmenu).click();
		}
		
		public void navigateStudentReportCard()
		{
			WebElement studentreportcard= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminViewReportsMenu_hyplnkReportStudentReportCard']"));
			driver.navigate().to(studentreportcard.getAttribute("href"));
		}
		
		public void selectStudentProgramofStudy(String programofstudy)
		{
			WebElement selectStudentProgramofStudy= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
			Library.highLightElement(driver, selectStudentProgramofStudy).sendKeys(programofstudy);
		}

		public void selectStudentInstitution(String studentInstitution)
		{
			/*WebElement studentins= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']"));
			Library.highLightElement(driver, studentins).sendKeys(studentInstitution);*/
			Library.highLightElement(driver, driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddInstitution")));
			new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddInstitution"))).selectByVisibleText(studentInstitution);
		}
		
		public void selectTestType()
		{
			WebElement studentins= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbxProducts']"));
			Library.highLightElement(driver, studentins).sendKeys("Integrated Testing");
		}
		
		public void selectTestType(String testtype)
		{
			WebElement studentins= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbxProducts']"));
			Library.highLightElement(driver, studentins).sendKeys(testtype);
		}
				
		public void selectStudentCohort(String studentCohort)
		{
			WebElement studentcoh= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbxCohort']"));
			Library.highLightElement(driver, studentcoh).sendKeys(studentCohort);
		}
		
		public void selectStudentName(String StudentName)
		{
			WebElement studentname= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbxStudent']"));
			Library.highLightElement(driver, studentname).sendKeys(StudentName);
		}
		
		public void selectStudentTest(String testname)
		{
			WebElement studenttest= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbxTests']"));
			Library.highLightElement(driver, studenttest).sendKeys(testname);
		}
		
		public void clickReportSubmit()
		{
			new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")));
			WebElement reportSubmit= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']"));
			Library.highLightElement(driver, reportSubmit).click();
		}
		
		public String getPercentCorrectReport()
		{
			String percentreport;
			WebElement reportpercent= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvResult']/tbody/tr[2]/td[8]"));
			percentreport=reportpercent.getText();
			return percentreport;
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
