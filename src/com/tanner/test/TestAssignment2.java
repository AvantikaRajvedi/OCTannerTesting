package com.tanner.test;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAssignment2 {
	
   public static WebDriver dr;	
   public static String dateToPrint;


	public static void main(String[] args) {
	

	}
	
	@BeforeMethod
	public static void HomePage() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C://SeleniumGecko//geckodriver-v0.14.0-win64//geckodriver.exe");
	    
		if(dr==null){
		dr = new FirefoxDriver();
		//dr.get("https://www.google.co.in/?q=Mahatma+Gandhi");
		dr.get("http://www.google.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		searchWiki();
		
		}
	}
	@Test(priority=1)
	public static void searchWiki() throws Exception{
		//Thread.sleep(5000);
		
		/*WebElement searchBox = dr.findElement(By.name("btnG"));
		if(searchBox.isDisplayed()){
			searchBox.submit();
		}*/
		WebElement search = dr.findElement(By.id("gs_htif0"));
		search.sendKeys("Mahatma Gandhi");
		search.submit();
		//dr.findElement(By.name("btnG")).click();
		/*WebElement myDynamicElement = (new WebDriverWait(dr, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));*/
		Thread.sleep(2000);
		
		dr.findElement(By.linkText("Mahatma Gandhi - Wikipedia")).click();
			
		String Title = dr.findElement(By.id("firstHeading")).getText();
	    if(Title.equals("Mahatma Gandhi")){
	    assertTrue(true);
	    }
	    else throw new Exception("Wrong Page opened");
	    	}
	
	
	@Test(priority=2)
	public static void findGandhi() throws Exception {
		WebElement bDaySpan = dr.findElement(By.className("bday"));
		//System.out.println("GANDHI ############## "+bDaySpan.getAttribute("innerHTML"));
		String dateStr = bDaySpan.getAttribute("innerHTML");
		SimpleDateFormat toDt = new SimpleDateFormat("d MMMMM yyyy");
		SimpleDateFormat fromDt = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date dob = fromDt.parse(dateStr);
			dateToPrint =  toDt.format(dob);
			System.out.println("Date of Birth "+dateToPrint);
		}
		catch (Exception e){
			System.out.println("date format exception");
		}
		String info = dr.findElement(By.xpath(".//*[@id='mw-content-text']/table/tbody/tr[3]/td")).getText();
		
		if(info.contains(dateToPrint)){
			assertTrue(true, "Correct DOB printed");
		}
		else throw new Exception("Unable to get DOB");
		
	}
	
	@AfterClass
	public static void ClosePage() {
		dr.quit();
	}
	
	
}
