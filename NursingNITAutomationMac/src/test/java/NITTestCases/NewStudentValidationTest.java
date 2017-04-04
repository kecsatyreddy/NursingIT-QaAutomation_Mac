package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class NewStudentValidationTest extends BaseClass{
	
	@Test(priority = 1)
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
}