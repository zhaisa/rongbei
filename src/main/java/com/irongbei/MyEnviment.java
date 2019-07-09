package com.irongbei;

import java.util.ArrayList;
import java.util.List;

public class MyEnviment {
public String getEvi(String envi,String beforafter) {
//String[] qianduan= {"http://testhf.irongbei.com","http://dev-test.irongbei.com"};
//String[] houtai= {"http://rongbeiadmin.51dmoz.com","http://dev-admin.irongbei.com"};
List<String> qianduan=new ArrayList<String>();
List<String> houtai=new ArrayList<String>();
qianduan.add("http://testhf.irongbei.com");
qianduan.add("http://dev-test.irongbei.com");
houtai.add("http://rongbeiadmin.51dmoz.com");
houtai.add("http://dev-admin.irongbei.com");
String url=null;
	switch(envi){
	case "test":
		if(beforafter.equals("test")) {
			url=qianduan.get(0);
		}
		if(beforafter.equals("testadmin")) {
			url=houtai.get(0);
		}
		break;
	case "dev":
		if(beforafter.equals("dev")) {
			url=qianduan.get(1);
		}
		if(beforafter.equals("devadmin")) {
			url=houtai.get(1);
		}
		break;
		
		
	}
	return url;
	
}
}
