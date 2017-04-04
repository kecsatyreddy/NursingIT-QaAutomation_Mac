/**
 * 
 */
package Utility;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import NITController.CreateQuestionsTestsandReleaseController;
import NITController.LoginPageController;
import NITController.NormingTestCategoriesProbabilityController;
import NITController.ProgramController;
import NITController.ReleaseRemediationLippincottController;
import NITController.RemediationLippincottController;
import NITController.SchedulingTestsController;
import NITController.TakingTestandCompareResultsController;
import NITController.AdminController;
import NITController.AssignStudentController;
import NITController.CohortController;
import NITController.InstController;
import NITController.NewStudentController;
import NITController.StudentController;
/**
 * @author SMuppidi
 *
 */
public class BaseClass extends UIData {

	protected static WebDriver driver;
	protected ExtentReports extent;
	protected static ExtentTest test;
	String reportPath;

	@Parameters("browserName")
	@BeforeClass
	public void startbrowser(String browserName) {
		System.out.println("Browser name is " + browserName);
		BrowserFactory factory=new BrowserFactory();
		driver=factory.getBrowser(browserName);

	}

		public LoginPageController NITStudentLogin()
		{
			driver.get(DataProviderFactory.getConfig().getNITStudentLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new LoginPageController(driver);
		}
		
		public LoginPageController NITAdminLogin()
		{
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new LoginPageController(driver);
		}

		public TakingTestandCompareResultsController NITTakingTest()
		{
			driver.get(DataProviderFactory.getConfig().getNITStudentLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new TakingTestandCompareResultsController(driver);
		}
		
		public TakingTestandCompareResultsController NITComparePercent()
		{
			driver.get(DataProviderFactory.getConfig().getNITStudentLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new TakingTestandCompareResultsController(driver);
		}
		
		public CreateQuestionsTestsandReleaseController NITCreateQuestions()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new CreateQuestionsTestsandReleaseController(driver);
		}
		
		public CreateQuestionsTestsandReleaseController NITCreateTests()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new CreateQuestionsTestsandReleaseController(driver);
		}
		
		public CreateQuestionsTestsandReleaseController NITReleaseQuestionsandTests()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new CreateQuestionsTestsandReleaseController(driver);
		}
		
		public SchedulingTestsController NITScheduleTests()
		{
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new SchedulingTestsController(driver);
		}
		
			public NormingTestCategoriesProbabilityController NITAddNormingProbability()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new NormingTestCategoriesProbabilityController(driver);
		}
			
			public RemediationLippincottController NITAddRemediationLippincott()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new RemediationLippincottController(driver);
		}
			
			public ReleaseRemediationLippincottController NITReleaseRemediationLippincott()
		{
			driver.get(DataProviderFactory.getConfig().getNITCMSAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new ReleaseRemediationLippincottController(driver);
		}
			public CohortController CohortValidation()
			{
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new CohortController(driver);
			}
			public AdminController AdminValidation()
			{
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new AdminController(driver);
			}


			public InstController InstValidation()
			{
				driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				return new InstController(driver);
			}

			public StudentController StudentValidation() {
				driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				return new StudentController(driver);
			}
			
			public NewStudentController NewStudentValidation() {
				driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				return new NewStudentController(driver);
			}
			
			public AssignStudentController AssignStudentValidation() {
				driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				return new AssignStudentController(driver);
			}	
			public ProgramController ProgramValidation()
			{
			driver.get(DataProviderFactory.getConfig().getNITAdminLoginPageURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			return new ProgramController(driver);
			}
		
		@BeforeSuite
		public void reportSetUp() {
			try
			{
			reportPath= startupPath+"\\AdvanceReports\\Kaplan"+System.currentTimeMillis()+".html";
			Thread.sleep(5000);
			extent = new ExtentReports(reportPath, false);
			}catch (Exception e)
			{
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		@AfterMethod
		public void endTestCase(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE)
			{
				try {
					test.log(LogStatus.INFO, test.addScreenCapture(Library.captureScreenshotwithpath(driver)));
					String tc_name = result.getName();
					//System.out.println("The test case name is " + tc_name);
					test.log(LogStatus.FAIL, "Validation Failed Taken Screenshot"+tc_name);
					//test.log(LogStatus.INFO, test.addScreenCapture(Library.captureScreenshotwithpath(driver)));
				} catch (Exception e) {
					System.out.println("Exception while taking screen shot"+e.getMessage());
				}
		
			}
			extent.endTest(test);
		}

		@AfterSuite
		public void tearDown() throws Throwable {
			
		extent.flush();
		driver.get(reportPath);
		Thread.sleep(5000);
		driver.quit();
	     System.out.println("Report is generated >>>> Browser is closed >>>>"+reportPath);
		}
		

}