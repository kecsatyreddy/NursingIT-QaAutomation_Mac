
package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy     
 *
 */
public class AdminValidationTest extends BaseClass{
	
	@Test(priority = 1)
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

}
