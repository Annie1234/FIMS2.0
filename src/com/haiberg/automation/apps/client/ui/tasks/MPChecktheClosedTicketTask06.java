package com.haiberg.automation.apps.client.ui.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.HomePageWidgets;
import com.haiberg.automation.apps.client.ui.widgets.OpenStoreWidgets;

public class MPChecktheClosedTicketTask06 {
	
	static boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	
	
	HomePageWidgets hpw=new HomePageWidgets();
	Platform plf=new Platform();
	CoreAutomation coreauto =new CoreAutomation();
	OpenStoreWidgets osw=new OpenStoreWidgets();
	KIKOpenANewStoreTask01 kikon=new KIKOpenANewStoreTask01();

	public boolean CheckNormalMStatus() throws IOException{
		
		result=osw.checkDisable(osw.getNormalMeidaField())&osw.checkDisable(osw.getZurFField1s())&osw.checkDisable(osw.getFreiField1s());		 
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckNormalMValues(String media1,String budget1,String etflight1,String duedate1) throws IOException{
		
		result=osw.checkValue(osw.getNormalMeidaField(),media1)&osw.checkValue(osw.getBudgetField1s(),budget1)&osw.checkValue(osw.getETFField1s(),etflight1)&
		osw.checkValue(osw.getDuedateField1s(),duedate1)&osw.checkSelectedStatus((osw.getZurFField1s()))&osw.checkSelectedStatus((osw.getFreiField1s()))&
		osw.checkSelectedStatus((osw.getGebuchtCheckbox1s()))&osw.checkUnselectedStatus((osw.getVerworfenCheckbox1s()));
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckRegularMStatus() throws IOException{
		
		result=osw.checkDisable(osw.getRegularMeidaField())&osw.checkDisableButton(osw.getFileButton2s())&
		osw.checkDisable(osw.getZurFField2s())&osw.checkDisable(osw.getFreiField2s())&
		osw.checkDisable(osw.getETFField2s())&
		osw.checkDisable(osw.getDuedateField2s())&kikon.CheckRegularMediaBColor();
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckRegularMValues(String media2,String budget2) throws IOException{
		
		result=osw.checkValue(osw.getRegularMeidaField(),media2)&osw.checkValue(osw.getBudgetField2s(),budget2)&osw.checkValue(osw.getETFField2s(),"")&
		osw.checkValue(osw.getDuedateField2s(),"")&osw.checkUnselectedStatus((osw.getZurFField2s()))&
		osw.checkUnselectedStatus((osw.getFreiField2s()))&osw.checkSelectedStatus((osw.getGebuchtCheckbox2()))&osw.checkUnselectedStatus((osw.getVerworfenCheckbox2()));
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckSpecialMStatus() throws IOException{
		
		result=osw.checkDisable(osw.getSpecialMeidaField())&osw.checkDisable(osw.getBudgetField3s())&osw.checkDisable(osw.getZurFField3s())&
			   osw.checkDisable(osw.getFreiField3s())&osw.checkGrayBColor(osw.getBudgetField3());
		
		plf.sleep(1000);
		
		return result;
    }
	
	public boolean CheckSpecialMValues(String media3,String etflight3,String duedate3) throws IOException{
		
		result=osw.checkValue(osw.getSpecialMeidaField(),media3)&osw.checkValue(osw.getBudgetField3s(),"")&osw.checkValue(osw.getETFField3s(),etflight3)&
		osw.checkValue(osw.getDuedateField3s(),duedate3)&osw.checkSelectedStatus((osw.getZurFField3s()))&
		osw.checkSelectedStatus((osw.getFreiField3s()))&osw.checkSelectedStatus((osw.getGebuchtCheckbox3()))&osw.checkUnselectedStatus((osw.getVerworfenCheckbox3s()));
		
		plf.sleep(1000);
		
		return result;
    }
}
