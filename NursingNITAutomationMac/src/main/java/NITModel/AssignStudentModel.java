package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.Library;

/**
 * @author LRamaswamy
 *
 */
public class AssignStudentModel {

	private WebDriver driver;

	public AssignStudentModel(WebDriver driver) {

		this.driver = driver;

	}
	
	public void linkClick() {
		
	    	WebElement linkClick = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkEditUserListXML']"));
		
		    linkClick.click();
	}
	
	public String studSelected(){
		
		WebElement sutduname = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvStudents']/tbody/tr[2]/td[4]"));
		
		return sutduname.getText();
	}
	
	public void chkboxClick() {
		
    	WebElement chkboxClick = driver.findElement(By
			.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gvStudents_ctl02_chkSelect']"));
	
    	chkboxClick.click();
}
	
	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By.id("ctl00_ContentPlaceHolder1_ddlProgramOfStudy"));
						
		programOfStudy.sendKeys(pname);
	}
	
	
	public void selectInst(String Iname) {

		WebElement selectInst = driver
				.findElement(By.id("ctl00_ContentPlaceHolder1_ddInstitution"));
		
		selectInst.sendKeys(Iname);
		
	}
	
	public void selectCohort(String Cname) {

		WebElement selectCohort = driver
				.findElement(By.id("ctl00_ContentPlaceHolder1_ddCohort"));
		selectCohort.sendKeys(Cname);
		 
		
	}
	

	public void assignClk() {

		WebElement assign = driver
				.findElement(By.id("ctl00_ContentPlaceHolder1_btnAssign"));
		assign.click();
		
	}
	
	public String verifySuccessMessage() {

		WebElement SuccessMessage = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblM']"));
		return SuccessMessage.getText();
	}

	public void clickLinkMainMenu() {

		WebElement LinkMainMenu = driver.findElement(By
				.id("ctl00_ucAdminMainRightMenu_btnMainMenu"));
		Library.highLightElement(driver, LinkMainMenu).click();

	}
	
	public void clickViewEditStud() {

		WebElement ViewEditStud = driver
				.findElement(By
						.id("ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewUserList"));
		Library.highLightElement(driver, ViewEditStud).click();

	}
	
	
	public void enterUname(String Uname) {

		WebElement enterUname = driver
				.findElement(By.id("ctl00_ContentPlaceHolder1_txtSearch"));
		enterUname.sendKeys(Uname);
		 
		
	}
	
	public void clickSearchBtn() {

		WebElement searchBtn = driver.findElement(By
				.id("ctl00_ContentPlaceHolder1_searchButton"));
		Library.highLightElement(driver, searchBtn).click();

	}

	public String validateUname() {

		WebElement SuccessMessage = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers']/tbody/tr[2]/td[2]"));
		return SuccessMessage.getText();
	}

	public String validateInst() {

		WebElement validateInst = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers_ctl02_InstitutionName']"));
		return validateInst.getText();
	}
	
	public String validateCohort() {

		WebElement validateCohort = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers_ctl02_cohortName']"));
		return validateCohort.getText();
	}
	
}
