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
public class SmokeTest extends BaseClass
{
		@Test(priority = 1)
		public void creatingQuestions()
		{
			test = extent.startTest("Verify creating different types of questions");
			NITCreateQuestions().createQuestions(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3));
		}
		
		@Test(priority = 2)
		public void creatingTests()
		{
			test = extent.startTest("Verify creating different types of tests");
			NITCreateTests().createTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority = 3)
		public void releaseQuestionsandTests()
		{
			test = extent.startTest("Verify releasing different types of questions and tests");
			NITReleaseQuestionsandTests().releaseQuestionsandTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority = 4)
		public void scheduleTests()
		{
			test = extent.startTest("Verify the functionality scheduling all types of tests");
			NITScheduleTests().scheduleAllTests(DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 0), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 2), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 3));
		}
		
		@Test(priority = 5)
		public void takingTest()
		{
			test = extent.startTest("Verify the functionality of taking all types of test from student application");
			NITTakingTest().TakingTestNIT(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority = 6)
		public void comparingPercent()
		{
			test = extent.startTest("Verify the percent correct from student application with the Student Report Card report");
			NITComparePercent().comparePercentWithAdminReport(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}		
				
	}
