package anyAut.Automation.UIanyAut.RegistrationPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import anyAut.Automation.UIanyAut.HomePage.LoginPage.TC01_VerifyLogin;
import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC_01VerifyRegistationwithValidCredential extends ReusbleFunctions{

	public static final Logger log=Logger.getLogger(TC_01VerifyRegistationwithValidCredential.class.getName());
	HomePage registration;
	String emailAddress="";
	String password="";
		
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestDataRegistration.xlsx","TC001");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
	
	System.out.println("Done");
			
	}
	@Test(dataProvider="loginData")
	public void verifywithinvlaidRegistrationfield(String frstnm,String lastname,String email,String pwd,String cpwd,String com,String desg,String phone,String country)
	{
		log.info("*****Starting Regisration with valid credential*********");
		registration=new HomePage(driver);
		registration.verifyRegistration(frstnm, lastname, email, pwd,cpwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registration.contactInformation(com,desg,phone,country);
		System.out.println("Done");
		//homepage.dashboadlink();
		//System.out.println(homepage.userErrorMsg());
		//System.out.println(homepage.userErrorMsg());
		//Assert.assertEquals(homepage.userErrorMsg(),msg1);
		try {
			getScreenShot("TC_01VerifyRegistationwithValidCredential");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert.assertEquals(homepage.userErrorMsg(),msg);
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending  Regisration with valid credential*********");
		}



	@AfterTest
	public void tearDown(){
		driver.close();
		
	}

}
