package Utility;

public class UIData
{
	public static String startupPath = System.getProperty("user.dir");
	public static String BROWSER;
	public static String URL;
	public static String FFDRIVER_EXE;
	public static String IEDRIVER_EXE;
	public static String CHROMEDRIVER_EXE;
	public static String OPERADRIVER_EXE;
	public static String ERRORS_SCREENSHOTS_PATH;
	
	//Static Block
	{
		IEDRIVER_EXE = startupPath+"\\Drivers\\IEDriverServer.exe";
		CHROMEDRIVER_EXE = startupPath+"\\Drivers\\chromedriver.exe";
		FFDRIVER_EXE = startupPath+"\\Drivers\\geckodriver.exe";
	}

}
