package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DataProvider.ReadConfig;
import Utility.Library;

import org.openqa.selenium.support.ui.Select;

public class ProgramModel {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	SoftAssert assertion = new SoftAssert();
	ReadConfig readConfigfile = new ReadConfig();

	public ProgramModel(WebDriver driver) {

		this.driver = driver;

	}
	
	

	public void clickAddProgram() {

		WebElement clickAddProgram = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddProgram']"));
		Library.highLightElement(driver, clickAddProgram).click();
		// System.out.println("Clicking on Add Program Link");
	}

	public void selectProgramOfStudy(String textRNPN) {

		WebElement programOfStudy = driver
				.findElement(By
						//.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
						.id("ctl00_ContentPlaceHolder1_ddlProgramOfStudy"));
		 Select dropdown = new Select(programOfStudy);
	//	programOfStudy.sendKeys(textRNPN);
		dropdown.selectByVisibleText(textRNPN);
	}

	public void enterprogramName(String pname) {

		WebElement enterprogramName = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtProgramName']"));
		enterprogramName.clear();
		Library.highLightElement(driver, enterprogramName).sendKeys(pname);
		
	}

	public void enterprogramDesc(String pdesc) {

		WebElement enterprogramdesc = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtProgramD']"));
		enterprogramdesc.clear();
		Library.highLightElement(driver, enterprogramdesc).sendKeys(pdesc);
		
	}

	public void clickSaveProgram() {

		WebElement clickSaveProgram = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_addbtn']"));
		Library.highLightElement(driver, clickSaveProgram).click();
	}

	public String verifySuccessMessage() {

		WebElement SuccessMessage = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblSuccessMsg']"));
		return SuccessMessage.getText();
	}
	
	
	public void clickEditProgram() {

		WebElement clickEditProgram = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lnkEdit']"));
		Library.highLightElement(driver, clickEditProgram).click();
	}
	

}