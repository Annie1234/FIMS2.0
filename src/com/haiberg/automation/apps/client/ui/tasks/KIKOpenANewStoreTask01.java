package com.haiberg.automation.apps.client.ui.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.Keys;

import com.haiberg.automation.CoreAuto.CoreAutomation;
import com.haiberg.automation.CoreAuto.Platform;
import com.haiberg.automation.apps.client.ui.widgets.OpenStoreWidgets;

public class KIKOpenANewStoreTask01 {

	static boolean result = false;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
	String currentTime = sdf.format(System.currentTimeMillis());
	
	
	OpenStoreWidgets osw=new OpenStoreWidgets();
	Platform plf=new Platform();
	CoreAutomation coreauto =new CoreAutomation();
	
	
	public boolean ClicktheNaviBar() throws IOException{
		
		if(osw.getNaviField()!=null){
			
			osw.getNaviField().click();
			plf.sleep(1000);
			return true;
		}
		
		else
		
		return false;
    }
	
	public boolean ClicktheOpenstoreBar() throws IOException{
		
		if(osw.getOpenstoreField()!=null){
			
			osw.getOpenstoreField().click();
			plf.sleep(1000);
			return true;
		}
		else
		
		return false;
    }
	
	public boolean FillPoint1(String storenumber,String storeort, String plz, String ort,String street,String housenumber) throws IOException{
		
	
		result = InputStorenumber(storenumber)&InputStoreOrt(storeort)&InputPLZ(plz)&InputOrt(ort)&InputStreet(street)&InputHousenumber(housenumber);
		
		return result;
    }
	
	public boolean InputStorenumber(String storenumber) throws IOException{
		
		osw.getStoreNumberTextField().sendKeys(storenumber);
		result = true;
		
		return result;
    }
	
	public boolean InputStoreOrt(String storeort) throws IOException{
		
		osw.getStoreOrtTextField().sendKeys(storeort);
		result=true;
		
		return result;
	}
	
	public boolean InputPLZ(String plz) throws IOException{
		
		osw.getPLZTextField().sendKeys(plz);
		result=true;
		
		return result;
	}
	
	public boolean InputOrt(String ort) throws IOException{
		
		osw.getOrtTextField().sendKeys(ort);
		result=true;
		
		return result;
	}
	
	public boolean InputStreet(String street) throws IOException{
		
		osw.getStreetTextField().sendKeys(street);
		result=true;
		
		return result;
	}
	
	public boolean InputHousenumber(String housenumber) throws IOException{
		
		osw.getHousenumberTextField().sendKeys(housenumber);
		result=true;
		
		return result;
	}
	
	public boolean ClickandSelectSM() throws IOException{
		
        osw.ClickSM().click();	
        plf.sleep(1500);
		osw.SelectSM().click();
		plf.sleep(1000);
		result = true;
		
		return result;
	}
	
	public boolean ClickandSelectAKIK() throws IOException{
		
        osw.ClickAKIK().click();	
		plf.sleep(1500);
		osw.SelectAKIK().click();
		plf.sleep(1000);
		result = true;
		
		return result;
	}
	
	public boolean ClickandSelectLand() throws IOException{
		
        osw.ClickLand().click();
		plf.sleep(1500);
		osw.SelectLand().click();
		plf.sleep(1000);
		result = true;
		
		return result;
	}
	
	public boolean InputDate(String date) throws IOException{
		
		osw.getDateTextFiled().sendKeys(date);
		result=true;
		
		return result;
	}
	
	public boolean InputRegularMBudget(String budget) throws IOException{
		
		osw.getBudgetTextFiled().clear();
		osw.getBudgetTextFiled().sendKeys(budget);
		result=true;
		
		return result;
	}
	

	
	
	public boolean SelectNormalMedia() throws IOException{
		
		osw.ClickMedia().click();
		plf.sleep(2000);
		osw.SelectMedia().click();
		plf.sleep(1000);
		result=true;
		
		return result;
	}
	
	public boolean SelectRegularMedia() throws IOException{
		
		osw.ClickMedia2().click();
		plf.sleep(2000);
		osw.SelectMedia2().click();
		plf.sleep(1000);
		result=true;
		
		return result;
	}
	
	public boolean FillRegularMedia(String m2budget) throws IOException{
		
		osw.getM2Budget().sendKeys(m2budget);
		plf.sleep(1000);
		result=true;
		
		return result;
	}
	
	public boolean CheckRegularMediaBColor() throws IOException{
		
		osw.ClickMedia2AddButton().click();
		plf.sleep(1000);
		result=osw.checkGrayBColor(osw.getZurFField2()) && osw.checkGrayBColor(osw.getFreiField2()) && osw.checkGrayBColor(osw.getETFField2())&&osw.checkGrayBColor(osw.getDuedateField2())&osw.checkDisable(osw.getZurFField2s())&osw.checkDisable(osw.getFreiField2s())&osw.checkDisable(osw.getETFField2s())&osw.checkDisable(osw.getDuedateField2s());
		plf.sleep(1000);
			
		return result;
	}
	
	public boolean CheckRegularMediaStatus() throws IOException{
		
		result=osw.checkUnselectedStatus(osw.getZurFCheckbox2()) && osw.checkUnselectedStatus(osw.getFreiCheckbox2()) && osw.checkSelectedStatus(osw.getGebuchtCheckbox2())&&osw.checkUnselectedStatus(osw.getVerworfenCheckbox2());
		plf.sleep(1000);
			
		return result;
	}
	
	public boolean CheckRegularMediaStatus2() throws IOException{
		
		result=osw.checkUnselectedStatus(osw.getZurFCheckbox2()) && osw.checkUnselectedStatus(osw.getFreiCheckbox2()) && osw.checkSelectedStatus(osw.getGebuchtCheckbox2())&&osw.checkUnselectedStatus(osw.getVerworfenCheckbox2());
		plf.sleep(1000);
			
		return result;
	}
	
	public boolean CheckRestBudgetField(String restbudget) throws IOException{
		
	  
		result=getRestBudget().equals(restbudget);
		plf.sleep(1000);
		
		return result;
	}
	
	public String getRestBudget() throws IOException{
		
		return osw.getRestBudgetField().getText();
	}
	
	public boolean SelectSpecialMedia() throws IOException{
		
		osw.ClickMedia3().click();
		plf.sleep(2000);
		osw.SelectMedia3().click();
		plf.sleep(1000);
		result=true;
		
		return result;
	}
	
	
	public boolean ClickAddMediaButton() throws Exception{
		
		osw.getAddmediaButton().click();
		plf.sleep(1500);
		result = true;
		
		return result;
    }
	
	public boolean ClickSaveandSend() throws Exception{
		
		osw.ClickSaveandSend().click();
		plf.sleep(1000);
		result=true;
		
		return result;
	}
	
	public boolean InputComment2() throws Exception{
	
		osw.getFoldButton2().click();
		plf.sleep(1000);
		osw.getComment1Field2().sendKeys("TE");
		plf.sleep(1000);
		osw.getComment1Field2().sendKeys(Keys.ENTER);
		plf.sleep(500);
		result=true;
		return result;
	}
	
}
