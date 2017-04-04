package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class ProgramValidationTest extends BaseClass{
	
	@Test(priority = 1)
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

}
