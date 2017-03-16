package com.tanner.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAssignment1 {
	
	public static WebDriver dr;

	public static void main(String[] args){
	TestAssignment1.HomePage();
	}
	
	@BeforeMethod
	public static void HomePage() {
		System.setProperty("webdriver.gecko.driver", "C://SeleniumGecko//geckodriver-v0.14.0-win64//geckodriver.exe");
	    
		if(dr==null){
		dr = new FirefoxDriver();
		dr.get("http://www.octanner.com/in/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		
		testMenuFirst();
		}
		
		
		
		
	}
	
	@Test(priority=1)
	public static void testMenuFirst(){
		
		WebElement navContainer = dr.findElement(By.id("main-nav"));
		List<WebElement> menuItems = navContainer.findElements(By.tagName("li"));
		System.out.println(menuItems.size());
		
		for (WebElement liEle : menuItems){
			// liEle.findElement(By.t)
		}
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[1]/a")).click();
		
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[1]/a")));
		
		String actualTitle1 = "elevate everything";
		String PageTitle1 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle1);
		
		//org.testng.Assert.assertEquals(actualTitle1, PageTitle1);
		
		if(actualTitle1.equals(PageTitle1)){
			System.out.println("testMenuOne PASSED!");
		}
		else{
			System.out.println("testMenuOne FAILED!");
		}
		//dr.close();
		dr.navigate().back();
	
	}
	
	@Test(priority=2)
	public static void testMenuSecond(){
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[2]/a")).click();
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[2]/a")));
		
		
		
		String actualTitle2 = "specificity matters";
		String PageTitle2 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle2);
		
		org.testng.Assert.assertEquals(actualTitle2, PageTitle2);
		/*
		if(actualTitle2.equals(PageTitle2)){
			System.out.println("testMenuSecond PASSED!");
		}
		else{
			System.out.println("testMenuSecond FAILED!");
		}*/
		//dr.close();
		dr.navigate().back();
	
	}
	
	@Test(priority=3)
	public static void testMenuThird(){
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[3]/a")).click();
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[3]/a")));
		
		String actualTitle3 = "partner with excellence";
		String PageTitle3 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle3);
		
		//org.testng.Assert.assertEquals(actualTitle1, PageTitle1);
		if(actualTitle3.equals(PageTitle3)){
			System.out.println("testMenuThird PASSED!");
		}
		else{
			System.out.println("testMenuThird FAILED!");
		}
		//dr.close();
		dr.navigate().back();
	
	}
	
	@Test(priority=4)
	public static void testMenuFourth(){
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[4]/a")).click();
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[4]/a")));
		
		String actualTitle4 = "gain understanding";
		String PageTitle4 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle4);
		
		//org.testng.Assert.assertEquals(actualTitle1, PageTitle1);
		if(actualTitle4.equals(PageTitle4)){
			System.out.println("testMenuFourth PASSED!");
		}
		else{
			System.out.println("testMenuFourth FAILED!");
		}
		//dr.close();
		dr.navigate().back();
	
	}
	
	@Test(priority=5)
	public static void testMenuFifth(){
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[5]/a")).click();
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[5]/a")));
		
		String actualTitle5 = "Institute";
		String PageTitle5 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle5);
		
		//org.testng.Assert.assertEquals(actualTitle1, PageTitle1);
		if(actualTitle5.equals(PageTitle5)){
			System.out.println("testMenuFifth PASSED!");
		}
		else{
			System.out.println("testMenuFifth FAILED!");
		}
		//dr.close();
		dr.navigate().back();
	
	}
	
	@Test(priority=6)
	public static void testMenuSixth(){
		
		dr.findElement(By.xpath(".//*[@id='main-nav']/li[6]/a")).click();
		WebElement myDynamicElement = (new WebDriverWait(dr, 15))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main-nav']/li[6]/a")));
		
		String actualTitle6 = "cultures of great work";
		String PageTitle6 = dr.findElement(By.xpath(".//*[@id='main']/section/div/header/div[1]/h1")).getText();
		System.out.println(PageTitle6);
		
		//org.testng.Assert.assertEquals(actualTitle1, PageTitle1);
		if(actualTitle6.equals(PageTitle6)){
			System.out.println("testMenuSixth PASSED!");
		}
		else{
			System.out.println("testMenuSixth FAILED!");
		}
		//dr.close();
		dr.navigate().back();
		//ClosePage();
		dr.quit();
	
	}
	
	/*@AfterMethod
	public static void ClosePage() {
		if(dr!=null){
	    dr.quit();
		}
		}*/
	
	
	

}
