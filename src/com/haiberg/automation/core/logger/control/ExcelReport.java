package com.haiberg.automation.core.logger.control;   

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxl.report.ReportEnginer;

/**  
 * <p>Title: ExcelReport</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: The whole test report.TODO</p> 
 * @author Adeng 
 * @date Sep 28, 2014 2:12:35 PM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
public class ExcelReport {

	public static  ReportEnginer enginer = new ReportEnginer();
	public static  Map<String, Object> context = new HashMap<String, Object>();
	@SuppressWarnings("rawtypes")
	public static  List<Map> DT =new ArrayList<Map>();
	
	public static  void ERportInit(String dm, String dd,String sys){
			
		 context.put("dm",dm);
		 context.put("dd",dd);
		 context.put("system",sys);
	}

}
