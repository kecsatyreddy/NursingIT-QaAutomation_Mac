package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.ProgramModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class ProgramController extends BaseClass {
	
	WebDriver driver;
	public LoginPageModel NITloginPage;
	public ProgramModel NITViewEditProgram;

	public ProgramController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITViewEditProgram=new ProgramModel(driver);

	}

	public void Program(String uname, String pwd, String textRNPN, String pgmname,
						String pgmdesc, String pgmname_edited, String pgmdesc_edited
			) throws InterruptedException {

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

				
		NITViewEditProgram.clickAddProgram();
		test.log(LogStatus.INFO, "Add Program clicked...");

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
		NITViewEditProgram.selectProgramOfStudy(textRNPN);
		test.log(LogStatus.INFO, "Program Of Study  entered....");

		NITViewEditProgram.enterprogramName(pgmname);
		test.log(LogStatus.INFO, "Program name entered...");

		NITViewEditProgram.enterprogramDesc(pgmdesc);
		test.log(LogStatus.INFO, "Program description entered...");

		NITViewEditProgram.clickSaveProgram();
		test.log(LogStatus.INFO, "Clicked on Save...");

	//	Thread.sleep(3000);
		Assert.assertEquals("Program successfully updated",NITViewEditProgram.verifySuccessMessage());
		test.log(LogStatus.PASS,"Cohort successfully created: "+pgmname);

	
		NITViewEditProgram.clickEditProgram();
		test.log(LogStatus.INFO,"Clicking on Edit Program Name ");
		
		NITViewEditProgram.enterprogramName(pgmname_edited);
		test.log(LogStatus.INFO, "Program name edited...");
		
		NITViewEditProgram.enterprogramDesc(pgmdesc_edited);
		test.log(LogStatus.INFO, "Program description edited...");

		NITViewEditProgram.clickSaveProgram();
		test.log(LogStatus.INFO, "Clicked on Save...");
		
	//	Thread.sleep(3000);
		Assert.assertEquals("Program successfully updated",NITViewEditProgram.verifySuccessMessage());
		test.log(LogStatus.PASS,"Cohort successfully edited: "+pgmname_edited);
		
	}	

}