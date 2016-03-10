package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.testng.annotations.*;
import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.*;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.BaseReport;
import com.haiberg.automation.apps.client.ui.tasks.UserLoginTask;
import com.haiberg.automation.core.web.WebBrowser;

/**
 *
 @author Adeng
 *
*/

public class UserLogin {

	public UserLogin(){
		
		System.out.println();
	}

    boolean result = false;
    String[][] objs = null;
	long startTime, endTime;
    ArrayList<String> al;
   
    
    UserLoginTask login=new UserLoginTask();
	CoreLogger logger=new CoreLogger();
	CoreAutomation coreauto=new CoreAutomation();
	BaseReport report =new BaseReport();
	
	
	
	@BeforeSuite
	public void setup1() throws Exception {

		// Misc.setExecutionENV();
		String Descritpinm = "Login check";
		String Descritpind = "System login page check, to verity this function can be used correctly.";
		String system = "FIMS2.0";
		report.ERportInit(Descritpinm, Descritpind, system);
        System.out.println("BeforeClass");
	}


	@BeforeMethod
	public void setup() throws Exception {
	
		startTime = System.currentTimeMillis();
		WebBrowser.browserinit();
		WebBrowser.loadUrl(Config.getProperty("FIMS"));
		System.out.println("BeforeMethod");

	}

	
	@AfterMethod
	public void tearDown() {

		endTime = System.currentTimeMillis();
		long runtime = endTime - startTime;
		System.out.println("runtime="+runtime);
		report.setTime(runtime);
		System.out.println("setTime finished");
	//	WebBrowser.shutdown();
		
	}

	/*
	 * AfterClass is called once at the end of each TestNG run Shuts down
	 * Selenium and the Browser Stops the Html Logger...
	 */

	@AfterSuite
	public void tearDown1() {
		
		WebBrowser.shutdown();
		
		try {
			
			String ElxTemplatePath=Config.getProperty("ElxTemplatePath");
			String ElxReportLocation=Config.getProperty("ElxReportLocation");
			BaseReport.context.put("DT", BaseReport.DT);
		
			Set<Entry<String, Object>> allSet=BaseReport.context.entrySet();
			Iterator<Entry<String, Object>> iter=allSet.iterator();
			         while(iter.hasNext()){
			             Entry<String, Object> me=iter.next();
			             System.out.println(me.getKey()+ " "+me.getValue());
			         }
			         
			         BaseReport.enginer.excute(ElxTemplatePath,BaseReport.context,ElxReportLocation);
			
		} catch (Exception e) {          
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@DataProvider(name = "dataGenerater")
	public  String[][] dataGenerater( ) {
	
		int k=0;
		String [][] objs=null;
		al = new ArrayList<String>();
		al = GetData.getGroupData(System. getProperty ("user.dir")+"\\src\\com\\haiberg\\automation\\datapool\\UserLogin.xlsx");// "Frontend", "UserLogin_001");
		
		if (al.size() > 0) {
			
			result = true;
		} 
		
		else {
			
			System.out.println("no Data found from excel!");
		}

		objs=new String[al.size()/4][4];	
	
		for (int i = 0; i < al.size()/4; i++) {  
			
	            for (int j = 0; j <4; j++) { 
	            	
	            	objs[i][j]=al.get(k);	
	            	System.out.println("objs"+i+"and"+j+"="+objs[i][j]);
	            	k++;
	            }
	     }
		
		return  objs;
	}
	
	
	@Test(dataProvider = "dataGenerater")
	public void CheckUserLogin(String name,String password, String res, String verifymessage)throws Exception {
		
		System.out.println("Test begain:");
		logger.caseStart();
	
		report.Base3Start(name, password, res);
		
		try {
			
			logger.info("F1." + "UserLogin");

			logger.info("A1." + "InputUserName");
			result =login.InputUserName(name);
			coreauto.assertTrue("Result", result);
			
			logger.info("A2." + "Input Password");
			result =login.InputPassword(password);
			coreauto.assertTrue("Result", result);
			
			logger.info("A3." + "Click submit button");
			result =login.ClickSubmitButton();
			coreauto.assertTrue("Result", result);	
			
			logger.info("F2." + "verifyLoginResult");
			result = login.verifyResult(verifymessage, res);
			coreauto.assertTrue("Result", result);

			report.setreport(result);

			coreauto.assertTrue("End", result);

		} catch (AssertionError e) {

			if (res.equals("fail")) {
				
				result = true;
				report.setreport(result);

				coreauto.assertTrue("End", result);
				
			} else {
				
				result = false;

				report.setreport(result);

				coreauto.assertTrue("The Script execution failed! ", result);
			}

		}

	}
}
