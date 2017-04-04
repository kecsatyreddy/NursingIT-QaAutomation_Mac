package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import NITModel.InstModel;
import Utility.BaseClass;

/**
 * @author LRamaswamy
 *
 */
public class InstController extends BaseClass {
	WebDriver driver;

	public LoginPageModel NITloginPage;
	public InstModel NITViewEditInst;
	

	public InstController(WebDriver driver) {

		this.driver = driver;
		NITloginPage = new LoginPageModel(driver);
		NITViewEditInst = new InstModel(driver);

	}

	public void Inst(String uname, String pwd, String textRNPN,
			String Iname, String Idesc, String centername,
			String facilityid, String contactname, String phno,
			String contactemail, String enterNC, String enterAM,
			String enterPgm, String enterTZone, String newIname) {

		// login NIT and add a new Inst
		
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='BtnLogIn']"))));
		NITloginPage.setNITAdminUserName(uname);
		NITloginPage.setNITAdminPwd(pwd);
		NITloginPage.clickAdminLogin();
		
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(DataProviderFactory.getConfig().getNITAdminHomePageURL()));
		Assert.assertEquals(NITloginPage.getadminhomepageurl(),
				DataProviderFactory.getConfig().getNITAdminHomePageURL(),
				"User is not able to login to site");
		test.log(LogStatus.PASS, "Admin User is able to login successfully");
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ucAdminAccountMenu_hyplnkAddInstitution']"))));

		NITViewEditInst.clickAddInst();
		test.log(LogStatus.INFO, "Add Admin clicked...");

		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By
						.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnSave']"))));
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramOfStudy']"))));
		NITViewEditInst.selectProgramOfStudy(textRNPN);
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtName']"))));
		NITViewEditInst.enterIName(Iname);
		test.log(LogStatus.INFO, "Inst name entered....");
		
		NITViewEditInst.enterDesc(Idesc);
		test.log(LogStatus.INFO, "Inst desc entered....");

		
		NITViewEditInst.enterCname(centername);
		test.log(LogStatus.INFO, "Center name entered....");


		NITViewEditInst.enterFId(facilityid);
		test.log(LogStatus.INFO, "Facility Id entered...");
		
		NITViewEditInst.enterContactName(contactname);
		test.log(LogStatus.INFO, "Contact name entered...");

		NITViewEditInst.enterPhno(phno);
		test.log(LogStatus.INFO, "Phone No entered...");

		NITViewEditInst.enterContactEmail(contactemail);
		test.log(LogStatus.INFO, "Contact Email entered...");
		
		NITViewEditInst.enterNurseConsultant(enterNC);
		test.log(LogStatus.INFO, "Nurse Consultant entered...");
		
		NITViewEditInst.enterAccountManager(enterAM);
		test.log(LogStatus.INFO, "Account Manager entered...");
		
		NITViewEditInst.enterDefaultPgm(enterPgm);
		test.log(LogStatus.INFO, "Default Program entered...");
		
		NITViewEditInst.enterTimeZone(enterTZone);
		test.log(LogStatus.INFO, "Time Zone entered...");
		

		NITViewEditInst.clickSaveInst();
		
		Assert.assertEquals("Institution successfully updated",NITViewEditInst.VerifySuccessMsg());
		test.log(LogStatus.PASS, "New Institution Successfully Created.. " +Iname);

		NITViewEditInst.clickLinkMainMenu();
		test.log(LogStatus.INFO,"Clicking on main menu");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(DataProviderFactory.getConfig().getNITAdminHomePageURL()));
		NITViewEditInst.clickViewEditInst();
		test.log(LogStatus.INFO,"Clicking on ViewEdit link of Inst");
		

		//    -----------------  not working ----------------------
	/*	
		//new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddlProgramofStudy']"))));
		NITViewEditInst.selectProgramOfStudy(textRNPN);
		test.log(LogStatus.INFO,"Clicked on Program of Study.");
	  */  
		//new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtSearch']"))));	
		////////////////////////the above might be needed for FF browser//////////////////////////////////////////
		NITViewEditInst.searchInstName(Iname);
		test.log(LogStatus.INFO,"searching for the newly created Inst");
		
		NITViewEditInst.clickSearchBtn();
		test.log(LogStatus.INFO,"Clicking on search button");
				
		//logic to check if Iname-RN(programOfStudy) ---DONE HERE----
		
		String Iname_toVerify=Iname+" "+"- "+textRNPN;
	   	Assert.assertEquals(Iname_toVerify,NITViewEditInst.validateInstLbl());
		test.log(LogStatus.PASS,"Able to search newly created Inst.. "+Iname);
				
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_gridInstitutions']/tbody/tr[2]/td[7]/a"))));
		                                                                                                         
		NITViewEditInst.clickEditLink();
		test.log(LogStatus.INFO,"Clicking on Edit link of the searched Inst");
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtName']"))));
		                                                                                                           
		NITViewEditInst.enterIName(newIname);
		test.log(LogStatus.INFO,"Entering updated Inst name");
		
		NITViewEditInst.clickSaveInst();
		test.log(LogStatus.INFO,"Clicking on save button");
		
		Assert.assertEquals("Institution successfully updated",NITViewEditInst.VerifySuccessMsg());
		test.log(LogStatus.PASS,"Institution successfully edited.. "+newIname);
		
		
	}

}
