package Com.resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
	public static ExtentReports getReportObject ()
	 {
			
		String path = System.getProperty("user.dir") + "/reports/index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("web automation results");
			reporter.config().setDocumentTitle("Test results");
			
			 ExtentReports extent = new ExtentReports();
			
			return extent;

		}

}
