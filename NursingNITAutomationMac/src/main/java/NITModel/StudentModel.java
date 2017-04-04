package NITModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utility.Library;

/**
 * @author LRamaswamy
 *
 */
public class StudentModel {

	private WebDriver driver;

	public StudentModel(WebDriver driver) {

		this.driver = driver;

	}
	
	public void selectProgramOfStudy(String pname) {

		WebElement programOfStudy = driver
				.findElement(By
						.xpath(".//select[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"));
		/*
		 * Select dropdown = new Select(programOfStudy);
		 * dropdown.selectByVisibleText(pname);
		 */
		programOfStudy.sendKeys(pname);
	}
	
	public void linkClick() {
		
		WebElement linkClick = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkViewUserList']"));
		
		linkClick.click();
	}
	
	public void searchStud(String uname) {

		WebElement searchStud = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"));
		searchStud.clear();
		Library.highLightElement(driver, searchStud).sendKeys(uname);

	}

	public void btnSearch() {

		WebElement searchStudBtn = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_searchButton']"));
		Library.highLightElement(driver, searchStudBtn).click();

	}
	
	public String validateStudLbl() {

		WebElement studLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers']/tbody/tr[2]/td[2]"));
								
		return studLbl.getText();

	}
	

	public void clickEditLink() {

		WebElement clickEditLnk = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridUsers']/tbody/tr[2]/td[7]/a"));
		clickEditLnk.click();
	}
	
	public void clickUpdatedEditLink() {

		WebElement clickEditLnk = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbEdit']"));
		clickEditLnk.click();
	}

	public void editStudEmail(String editedStudEmail) {

		WebElement editStudEmail = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtEmail']"));
		editStudEmail.clear();
		editStudEmail.sendKeys(editedStudEmail);

	}


	public void btnSave() {
		WebElement btnSave = driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btSave']"));
		btnSave.click();
	}

	
	public String validateEditedStudLbl() {

		WebElement StudLbl = driver
				.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblEmail']"));

		return StudLbl.getText();
	}
}

