package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.ReadConfig;
import Utility.Library;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author LRamaswamy
 *
 */
public class InstModel {

	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion = new SoftAssert();
	ReadConfig readConfigfile = new ReadConfig();

	public InstModel(WebDriver driver) {

		this.driver = driver;

	}

	public void clickAddInst() {

		WebElement clickAddAdmin = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddInstitution']"));
		Library.highLightElement(driver, clickAddAdmin).click();

	}

	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"));

		programOfStudy.sendKeys(pname);

	}
	
	

	public void enterIName(String Iname) {

		WebElement enterUserName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtName']"));
		enterUserName.clear();
		Library.highLightElement(driver, enterUserName).sendKeys(Iname);

	}

	public void enterDesc(String Idesc) {

		WebElement enterUserName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDescription']"));
		enterUserName.clear();
		Library.highLightElement(driver, enterUserName).sendKeys(Idesc);

	}

	public void enterCname(String centername) {

		WebElement enterCname = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtCenterName']"));
		enterCname.clear();
		Library.highLightElement(driver, enterCname).sendKeys(centername);

	}

	public void enterFId(String facilityid) {

		WebElement enterFId = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtFacility']"));
		enterFId.clear();
		Library.highLightElement(driver, enterFId).sendKeys(facilityid);

	}

	public void enterContactName(String cname) {

		WebElement enterContactName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtContactName']"));
		enterContactName.clear();
		Library.highLightElement(driver, enterContactName).sendKeys(cname);

	}

	public void enterPhno(String pnum) {

		WebElement enterContactName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtPhone']"));
		enterContactName.clear();
		Library.highLightElement(driver, enterContactName).sendKeys(pnum);

	}

	public void enterContactEmail(String email) {

		WebElement enterContactEmail = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtEmail']"));
		enterContactEmail.clear();
		Library.highLightElement(driver, enterContactEmail).sendKeys(email);

	}

	public void enterNurseConsultant(String enterNC) {

		WebElement enterNurseConsultant = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddNurseConsultant']"));

		Select dropdown = new Select(enterNurseConsultant);
		dropdown.selectByVisibleText(enterNC);

	}

	public void enterAccountManager(String enterAM) {

		WebElement enterAccountManager = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddAccountManager']"));

		Select dropdown = new Select(enterAccountManager);
		dropdown.selectByVisibleText(enterAM);

	}

	public void enterDefaultPgm(String enterPgm) {

		WebElement enterDefaultPgm = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddProgram']"));

		enterDefaultPgm.sendKeys(enterPgm);
	}

	public void enterTimeZone(String enterTZone) {

		WebElement enterTimeZone = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddTimeZone']"));
		enterTimeZone.sendKeys(enterTZone);

	}

	public void clickSaveInst() {

		WebElement clickSaveInst = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSave']"));
		Library.highLightElement(driver, clickSaveInst).click();

	}

	public String VerifySuccessMsg() {

		WebElement VerifySuccessMsg = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblSuccessMsg']"));
		return VerifySuccessMsg.getText();
	}

	public void clickLinkMainMenu() {

		WebElement LinkMainMenu = driver.findElement(By
				.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
		Library.highLightElement(driver, LinkMainMenu).click();

	}

	public void clickViewEditInst() {

		WebElement ViewEditInst = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewInstitutionList']"));
		Library.highLightElement(driver, ViewEditInst).click();

	}

	public void searchInstName(String Iname) {

		WebElement searchInstName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
		searchInstName.clear();
		Library.highLightElement(driver, searchInstName).sendKeys(Iname);
	}

	public void clickSearchBtn() {

		WebElement clickSearchBtn = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
		Library.highLightElement(driver, clickSearchBtn).click();

	}

	public String validateInstLbl() {

		WebElement InstLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridInstitutions']/tbody/tr[2]/td[2]"));

		return InstLbl.getText();
	}

	public void clickEditLink() {

		WebElement clickEditLink = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridInstitutions']/tbody/tr[2]/td[7]/a"));
		Library.highLightElement(driver, clickEditLink).click();

	}

	public void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}