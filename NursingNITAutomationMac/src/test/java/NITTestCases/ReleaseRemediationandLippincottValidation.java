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
public class ReleaseRemediationandLippincottValidation extends BaseClass{
		@Test(priority=1)
		public void releaseRemediationandLippincott()
		{
			test = extent.startTest("Verify releasing remediation and Lippincott");
			NITReleaseRemediationLippincott().releaseRemediationandLippincott(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 5), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 6));
		}
				
	}
