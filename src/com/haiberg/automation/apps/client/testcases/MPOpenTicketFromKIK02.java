package com.haiberg.automation.apps.client.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.apps.client.ui.report.OpenStoreReport02;
import com.haiberg.automation.apps.client.ui.tasks.KIKOpenANewStoreTask01;
import com.haiberg.automation.apps.client.ui.tasks.MPOpenTicketFromKIKTask02;
import com.haiberg.automation.apps.client.ui.tasks.UserLoginTask;
import com.haiberg.automation.apps.client.ui.tasks.UserLogoutTask;
import com.haiberg.automation.core.logger.control.CoreLogger;
import com.haiberg.automation.util.GetData;

public class MPOpenTicketFromKIK02 {
	
 	boolean result = false;
    String[][] objs = null;
	long startTime, endTime;
    ArrayList<String> al;   

	CoreLogger logger=new CoreLogger();
	CoreAutomation coreauto=new CoreAutomation();
	UserLoginTask ult =new UserLoginTask();
	MPOpenTicketFromKIKTask02 mpt2=new MPOpenTicketFromKIKTask02();
	KIKOpenANewStoreTask01 kik1=new KIKOpenANewStoreTask01();
	UserLogoutTask ulto=new UserLogoutTask();
	OpenStoreReport02 report =new OpenStoreReport02();
	
	@BeforeClass
	public void setup1() throws Exception {

		// Misc.setExecutionENV();
		String Descritpinm = "MPOpenTicketFromKIK02";
		String Descritpind = "MPOpenTicketFromKIK02";
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
		al = GetData.getGroupData(System. getProperty ("user.dir")+"\\src\\com\\haiberg\\automation\\datapool\\OpenStore02.xlsx");// "Frontend", "UserLogin_001");
		
		if (al.size() > 0) {
			
			result = true;
		} 
		
		else {
			
			System.out.println("no Data found from excel!");
		}

		objs=new String[al.size()/16][16];	
	
		for (int i = 0; i < al.size()/16; i++) {  
			
	            for (int j = 0; j <16; j++) { 
	            	
	            	objs[i][j]=al.get(k);	
	            	System.out.println("objs"+i+"and"+j+"="+objs[i][j]);
	            	k++;
	            }
	     }
		
		return  objs;
	}
	
	
	@Test(dataProvider = "dataGenerater")
	public void CheckMPOpenTicketFromKIK02(String verifyinfo,String fort, String plz, String ort,String street,String housenumber,String date, String budget,String budget1,String duedate1,String comment1,String budget2,String comment3, String restbudget,String duedate3,String res)throws Exception {
		
		System.out.println("Test begain:");
		logger.caseStart();
	
		report.OpenStoreStart(fort, plz, ort,street,housenumber,date,budget,budget1,duedate1,comment1,budget2,comment3,restbudget,duedate3);
		
		try {
			
			logger.info("F1." + "MP Login the FIMS");
			
			logger.info("A1." + "Input username and password");
			ult.InputUserName("mpp1");
			ult.InputPassword("123");
			coreauto.assertTrue("Result", true);
			
			logger.info("A2." + "Click submit button");
			result =ult.ClickSubmitButton();
			coreauto.assertTrue("Result", result);	
			
			logger.info("A3." + "verifyLoginResult");
			result = ult.verifyResult(verifyinfo, res);
			coreauto.assertTrue("Result", result);
//***********************************************************************
			logger.info("F2." + "MP Check the ticket");
			
			logger.info("A1" + "Check Home ticket color bar");
			result =mpt2.CheckHomeTicketColor();
			coreauto.assertTrue("Result", result);
			
			logger.info("A2." + "Click the Home ticket");
			result =mpt2.ClicktheHomeTicket();
			coreauto.assertTrue("Result", result);
			
			logger.info("A3." + "Click the Point 1");
			result =mpt2.ClickP1();
			coreauto.assertTrue("Result", result);
			
			logger.info("A4." + "Change the Point 1");
			result =mpt2.ChangePoint1( fort,plz,ort,street,housenumber);
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
			result =mpt2.CheckP5Color();
			coreauto.assertTrue("Result", result);
			
			logger.info("A10" + "Check Position color");
			result =mpt2.CheckPositionColor();
			coreauto.assertTrue("Result", result);
			
			logger.info("F3." + "MP Checks the different medias");
			
			logger.info("A1" + "Click Position 1 add button");
			result =mpt2.ClickAddButton1();
			coreauto.assertTrue("Result", result);
			
			logger.info("A2" + "Upload File 1");
			result =mpt2.UploadFile1();
			coreauto.assertTrue("Result", result);
			
			logger.info("A3" + "Input budget1");
			result =mpt2.InputBudget1(budget1);
			coreauto.assertTrue("Result", result);
			
			logger.info("A4" + "Input duedate");
			result =mpt2.InputDuedate1(duedate1);
			coreauto.assertTrue("Result", result);
			
			logger.info("A5" + "Input comment");
			result =mpt2.InputComment1(comment1);
			coreauto.assertTrue("Result", result);
//************************************************************************		P2
			logger.info("A6" + "Check Position2 upload file button status");
			result =mpt2.CheckPo2UploadButton();
			coreauto.assertTrue("Result", result);
			
			logger.info("A7" + "Check Position2 Background color");
			result =kik1.CheckRegularMediaBColor();
			coreauto.assertTrue("Result", result);
			
			logger.info("A8" + "Check Position2 check-box status");
			result =kik1.CheckRegularMediaStatus();
			coreauto.assertTrue("Result", result);
			
			logger.info("A9" + "Change the Position 2 budget");
			result =kik1.InputRegularMBudget(budget2);
			coreauto.assertTrue("Result", result);
//************************************************************************       P3
			logger.info("A10" + "Click position 3 add button");
			result =mpt2.ClickAddButton3();
			coreauto.assertTrue("Result", result);
			
			logger.info("A11" + "Check background color");
			result =mpt2.CheckPo3BColorandStatus();
			coreauto.assertTrue("Result", result);		
			
			logger.info("A12" + "Upload File 3");
			result =mpt2.UploadFile3();
			coreauto.assertTrue("Result", result);
			
			logger.info("A13" + "Check the check-boxes status 3");
			result =mpt2.CheckPo3CStatusAgain();
			coreauto.assertTrue("Result", result);
			
			logger.info("A14" + "Input comment 3");
			result =mpt2.InputComment3(comment3);
			coreauto.assertTrue("Result", result);
			
			logger.info("A15" + "Check Rest-Budget value");
			result =kik1.CheckRestBudgetField(restbudget);
			coreauto.assertTrue("Result", result);
			
			logger.info("A16" + "Click the save and senden button");
			result =mpt2.ClickSaveandSendButton1();
			coreauto.assertTrue("Result", result);
			
			logger.info("A17" + "Input due date 3");
			result =mpt2.InputDueDate3(duedate3);
			coreauto.assertTrue("Result", result);
			
			logger.info("A18" + "Click the save and senden button");
			result =mpt2.ClickSaveandSendButton2();
			coreauto.assertTrue("Result", result);
			

			logger.info("A19." + "verifyMPSendTicketResult");
			result = ult.verifyResult("Nachrichten & Vorgänge", "true");
			coreauto.assertTrue("Result", result);
			
			logger.info("F4." + "MP Logout");
			
			logger.info("A1." + "Click Logout Button");
			result =ulto.ClickLogoutButton();
			coreauto.assertTrue("Result", result);
			
			logger.info("A2." + "Logout Confirm");
			result =ulto.ClickConfirmButton();
			coreauto.assertTrue("Result", result);
			
			logger.info("A3." + "verify Logout Result");
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

