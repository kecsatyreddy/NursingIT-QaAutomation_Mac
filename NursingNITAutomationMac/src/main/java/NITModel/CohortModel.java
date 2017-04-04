package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.ReadConfig;
import Utility.Library;

import org.openqa.selenium.support.ui.Select;

/**
 * @author LRamaswamy
 *
 */
public class CohortModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion = new SoftAssert();
	ReadConfig readConfigfile = new ReadConfig();

	public CohortModel(WebDriver driver) {

		this.driver = driver;

	}

	public void clickAddCohort() {

		WebElement clickViewEditCohort = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddCohort']"));
		Library.highLightElement(driver, clickViewEditCohort).click();

	}

	public void enterCohortName(String cname) {

		WebElement clickNewCohort = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtCohortName']"));
		clickNewCohort.clear();
		Library.highLightElement(driver, clickNewCohort).sendKeys(cname);

	}

	public void searchCohortName(String cname) {

		WebElement clickNewCohort = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
		Library.highLightElement(driver, clickNewCohort).sendKeys(cname);

	}

	public void clickSearchBtn() {

		WebElement searchBtn = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
		Library.highLightElement(driver, searchBtn).click();

	}

	public void clickEditLink() {

		WebElement EditLink = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridCohorts']/tbody/tr[2]/td[9]/a"));

		Library.highLightElement(driver, EditLink).click();

	}

	public void enterClassCode(String clname) {

		WebElement clickClassCode = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDescription']"));
		Library.highLightElement(driver, clickClassCode).sendKeys(clname);

	}

	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgramofStudy']"));

		programOfStudy.sendKeys(pname);

	}

	public void selectInstituition(String Iname) {

		WebElement IName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']"));
		IName.sendKeys(Iname);

		/*
		 * Select Instdropdown = new Select(driver.findElement(By.xpath(
		 * ".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']")));
		 * Instdropdown.selectByVisibleText(Iname);
		 */
	}

	public void selectInstituitionview(String Iname) {

		WebElement IName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbInstitution']"));
		IName.sendKeys(Iname);

		/*
		 * Select Instdropdown = new Select(driver.findElement(By.xpath(
		 * ".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']")));
		 * Instdropdown.selectByVisibleText(Iname);
		 */

	}

	public void enterCohortStartDate(String sdate) {

		WebElement cohortStartDate = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSD']"));
		Library.highLightElement(driver, cohortStartDate).sendKeys(sdate);

	}

	public void enterCohortEndDate(String edate) {

		WebElement cohortEndDate = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtED']"));
		Library.highLightElement(driver, cohortEndDate).sendKeys(edate);

	}

	public void clickStatusRadioBtn() {

		WebElement statusRadioButton = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_RadioButtonList1_0']"));
		if (!statusRadioButton.isSelected())
			statusRadioButton.click();
	}

	public void clickSaveCohort() {

		WebElement clickSaveCohort = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSave']"));
		Library.highLightElement(driver, clickSaveCohort).click();

	}

	public void clickLinkMainMenu() {

		WebElement LinkMainMenu = driver.findElement(By
				.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
		Library.highLightElement(driver, LinkMainMenu).click();

	}

	public String verifySuccessMessage() {

		WebElement SuccessMessage = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblSuccessMsg']"));
		return SuccessMessage.getText();
	}

	public void clickViewEditCohort() {

		WebElement ViewEditCohort = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewCohortList']"));
		Library.highLightElement(driver, ViewEditCohort).click();

	}

	public String validateCohortLbl() {

		WebElement cohortLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridCohorts']/tbody/tr[2]/td[2]"));

		return cohortLbl.getText();
	}

	public void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}