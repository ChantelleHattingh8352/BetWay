package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import PageObjectModel.BetWay.Utilities;

public class listeners implements ITestListener {

	Utilities utilities = new Utilities();
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Failed, due to timeout " + result.getName()); 
		try {
			utilities.takeSnapShot("On test start " + utilities.timereturn() +".png");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listener, Test start " + context.getName()); 
		try {
			utilities.takeSnapShot("On test start " + utilities.timereturn() +".png");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Listener, Test finish " + context.getName()); 
		try {
			utilities.takeSnapShot("On test start " + utilities.timereturn() +".png");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("!Listener, !Test failed " + result.getName()); 
		try {
			utilities.takeSnapShot("On test !Failure " + utilities.timereturn() +".png");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Listener, Test start " + result.getName()); 
		try {
			utilities.takeSnapShot("On test start " + utilities.timereturn() +".png");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Listener, Successful test " + result.getName());
		try { 
			utilities.takeSnapShot("On test success" + utilities.timereturn() + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	
	}
}
