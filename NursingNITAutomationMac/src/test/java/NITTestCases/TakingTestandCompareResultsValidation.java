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
public class TakingTestandCompareResultsValidation extends BaseClass{
		@Test(priority=1)
		public void takingFRTTest()
		{
			test = extent.startTest("Verify Login with valid username and password");
			NITTakingTest().TakingTestNIT(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority=2)
		public void comparingPercent()
		{
			test = extent.startTest("Verify the percent correct with the admin report");
			NITComparePercent().comparePercentWithAdminReport(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
	}
