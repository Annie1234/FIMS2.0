package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.OpenStoreReport03;
import com.haiberg.automation.apps.client.ui.tasks.KIKReceivedMPTicketTask03;
import com.haiberg.automation.apps.client.ui.tasks.MPOpenTicketFromKIKTask02;
import com.haiberg.automation.apps.client.ui.tasks.UserLoginTask;
import com.haiberg.automation.apps.client.ui.tasks.UserLogoutTask;
import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.GetData;

	public class KIKReceivedMPTicket03 {
		
	 	boolean result = false;
	    String[][] objs = null;
		long startTime, endTime;
	    ArrayList<String> al;   

		CoreLogger logger=new CoreLogger();
		CoreAutomation coreauto=new CoreAutomation();
		UserLoginTask ult =new UserLoginTask();
		KIKReceivedMPTicketTask03 kikrt =new KIKReceivedMPTicketTask03();
		MPOpenTicketFromKIKTask02 mpt2=new MPOpenTicketFromKIKTask02();
		UserLogoutTask ulto=new UserLogoutTask();
		OpenStoreReport03 report =new OpenStoreReport03();
		
		@BeforeClass
		public void setup1() throws Exception {

			// Misc.setExecutionENV();
			String Descritpinm = "KIKReceivedMPTicket03";
			String Descritpind = "KIKReceivedMPTicket03";
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
			al = GetData.getGroupData(System. getProperty ("user.dir")+"\\src\\com\\haiberg\\automation\\datapool\\OpenStore03.xlsx");// "Frontend", "UserLogin_001");
			
			if (al.size() > 0) {
				
				result = true;
			} 
			
			else {
				
				System.out.println("no Data found from excel!");
			}

			objs=new String[al.size()/19][19];	
		
			for (int i = 0; i < al.size()/19; i++) {  
				
		            for (int j = 0; j <19; j++) { 
		            	
		            	objs[i][j]=al.get(k);	
		            	System.out.println("objs"+i+"and"+j+"="+objs[i][j]);
		            	k++;
		            }
		     }
			
			return  objs;
		}
		
		
		@Test(dataProvider = "dataGenerater")
		public void CheckMPOpenTicketFromKIK02(String verifyinfo,String fort, String plz, String ort,String street,String housenumber,String date, String budget,String media1,String budget1,String duedate1,String comment1,String commentauto1,String media2, String budget2,String media3, String duedate3,String etflight3,String res)throws Exception {
			
			System.out.println("Test begain:");
			logger.caseStart();
		
			report.OpenStoreStart(fort, plz,ort,street,housenumber,date,budget,media1,budget1,duedate1,comment1,commentauto1,media2,budget2,media3,duedate3,etflight3);
			
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
				
				logger.info("A1" + "Check Home ticket color bar");
				result =kikrt.CheckHomeTicketColor();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2." + "Click the Home ticket");
				result =kikrt.ClicktheHomeTicket();
				coreauto.assertTrue("Result", result);
				
				logger.info("A3." + "Click the Point 1");
				result =mpt2.ClickP1();
				coreauto.assertTrue("Result", result);
				
				logger.info("A4." + "Change the Point 1");
				result =mpt2.ChangePoint1(fort,plz,ort,street,housenumber);
				coreauto.assertTrue("Result", result);
				
				logger.info("A5." + "Click the Point 2");
				result =mpt2.CheckP2("Neueröffnung");
				coreauto.assertTrue("Result", result);
				
				logger.info("A6." + "Change the Point 3");
				result =mpt2.ChangeP3(date);
				coreauto.assertTrue("Result", result);
				
				logger.info("A7." + "Change the Point 4");
				result =mpt2.ChangeP4(budget);
				coreauto.assertTrue("Result", result);
				
				logger.info("A8." + "click the update button");
				result =mpt2.ClickUpdateButton();
				coreauto.assertTrue("Result", result);
	//***************************************************************************		
			/*	logger.info("A8." + "click the history field");
				result =mpt2.ClickHistoryField();
				coreauto.assertTrue("Result", result);
				
				logger.info("A9." + "check the history field");
				result =mpt2.CheckHistoryField();
				coreauto.assertTrue("Result", result);*/
				
				logger.info("A9" + "Check Point 5 color");
				result =kikrt.CheckP5Color();
				coreauto.assertTrue("Result", result);
				
				logger.info("A10" + "Check Position color");
				result =kikrt.CheckPositionColor();
				coreauto.assertTrue("Result", result);
				
				logger.info("F3." + "KIK Checks the different medias");
				
				logger.info("A1" + "Check Normal media status");
				result =kikrt.CheckNormalMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A2" + "Check Normal media value");
				result =kikrt.CheckNormalMValues(media1,budget1,duedate1,comment1,commentauto1);
				coreauto.assertTrue("Result", result);		
				
	//************************************************************************		P2
				logger.info("A3" + "Check Regular media status");
				result =kikrt.CheckRegularMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A4" + "Check Regular media value");
				result =kikrt.CheckRegularMValues(media2,budget2);
				coreauto.assertTrue("Result", result);	
				
				logger.info("A5" + "Click the Cancel Regular media checkbox");
				result =kikrt.ClickCancelCheckbox();
				coreauto.assertTrue("Result", result);
				
	//************************************************************************       P3
				logger.info("A6" + "Check Special media status");
				result =kikrt.CheckSpecialMStatus();
				coreauto.assertTrue("Result", result);
				
				logger.info("A7" + "Check Special media value");
				result =kikrt.CheckSpecialMValues(media3,duedate3);
				coreauto.assertTrue("Result", result);	
				
				logger.info("A8" + "Click the approve Special media checkbox");
				result =kikrt.ClickApproveCheckbox();
				coreauto.assertTrue("Result", result);
				
				logger.info("A9" + "Fill the ET/Flight Field");
				result =kikrt.FillETField(etflight3);
				coreauto.assertTrue("Result", result);
				

				logger.info("A10" + "Click the save and senden button");
				result =mpt2.ClickSaveandSendButton2();
				coreauto.assertTrue("Result", result);
				

				logger.info("A11." + "verifyMPSendTicketResult");
				result = ult.verifyResult("Nachrichten & Vorgänge", "true");
				coreauto.assertTrue("Result", result);
				
				logger.info("F4." + "KIK Logout");
				
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

