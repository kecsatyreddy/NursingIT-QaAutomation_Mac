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
public class NewStudentModel {

	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion = new SoftAssert();
	ReadConfig readConfigfile = new ReadConfig();

	public NewStudentModel(WebDriver driver) {

		this.driver = driver;

	}
	
	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By
				.xpath(".//select[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"));
		
		   Select dropdown = new Select(programOfStudy);
		   dropdown.selectByVisibleText(pname);
		 
	//	programOfStudy.sendKeys(pname);
	}
	
	public void verifyTitle() {
		
		WebElement linkClick = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblTitle']"));
		
		System.out.println(linkClick.getText());
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
	

	public void enterProfileId(String profileId) {
		WebElement enterProfileId = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtKaplanID']"));
		enterProfileId.clear();
		Library.highLightElement(driver, enterProfileId).sendKeys(profileId);
		
	}
	
	public void selectInstituition(String Iname) {

		WebElement IName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddInstitution']"));
		IName.sendKeys(Iname);
	}
	
	public void selectCohort(String Cname) {

		WebElement selectCohort = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddCohort']"));
		selectCohort.sendKeys(Cname);
	}
	
	

	public void enterEmail(String email) {

		WebElement enterEmail = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtEmail']"));
		enterEmail.clear();
		Library.highLightElement(driver, enterEmail).sendKeys(email);

	}

	
	public void clickSaveStud() {

		WebElement clickSaveStud = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btSave']"));
		Library.highLightElement(driver, clickSaveStud).click();

	}
	
	public String verifySuccessMessage() {

		WebElement SuccessMessage = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblSuccessMsg']"));
		return SuccessMessage.getText();
	}

	public String validateStudLbl() {

		WebElement studLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblUserName']"));
		return studLbl.getText();
	}
	
}