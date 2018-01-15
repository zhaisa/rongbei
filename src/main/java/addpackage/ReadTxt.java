package addpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.io.FileHandler;


public class ReadTxt {
	public static void main(String[] args) {
		ReadTxt rt=new ReadTxt();
		try {
			String sss=rt.readFS("D:\\users\\user.txt");
			
 }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public  String readFS(String path) throws IOException {
//File file = new File("D:\\users\\user.txt");
		int lineNo = 1;
		int i= 1;
		String a = "";
		
	File file = new File(path);

FileReader fr=new FileReader(file);
BufferedReader br = new BufferedReader (fr);
String s="";
while ((s=br.readLine())!=null) {
	if(lineNo==i){
		a=s;
	}
	i++;
}
System.out.println(s);
return a;

	 }
}