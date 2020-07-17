package week3;

import org.testng.annotations.Test;


	
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	
	
	public class Logs_Listensers implements ITestListener{
	    @Override
	    public void onFinish(ITestContext result) {
	        System.out.println("Testing is finished - " + result.getName());
	        
	    }
	    @Override
	    public void onStart(ITestContext result) {
	        System.out.println("Testing is Started - " + result.getName());
	        
	    }
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println("Failed on % - " + result.getName());
	        
	    }




	@Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Testcase is failed - " + result.getName());
	        
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Testcase is skipped - " + result.getName());
	        
	    }
	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("Testcase is started - " + result.getName());
	        
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Testcase is success - " + result.getName());
	        
	    }
	    
	}

