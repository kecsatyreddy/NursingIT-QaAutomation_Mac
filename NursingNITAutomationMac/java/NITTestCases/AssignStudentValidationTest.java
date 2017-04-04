package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class AssignStudentValidationTest extends BaseClass{
	
	@Test(priority = 1)
	public void AssignStudent() throws InterruptedException {
		test = extent.startTest("Assign Student");
		AssignStudentValidation().AssignStudent(
				DataProviderFactory.getExcelConfig().getStringData("AssignStudent", 1,
						0),
				DataProviderFactory.getExcelConfig().getStringData("AssignStudent", 1,
						1),
				DataProviderFactory.getExcelConfig().getStringData("AssignStudent", 1,
						2),
				DataProviderFactory.getExcelConfig().getStringData("AssignStudent", 1,
						3),
				DataProviderFactory.getExcelConfig().getStringData("AssignStudent", 1,
						4)
				
				);
								
	}
}
