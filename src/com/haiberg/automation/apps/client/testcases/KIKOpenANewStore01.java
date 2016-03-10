package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.OpenStoreReport01;
import com.haiberg.automation.apps.client.ui.tasks.KIKOpenANewStoreTask01;
import com.haiberg.automation.apps.client.ui.tasks.UserLogoutTask;
import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.GetData;

public class KIKOpenANewStore01 {

	 	boolean result = false;
	    String[][] objs = null;
		long startTime, endTime;
	    ArrayList<String> al;
	   
	    
	    KIKOpenANewStoreTask01 op=new KIKOpenANewStoreTask01();
		CoreLogger logger=new CoreLogger();
		CoreAutomation coreauto=new CoreAutomation();
		UserLogoutTask ult=new UserLogoutTask();
		OpenStoreReport01 report =new OpenStoreReport01();

		@BeforeClass
		public void setup1() throws Exception {

			// Misc.setExecutionENV();
			String Descritpinm = "KIKOpenANewStore01";
			String Descritpind = "KIKOpenANewStore01";
			String system = "FIMS";
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
			System.out.println("setTime finished");
		//	WebBrowser.shutdown();
			
		}

		/*
		 * AfterClass is called once at the end of each TestNG run Shuts down
		 * Selenium and the Browser Stops the Html Logger...
		 */



		
		@DataProvider(name = "dataGenerater")
		public  String[][] dataGenerater( ) {
		
			int k=0;
			String [][] objs=null;
			al = new ArrayList<String>();
			al = GetData.getGroupData(System. getProperty ("user.dir")+"\\src\\com\\haiberg\\automation\\datapool\\OpenStore.xlsx");// "Frontend", "UserLogin_001");
			
			if (al.size() > 0) {
				
				result = true;
			} 
			
			else {
				
				System.out.println("no Data found from excel!");
			}

			objs=new String[al.size()/11][11];	
		
			for (int i = 0; i < al.size()/11; i++) {  
				
		            for (int j = 0; j <11; j++) { 
		            	
		            	objs[i][j]=al.get(k);	
		            	System.out.println("objs"+i+"and"+j+"="+objs[i][j]);
		            	k++;
		            }
		     }
			
			return  objs;
		}
		
		
		@Test(dataProvider = "dataGenerater")
		public void CheckKIKOpenANewStore01(String storenumber,String storeort, String plz, String ort,String street,String housenumber,String date,String budget,String m2budget,String restbudget, String res)throws Exception {
			
			System.out.println("Test begain:");
			logger.caseStart();
		
			report.OpenStoreStart(storenumber, storeort, plz,ort,street,housenumber);
			
			try {
				
				logger.info("F1." + "Click the Navigation bar - Open store");
				
				logger.info("A1." + "Click the Navi bar");
				result =op.ClicktheNaviBar();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2." + "Click the Open Store bar");
				result =op.ClicktheOpenstoreBar();
				coreauto.assertTrue("Result", result);
				
//*****************************************************************************************************************
				logger.info("F2." + "Fill the Open Store ticket Point 1-4");
				
				logger.info("A1." + "Input Point1 information");
				result =op.FillPoint1(storenumber,storeort,plz,ort,street,housenumber);
				coreauto.assertTrue("Result", result);
				
				logger.info("A2." + "Click and select the sale manager");
				result =op.ClickandSelectSM();
				coreauto.assertTrue("Result", result);
				
				logger.info("A3." + "Click and select the agent KIK ");
				result =op.ClickandSelectAKIK();
				coreauto.assertTrue("Result", result);
				
				logger.info("A4." + "Click and select the Land ");
				result =op.ClickandSelectLand();
				coreauto.assertTrue("Result", result);
				
				logger.info("A5." + "Select Point 3 ");
				result =op.InputDate(date);
				coreauto.assertTrue("Result", result);
				
				logger.info("A6." + "Input a Budget in Point 4 ");
				result =op.InputRegularMBudget(budget);
				coreauto.assertTrue("Result", result);
//*****************************************************************************************			
				logger.info("F3." + "Fill the Open Store ticket Point 5");
				
				logger.info("A1." + "Select a Normal Media ");
				result =op.SelectNormalMedia();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2." + "Click the adding Media icon ");
				result =op.ClickAddMediaButton();
				coreauto.assertTrue("Result", result);
//*********************************************************************************				
				logger.info("A3." + "Select a regular Media ");
				result =op.SelectRegularMedia();
				coreauto.assertTrue("Result", result);	
				
				logger.info("A4." + "check the regular Media background color ");
				result =op.CheckRegularMediaBColor();
				coreauto.assertTrue("Result", result);
				
				logger.info("A5." + "Fill the regular Media Info ");
				result =op.FillRegularMedia(m2budget);
				coreauto.assertTrue("Result", result);
				
				logger.info("A6." + "check the regular Media checkbox status ");
				result =op.CheckRegularMediaStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A7." + "Input Comment 2");
				result =op.InputComment2();
				coreauto.assertTrue("Result", result);
				
				logger.info("A8." + "check the checkbox status again ");
				result =op.CheckRegularMediaStatus2();
				coreauto.assertTrue("Result", result);				
				
				logger.info("A9." + "check the Rest-budget field ");
				result =op.CheckRestBudgetField(restbudget);
				coreauto.assertTrue("Result", result);
				
//***********************************************************************************				
				logger.info("A10." + "Click the adding Media icon ");
				result =op.ClickAddMediaButton();
				coreauto.assertTrue("Result", result);
				
				logger.info("A11." + "Select a special Media ");
				result =op.SelectSpecialMedia();
				coreauto.assertTrue("Result", result);
				
				logger.info("F4." + "Send the Ticket to MP");
				
				logger.info("A1." + "Click the save and send button ");
				result =op.ClickSaveandSend();
				coreauto.assertTrue("Result", result);
				
				logger.info("F5." + "KIK Logout");
				
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

				if (res.equals("fail")) {
					
					result = true;
					report.setreport(result);

					coreauto.assertTrue("End", result);
					
				} else {
					
					result = false;

					report.setreport(result);

					//coreauto.assertTrue("The Script execution failed! ", result);
				}

			}

		}
}
