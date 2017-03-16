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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAssignment2 {
	
   public static WebDriver dr;	


	public static void main(String[] args) {
	

	}
	
	@BeforeMethod
	public static void HomePage() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C://SeleniumGecko//geckodriver-v0.14.0-win64//geckodriver.exe");
	    
		if(dr==null){
		dr = new FirefoxDriver();
		//dr.get("https://www.google.co.in/?q=Mahatma+Gandhi");
		dr.get("https://www.google.co.in/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		searchWiki();
		
		}
	}
	@Test(priority=1)
	public static void searchWiki() throws Exception{
		//Thread.sleep(5000);
		
		//dr.findElement(By.name("btnG")).click();
		dr.findElement(By.xpath("//input[@name='q']")).sendKeys("Mahatma Gandhi");
		dr.findElement(By.name("btnG")).click();
		Thread.sleep(5000);
		
		dr.findElement(By.linkText("Mahatma Gandhi - Wikipedia")).click();
		
		WebElement pageCheck = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='p-logo']/a")));
		
		String Title = dr.findElement(By.id("firstHeading")).getText();
	    if(Title.equals("Mahatma Gandhi")){
	    assertTrue(true);
	    }
	    else throw new Exception("Wrong Page opened");
	    
	    /*if(pageCheck.isDisplayed()){
			assertTrue(dr.findElement(By.xpath(".//*[@id='p-logo']/a")).isDisplayed(), "Wiki page is opened!");
		}
		else
		{
		System.out.println("Wrong search!!");	
		}*/
	}
	
	/*@Test(priority=2,dependsOnMethods="searchWiki")
	public static void findDOB() throws Exception{
		
		String info = dr.findElement(By.xpath(".//*[@id='mw-content-text']/table/tbody/tr[3]/td/span[2]")).getText();
		System.out.println(info);
		//if(info.contains(s))
		if(info.equals("2 October 1869")){
			System.out.println("PASS");
		}
		else{
			throw new Exception("FAILED");
		}
                                                          		
		List<WebElement> rows = dr.findElements(By.xpath(".//*[@id='mw-content-text']/table/tbody/tr[3]"));
		for (WebElement row: rows) {
		    List<WebElement> cells = row.findElements(By.xpath(".//*[@id='mw-content-text']/table/tbody/tr[3]/td"));
		    for (WebElement cell: cells) {
		        System.out.println(cell.getText());
		    }
		}
	}*/
	@Test(priority=2)
	public static void findGandhi() {
		WebElement bDaySpan = dr.findElement(By.className("bday"));
		//System.out.println("GANDHI ############## "+bDaySpan.getAttribute("innerHTML"));
		String dateStr = bDaySpan.getAttribute("innerHTML");
		SimpleDateFormat toDt = new SimpleDateFormat("d MMMMM yyyy");
		SimpleDateFormat fromDt = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date dob = fromDt.parse(dateStr);
			String dateToPrint =  toDt.format(dob);
			System.out.println("Date of Birth "+dateToPrint);
		}
		catch (Exception e){
			System.out.println("date format exception");
		}
	}
	
}
