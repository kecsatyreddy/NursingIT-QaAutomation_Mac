package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.AdminModel;
import NITModel.CohortModel;
import NITModel.LoginPageModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class AdminController extends BaseClass {
	WebDriver driver;

	public LoginPageModel NITloginPage;
	public AdminModel NITViewEditAdmin;
	public CohortModel NITViewEditCohort;

	public AdminController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITViewEditAdmin = new AdminModel(driver);

	}

	public void Admin(String uname, String pwd, String newadminuname,
			String newadminpwd, String newadminfname, String newadminlname,
			String newadminemail, String newadminlevel, String canupload,
			String textRNPN, String editedadminfname) {

		// login NIT and add a new Admin
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='BtnLogIn']"))));
		NITloginPage.setNITAdminUserName(uname);
		NITloginPage.setNITAdminPwd(pwd);
		NITloginPage.clickAdminLogin();

		Assert.assertEquals(NITloginPage.getadminhomepageurl(),
				DataProviderFactory.getConfig().getNITAdminHomePageURL(),
				"User is not able to login to site");
		test.log(LogStatus.PASS, "Admin User is able to login successfully");

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddAdmin']"))));
		NITViewEditAdmin.clickAddAdmin();
		test.log(LogStatus.INFO, "Add Admin clicked...");

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
		NITViewEditAdmin.enterUserName(newadminuname);
		test.log(LogStatus.INFO, "New Admin uname entered....");

		NITViewEditAdmin.enterPwd(newadminpwd);
		test.log(LogStatus.INFO, "New Admin Pwd entered...");

		NITViewEditAdmin.enterFirstName(newadminfname);
		test.log(LogStatus.INFO, "New Admin fname entered...");

		NITViewEditAdmin.enterLastName(newadminlname);
		test.log(LogStatus.INFO, "New Admin lname entered...");

		NITViewEditAdmin.enterEmail(newadminemail);
		test.log(LogStatus.INFO, "New Admin email entered...");

		NITViewEditAdmin.enterLevel(newadminlevel);
		test.log(LogStatus.INFO, "New Admin level selected...");

		NITViewEditAdmin.selectcanupload(canupload);

		NITViewEditAdmin.clickSaveAdmin();

		// //////////No success msg to validate, using the 'Edit' link as
		// validation upon successful creation

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lbEdit']"))));
		test.log(LogStatus.PASS, "New Admin created successfully "
				+ newadminuname);

		NITViewEditAdmin.clickLinkMainMenu();
		test.log(LogStatus.INFO, "Clicking on main menu");

		NITViewEditAdmin.clickEditAdmin();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));

		NITViewEditAdmin.selectProgramOfStudy(textRNPN);

		NITViewEditAdmin.searchAdmin(newadminemail);
		NITViewEditAdmin.adminBtnClick();
		NITViewEditAdmin.waitFor(2);
		Assert.assertEquals(newadminuname, NITViewEditAdmin.validateAdminLbl());
		test.log(LogStatus.PASS, "Able to search newly created Admin. "
				+ newadminuname);

		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridAdmins']/tbody/tr[2]/td[6]/a"))));
		NITViewEditAdmin.clickEditLink();
		test.log(LogStatus.INFO, "Clicking on Edit link of the searched Admin");

		NITViewEditAdmin.editAdminfname(editedadminfname);
		Assert.assertEquals(editedadminfname,
				NITViewEditAdmin.validateEditedAdminLbl());
		// test.log(LogStatus.PASS,"Updating Admin FName  "+editedadminfname);

		NITViewEditAdmin.btnSave();

		// test.log(LogStatus.PASS,
		// "Able to edit admin details successfully.. "+editedadminfname);

	}

}
