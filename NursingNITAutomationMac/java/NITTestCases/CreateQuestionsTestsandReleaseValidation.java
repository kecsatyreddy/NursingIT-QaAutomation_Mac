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
public class CreateQuestionsTestsandReleaseValidation extends BaseClass{
		@Test(priority=1)
		public void creatingQuestions() throws Exception
		{
			test = extent.startTest("Verify creating different types of questions");
			NITCreateQuestions().createQuestions(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3));
		}
		
		@Test(priority=2)
		public void creatingTests()
		{
			test = extent.startTest("Verify creating different types of tests");
			NITCreateTests().createTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority=3)
		public void releaseQuestionsandTests()
		{
			test = extent.startTest("Verify releasing different types of questions and tests");
			NITReleaseQuestionsandTests().releaseQuestionsandTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
				
	}
