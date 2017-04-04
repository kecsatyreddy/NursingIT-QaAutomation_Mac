/**
 * 
 */
package NITTestCases;

import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import Utility.BaseClass;

/**
 * @author Keerthi Anand
 *
 */
public class SchedulingTestsValidation extends BaseClass{
		@Test(priority=1)
		public void scheduleTests()
		{
			test = extent.startTest("Verify creating different types of questions");
			NITScheduleTests().scheduleAllTests(DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 0), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 2), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 3));
		}
						
	}
