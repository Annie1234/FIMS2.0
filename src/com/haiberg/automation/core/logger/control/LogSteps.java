package com.haiberg.automation.core.logger.control;   

import com.haiberg.automation.CoreAuto.Platform;

/**  
 * <p>Title: LogSteps</p>  
 * <p>Project name: ZOEIIAuto</p>
 * <p>Description: TODO</p> 
 * @author Adeng 
 * @date Sep 28, 2014 1:46:59 PM 
 * @version 1.0   
 * <p>Copyright: 2014 www.haiberg.de Inc. All rights reserved.</p>
 */
public class LogSteps {
	 
	
	 public  void logVstart(String verify,String path){
	     
		 WordManager.getInstance().copyParagraphFromAnotherDoc(path, 6);
		 WordManager.getInstance().replaceAllText("$Vdescreiption$", verify);
	   
	   }
	    
	    public void LogEstart(String des,String path){
	   	   
	    	WordManager.getInstance().copyParagraphFromAnotherDoc(path, 7);
	    	WordManager.getInstance().replaceAllText("$verify$", des);
	
	    	WordManager.getInstance().copyParagraphFromAnotherDoc(path, 8);
	    	WordManager.getInstance().replaceAllText("$methodname$", Platform.methodname);
	    	WordManager.getInstance().replaceAllText("$result$", des);
	    	WordManager.getInstance().replaceAllText("$testdate$", Platform.date);
	    	
	    	WordManager.getInstance().save(Platform.filename);
	    	WordManager.getInstance().close();
	        System.out.println("Word close!");
	    	
	    }
	    
	    public  void logPstart(String des,String path){
	    	
	    	WordManager.getInstance().copyParagraphFromAnotherDoc(path, 4);
	    	WordManager.getInstance().replaceAllText("$result$", des);
	    
   	    }
	    
	    public  void logFstart(String sec,String des,String path){
	    	
	    	WordManager.getInstance().copyParagraphFromAnotherDoc(path, 2);
	    	WordManager.getInstance().replaceAllText("$Fnumber$", sec);
	    	WordManager.getInstance().replaceAllText("$Fdescription$", des);
	        
	    }
	    
	    public  void logAstart(String sec,String des,String path){
	    	
	    	WordManager.getInstance().copyParagraphFromAnotherDoc(path, 3);
	    	WordManager.getInstance().replaceAllText("$Anumber$", sec);
	    	WordManager.getInstance().replaceAllText("$Adescription$", des);
	     
	    }
}
