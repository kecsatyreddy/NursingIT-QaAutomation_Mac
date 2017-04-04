/**
 * 
 */
package NITModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 * @author Keerthi Anand
 *
 */
public class NormingTestCategoriesProbabilityModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion=new SoftAssert();
	ReadConfig readConfigfile=new ReadConfig();
	
		public NormingTestCategoriesProbabilityModel(WebDriver driver){
			this.driver= driver;
		}
		
		public void clickAddNorming(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink4']"), 350);
			WebElement addNorming = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink4']"));
			Library.highLightElement(driver, addNorming).click();
		}		
		
		public void selectProgramofStudy(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"), 350);
			WebElement selectProgramofStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"));
			Library.highLightElement(driver, selectProgramofStudy).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='content']/tbody/tr[1]/td/table/tbody/tr/td[1]"));
			firefoxClick.click();
		}
		
		public void selectTestType(){
			WebElement selectTestType = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTestType']"));
			Library.highLightElement(driver, selectTestType).sendKeys("Integrated Testing");
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='content']/tbody/tr[1]/td/table/tbody/tr/td[1]"));
			firefoxClick.click();
		}
		
		public void selectTestName(String testName){
			WebElement selectTestName = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTest']"));
			Library.highLightElement(driver, selectTestName).sendKeys(testName);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='content']/tbody/tr[1]/td/table/tbody/tr/td[1]"));
			firefoxClick.click();
		}
		
		public void selectCategory(String category){
			WebElement selectCategory = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddCategory']"));
			Library.highLightElement(driver, selectCategory).sendKeys(category);
		}
		
		public void setOverallNorming(){		
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_B_0']"), 350);
			WebElement setOverallNorming = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_B_0']"));
			setOverallNorming.clear();
			Library.highLightElement(driver, setOverallNorming).sendKeys("80");
		}
		
		public int rowCount(){
			List<WebElement> rowCount = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[7]/td/table/tbody/tr"));
			int rowcount1= rowCount.size();
			return rowcount1;
		}				
		
		public void enterNormingData(int rows){
			int value1=70;
			for (int i=2; i<=rows; i++)
			{
				WebElement enterNormingData = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[7]/td/table/tbody/tr["+i+"]/td[2]/input"));
				enterNormingData.clear();
				Library.highLightElement(driver, enterNormingData).sendKeys(String.valueOf(value1));
				value1=value1+2;
			}
		}
		
		public void clickSave(){
			WebElement clickSave = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSave']"));
			Library.highLightElement(driver, clickSave).click();
		}
		
		public void clickMainMenu(){
			WebElement clickMainMenu = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[1]/td/table/tbody/tr/td[2]/input[1]"));
			Library.highLightElement(driver, clickMainMenu).click();
		}
		
		public void clickEditTestCategories(){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink27']"), 350);
			WebElement clickEditTestCategories = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink27']"));
			Library.highLightElement(driver, clickEditTestCategories).click();
		}
		
		public void selectTestCategoriesProgofStudy(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"), 350);
			WebElement selectTestCategoriesProgofStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
			Library.highLightElement(driver, selectTestCategoriesProgofStudy).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='testCategories']/tbody/tr/td[1]"));
			firefoxClick.click();
			}
		
		public void selectTestCategoriesTestType(){
			WebElement selectTestCategoriesTestType = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTestCategory']"));
			Library.highLightElement(driver, selectTestCategoriesTestType).sendKeys("Integrated Testing");
			waitFor(15);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='testCategories']/tbody/tr/td[1]"));
			firefoxClick.click();
		}
		
		public void selectTestCategoriesTest(String ITTestName){
			WebElement selectTestCategoriesTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTest']"));
			Library.highLightElement(driver, selectTestCategoriesTest).sendKeys(ITTestName);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='testCategories']/tbody/tr/td[1]"));
			firefoxClick.click();
		}
		
		public void selectTestCategories(){
			new WebDriverWait(driver, 350).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/div/table//tbody/tr")));
			List<WebElement> rowCount = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/div/table//tbody/tr"));
			int rowcount1= rowCount.size();
			for (int i=2; i<=rowcount1; i++)
			{
				WebElement selectTestCategories1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/div/table/tbody/tr["+i+"]/td[2]/input"));
				Library.highLightElement(driver, selectTestCategories1).click();
				WebElement selectTestCategories2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/div/table/tbody/tr["+i+"]/td[3]/input"));
				Library.highLightElement(driver, selectTestCategories2).click();				
			}		
		}
		
		public void clickTestCategoriesAssign(){
			WebElement clickTestCategoriesAssign = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnAssign']"));
			Library.highLightElement(driver, clickTestCategoriesAssign).click();
		}
		
		public void clickViewEditProbability(){					
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink3']"), 350);
			WebElement clickViewEditProbability = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminContentManagementMenu_HyperLink3']"));
			Library.highLightElement(driver, clickViewEditProbability).click();
		}
		
		public void selectProbabilityProgofStudy(String programofstudy){
			WaitTool.waitForElementDisplay(driver, By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"), 350);
			WebElement selectProbabilityProgofStudy = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
			Library.highLightElement(driver, selectProbabilityProgofStudy).sendKeys(programofstudy);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[2]/td"));
			firefoxClick.click();
			}
		
		public void selectProbabilityTestType(){
			WebElement selectProbabilityTestType = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProducts']"));
			Library.highLightElement(driver, selectProbabilityTestType).sendKeys("Integrated Testing");
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[2]/td"));
			firefoxClick.click();
			}
		
		public void selectProbabilityTest(String ITTestName){
			WebElement selectProbabilityTest = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTests']"));
			Library.highLightElement(driver, selectProbabilityTest).sendKeys(ITTestName);
			//Step to make the selection work in Firefox
			WebElement firefoxClick = driver.findElement(By.xpath(".//*[@id='cFormHolder']/tbody/tr[2]/td"));
			firefoxClick.click();
			}
		
		public void addProbabilityTest(){
			for (int i=1; i<=5; i++)
			{
				if (i==1)
				{					
					WaitTool.waitForElementDisplay(driver, By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]/input"), 350);
					WebElement addProbabilitycorrect1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]/input"));
					addProbabilitycorrect1.clear();
					Library.highLightElement(driver, addProbabilitycorrect1).sendKeys("1");
					WebElement addProbabilitycorrect2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/input"));
					addProbabilitycorrect2.clear();
					Library.highLightElement(driver, addProbabilitycorrect2).sendKeys("20");
					WebElement addProbabilitycorrect3 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[3]/input"));
					addProbabilitycorrect3.clear();
					Library.highLightElement(driver, addProbabilitycorrect3).sendKeys("20");
					WebElement addProbabilityTest1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[5]/a"));
					Library.highLightElement(driver, addProbabilityTest1).click();
					waitFor(5);
					
				}
				if (i==2)
				{	
					WaitTool.waitForElementDisplay(driver, By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]/input"), 350);
					WebElement addProbabilitycorrect1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[1]/input"));
					addProbabilitycorrect1.clear();
					Library.highLightElement(driver, addProbabilitycorrect1).sendKeys("2");
					WebElement addProbabilitycorrect2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/input"));
					addProbabilitycorrect2.clear();
					Library.highLightElement(driver, addProbabilitycorrect2).sendKeys("40");
					WebElement addProbabilitycorrect3 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[3]/input"));
					addProbabilitycorrect3.clear();
					Library.highLightElement(driver, addProbabilitycorrect3).sendKeys("40");
					WebElement addProbabilityTest1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[5]/a"));
					Library.highLightElement(driver, addProbabilityTest1).click();
					waitFor(5);
				}
				if (i==3)
				{	
					WaitTool.waitForElementDisplay(driver, By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[1]/input"), 350);
					WebElement addProbabilitycorrect1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[1]/input"));
					addProbabilitycorrect1.clear();
					Library.highLightElement(driver, addProbabilitycorrect1).sendKeys("3");
					WebElement addProbabilitycorrect2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[2]/input"));
					addProbabilitycorrect2.clear();
					Library.highLightElement(driver, addProbabilitycorrect2).sendKeys("60");
					WebElement addProbabilitycorrect3 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[3]/input"));
					addProbabilitycorrect3.clear();
					Library.highLightElement(driver, addProbabilitycorrect3).sendKeys("60");
					WebElement addProbabilityTest1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[5]/a"));
					Library.highLightElement(driver, addProbabilityTest1).click();
					waitFor(5);
				}
				if (i==4)
				{	
					WaitTool.waitForElementDisplay(driver, By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[1]/input"), 350);
					WebElement addProbabilitycorrect1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[1]/input"));
					addProbabilitycorrect1.clear();
					Library.highLightElement(driver, addProbabilitycorrect1).sendKeys("4");
					WebElement addProbabilitycorrect2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[2]/input"));
					addProbabilitycorrect2.clear();
					Library.highLightElement(driver, addProbabilitycorrect2).sendKeys("80");
					WebElement addProbabilitycorrect3 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[3]/input"));
					addProbabilitycorrect3.clear();
					Library.highLightElement(driver, addProbabilitycorrect3).sendKeys("80");
					WebElement addProbabilityTest1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[5]/a"));
					Library.highLightElement(driver, addProbabilityTest1).click();
					waitFor(5);
				}
				if (i==5)
				{	
					WaitTool.waitForElementDisplay(driver, By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[1]/input"), 350);
					WebElement addProbabilitycorrect1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[1]/input"));
					addProbabilitycorrect1.clear();
					Library.highLightElement(driver, addProbabilitycorrect1).sendKeys("5");
					WebElement addProbabilitycorrect2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[2]/input"));
					addProbabilitycorrect2.clear();
					Library.highLightElement(driver, addProbabilitycorrect2).sendKeys("100");
					WebElement addProbabilitycorrect3 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[3]/input"));
					addProbabilitycorrect3.clear();
					Library.highLightElement(driver, addProbabilitycorrect3).sendKeys("90");
					WebElement addProbabilityTest1 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[6]/td[5]/a"));
					Library.highLightElement(driver, addProbabilityTest1).click();
					waitFor(5);
				}
			}
			
			}
		public void waitFor(int sec){
			  try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		
	}
