/**
 * 
 */
package NITModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataProvider.ReadConfig;
import Utility.Library;
import Utility.WaitTool;

/**
 * @author Keerthi Anand
 *
 */
public class ScheduleTestsModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();	
		public ScheduleTestsModel(WebDriver driver){
			this.driver= driver;
			}						
		
		public void clickViewEditProgram(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewProgramList']"), 350);
			WebElement clickViewEditProgram = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewProgramList']"));
			Library.highLightElement(driver, clickViewEditProgram).click();
			}
		
		public void selectProgramofStudy(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"), 350);
			WebElement selectProgramofStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"));
			Library.highLightElement(driver, selectProgramofStudy).sendKeys(programofstudy);
			}
		
		public void searchProgram(String programname){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtsearch']"), 350);
			WebElement enterProgramName = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtsearch']"));
			Library.highLightElement(driver, enterProgramName).sendKeys(programname);
			WebElement searchProgram = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_seabtn']"));
			Library.highLightElement(driver, searchProgram).click();
			}
		
		public void clickProgramTests(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridPrograms']/tbody/tr[2]/td[5]/a"), 350);
			WebElement clickProgramTests = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridPrograms']/tbody/tr[2]/td[5]/a"));
			Library.highLightElement(driver, clickProgramTests).click();
			}
		
		public void selectAssetType(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"), 350);
			WebElement selectAssetType = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
			Library.highLightElement(driver, selectAssetType).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblTitle']"));
			firefoxClick.click();
			}
		
		public void selectAssetGroup(String TestType){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlAssetGroup']"), 350);
			WebElement selectAssetGroup = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlAssetGroup']"));
			Library.highLightElement(driver, selectAssetGroup).sendKeys(TestType);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblTitle']"));
			firefoxClick.click();
			}
		
		public void selectAssetName(String TestName){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlAssetName']"), 350);
			WebElement selectAssetName = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlAssetName']"));
			/*List<WebElement> options = driver.findElements(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlAssetName']/option"));
			for(WebElement option : options)
			{
				System.out.println("The Option is :"+option.getText());
				if(option.getText().equalsIgnoreCase(TestName))
				{
					System.out.println("Matching Is :"+option.getText());
					option.sendKeys(TestName);
					waitFor(5);
					option.click();
					waitFor(5);
					break;
				}
			}*/
			Library.highLightElement(driver, selectAssetName).sendKeys(TestName);
			}
		
		public void clickProgramTestsAdd(){
			WebElement clickProgramTestsAdd = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ibtnAdd']"));
			Library.highLightElement(driver, clickProgramTestsAdd).click();
			}
		
		public String messageProgramTestsAdd(){
			WebElement messageProgramTestsAdd1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblM']"));
			String messageProgramTestsAdd = messageProgramTestsAdd1.getText();
			return messageProgramTestsAdd;
			}
		
		public void clickMainMenu(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"), 350);
			WebElement clickMainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
			Library.highLightElement(driver, clickMainMenu).click();
			}
		
		public void clickViewEditCohort(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewCohortList']"), 250);
			WebElement clickViewEditCohort = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewCohortList']"));
			Library.highLightElement(driver, clickViewEditCohort).click();
			}
		
		public void selectCohrotProgramofStudy(String programofstudy){
			WebElement selectCohrotProgramofStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"));
			Library.highLightElement(driver, selectCohrotProgramofStudy).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[2]/td"));
			firefoxClick.click();
			}
		
		public void searchCohort(String cohortname){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"), 350);
			WebElement enterCohortName = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
			Library.highLightElement(driver, enterCohortName).sendKeys(cohortname);
			WebElement searchCohort = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
			Library.highLightElement(driver, searchCohort).click();
			}
		
		public void clickCohortTests(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridCohorts']/tbody/tr[2]/td[11]/a"), 350);
			WebElement clickCohortTests = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridCohorts']/tbody/tr[2]/td[11]/a"));
			Library.highLightElement(driver, clickCohortTests).click();
			}
		
		public void enterTestDateandTime(String testname){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtTestName']"), 250);
			waitFor(5);
			WebElement enterTestName = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtTestName']"));
			Library.highLightElement(driver, enterTestName).clear();
			Library.highLightElement(driver, enterTestName).sendKeys(testname);
			WebElement clickTestSearch = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ibtnSearch']"));
			Library.highLightElement(driver, clickTestSearch).click();
			waitFor(5);
			new WebDriverWait(driver, 350).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			
			Date date = new Date();
			SimpleDateFormat dd = new SimpleDateFormat("MM/dd/yyyy");
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_tbSD']"), 250);
			WebElement enterStartDate = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_tbSD']"));
			Library.highLightElement(driver, enterStartDate).clear();
			Library.highLightElement(driver, enterStartDate).sendKeys(dd.format(date));
			
			SimpleDateFormat dd1 = new SimpleDateFormat("dd/MM/yyyy");
			String enddate1[]=dd1.format(date).split("/",3);
			int enddate2=Integer.parseInt(enddate1[0]);
			enddate2=enddate2+1;
			String endate3 = enddate1[1]+"/"+enddate2+"/"+enddate1[2];
			
			SimpleDateFormat tt = new SimpleDateFormat("HH:mm:ss");
			System.out.println(tt.format(date));
			String time1=tt.format(date).substring(0,2);
			System.out.println(time1);
			int time2=Integer.parseInt(time1);
			
			if (time2==12){			
				WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_S']"), 250);
				WebElement enterAMPM = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_S']"));
				Library.highLightElement(driver, enterAMPM).sendKeys("PM");
			}
			
			if (time2>12){
				time2=time2-12;
				WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_S']"), 250);
				WebElement enterAMPM = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_S']"));
				Library.highLightElement(driver, enterAMPM).sendKeys("PM");
			}
			
			if (time2==0){
				time2=12;
			}
			
			String time3 = time2+"";
			
			if (time2==1){				
			}
			
			else{
				WebElement enterStartTime = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddTime_S']"));
				Library.highLightElement(driver, enterStartTime).sendKeys(time3);				
			}			
			
			WebElement enterEndDate = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_tbED']"));
			Library.highLightElement(driver, enterEndDate).clear();
			
			int time4=Integer.parseInt(time1);
			int time5=time4+8;
			
			if (time5<12){				
				Library.highLightElement(driver, enterEndDate).sendKeys(dd.format(date));
			}
			
			if (time5==12){				
				Library.highLightElement(driver, enterEndDate).sendKeys(dd.format(date));
				WebElement enterAMPM = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_E']"));
				Library.highLightElement(driver, enterAMPM).sendKeys("PM");
			}
			
			if (time5>12 && time5<24){
				time5=time5-12;				
				Library.highLightElement(driver, enterEndDate).sendKeys(dd.format(date));
				WebElement enterAMPM = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddAMPM_E']"));
				Library.highLightElement(driver, enterAMPM).sendKeys("PM");
			}
			
			if (time5==24){
				time5=12;				
				Library.highLightElement(driver, enterEndDate).sendKeys(endate3);
			}
			
			if (time5>24){
				time5=time5-24;				
				Library.highLightElement(driver, enterEndDate).sendKeys(endate3);
			}			
			
			String time6 = time5+"";
			WebElement enterEndTime = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests_ctl02_ddTime_E']"));
			if (time6.equalsIgnoreCase("1"))
			{				
				//To make sure we are not selecting any time as the system already selected the time as 1. 
			}
			else
			{
				Library.highLightElement(driver, enterEndTime).sendKeys(time6);
			}
			}
		
		public void clickCohortTestsSave(){
			WaitTool.waitForElementClickable(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests']/tbody/tr[2]/td[7]/a"), 350);
			WebElement clickCohortTestsSave = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvTests']/tbody/tr[2]/td[7]/a"));
			Library.highLightElement(driver, clickCohortTestsSave).click();
			}
		
		public String messageCohortTestsSchedule(){
			WebElement messageCohortTestsSchedule1 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblM']"));
			String messageCohortTestsSchedule = messageCohortTestsSchedule1.getText();
			return messageCohortTestsSchedule;
			}
		
		public void clickAdminSignout(){
			WebElement clicklogout = driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"));
			Library.highLightElement(driver, clicklogout).click();
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
