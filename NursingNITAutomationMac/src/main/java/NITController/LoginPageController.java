/**
 * 
 */
package NITController;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Factory.DataProviderFactory;
import NITModel.LoginPageModel;
import Utility.BaseClass;

/**
 * @author SMuppidi
 *
 */
public class LoginPageController extends BaseClass
{
		WebDriver driver;
			   
		public LoginPageModel NITloginPage;

		public LoginPageController(WebDriver driver)
		{
			this.driver = driver;
			NITloginPage = new LoginPageModel(driver);
		}
		
		public void loginAdminNIT(String uname, String pwd)
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITAdminUserName(uname);
			test.log(LogStatus.INFO,"Admin User name entered successfully");
			NITloginPage.setNITAdminPwd(pwd);
			test.log(LogStatus.INFO,"Admin Password entered successfully");
			NITloginPage.clickAdminLogin();
			test.log(LogStatus.INFO,"Admin Login button is clicked");
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_ucAdminMainRightMenu_btnLogout']"))));
			Assert.assertEquals(NITloginPage.getadminhomepageurl(),DataProviderFactory.getConfig().getNITAdminHomePageURL(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Admin User is able to login successfully");

			}
		
		public void loginStudentNIT(String uname, String pwd)
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='BtnLogIn']"))));
			NITloginPage.setNITStudentUserName(uname);
			test.log(LogStatus.INFO,"Student User name entered successfully");
			NITloginPage.setNITStudentPwd(pwd);
			test.log(LogStatus.INFO,"Student Password entered successfully");
			NITloginPage.clickStudentLogin();
			test.log(LogStatus.INFO,"Student Login button is clicked");
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='Head11_LbLogout']"))));
			Assert.assertEquals(NITloginPage.getstudenthomepageurl(),DataProviderFactory.getConfig().getstudenthomepageurl(),"User is not able to login to site");
			test.log(LogStatus.PASS, "Student User is able to login successfully");

			}
		
	}