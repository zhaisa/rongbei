package addpackage;
/*
 * 
 * 
 * 
 * 将流数据放到list集合后，读取
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ReadTxt {
	public static void main(String[] args) {
		try {
			for(int i =0;i<22;i++)  {
			readFS(i);
			
 }}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static  String readFS(int lineNo) throws IOException {
		int i=0;
		String a="";
		FileReader fr = null;
		try {
			fr = new FileReader("D:\\users\\usertext1.txt");//读取用户名文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> list =new ArrayList<String>();
		BufferedReader br=new BufferedReader(fr);
		String line="";
		try {
			while ((line=br.readLine())!=null) {
			
				list.add(line);
				
			
			
			}
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("流关闭失败！");
			}
		}
		
		if(lineNo<list.size()) {
			list.get(lineNo);
		System.out.println(list.get(lineNo));	
		}
		if(lineNo>=list.size()) {
			lineNo=lineNo-list.size();
			list.get(lineNo);
			System.out.println(list.get(lineNo));
		}
		
		return list.get(lineNo);
	
	 }
}
