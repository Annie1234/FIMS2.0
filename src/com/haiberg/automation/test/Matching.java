package com.haiberg.automation.test;

class Matching{
	 
	 String orgStr ="";
	 String subStr ="";
	 static int count=0;
	 int i=0,j=0;
	 
	 public String setOrgStr(String orgStr){
		 
	  this.orgStr = orgStr;
	  return this.orgStr;
	 }
	 
	 public String setSubStr(String subStr){
		 
	  this.subStr = subStr;
	  return this.subStr;
	 }
	   
	 public boolean ifStartandEndwithStar(){
		
		return orgStr.contains(subStr.substring(1, subStr.length()-1));	
	 }
	 
	 public boolean ifEndtwithStar(){
		 
		 return this.orgStr.startsWith(subStr.substring(0, subStr.length()-1));
	 }
	 
	 
	 public boolean ifNoStar(){
		 
		 return this.orgStr.contains(subStr);
	 }
	 
	 public boolean ifStartwithStar(){
		 
		 System.out.println("subsubsub="+subStr.substring(1));
		 return  this.orgStr.endsWith(subStr.substring(1));
	 
	 }
	 
	 public static void main(String []args){
		 
		 Matching matching=new Matching();
		 matching.setOrgStr("abcdef");
		 matching.ifStartandEndwithStar();
		 
	 }
	 
	 public int judgeach(String a[][],int row,int kind){
		 
		 for(i=0;i<row;i++ ){
			 
			 for(j=0;j<3;j++){
				 
				 setOrgStr(a[i][j]);
				
				 switch(kind){
				 case 1:
				     if(subStr.equals("*")){
				    	 
				    	 count++;
				     }
				     else if(ifStartandEndwithStar()==true){
				    	 
						 count++;						 
					 }
					 break;
				 case 2:					 
					 if(ifEndtwithStar()==true){
						 
						 count++;						
					 }
					 break;
				 case 3:
					 if(ifStartwithStar()==true){
						 
						 count++;						
					 }
					 break;
				 case 4:
					 if(ifNoStar()==true){
						 
						 count++;						 
					 }
					 break;
					
			 }
		 }
	 }
		 
		 return count;		 
	}
}