package com.fengkong;

import java.util.Random;

public class NewUserCardAndBankCard {
	//随机姓和名组合
	 public static String getName() {
		 String familyNames[] = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"};
	     String givenNames[] = {"子璇", "淼", "国栋", "夫子", "瑞堂", "甜", "敏", "尚", "国贤", "贺祥", "晨涛", "昊轩", "易轩", "益辰", "益帆", "益冉", "瑾春", "瑾昆", "春齐", "杨", "文昊", "东东", "雄霖", "浩晨", "熙涵", "溶溶", "冰枫", "欣欣", "宜豪", "欣慧", "建政", "美欣", "淑慧", "文轩", "文杰", "欣源", "忠林", "榕润", "欣汝", "慧嘉", "新建", "建林", "亦菲", "林", "冰洁", "佳欣", "涵涵", "禹辰", "淳美", "泽惠", "伟洋", "涵越", "润丽", "翔", "淑华", "晶莹", "凌晶", "苒溪", "雨涵", "嘉怡", "佳毅", "子辰", "佳琪", "紫轩", "瑞辰", "昕蕊", "萌", "明远", "欣宜", "泽远", "欣怡", "佳怡", "佳惠", "晨茜", "晨璐", "运昊", "汝鑫", "淑君", "晶滢", "润莎", "榕汕", "佳钰", "佳玉", "晓庆", "一鸣", "语晨", "添池", "添昊", "雨泽", "雅晗", "雅涵", "清妍", "诗悦", "嘉乐", "晨涵", "天赫", "玥傲", "佳昊", "天昊", "萌萌", "若萌"};

	     double i = Math.floor(Math.random()*100);
	     String str1 = String.valueOf(i);
	     int idx1 = str1.lastIndexOf(".");//查找小数点的位置
	     String strNum1 = str1.substring(0,idx1);
	     int num1 = Integer.parseInt(strNum1);
	     //System.out.println(givenNames.length);
	     //String i3 = parseString(10 * Math.random()) * 10 + parseInt(10 * Math.random());
	     String familyName = familyNames[num1];
	        
	     double j = Math.floor(Math.random()*100);
	     String str2 = String.valueOf(j);
	     int idx2 = str2.lastIndexOf(".");//查找小数点的位置
	     String strNum2 = str2.substring(0,idx2);
	     int num2 = Integer.parseInt(strNum2);
	     //System.out.println(num2);
	     //String j = parseInt(10 * Math.random()) * 10 + parseInt(10 * Math.random());
	     String givenName = givenNames[num2];

	     String name = familyName + givenName;
	     System.out.println("生成的姓名是：" + name);
	     return name;
	 }
	//---------------------------------------------------------------
	//随机合法的身份证号
	 public static String Calculate() {
		 String areaCode = "412702"; // 用于存放用户输入的区域编号
	     String birthday = "19901007"; // 用户存放用户输入的出生日期
	     Random random = new Random();
	     int a = random.nextInt(10);
	     String sex = String.valueOf(a); // 用户存放用户输入的性别
	     int b = random.nextInt(90) + 10;
	     String idNo = String.valueOf(b); // 用户存放用户输入的顺序编号
	        
	     // 前17位要除以的数：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	     int finalAreaCode = Integer.parseInt(areaCode.substring(0, 1)) * 7
	                + Integer.parseInt(areaCode.substring(1, 2)) * 9
	                + Integer.parseInt(areaCode.substring(2, 3)) * 10
	                + Integer.parseInt(areaCode.substring(3, 4)) * 5
	                + Integer.parseInt(areaCode.substring(4, 5)) * 8
	                + Integer.parseInt(areaCode.substring(5, 6)) * 4;
	     int finalBirthday = Integer.parseInt(birthday.substring(0, 1)) * 2
	                + Integer.parseInt(birthday.substring(1, 2)) * 1
	                + Integer.parseInt(birthday.substring(2, 3)) * 6
	                + Integer.parseInt(birthday.substring(3, 4)) * 3
	                + Integer.parseInt(birthday.substring(4, 5)) * 7
	                + Integer.parseInt(birthday.substring(5, 6)) * 9
	                + Integer.parseInt(birthday.substring(6, 7)) * 10
	                + Integer.parseInt(birthday.substring(7, 8)) * 5;
	     int NoIs = (Integer.parseInt(idNo.substring(0, 1))) * 8
	                + (Integer.parseInt(idNo.substring(1, 2))) * 4;
	     int sexNo = (Integer.parseInt(sex.substring(0, 1))) * 2;
	     int checkCode = (finalAreaCode + finalBirthday + NoIs + sexNo) % 11;
	     int finalCheckCode = 0;
	     // 余数范围： 0 1 2 3 4 5 6 7 8 9 10
	     // 余数对应的数：1 0 X 9 8 7 6 5 4 3 2
	     // 计算出最终的校验码：finalCheckCode
	     switch (checkCode) {
	     	case 0:finalCheckCode = 1;break;
	        case 1:finalCheckCode = 0;break;
	        case 2:finalCheckCode = -3;break;
	        case 3:finalCheckCode = 9;break;
	        case 4:finalCheckCode = 8;break;
	        case 5:finalCheckCode = 7;break;
	        case 6:finalCheckCode = 6;break;
	        case 7:finalCheckCode = 5;break;
	        case 8:finalCheckCode = 4;break;
	        case 9:finalCheckCode = 3;break;
	        case 10:finalCheckCode = 2;break;
	        default:break;
	     }
	     String finalCheckCode2;
	     if(finalCheckCode == -3){
	        finalCheckCode2 = "X";
	     }
	     else{
	        finalCheckCode2 = String.valueOf(finalCheckCode);
	     }
//	     System.out.println("恭喜，生成的身份证号是：" + "\r" + areaCode + birthday + idNo
//	                + sex + finalCheckCode2);
	     // 区域编号(6位数)+出生日期(8位数)+顺序编号(2位数)+性别号(1位数)+校验码(1位数)=身份证号(18位数)
	     String id_card = areaCode + birthday + idNo + sex + finalCheckCode2;
	     System.out.println("恭喜，生成的身份证号是：" + id_card);
	     return id_card;
	 }
	//---------------------------------------------------------------
	//随机银行卡号
	 public static String getBankAccount() {
		// var bank_no = document.getElementById("bank_no_select").value;
		 String bank_no = "0102";
		 String prefix = "";
		 switch (bank_no) {
		    case "0102":prefix = "622202";break;
		    case "0103":prefix = "622848";break;
		    case "0105":prefix = "622700";break;
		    case "0301":prefix = "622262";break;
		    case "104":prefix = "621661";break;
		    case "0303":prefix = "622666";break;
		    case "305":prefix = "622622";break;
		    case "0306":prefix = "622556";break;
		    case "0308":prefix = "622588";break;
		    case "0410":prefix = "622155";break;
		    case "302":prefix = "622689";break;
		    case "304":prefix = "622630";break;
		    case "309":prefix = "622908";break;
		    case "310":prefix = "621717";break;
		    case "315":prefix = "622323";break;
		    case "316":prefix = "622309";break;
		    default:
		 }
		 for (int j = 0; j < 13; j++) {
			 double num = Math.floor(Math.random()*10);
		     //prefix = prefix + Math.floor(Math.random()*10);
		     String str = String.valueOf(num);//浮点变量a转换为字符串str
		     int idx = str.lastIndexOf(".");//查找小数点的位置
		     String strNum = str.substring(0,idx);//截取从字符串开始到小数点位置的字符串，就是整数部分
		     prefix = prefix + strNum;
		}
		//String y="6222025763591467370";
		 System.out.println("生成的银行号是：" + prefix);
		return prefix;
	}

}
