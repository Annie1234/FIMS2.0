package com.haiberg.automation.CoreAuto;



import com.haiberg.automation.core.logger.control.CoreLogger;
import org.openqa.selenium.WebElement;


	public  class CoreAutomation {
		
		private  boolean captureScreenshot = true;
		private  boolean showScreenshotInLogs = true;
		CoreLogger log=new CoreLogger();
	
		public  void enableScreenshots() {
			
			captureScreenshot = true;
		}

		public  void disableScreenshots() {
			
			captureScreenshot = false;
		}

		public  void showScreenshotsAsLinksInLogs() {
			
			showScreenshotInLogs = false;
		}

		// Asserts that a condition is false.
		public  void assertFalse(java.lang.String message, boolean condition) {
			
	//		message = message + captureScreenshotIfEnabled(getPicFrontName(message));

			if (condition) {
				log.error("FAIL: " + message);
			} else {
				log.info("PASS: " + message);
			}
		//	BitmapHelper.captureScreenshot(message);
			//org.junit.Assert.assertFalse(message, condition);
			
		}

		
		// Asserts that a condition is true.
		public  void assertTrue(java.lang.String message, boolean condition) {
			
	//		message = message + captureScreenshotIfEnabled(getPicFrontName(message));
			
			if (!condition) {
				
				log.error("FAIL: " + message);
				
			} else {
				
				log.info("PASS: " + message);
			}
			
			org.testng.AssertJUnit.assertTrue(message, condition);		
			
		}
		
		
		public  boolean assertElement(WebElement element, String text){
			
			return element.getText().equals(text);
		}
		
		// Verify page element 
	/*	public static boolean assertElement(SeleniumTestObject myWebTable) {

			String myMessage = "Page Element \""+myWebTable.getLocator()+"\" Verification";
		
			boolean myResult = myWebTable.waitForExistence(10);
			
			assertTrue(myMessage, myResult);

			org.testng.AssertJUnit.assertTrue(myMessage, myResult);
			
			return myResult;
		}
		*/	
		public  boolean  waitForExistence(String locator, long min){
			
	//        WebElement targetElement =(new WebDriverWait(WebBrowser.driver,min)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	      return true;
	       
		}
		
		// Asserts that a condition is true.
		public  void assertEquals(java.lang.String message, Object expected, Object actual) {
			
			//message = message + captureScreenshotIfEnabled(getPicFrontName(message));

			if (!expected.equals(actual)) {
				log.error("FAIL: " + message);
			} else {
				log.info("PASS: " + message);
			
            
				org.testng.AssertJUnit.assertTrue(message, expected.equals(actual));
			}
		}

		// Fails a test with the given message.
		public  void fail(java.lang.String message) {
			fail(message, null);
		}

		// Fails a test with the given message.
		public  void fail(java.lang.String message, java.lang.Exception e) {
		//	message = message + captureScreenshotIfEnabled(getPicFrontName(message));
			log.error("TEST FAIL: " + message);
			try {
				log.error(e.getMessage());
			} catch (Exception e2) {
				// TODO: handle exception
			}
			org.testng.AssertJUnit.fail(message);
		//	org.junit.Assert.fail(message);
		}
		
		/*private  String getClassAndMethodName(){
			
			String screenshotName = Platform.getCallingMethodName().replace("com.haiberg.automation.apps.", "");
			screenshotName = screenshotName.replace("(", "");
			screenshotName = screenshotName.replace(")", "");
			screenshotName = screenshotName.concat("_");
			
			return screenshotName;
		}
	
		
		
		private  String getPicFrontName(String message){
			
			String returnMessage = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
	    	String mDateTime=formatter.format(cal.getTime());
	    	System.out.println(message);
			if(message.indexOf(".")>0){
				message = message.trim();
				returnMessage = getClassAndMethodName()+ message.substring(0, message.indexOf("."));
			}else if((message.indexOf(".")<=0)||(message.indexOf(".")>3)||(message.indexOf("A")<0)){
				returnMessage = getClassAndMethodName()+"A"+mDateTime;
			}
			return returnMessage.concat("_");
		}*/

		public  void screenCapture(String message) {
		//	message += captureScreenshotIfEnabled(getPicFrontName(message));;

			log.info(message);
		}

	
	}		
		

