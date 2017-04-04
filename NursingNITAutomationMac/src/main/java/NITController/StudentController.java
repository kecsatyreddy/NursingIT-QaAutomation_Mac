package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.StudentModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class StudentController extends BaseClass {
	WebDriver driver;

	public LoginPageModel NITloginPage;
	public StudentModel NITViewEditStudent;
	public StudentController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITViewEditStudent = new StudentModel(driver);

	}

	
	public void Student(String uname, String pwd, String pname, String studUName, String editedStudEmail, String orgStudEmail){

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
		test.log(LogStatus.PASS, "Logged in as admin");
		
		
		NITViewEditStudent.linkClick();
		
	/* failing here, need to fix ...
		
		NITViewEditStudent.selectProgramOfStudy(pname);
	
	*/
		NITViewEditStudent.searchStud(studUName);
		NITViewEditStudent.btnSearch();
		Assert.assertEquals(studUName, NITViewEditStudent.validateStudLbl());
		test.log(LogStatus.PASS, "Able to search the student from excel.. "
				+ studUName);
		
		//Editing the Stud Details ...
		NITViewEditStudent.clickEditLink();
		test.log(LogStatus.INFO, "Clicking on Edit link of the Stud:  "+studUName);
		
		//Editing the student email
		NITViewEditStudent.editStudEmail(editedStudEmail);
		NITViewEditStudent.btnSave();
		Assert.assertEquals(editedStudEmail,NITViewEditStudent.validateEditedStudLbl());
			test.log(LogStatus.PASS,"Student email is updated correctly as in excel.. "+editedStudEmail);
			
		NITViewEditStudent.clickUpdatedEditLink();
			
		NITViewEditStudent.editStudEmail(orgStudEmail);
		NITViewEditStudent.btnSave();
		Assert.assertEquals(orgStudEmail,NITViewEditStudent.validateEditedStudLbl());
		test.log(LogStatus.PASS,"Student email is updated back to original.. "+orgStudEmail);
		
			
					
	
		
	
	}
	
}