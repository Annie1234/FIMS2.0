package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.OpenStoreReport02;
import com.haiberg.automation.apps.client.ui.tasks.KIKBookP2TicketTask05;
import com.haiberg.automation.apps.client.ui.tasks.MPBookKIKTicketTask04;
import com.haiberg.automation.apps.client.ui.tasks.MPOpenTicketFromKIKTask02;
import com.haiberg.automation.apps.client.ui.tasks.UserLoginTask;
import com.haiberg.automation.apps.client.ui.tasks.UserLogoutTask;
import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.GetData;

	public class KIKBookP2Ticket05 {
		
	 	boolean result = false;
	    String[][] objs = null;
		long startTime, endTime;
	    ArrayList<String> al;   

		CoreLogger logger=new CoreLogger();
		CoreAutomation coreauto=new CoreAutomation();
		UserLoginTask ult =new UserLoginTask();
		KIKBookP2TicketTask05 kikbp =new KIKBookP2TicketTask05();
		MPOpenTicketFromKIKTask02 mpt2=new MPOpenTicketFromKIKTask02();
		MPBookKIKTicketTask04 mpbt=new MPBookKIKTicketTask04();
		UserLogoutTask ulto=new UserLogoutTask();
		OpenStoreReport02 report=new OpenStoreReport02();
		
		@BeforeClass
		public void setup1() throws Exception {

			// Misc.setExecutionENV();
			String Descritpinm = "KIKBookP2Ticket05";
			String Descritpind = "KIKBookP2Ticket05";
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
			
		}
		
		@DataProvider(name = "dataGenerater")
		public  String[][] dataGenerater( ) {
		
			int k=0;
			String [][] objs=null;
			al = new ArrayList<String>();
			al = GetData.getGroupData(System. getProperty ("user.dir")+"\\src\\com\\haiberg\\automation\\datapool\\OpenStore04.xlsx");// "Frontend", "UserLogin_001");
			
			if (al.size() > 0) {
				
				result = true;
			} 
			
			else {
				
				System.out.println("no Data found from excel!");
			}

			objs=new String[al.size()/14][14];	
		
			for (int i = 0; i < al.size()/14; i++) {  
				
		            for (int j = 0; j <14; j++) { 
		            	
		            	objs[i][j]=al.get(k);	
		            	System.out.println("objs"+i+"and"+j+"="+objs[i][j]);
		            	k++;
		            }
		     }
			
			return  objs;
		}
		
		
		@Test(dataProvider = "dataGenerater")
		public void CheckKIKBookP2Ticket05(String verifyinfo,String media1,String budget1,String duedate1,String comment1,String commentauto1,String etflight1,String media2, String budget2,String media3, String duedate3,String etflight3,String resbudget,String res)throws Exception {
			
			System.out.println("Test begain:");
			logger.caseStart();
		
			report.OpenStoreStart(verifyinfo,media1,budget1,duedate1,comment1,commentauto1,etflight1,media2,budget2,media3,duedate3,etflight3,resbudget,res);
			
			try {
				
				logger.info("F1." + "KIK Login the FIMS");
				
				logger.info("A1." + "Input username and password");
				ult.InputUserName("kikp1");
				ult.InputPassword("123");
				coreauto.assertTrue("Result", true);
				
				logger.info("A2." + "Click submit button");
				result =ult.ClickSubmitButton();
				coreauto.assertTrue("Result", result);	
				
				logger.info("A3." + "verifyLoginResult");
				result = ult.verifyResult(verifyinfo, res);
				coreauto.assertTrue("Result", result);
				
	//***********************************************************************
				
				logger.info("F2." + "KIK Check the ticket");
				
				logger.info("A1" + "click the Done tab in navigation bar");
				result =kikbp.ClickDoneNaviBar();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2" + "Check Home ticket color bar");
				result =kikbp.CheckHomeTicketColor();
				coreauto.assertTrue("Result", result);
				
				logger.info("A3." + "Click the Home ticket");
				result =kikbp.ClicktheHomeTicket();
				coreauto.assertTrue("Result", result);
				
	//***************************************************************************		
				
			/*	logger.info("A8." + "click the history field");
				result =mpt2.ClickHistoryField();
				coreauto.assertTrue("Result", result);
				
				logger.info("A9." + "check the history field");
				result =mpt2.CheckHistoryField();
				coreauto.assertTrue("Result", result);*/
				
				logger.info("A4" + "Check Point 5 color");
				result =kikbp.CheckP5Color();
				coreauto.assertTrue("Result", result);
				
				logger.info("A5" + "Check Position color");
				result =kikbp.CheckPositionColor();
				coreauto.assertTrue("Result", result);
				
				logger.info("F3." + "KIK Checks the different medias ");
				
				logger.info("A1" + "Check Normal media status");
				result =kikbp.CheckNormalMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2" + "Check Normal media value");
				result =kikbp.CheckNormalMValues(media1,budget1,etflight1,duedate1);
				coreauto.assertTrue("Result", result);		
				
	//************************************************************************		P2
				logger.info("A3" + "Check Regular media status");
				result =kikbp.CheckRegularMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A4" + "Check Regular media value");
				result =mpbt.CheckRegularMValues(media2,budget2);
				coreauto.assertTrue("Result", result);	
				
				logger.info("A5" + "Check the book checkbox");
				result =kikbp.CheckRegularBook();
				coreauto.assertTrue("Result", result);	
				
				
	//************************************************************************       P3
				logger.info("A6" + "Check Special media status");
				result =kikbp.CheckSpecialMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A7" + "Check Special media value");
				result =kikbp.CheckSpecialMValues(media3,etflight3,duedate3);
				coreauto.assertTrue("Result", result);	
				
				logger.info("A8" + "Check the rest-budget Field");
				result =mpbt.CheckRestBudgetField(resbudget);
				coreauto.assertTrue("Result", result);

				logger.info("A9" + "Click the save and senden button");
				result =mpt2.ClickSaveandSendButton2();
				coreauto.assertTrue("Result", result);
				

				logger.info("A10." + "verifyMPSendTicketResult");
				result = ult.verifyResult("Nachrichten & Vorgänge", "true");
				coreauto.assertTrue("Result", result);
				
				logger.info("F4." + "Mp Logout");
				
				logger.info("A1." + "Click Logout Button");
				result =ulto.ClickLogoutButton();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2." + "Logout Confirm");
				result =ulto.ClickConfirmButton();
				coreauto.assertTrue("Result", result);
				
				logger.info("A3." + "verifyCreateMessageResult");
				result = ulto.verifyResult("Login", "true");
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

