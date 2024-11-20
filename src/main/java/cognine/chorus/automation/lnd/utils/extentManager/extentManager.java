package cognine.chorus.automation.lnd.utils.extentManager;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentManager {
	private static ExtentReports extent;

	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);

		return extent;
	}

	public static String getReportName() {
		// TODO Auto-generated method stub
		return null;
	}
}
