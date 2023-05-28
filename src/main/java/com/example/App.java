package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pooja\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		//through this project will learn about all type of drop down
		
		//1st static drop down(options are fixed(static) after selecting the dropdown)
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		staticDropDown.click();
		Select staticDrop = new Select(staticDropDown);
	    staticDrop.selectByIndex(0);
	    System.out.println(staticDrop.getFirstSelectedOption().getText());
	    staticDrop.selectByValue("INR");
	    System.out.println(staticDrop.getFirstSelectedOption().getText());
	    staticDrop.selectByVisibleText("AED");
	    System.out.println(staticDrop.getFirstSelectedOption().getText());
	    
	    //2nd i.e latest dropdown increasing and decreasing (+,-),please open the site in incognito mode then only will be visible the adult part)
	    
	    WebElement adult = driver.findElement(By.id("divpaxinfo"));
	    adult.click();
	    Thread.sleep(2000);
	    WebElement increase = driver.findElement(By.id("hrefIncAdt"));
	   
	    int i=1;
	    while(i<5){
	    	increase.click();
	        i++;
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();

    
//	    //3rd dynamic dropdown(when after selecting the dropdown only then options are visible)
//	    //from city  , To city
//	    //departure city, arrival city
	    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	    driver.findElement(By.xpath("//a[text()=' Pune (PNQ)']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[text()=' Bengaluru (BLR)'])[2]")).click();
	    
	    //4th date drop down
//	    driver.findElement(By.xpath("//*[@id='flightSearchContainer']/div[4]/button")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']/a")).click();
	    System.out.println(driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']/a")).getText());
	    
	    //5th Auto suggestive drop down(based upon input output displaying)
	    driver.findElement(By.xpath("//input[@placeholder='Type to Select']")).sendKeys("Ind");
	    Thread.sleep(2000);
	    List<WebElement> indiaSearch = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	    for(WebElement india: indiaSearch ) {
	        Thread.sleep(2000);
	    	if(india.getText().equals("India")) {
	    		india.click();
	        }
	    }
	    driver.close();
	 
    }
}
