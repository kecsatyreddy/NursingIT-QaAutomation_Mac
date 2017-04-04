package NITTestCases;

import org.testng.annotations.Test;

import Utility.BaseClass;
import Factory.DataProviderFactory;

/**
 * @author LRamaswamy
 *
 */
public class InstValidationTest extends BaseClass {

	@Test(priority = 1)
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
;

	}

}
