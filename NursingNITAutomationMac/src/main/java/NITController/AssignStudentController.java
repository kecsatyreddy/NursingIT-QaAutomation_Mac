package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.AssignStudentModel;
import NITModel.LoginPageModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class AssignStudentController extends BaseClass {
	WebDriver driver;

	public LoginPageModel NITloginPage;
	public AssignStudentModel NITAssignStudent;
	public AssignStudentController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITAssignStudent = new AssignStudentModel(driver);

	}
	
	public void AssignStudent(String uname, String pwd, String textRNPN, String Inst, String Cohort) throws InterruptedException{

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
		
		
		NITAssignStudent.linkClick();
		
	    NITAssignStudent.chkboxClick();
	    
	    String studuname=NITAssignStudent.studSelected();
	    
	    test.log(LogStatus.INFO, "Student to be assigned : "+studuname);
	  	  		
		NITAssignStudent.selectProgramOfStudy(textRNPN);
		
		NITAssignStudent.selectInst(Inst);
		
		NITAssignStudent.selectCohort(Cohort);
		
		NITAssignStudent.assignClk();
		
		Assert.assertEquals("Selected Students have been assigned",NITAssignStudent.verifySuccessMessage());
		test.log(LogStatus.PASS, "Selected Student has been assigned");
		
		NITAssignStudent.clickLinkMainMenu();
		test.log(LogStatus.INFO,"Clicking on main menu");
		
		NITAssignStudent.clickViewEditStud();
		test.log(LogStatus.INFO,"Clicking View Edit Stud Link");
		
		NITAssignStudent.selectProgramOfStudy(textRNPN);
		
		NITAssignStudent.enterUname(studuname);
	
		NITAssignStudent.clickSearchBtn();
		test.log(LogStatus.INFO,"Clicking on search button");
				
		Assert.assertEquals(studuname,NITAssignStudent.validateUname());
		test.log(LogStatus.PASS,"Expected student is assigned: "+studuname);
		
		Assert.assertEquals(Inst,NITAssignStudent.validateInst());
		test.log(LogStatus.PASS,"Expected Inst is assigned: "+Inst);
		
		Assert.assertEquals(Cohort,NITAssignStudent.validateCohort());
		test.log(LogStatus.PASS,"Expected Cohort is assigned: "+Cohort);
		
	
		
	}
}