package seleniumgluecode;

import cucumber.api.java.en.Given;
import java.net.HttpURLConnection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Assert;

public class Test1 {
    public static WebDriver driver;
    
@Given("^user is  on homepage$")
public void user_is_on_homepage() throws Throwable 

{
    
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://award.wcltest.com/");
}

@When("^user click on sign in button$")
public void user_click_on_sign_in_button() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div[2]/div[2]/a/span[2]")).click();
}

@When("^user enters username and Password$")
public void user_enters_username_and_Password() throws Throwable {
   driver.findElement(By.id("email")).sendKeys("himanshi.sharma@williamscommerce.com");
   driver.findElement(By.id("pass")).sendKeys("tester@111");
   screenshot("valid login",".png");
}
@Then("^user click on login button$")
public void user_click_on_login_button() throws Throwable {
	 driver.findElement(By.name("send")).click();
	 
}


@Then("^success message is displayed$")
public void success_message_is_displayed() throws Throwable {
	
}

private void screenshot(String fileName,String extension) throws IOException {
	
	TakesScreenshot scr = (TakesScreenshot)driver;
	String timestamp = new SimpleDateFormat("DD-MM-YY").format(new Date());
	File scrFile = scr.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("./Screenshot/" + fileName+" "+timestamp+ extension));
}


}
