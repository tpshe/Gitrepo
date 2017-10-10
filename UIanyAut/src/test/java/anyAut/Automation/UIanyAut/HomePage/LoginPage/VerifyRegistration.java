package anyAut.Automation.UIanyAut.HomePage.LoginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;
//import anyAut.Automation.UIanyAut.UIAction.RegistraionPage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class VerifyRegistration extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());
	HomePage  registration;
		
	@BeforeTest
	public void setUp()
	{
	callURL();
			
	System.out.println("Done");
			
	}
	@Test
	public void vefifywithvalidcredential() throws Exception{
		log.info("*****Starting a Test*********");
		registration=new HomePage(driver);
		registration.verifyRegistration("nalini", "kapoor"," nalini.kapoor@gmail.com","nalini@kapoor" ,"nalini@kapoor");
	//	WebDriverWait pageWait = new WebDriverWait(driver, 30);
		//pageWait.until(ExpectedConditions.presenceOfElementLocated((By) driver.findElement(By.name("register"))));
		registration.contactInformation("ABC","Tester", "1234566789","US");
		log.info("*****Ending a Test************");
		}


	@AfterTest
	public void tearDown(){
		//driver.close();
		
	}

}
