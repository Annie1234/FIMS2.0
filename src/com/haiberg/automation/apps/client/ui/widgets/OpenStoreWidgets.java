package com.haiberg.automation.apps.client.ui.widgets;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.haiberg.automation.core.web.wigdets.BaseWidgets;
import com.haiberg.automation.core.web.wigdets.Locator;

public class OpenStoreWidgets extends BaseWidgets{
	
	public WebElement getNaviField() throws IOException {
		
		return  getElement(new Locator("//*[@id='menuFilialwerbung-btnInnerEld']"));
	}
	
	public WebElement getOpenstoreField() throws IOException {
		
		return  getElement(new Locator("//*[@id='menuFilial-Eröffnung-btnInnerEl']"));
	}
	
	public WebElement getStoreNumberTextField() throws IOException {
		
		return  getElement(new Locator("//*[@id='storeNumber-inputEl']"));
	}
	
	public WebElement getStoreOrtTextField() throws IOException{
		
		return getElement(new Locator("//*[@id='storeOrt-inputEl']"));
	}

	public WebElement getPLZTextField() throws IOException{
		
		return getElement(new Locator("//*[@id='storePlz-inputEl']"));
	}

	public WebElement getOrtTextField() throws IOException{
		
		return getElement(new Locator("//*[@id='storeAddressOrt-inputEl']"));
	}
	
	public WebElement getStreetTextField() throws IOException{
		
		return getElement(new Locator("//*[@id='storeStreet-inputEl']"));
	}
	
	public WebElement getHousenumberTextField() throws IOException{
		
		return getElement(new Locator("//*[@id='storeHouseNo-inputEl']"));
	}
	
	public WebElement ClickSM() throws IOException{
		
		return getElement(new Locator("//*[@id='storeSalesManager-trigger-picker']"));
	}
	
	public WebElement SelectSM() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][1]/div/ul/li[3]"));
	}
	
	public WebElement ClickAKIK() throws IOException{
		
		return getElement(new Locator("//*[@id='storeAgentKik-trigger-picker']"));
	}
	
	public WebElement SelectAKIK() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][2]/div/ul/li[4]"));
	}
	
	public WebElement ClickLand() throws IOException{
		
		return getElement(new Locator("//*[@id='storeLand-trigger-picker']"));
	}
	
	public WebElement SelectLand() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][3]/div/ul/div[1]"));
	}
	
	public WebElement getDateTextFiled() throws IOException{
		
		return getElement(new Locator("//*[@id='storeOpenDate-inputEl']"));
	}
	
	public WebElement getBudgetTextFiled() throws IOException{
		
		return getElement(new Locator("//*[@id='storeBudgetProposal-inputEl']"));
	}
	
	public WebElement getAddPButton3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div[2]/div/div/a"));
	}
	
	public WebElement getZurFCheckbox3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getFreiCheckbox3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getGebuchtCheckbox3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[7]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getVerworfenCheckbox3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[8]/div/div/div/div/div/div/div/div/input"));
	} 
	
	public WebElement getVerworfenChseckbox3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
	} 
	
	public WebElement getUploadButton3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[3]/div"));
	}
	
	public WebElement getBudgetField3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div"));
	}                                                        
	
	public WebElement getBudgetField3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement ClickMedia() throws IOException{
		
		return getElement(new Locator("//*[@id='storeplanPosition-innerCt']//div[contains(@id,'trigger-picker')]"));
	
	}
	
	public WebElement SelectMedia() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][4]/div/ul/div[1]/div"));
	}
	
	
	public WebElement ClickMedia2() throws IOException{
		
		return getElement(new Locator("//*[@id='storeplanPosition-innerCt']/div[2]//div[contains(@id,'trigger-picker')]"));
	}
	
	public WebElement ClickMedia2AddButton() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/a/span/span/span[1]"));
	}
	
	public WebElement getZurFField2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]"));
	}
	
	public WebElement getZurFField2s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getZurFField3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getFreiField2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]"));
	}
	
	public WebElement getFreiField2s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getFreiField3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getETFField2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[6]"));
	}
	
	public WebElement getETFField2s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getETFField3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getGebuchtCheckbox3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[7]/div/div/div/div/div/div/div/div/input"));
	}         
	
	public WebElement getVerworfenCheckbox3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[8]/div/div/div/div/div/div/div/div/input"));
	}
	
	
	public WebElement getDuedateField2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]"));
	}
	
	public WebElement getDuedateField2s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
	}
	
	public WebElement getDuedateField3s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
	}
	
	public WebElement getZurFCheckbox2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getFreiCheckbox2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getGebuchtCheckbox2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[7]/div/div/div/div/div/div/div/div/input"));
	}
	
	public WebElement getVerworfenCheckbox2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[8]/div/div/div/div/div/div/div/div/input"));
	}
	
	
	public WebElement getM2Budget() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/input"));
	}
	
	
	public WebElement SelectMedia2() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][5]/div/ul/div[8]/div"));
	}
	
	public WebElement ClickMedia3() throws IOException{
		
		return getElement(new Locator("//*[@id='storeplanPosition-innerCt']/div[3]//div[contains(@id,'trigger-picker')]"));
	}
	
	public WebElement SelectMedia3() throws IOException{
		
		return getElement(new Locator("//div[starts-with(@id,'boundlist-')][6]/div/ul/div[14]/div"));
	}
	
	public WebElement getAddmediaButton() throws IOException{
		
		return getElement(new Locator("//*[@id='openStorePlan-targetEl']/div[2]/div//span[contains(@id,'btnWrap')]"));
	}
	
	public WebElement ClickSaveandSend() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreSaveAndSendAllBtn-btnInnerEl']"));
	}
	
	public WebElement ClickPoint1() throws IOException{
		
		return getElement(new Locator("//*[@id='storeInfoTitle']"));
	}
	
	public WebElement checkPoint2() throws IOException{
		
		return getElement(new Locator("//*[@id='storeTypeTitleContent']"));
	}
	
	public WebElement getUpdateButton() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreSaveAndSendBtn-btnInnerEl']"));
	}
	
	public WebElement getHistoryTitle() throws IOException{
		
		return getElement(new Locator("//*[@id='storeHistoryTitle']"));
	}
	
	
	public WebElement getHistoryTable() throws IOException{
		
		return getElement(new Locator("//*[@id='storeHistoryPanel-innerCt']/div/div[2]/div[1]/div[2]/table[6]"));
	}
	
	public WebElement getAddButton1() throws IOException{
		
		return getElement(new Locator("//*[@id='storeplanPosition-innerCt']/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/a/span/span/span[1]"));
	}
	
	public WebElement getUploadButton1() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div"));
	
	}
	
	public File getFile1() {
		
		File f=new File("C:\\Users\\Adeng\\Desktop\\complaints.xls");
		return f;
	
	}
	
	public String getExecuteFile1(){
		
		String executeFile="C:\\Users\\Adeng\\Desktop\\UploadFile.exe";
		return executeFile;
		
	}
	
	
	public WebElement getBudgetField() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/input"));
	
	}
	
	public WebElement getDuedateField() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
	
	}
	
	public WebElement getComment1Field1() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/input"));
	
	}
	
	public WebElement getComment1Field2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/input"));
	
	}
	
	public WebElement getComment1Field3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/input"));
	
	}
	
	public WebElement getFoldButton2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[2]"));
	
	}
	
	public WebElement getDueDateField3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
	
	}
	
	public WebElement getSaveandSendButton() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreSaveAndSendAllBtn-btnInnerEl']"));
	
	}
	
	public WebElement getHintMessage() throws IOException{
		
		return getElement(new Locator("//*[@id='AutoDestroyAlertMessage-innerCt']"));
	
	}
	
	public WebElement getHintMessage2() throws IOException{
		
		return getElement(new Locator("//*[@id='AutoDestroyAlertMessage-innerCt']"));
	
	}
	
	public WebElement getFileButton2() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/input"));
	
	}
	
	public WebElement getFileButton2s() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div"));
	
	}
	
	public WebElement getFileButton3() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/a"));
	
	}
	
	public Boolean checkDisable(WebElement el) throws IOException{
		
		System.out.println("Disabled="+el.getAttribute("disabled"));
		
		return el.getAttribute("disabled").equals("true");
	
	}
	
	public Boolean checkValue(WebElement el,String value) throws IOException{
		
		return el.getAttribute("value").equals(value);
	
	}
	
	public Boolean checkText(WebElement el,String value) throws IOException{
		
		System.out.println("CheckValue="+el.getText());
		
		return el.getText().equals(value);
	
	}
	
	/*public Boolean checkEnable(WebElement el) throws IOException{
		
		System.out.println("Disabled="+el.getAttribute("disabled"));
		
		return el.getAttribute("disabled").equals("null");
	
	}
	*/
	public Boolean checkDisableButton(WebElement el) throws IOException{
		
		System.out.println("Disabled="+el.getAttribute("unselectable"));
		
		return el.getAttribute("unselectable").equals("on");
	
	}
	 
	public WebElement getP5ColorBar() throws IOException{
		
		return getElement(new Locator("//*[@id='openStorePlanStatusColorBar']"));
	
	}
	
	public WebElement getPo1ColorBar() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div[1]"));
	
	}
	
	public WebElement getPo2ColorBar() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div[1]"));
	
	}
	
	public WebElement getPo3ColorBar() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div/div/div[1]"));
	
	}                                                              
	
	public boolean getRedColor(WebElement el) throws IOException{

		return el.getCssValue("border-left-color").equals("rgba(204, 0, 0, 1)");
					
	}
	
	public boolean getGrayColor(WebElement el) throws IOException{
		
		System.out.println("color="+el.getCssValue("border-left-color"));
		return el.getCssValue("border-left-color").equals("rgba(155, 155, 155, 1)");
					
	}
	
	public boolean getYellowColor(WebElement el) throws IOException{
		
		System.out.println("color="+el.getCssValue("border-left-color"));
		return el.getCssValue("border-left-color").equals("rgba(255, 255, 0, 1)");
					
	}
	
	public boolean getGreenColor(WebElement el) throws IOException{
		
		System.out.println("color="+el.getCssValue("border-left-color"));
		return el.getCssValue("border-left-color").equals("rgba(0, 158, 15, 1)");
					
	}
	
	public WebElement getNormalMeidaField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/input"));
					
	}
	
	public WebElement getRegularMeidaField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/input"));
					
	}
	
	public WebElement getSpecialMeidaField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/input"));
					
	}
	
	
	public WebElement getBudgetField2s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getBudgetField1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getZurFField1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getFreiField1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[5]/div/div/div/div/div/div/div/div/input"));
		
	}
	
	public WebElement getETFField1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[6]/div/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getGebuchtCheckbox1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[7]/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getVerworfenCheckbox1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[8]/div/div/div/div/div/div/div/div/input"));
					
	}
	
	public WebElement getDuedateField1s() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[9]/div/div/div/div/div/div/div/div/div[1]/input"));
					
	}
	
	public WebElement getComment1ValueField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div/table[1]/tbody/tr/td[3]/div"));
					
	}
	
	public WebElement getCommentAuto1ValueField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div/table[5]/tbody/tr/td[3]/div"));
					
	} 
	
	public WebElement getCommentAuto2ValueField() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div/table[5]/tbody/tr/td[3]/div"));
					
	}
	
	public WebElement getNormalFileDButton() throws IOException{
		
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/a/span/span"));
					
	}
	
	public boolean checkGrayBColor(WebElement el) throws IOException{
		
		System.out.println("The color is="+el.getCssValue("background-color"));
		return el.getCssValue("background-color").equals("rgba(240, 240, 240, 1)");
					
	}
	
	public boolean checkUnselectedStatus(WebElement el) throws IOException{
		
		System.out.println("The position is="+el.getCssValue("background-position"));
		return el.getCssValue("background-position").equals("0% 0%");
					
	}
	
	public boolean checkSelectedStatus(WebElement el) throws IOException{
		
		if(! (el.getCssValue("background-position").equals("0% 0%")))
			
			return true;
		else
			return false;
					
	}
	
	public WebElement getRestBudgetField() throws IOException{
		
		return getElement(new Locator("//*[@id='storeRestBudget']"));
					
	}
	
	public WebElement getM2CancelCheckbox() throws IOException{
		
		return getElement(new Locator("//*[@id='openStoreStorePlan']/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[8]/div/div/div/div/div/div/div/div/input"));
					
	}
	
	
}
