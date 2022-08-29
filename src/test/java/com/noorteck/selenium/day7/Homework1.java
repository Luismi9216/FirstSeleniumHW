package com.noorteck.selenium.day7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Homework1 {

	private static final String WebElement = null;
	WebDriver driver;

	public void setUp() {
		String key = "webdriver.chrome.driver";
		String path = "C:\\Users\\airmo\\OneDrive\\Escritorio\\B7-Selenium\\chromedriver.exe";
		System.setProperty(key, path);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

	// right click
	public void rightClickTest() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		Actions action = new Actions(driver);
		WebElement rightClick = driver.findElement(By.xpath("//*[contains(text(), 'right click me')]"));
		action.contextClick(rightClick).build().perform();
		WebElement copyBt = driver.findElement(By.xpath("//*[@class='context-menu-list context-menu-root']//li[3]"));
		copyBt.click();

		String actText = driver.switchTo().alert().getText();
		System.out.println("ActualT : " + actText);
		driver.switchTo().alert().accept();

	}

	// double click
	public void doubleClickTest() {
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");

		WebElement doubleC = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));

		String expText = "You double clicked me.. Thank You..";

		Actions action = new Actions(driver);

		action.doubleClick(doubleC).build().perform();

		Alert alert = driver.switchTo().alert();
		String actText = alert.getText();
		System.out.println("Alert Message:" + actText);
		alert.accept();

		System.out.println("Exp: " + expText);
		System.out.println("Act: " + actText);

		Assert.assertEquals(actText, expText, "Double Click Test Failed");
	}
	public void dragAndDrop() throws InterruptedException {
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		// capitals
		WebElement capital1 = driver.findElement(By.xpath("//*[contains(text(),'Stockholm')][2]"));
		WebElement capital2 = driver.findElement(By.xpath("//*[contains(text(),'Washington')][2]"));
		WebElement capital3 = driver.findElement(By.xpath("//*[contains(text(),'Copenhagen')][2]"));
		WebElement capital4 = driver.findElement(By.xpath("//*[contains(text(),'Seoul')][2]"));
		WebElement capital5 = driver.findElement(By.xpath("//*[contains(text(),'Rome')][2]"));
		WebElement capital6 = driver.findElement(By.xpath("//*[contains(text(),'Madrid')][2]"));
		WebElement capital7 = driver.findElement(By.xpath("//*[contains(text(),'Oslo')][2]"));
		// countries	
		WebElement country1 = driver.findElement(By.xpath("//*[contains(text(),'Italy')]"));
		WebElement country2 = driver.findElement(By.xpath("//*[contains(text(),'Spain')]"));
		WebElement country3 = driver.findElement(By.xpath("//*[@id='box101']"));
		WebElement country4 = driver.findElement(By.xpath("//*[contains(text(),'Denmark')]"));
		WebElement country5 = driver.findElement(By.xpath("//*[contains(text(),'South Korea')]"));
		WebElement country6 = driver.findElement(By.xpath("//*[contains(text(),'Sweden')]"));
		WebElement country7 = driver.findElement(By.xpath("//*[contains(text(),'United States')]"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(capital2,country7 ).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital5, country1).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital4, country5).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital6, country2).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital1, country6).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital3,country4).release().build().perform();
		Thread.sleep(1000);
		
		action.dragAndDrop(capital7,country3).release().build().perform();
		Thread.sleep(1000);
		
		
		System.out.println("Done...");
		
	}
	public void addNewJob() {
	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab --parent'][1]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Job Titles')]")).click();
		
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys("SDET");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")).sendKeys("Software Development Engineer in Test");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")).sendKeys("I am qualified for Sdet");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")).click();
		
		String expText = "SDET";
		String actText = driver.findElement(By.xpath("//*[contains(text(),'SDET')]")).getText();
		
		Assert.assertEquals(actText, expText, "Job title didn't match");
		System.out.println("Done...");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
