/**
 * 
 */
package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SMuppidi  
 *
 */
public class ReadConfig 
{
	Properties pro;
	public ReadConfig(){
		try {
			File src=new File("./Configuration/frameworkConfigQA.properties");
			
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			System.out.println("Config file loaded Successfully");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found please check location of config file");
			System.out.println(e.getMessage());
		} catch (IOException e) {
		
			System.out.println("Exception while reading config file");
			System.out.println(e.getMessage());
			
		}
	}
	
	public String getChromePath()
	{
		return pro.getProperty("ChromeDriverPath");
	}
	public String getIEPath()
	{
		return pro.getProperty("IEDriverPath");
	}
	public String getFFPath()
	{
		return pro.getProperty("FFDriverPath");
	}
	public String getApplicationQAUrl()
	{
		return pro.getProperty("ApplicationQAURL");
	}
	public String getApplicationStgUrl()
	{
		return pro.getProperty("ApplicationSTGURL");
	}
	public String getApplicationProdUrl()
	{
		return pro.getProperty("ApplicationPRODURL");
	}
	
	public String getExcelPath()
	{
		return pro.getProperty("ExcelPath");
	}
	public String getHomePageURL()
	{
		return pro.getProperty("HomePageURL");
	}
	public String getReportPageURL()
	{
		return pro.getProperty("ReportPageURL");
	}
	public String getRosterPageURL()
	{
		return pro.getProperty("RosterPageURL");
	}
	public String getUserGuidePageURL()
	{
		return pro.getProperty("UserGuidePageURL");
	}
	public String getManageTestPageURL()
	{
		return pro.getProperty("ManageTestPageURL");
	}
	public String getManageAccountPageURL()
	{
		return pro.getProperty("ManageAccountPageURL");
	}
	public String getManageGroupsPageURL()
	{
		return pro.getProperty("ManageGroupsPageURL");
	}
	public String getLoginPageURL()
	{
		return pro.getProperty("LoginPageURL");
	}
	public String getFRTTestPageURL()
	{
		return pro.getProperty("FRTTestPageURL");
	}
	public String getMidFedilitySimulationsPageURL()
	{
		return pro.getProperty("MidFedilitySimulationsPageUR");
	}
	public String getEssentialNursingSkillsPageURL()
	{
		return pro.getProperty("EssentialNursingSkillsPageURL");
	}
	public String getNCLEXPrepPageURL()
	{
		return pro.getProperty("NCLEXPrepPageURL");
	}
	public String getNITStudentLoginPageURL()
	{
		return pro.getProperty("NITStudentLoginPageURL");
	}
	public String getstudenthomepageurl()
	{
		return pro.getProperty("NITStudentHomePageURL");
	}

	public String getNITAdminLoginPageURL()
	{
		return pro.getProperty("getNITAdminLoginPageURL");
	}
	
	public String getNITAdminHomePageURL()
	{
		return pro.getProperty("getNITAdminHomePageURL");
	}

	public String getNITCMSAdminLoginPageURL() {
		return pro.getProperty("getNITCMSAdminLoginPageURL");
	}

	public String getNITCMSAdminHomePageURL() {
		return pro.getProperty("getNITCMSAdminHomePageURL");
	}

}

