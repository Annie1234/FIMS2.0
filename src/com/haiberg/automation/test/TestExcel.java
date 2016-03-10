package com.haiberg.automation.test;   

import java.util.HashMap;
import java.util.Map;

import jxl.report.ReportEnginer;

import com.haiberg.automation.core.logger.control.ExcelReport;

/**  
 * <p>Title: TestExcel</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: TODO</p> 
 * @author Adeng 
 * @date Sep 28, 2014 3:17:40 PM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
public class TestExcel {
	static ReportEnginer enginer = new ReportEnginer();
	static Map<String, Object> context = new HashMap<String, Object>();
	public static void main(String [ ]args){
	
	
	 context.put("number",1);
   //  context.put("username","sdfs");
    // context.put("password","dddddddddd");
   //  context.put("reportname","sfsfsdf");
     
     
     try {
		enginer.excute("h:\\temp.xls", context, "h:\\dq.xls");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}