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
public class RemediationLippincottValidation extends BaseClass{
		@Test(priority=1)
		public void addRemediationLippincott()
		{
			test = extent.startTest("Verify adding Remediation and Lippincott to question in CMS");
			NITAddRemediationLippincott().addRemediationLippincott(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 5), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 6));
		}
	}
