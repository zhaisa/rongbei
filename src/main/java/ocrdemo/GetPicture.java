package ocrdemo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPicture {
	public static void main(String[] args) {
		GetPicture gp=new GetPicture();
		OcrDemo oc=new OcrDemo();
		gp.getPicture();
		oc.readPicture("E:/Vame/img/test.jpg");
		
	}
public void getPicture() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://testhf.irongbei.com/userRegister/index");
	dr.manage().window().maximize();
	WebElement ele = dr.findElement(By.xpath("//*[@id=\"imageC\"]"));
	File screenshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	 BufferedImage fullImg=null;
	try {
		fullImg = ImageIO.read(screenshot);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  // 读取截图
        // Get the location of element on the page  
	     Point point= ele.getLocation();  
	        // Get width and height of the element  
	        int eleWidth= ele.getSize().getWidth();  
	        int eleHeight= ele.getSize().getHeight();  
	        // Crop the entire page screenshot to get only element screenshot  
	        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);  
	         try {
				ImageIO.write(eleScreenshot, "png", screenshot);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	         // Copy the element screenshot to disk  
	         File screenshotLocation = new File("E:/Vame/img/test.png");  
	        try {
				FileUtils.copyFile(screenshot, screenshotLocation);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	
	
}
}
