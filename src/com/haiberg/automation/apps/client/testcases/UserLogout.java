package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;
import org.testng.annotations.*;

import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.*;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.BaseReport;
import com.haiberg.automation.apps.client.ui.tasks.UserLogoutTask;

/**
 * @author Adeng
 *
 */
public class UserLogout {

	boolean result = false;
	String[][] objs = null;
	long startTime, endTime;
	ArrayList<String> al;
	
	CoreLogger logger=new CoreLogger();
	CoreAutomation coreauto=new CoreAutomation();
    UserLogoutTask ult=new UserLogoutTask();
    BaseReport report =new BaseReport();
    
	@BeforeClass
	public void setup1() throws Exception {

		// Misc.setExecutionENV();
		String Descritpinm = "User Logout FIMS 2.0";
		String Descritpind = "Logout function check.";
		String system = "FIMS2.0";
		report.ERportInit(Descritpinm, Descritpind, system);
        System.out.println("BeforeClass");
        
	}


	@BeforeMethod
	public void setup() throws Exception {
	
		startTime = System.currentTimeMillis();


	}

	@AfterMethod
	public void tearDown() {

		endTime = System.currentTimeMillis();
		long runtime = endTime - startTime;
		System.out.println("runtime="+runtime);
		report.setTime(runtime);
	//	WebBrowser.shutdown();
		
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
	public void CheckLogout(String name,String password, String res, String verifymessage)throws Exception {
		
		System.out.println("Test begain:");
		
		logger.caseStart();
		report.Base3Start(name, password,res);
		
	try {
			
			logger.info("F1." + "UserLogout");
			
			logger.info("A1." + "Click Logout Button");
			result =ult.ClickLogoutButton();
			coreauto.assertTrue("Result", result);
			
			logger.info("A2." + "Logout Confirm");
			result =ult.ClickConfirmButton();
			coreauto.assertTrue("Result", result);
			
			logger.info("A3." + "verifyCreateMessageResult");
			result = ult.verifyResult("Login", "true");
			coreauto.assertTrue("Result", result);
			
			report.setreport(result);
			coreauto.assertTrue("End", result);

		} catch (AssertionError e) {
				
			report.setreport(result);

			coreauto.assertTrue("The Script execution failed! ", result);
			
			}

	}
}
