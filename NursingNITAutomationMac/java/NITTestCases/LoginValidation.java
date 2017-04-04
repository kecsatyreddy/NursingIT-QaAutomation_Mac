/**
 * 
 */
package NITTestCases;

import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import Utility.BaseClass;

/**
 * @author SMuppidi
 *
 */
public class LoginValidation extends BaseClass{
		@Test(priority=1)
		public void studentloginwithvalidusernameandpassword()
		{
			test = extent.startTest("Verify Login with valid username and password for admin");
			NITStudentLogin().loginStudentNIT(DataProviderFactory.getExcelConfig().getStringData("NITLogin", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITLogin", 1, 1));
		}
		
		@Test(priority=2)
		public void adminloginwithvalidusernameandpassword()
		{
			test = extent.startTest("Verify Login with valid username and password student");
			NITAdminLogin().loginAdminNIT(DataProviderFactory.getExcelConfig().getStringData("NITLogin", 3, 0), DataProviderFactory.getExcelConfig().getStringData("NITLogin", 3, 1));
		}
	}
