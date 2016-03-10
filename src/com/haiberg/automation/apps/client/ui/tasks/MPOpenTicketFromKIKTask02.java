package com.haiberg.automation.apps.client.ui.tasks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.Keys;

import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.HomePageWidgets;
import com.haiberg.automation.apps.client.ui.widgets.OpenStoreWidgets;
import com.haiberg.automation.util.Config;

public class MPOpenTicketFromKIKTask02 {

	static boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	
	
	HomePageWidgets hpw=new HomePageWidgets();
	Platform plf=new Platform();
	CoreAutomation coreauto =new CoreAutomation();
	OpenStoreWidgets osw=new OpenStoreWidgets();
	
	public boolean CheckHomeTicketColor() throws IOException{
		
		result=hpw.getRedColor(hpw.getHomeTicketColor02());
		plf.sleep(1000);
		
		
		return result;
    }
	
	public boolean ClicktheHomeTicket() throws IOException{
		
		hpw.DoubleClickTicket02();
		plf.sleep(5000);
		result = true;
		
		return result;
    }
	
	public boolean ClickP1() throws IOException{
		
		osw.ClickPoint1().click();
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean ChangePoint1(String fort,String plz, String ort,String street,String housenumber) throws IOException{
		
		result=ChangeFOrt(fort)&ChangePLZ(plz)&ChangeOrt(ort)&ChangeStreet(street)&ChangeHousenumber(housenumber);
		plf.sleep(1000);
		
		
		return result;
    }
	
	public boolean ChangeFOrt(String fort) throws IOException{
		
		osw.getStoreOrtTextField().clear();
		osw.getStoreOrtTextField().sendKeys(fort);
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean ChangePLZ(String plz) throws IOException{
		
		osw.getPLZTextField().clear();
		osw.getPLZTextField().sendKeys(plz);
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean ChangeOrt(String ort) throws IOException{
		
		osw.getOrtTextField().clear();
		osw.getOrtTextField().sendKeys(ort);
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean ChangeStreet(String street) throws IOException{
		
		osw.getStreetTextField().clear();
		osw.getStreetTextField().sendKeys(street);
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean ChangeHousenumber(String housenumber) throws IOException{
		
		osw.getHousenumberTextField().clear();
		osw.getHousenumberTextField().sendKeys(housenumber);
		plf.sleep(1000);
		result = true;
		
		return result;
    }
	
	public boolean CheckP2(String str) throws IOException{
		
		result=osw.checkPoint2().getText().equals(str);
		plf.sleep(1000);
		
		
		return result;
    }
	
	public boolean ChangeP3(String date) throws IOException{
		
		osw.getDateTextFiled().clear();
		osw.getDateTextFiled().sendKeys(date);
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean ChangeP4(String budget) throws IOException{
		
		osw.getBudgetTextFiled().clear();
		osw.getBudgetTextFiled().sendKeys(budget);
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean ClickUpdateButton() throws IOException{
		
		osw.getUpdateButton().click();
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean ClickHistoryField() throws IOException{
		
		osw.getHistoryTitle().click();
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean CheckHistoryField() throws IOException{
		
		result=osw.getHistoryTable().isDisplayed();
		plf.sleep(1000);
		
		
		return result;
    }
	
	public boolean ClickAddButton1() throws IOException{
		
		osw.getAddButton1().click();
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean UploadFile1() throws Exception{
		
		osw.getUploadButton1().click();
		String browser=Config.getProperty("browserType");
		File f=osw.getFile1();
		String executeFile=osw.getExecuteFile1();
		
		osw.handleUpload(browser, f, executeFile);
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean InputBudget1(String budget) throws Exception{
		
		osw.getBudgetField().sendKeys(budget);
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean InputDuedate1(String duedate) throws Exception{
		
		osw.getDuedateField().sendKeys(duedate);
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean InputComment1(String comment1) throws Exception{
		
		osw.getComment1Field1().sendKeys(comment1);
		plf.sleep(1000);
		osw.getComment1Field1().sendKeys(Keys.ENTER);
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean InputComment3(String comment3) throws Exception{
		
		osw.getComment1Field3().sendKeys(comment3);
		plf.sleep(1000);
		osw.getComment1Field3().sendKeys(Keys.ENTER);
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean InputDueDate3(String duedate3) throws Exception{
		
		osw.getDueDateField3().sendKeys(duedate3);
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	
	public boolean ClickSaveandSendButton1() throws Exception{
		
		osw.getSaveandSendButton().click();
		osw.getHintMessage();
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean ClickSaveandSendButton2() throws Exception{
		
		osw.getSaveandSendButton().click();
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	
	public boolean CheckHintMessage(String message) throws Exception{
		
		osw.getHintMessage2().equals(message);
		plf.sleep(1000);
		result=true;
		
		return result;
    }

	
	
	public boolean CheckPo2UploadButton() throws Exception{
		
		osw.checkDisable(osw.getFileButton2());

		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean ClickAddButton3() throws IOException{
		
		osw.getAddPButton3().click();
		result=true;
		
		return result;
	}
	
	public boolean UploadFile3() throws Exception{
		
		osw.getUploadButton3().click();
		String browser=Config.getProperty("browserType");
		File f=osw.getFile1();
		String executeFile=osw.getExecuteFile1();
		
		osw.handleUpload(browser, f, executeFile);
		plf.sleep(1500);
		result=true;
		
		return result;
    }
	
	public boolean CheckPo3CStatusAgain() throws IOException{
		
		result=osw.checkSelectedStatus(osw.getZurFCheckbox3()) && osw.checkUnselectedStatus(osw.getFreiCheckbox3()) && osw.checkUnselectedStatus(osw.getGebuchtCheckbox3())&&osw.checkUnselectedStatus(osw.getVerworfenCheckbox3());
		plf.sleep(1000);
			
		return result;
	}
	
	
	public boolean CheckPo3BColorandStatus() throws IOException{
		
		result=osw.checkGrayBColor(osw.getBudgetField3())&osw.checkDisable(osw.getBudgetField3s());
		plf.sleep(1000);
			
		return result;
	}
	
	
	
	public boolean CheckP5Color() throws Exception{
		
		result=osw.getRedColor(osw.getP5ColorBar());
		//System.out.println("color="+a);
		plf.sleep(1500);
	
		
		return result;
    }
	
	public boolean CheckPositionColor() throws Exception{
	
		System.out.println("R1="+osw.getRedColor(osw.getPo1ColorBar()));
		System.out.println("R2="+osw.getGrayColor(osw.getPo2ColorBar()));
		System.out.println("R3="+osw.getRedColor(osw.getPo3ColorBar()));
		result=osw.getRedColor(osw.getPo1ColorBar())&osw.getGrayColor(osw.getPo2ColorBar())&osw.getRedColor(osw.getPo3ColorBar());
		plf.sleep(1500);
	
		
		return result;
    }
	
	
	
}
