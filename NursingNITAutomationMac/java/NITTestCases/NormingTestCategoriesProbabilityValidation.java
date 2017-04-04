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
public class NormingTestCategoriesProbabilityValidation extends BaseClass{
		@Test(priority=1)
		public void addNorming()
		{
			test = extent.startTest("Verify adding norming to IT Test in CMS");
			NITAddNormingProbability().addNormingProbability(DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 0), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 1), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 2), DataProviderFactory.getExcelConfig().getStringData("CMS", 1, 4));
		}		
				
	}
