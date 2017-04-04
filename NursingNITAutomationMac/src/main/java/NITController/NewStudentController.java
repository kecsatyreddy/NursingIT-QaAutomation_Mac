package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.NewStudentModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class NewStudentController extends BaseClass {
	WebDriver driver;

	public LoginPageModel NITloginPage;
	public NewStudentModel NITNewStudent;
	public NewStudentController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITNewStudent = new NewStudentModel(driver);

	}

	
	public void Student(String uname, String pwd, String studuname, String studpwd, String fname, String lname, String profileId, String textRNPN, String Iname, String Cname, String email) throws InterruptedException{

		// login NIT and add a new Admin
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='BtnLogIn']"))));
		NITloginPage.setNITAdminUserName(uname);
		NITloginPage.setNITAdminPwd(pwd);
		NITloginPage.clickAdminLogin();
		Thread.sleep(3000);
		Assert.assertEquals(NITloginPage.getadminhomepageurl(),
				DataProviderFactory.getConfig().getNITAdminHomePageURL(),
				"User is not able to login to site");
		test.log(LogStatus.PASS, "Logged in as admin");
			
		
		driver.get("https://qa-nursing.kaptest.com/Admin/UserEdit.aspx?ActionType=1");
		
		NITNewStudent.verifyTitle();
		

		//enter student info here ...
		
		NITNewStudent.enterUserName(studuname);
		test.log(LogStatus.INFO, "New Stud uname entered....");

		NITNewStudent.enterPwd(studpwd);
		test.log(LogStatus.INFO, "New Stud Pwd entered...");

		NITNewStudent.enterFirstName(fname);
		test.log(LogStatus.INFO, "New Stud Fname entered...");

		NITNewStudent.enterLastName(lname);
		test.log(LogStatus.INFO, "New Stud Lname entered...");
		
		NITNewStudent.enterProfileId(profileId);
		test.log(LogStatus.INFO, "Profile Id entered...");

		NITNewStudent.selectProgramOfStudy(textRNPN);
		test.log(LogStatus.INFO, "Program Of Study entered...");
		
		Thread.sleep(3000);
		
		NITNewStudent.selectInstituition(Iname);
		test.log(LogStatus.INFO,"Selecting institution name from the dropdown.");
		
		Thread.sleep(3000);
		
		NITNewStudent.selectCohort(Cname);
		test.log(LogStatus.INFO,"Selecting institution name from the dropdown.");
					
		Thread.sleep(3000);
		
		NITNewStudent.enterEmail(email);
		test.log(LogStatus.INFO, "New Stud email entered...");
		
		NITNewStudent.clickSaveStud();
		
		//verifying success msg
		
		Assert.assertEquals("Student successfully updated",NITNewStudent.verifySuccessMessage());
		test.log(LogStatus.INFO, "New Student created successfully...");
			
		Assert.assertEquals(studuname, NITNewStudent.validateStudLbl());
		test.log(LogStatus.PASS, "Able to verify new student created.. "
				+ studuname);
		
			
			
					
	
		
	
	}
	
}

