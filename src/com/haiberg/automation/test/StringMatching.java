package com.haiberg.automation.test;


 public class StringMatching {
		 
	 
	  
		 public static void main(String[] args){
			 
		  Matching m = new Matching();
		  
		  String ori[][]={{"asf","safsd","grgerg"},{"grasafsd","dgrargr","gergerg"}};
		  int count=0;
		  int lenth=ori.length;
		  System.out.println("length=="+lenth);
		  String key="12";
		  m.setSubStr(key);
		  System.out.println("judge=="+judge(m.setSubStr(key)));
	      count=m.judgeach(ori, lenth,judge(m.setSubStr(key)));
	      System.out.println("count=="+count);
		 }
		 
		 public static int judge(String key){		
			 
			 if(key.startsWith("*")&&key.endsWith("*")){
				 
				 return 1;
			 }
			 if(key.endsWith("*")){
				 return 2;
			 }
			 if(key.startsWith("*")){
				 
				 return 3;
			 }
			 else{
				 
				 return 4;
			 }
			 
			 
		 }
		 
}
 

    