package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

driver.get("http://leaftaps.com/opentaps/control/main");
driver.findElement(By.id("username")).sendKeys("DemoCSR");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.partialLinkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Find Leads")).click();
driver.findElement(By.id("ext-gen248")).sendKeys("jeevitha");

driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
String title= driver.getTitle();
System.out.println(title);
Thread.sleep(3000);
String text = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col')]/a")).getText();
System.out.println("Lead number"+text);
driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col')]/a")).click();
driver.findElement(By.linkText("Edit")).click();

driver.findElement(By.id("updateLeadForm_companyName")).clear();
driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("testleaf");
driver.findElement(By.name("submitButton")).click();
String updatedcompname= "testleaf";
String compname=driver.findElement(By.id("viewLead_companyName_sp")).getText();
if(compname.contains(updatedcompname))
{
	System.out.println("company name updated");
}
else
{
	System.out.println("company name not updated");
}

	
}
	}

