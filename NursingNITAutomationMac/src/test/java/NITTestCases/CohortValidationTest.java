package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class CohortValidationTest extends BaseClass{

	@Test(priority = 1)
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

}
