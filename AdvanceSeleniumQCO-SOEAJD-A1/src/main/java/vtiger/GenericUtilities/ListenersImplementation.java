package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test; 

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"==========Test Script Execution Started==========");
		
		test= report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"==========Pass==========");
		test.log(Status.PASS,methodname+"==========Pass==========");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility w=new WebDriverUtility();
		JavaUtility j=new JavaUtility();
		String methodname = result.getMethod().getMethodName();
		String screenshotName=methodname+j.getDate();
		
		System.out.println(result.getThrowable());
		
		//System.out.println(methodname+"==========Fail==========");
		try {
			String path = w.captureScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL,methodname+"==========Fail==========");
		test.log(Status.INFO,result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getThrowable());
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"==========Skipped===========");
		test.log(Status.SKIP,methodname+"==========Skipped===========");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("E:\\Selenium 16-06-2023\\AdvanceSeleniumQCO-SOEAJD-A1\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution report");
		htmlreport.config().setReportName("Automation Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base platform","windows");
		report.setSystemInfo("base browser","firefox");
		
		
		
		
		
		System.out.println("==========Suit execution started==========");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==========Suit execution finished==========");
		report.flush();
		
		
		
		
		
		
	}

}

























