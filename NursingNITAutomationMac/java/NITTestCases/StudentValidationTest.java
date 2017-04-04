package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class StudentValidationTest extends BaseClass{
	
	@Test(priority = 1)
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
								
	}
}

