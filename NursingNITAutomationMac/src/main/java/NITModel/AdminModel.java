package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataProvider.ReadConfig;
import Utility.Library;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author LRamaswamy
 *
 */
public class AdminModel {

	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion = new SoftAssert();
	ReadConfig readConfigfile = new ReadConfig();

	public AdminModel(WebDriver driver) {

		this.driver = driver;

	}

	public void clickAddAdmin() {

		WebElement clickAddAdmin = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddAdmin']"));
		Library.highLightElement(driver, clickAddAdmin).click();

	}

	public void enterUserName(String uname) {

		WebElement enterUserName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtUserName']"));
		enterUserName.clear();
		Library.highLightElement(driver, enterUserName).sendKeys(uname);

	}

	public void enterPwd(String pwd) {

		WebElement enterPwd = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtPassword']"));

		enterPwd.clear();
		Library.highLightElement(driver, enterPwd).sendKeys(pwd);

	}

	public void enterFirstName(String fname) {

		WebElement enterFirstName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtFirstName']"));
		enterFirstName.clear();
		Library.highLightElement(driver, enterFirstName).sendKeys(fname);
	}

	public void enterLastName(String lname) {

		WebElement enterLastName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtLastName']"));
		enterLastName.clear();
		Library.highLightElement(driver, enterLastName).sendKeys(lname);

	}

	public void enterEmail(String email) {

		WebElement enterEmail = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtEmail']"));
		enterEmail.clear();
		Library.highLightElement(driver, enterEmail).sendKeys(email);

	}

	public void enterLevel(String level) {

		WebElement selectlevel = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddLevel']"));
		/*
		 * Select dropdown = new Select(selectlevel);
		 * dropdown.selectByVisibleText(level);
		 */
		selectlevel.sendKeys(level);

	}

	public void selectcanupload(String canupload) {

		WebElement selectlevel = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_chkAbleToUpload']"));
		if (canupload.equalsIgnoreCase("Y")) {
			if (!selectlevel.isSelected()) {
				selectlevel.click();
			}
		}

	}

	public void clickSaveAdmin() {

		WebElement clickSaveAdmin = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ibtnSave']"));
		Library.highLightElement(driver, clickSaveAdmin).click();

	}

	public void clickLinkMainMenu() {

		WebElement LinkMainMenu = driver.findElement(By
				.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnMainMenu']"));
		Library.highLightElement(driver, LinkMainMenu).click();

	}

	public void clickEditAdmin() {

		WebElement LinkMainMenu = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewAdminList']"));
		Library.highLightElement(driver, LinkMainMenu).click();

	}

	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
		/*
		 * Select dropdown = new Select(programOfStudy);
		 * dropdown.selectByVisibleText(pname);
		 */
		programOfStudy.sendKeys(pname);
	}

	public void searchAdmin(String email) {

		WebElement searchAdmin = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
		searchAdmin.clear();
		Library.highLightElement(driver, searchAdmin).sendKeys(email);

	}

	public void adminBtnClick() {

		WebElement searchAdminBtn = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
		Library.highLightElement(driver, searchAdminBtn).click();

	}

	public String validateAdminLbl() {

		WebElement adminLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridAdmins']/tbody/tr[2]/td[4]"));
		return adminLbl.getText();

	}

	public String validateEditedAdminLbl() {

		WebElement adminLbl = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtFirstName']"));
		System.out
				.println("What is returned in getText: " + adminLbl.getText());
		System.out.println("What is returned in Value: "
				+ adminLbl.getAttribute("value"));
		return adminLbl.getAttribute("value");

	}

	public void editAdminfname(String editedadminfname) {

		WebElement editfname = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtFirstName']"));
		editfname.clear();
		editfname.sendKeys(editedadminfname);

	}

	public void clickEditLink() {

		WebElement clickEditLnk = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridAdmins']/tbody/tr[2]/td[6]/a"));
		clickEditLnk.click();
	}

	public void btnSave() {
		WebElement btnSave = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ibtnSave']"));
		btnSave.click();
	}

	public void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
