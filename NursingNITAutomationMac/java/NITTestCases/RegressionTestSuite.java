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
public class RegressionTestSuite extends BaseClass{
	
		/*@Test(priority=1)
		public void addRemediationLippincott()
		{
			test = extent.startTest("Verify adding Remediation and Lippincott to question in CMS");
			NITAddRemediationLippincott().addRemediationLippincott(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 5), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 6));
		}
		
		@Test(priority=2)
		public void creatingQuestions() throws Exception
		{
			test = extent.startTest("Verify creating different types of questions");
			NITCreateQuestions().createQuestions(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3));
		}
		
		
		@Test(priority=3)
		public void creatingTests()
		{
			test = extent.startTest("Verify creating different types of tests");
			NITCreateTests().createTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		
		@Test(priority=4)
		public void addNormingProbability()
		{
			test = extent.startTest("Verify adding test categories, norming and probability to IT Test in CMS");
			NITAddNormingProbability().addNormingProbability(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority=5)
		public void releaseRemediationandLippincott()
		{
			test = extent.startTest("Verify releasing remediation and Lippincott");
			NITReleaseRemediationLippincott().releaseRemediationandLippincott(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 5), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 6));
		}	
	
		@Test(priority=6)
		public void releaseQuestionsandTests()
		{
			test = extent.startTest("Verify releasing different types of questions and tests");
			NITReleaseQuestionsandTests().releaseQuestionsandTests(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 3), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
	
		@Test(priority=7)
		public void scheduleTests()
		{
			test = extent.startTest("Verify scheduling all types of tests");
			NITScheduleTests().scheduleAllTests(DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 0), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 2), DataProviderFactory.getExcelConfig().getStringData("Admin", 1, 3));
		}
		*/
		
		@Test(priority=8)
		public void takingAllTests()
		{
			test = extent.startTest("Verify student taking all types of tests");
			NITTakingTest().TakingTestNIT(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
	
		/*
		@Test(priority=9)
		public void comparingPercent()
		{
			test = extent.startTest("Verify the percent correct with the admin report");
			NITComparePercent().comparePercentWithAdminReport(DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 1, 1), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 0), DataProviderFactory.getExcelConfig().getStringData("NITTakingTest", 3, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}
		
		@Test(priority = 10)
		public void Inst() {
			test = extent.startTest("Add New Inst");
			InstValidation().Inst(
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							0),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							1),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							2),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							3),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							4),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							5),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							6),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							7),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							8),	
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							9),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							10),	
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							11),	
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							12),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							13),
					DataProviderFactory.getExcelConfig().getStringData("Inst", 1,
							14)		
					);
		}
			
		@Test(priority = 11)
			
			public void adminLoginViewEditCohort()  {
				test = extent
						.startTest("Login as admin and Verify Add, View Edit Cohort");
				CohortValidation().Cohort(
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								0),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								1),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								2),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								3),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								4),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								5),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								6),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								7),
						DataProviderFactory.getExcelConfig().getStringData("Cohort", 1,
								8));

			}
		
		@Test(priority = 12)
		public void ViewEditAdmin() {
			test = extent.startTest("Add New Admin");
			AdminValidation().Admin(
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							0),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							1),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							2),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							3),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							4),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							5),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							6),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							7),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							8),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							9),
					DataProviderFactory.getExcelConfig().getStringData("Admin1", 1,
							10));

		}
		
		
		@Test(priority = 13)
		public void ViewEditProgram() throws InterruptedException {
			test = extent.startTest("Add New Program");
			ProgramValidation().Program(
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							0),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							1),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							2),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							3),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							4),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							5),
					DataProviderFactory.getExcelConfig().getStringData("Program", 1,
							6)
							);

		}

		@Test(priority = 14)
		public void NewStudent() throws InterruptedException {
			test = extent.startTest("Add New Student");
			NewStudentValidation().Student(
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							0),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							1),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							2),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							3),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							4),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							5),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							6),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							7),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							8),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							9),
					DataProviderFactory.getExcelConfig().getStringData("AddStudent", 1,
							10)			
									
					);
		}
		

		@Test(priority = 15)
		public void ViewEditStudent() {
			test = extent.startTest("View Edit Student");
			StudentValidation().Student(
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							0),
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							1),
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							2),
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							3),
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							4),
					DataProviderFactory.getExcelConfig().getStringData("Student", 1,
							5)
									
									
							
					);
		}*/
}
