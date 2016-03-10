package com.haiberg.automation.apps.client.ui.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.HomePageWidgets;
import com.haiberg.automation.apps.client.ui.widgets.OpenStoreWidgets;

public class MPBookKIKTicketTask04 {
	
	static boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	
	
	HomePageWidgets hpw=new HomePageWidgets();
	Platform plf=new Platform();
	CoreAutomation coreauto =new CoreAutomation();
	OpenStoreWidgets osw=new OpenStoreWidgets();
	KIKOpenANewStoreTask01 kikon=new KIKOpenANewStoreTask01();
	
	
	public boolean CheckHomeTicketColor() throws IOException{
		
		result=hpw.getYellowColor(hpw.getHomeTicketColor04());
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean ClicktheHomeTicket() throws IOException{
		
		hpw.DoubleClickTicket04();
		plf.sleep(5000);
		result = true;
		
		return result;
    }
	
	public boolean CheckPositionColor() throws Exception{
		
		result=osw.getYellowColor(osw.getPo1ColorBar())&osw.getGrayColor(osw.getPo2ColorBar())&osw.getGreenColor(osw.getPo3ColorBar());
		plf.sleep(1500);
	
		
		return result;
    }
	
	public boolean CheckNormalMStatus() throws IOException{
		
		result=osw.checkDisable(osw.getNormalMeidaField())&osw.checkDisable(osw.getETFField1s())&osw.checkDisable(osw.getGebuchtCheckbox1s());
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckNormalMValues(String media1,String budget1,String duedate1,String comment1,String commentauto1) throws IOException{
		
		result=osw.checkValue(osw.getNormalMeidaField(),media1)&osw.checkValue(osw.getBudgetField1s(),budget1)&osw.checkValue(osw.getETFField1s(),"")&
		osw.checkValue(osw.getDuedateField1s(),duedate1)&osw.checkText(osw.getComment1ValueField(), comment1)&
		osw.checkSelectedStatus((osw.getZurFField1s()))&osw.checkUnselectedStatus((osw.getFreiField1s()))&
		osw.checkUnselectedStatus((osw.getGebuchtCheckbox1s()))&osw.checkUnselectedStatus((osw.getVerworfenCheckbox1s()));
		System.out.println("1="+osw.checkValue(osw.getNormalMeidaField(),media1));
		System.out.println("2="+osw.checkValue(osw.getBudgetField1s(),budget1));
		System.out.println("3="+osw.checkValue(osw.getETFField1s(),""));
		System.out.println("4="+osw.checkValue(osw.getDuedateField1s(),duedate1));
		System.out.println("5="+osw.checkText(osw.getComment1ValueField(), comment1));
		System.out.println("6="+osw.checkText(osw.getCommentAuto2ValueField(), commentauto1));
		System.out.println("7="+osw.checkSelectedStatus((osw.getZurFField1s())));
		System.out.println("8="+osw.checkUnselectedStatus((osw.getFreiField1s())));
		System.out.println("9="+osw.checkUnselectedStatus((osw.getGebuchtCheckbox1s())));
		System.out.println("10="+osw.checkUnselectedStatus((osw.getVerworfenCheckbox1s())));
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckConfirmCheckbox() throws IOException{
		
		osw.getFreiField1s().click();
		
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean InputETFlight(String etflight1) throws IOException{
		
		osw.getETFField1s().sendKeys(etflight1);
		
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean CheckBook1Checkbox() throws IOException{
		
		osw.getGebuchtCheckbox1s().click();
		
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean CheckRegularMValues(String media2,String budget2) throws IOException{
		
		result=osw.checkValue(osw.getRegularMeidaField(),media2)&osw.checkValue(osw.getBudgetField2s(),budget2)&osw.checkValue(osw.getETFField2s(),"")&
		osw.checkValue(osw.getDuedateField2s(),"")&osw.checkUnselectedStatus((osw.getZurFField2s()))&
		osw.checkUnselectedStatus((osw.getFreiField2s()))&osw.checkUnselectedStatus((osw.getGebuchtCheckbox2()))&osw.checkSelectedStatus((osw.getVerworfenCheckbox2()));
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckSpecialMStatus() throws IOException{
		
		result=osw.checkDisable(osw.getSpecialMeidaField())&osw.checkDisableButton(osw.getFileButton3())&
		osw.checkDisable(osw.getBudgetField3s())&osw.checkDisable(osw.getZurFField3s())&osw.checkGrayBColor(osw.getBudgetField3());
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckSpecialMValues(String media3,String etflight3,String duedate3) throws IOException{
		
		result=osw.checkValue(osw.getSpecialMeidaField(),media3)&osw.checkValue(osw.getBudgetField3s(),"")&osw.checkValue(osw.getETFField3s(),etflight3)&
		osw.checkValue(osw.getDuedateField3s(),duedate3)&osw.checkSelectedStatus((osw.getZurFField3s()))&
		osw.checkSelectedStatus((osw.getFreiField3s()))&osw.checkUnselectedStatus((osw.getGebuchtCheckbox3()))&osw.checkUnselectedStatus((osw.getVerworfenCheckbox3s()));
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckBook3Checkbox() throws IOException{
		
		osw.getGebuchtCheckbox3s().click();
		
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
	public boolean CheckRestBudgetField(String resb) throws IOException{
		
		osw.getRestBudgetField().equals(resb);
		
		plf.sleep(1000);
		result=true;
		
		return result;
    }
	
}
