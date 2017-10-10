package anyAut.Automation.UIanyAut.HomePage.LoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;

import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;


public class TC03_VerifyWithDifferentData extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());
	HomePage homepage;
	String emailAddress="";
	String password="";
		
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestDataLogin1.xlsx","TC003");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
			
	System.out.println("Done");
			
	}
	@Test(dataProvider="loginData")
	public void verifywithvalidcredential(String emailAddress,String password,String runMode){
		if(runMode.equalsIgnoreCase("N")){ 
			throw new SkipException("User marked as no run for the testcase");
		}
		log.info("*****Starting login with Different Records*********");
		homepage=new HomePage(driver);
		
		homepage.logintoApplication(emailAddress, password);
		homepage.clickOnLogout();
		//boolean dply=homepage.verifyLogOutDisplay();
		//Assert.assertEquals(true, dply);
		//if(dply){
			//homepage.clickOnLogout();
		//Assert.assertEquals(homepage.dashboadlink(),true);
		//}
		//Assert.assertEquals(true, dply);
		try {
			getScreenShot("TC_03VerifyWithDifferentData");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("*****Ending login with Different Records************");
		}


	@AfterTest
	public void tearDown(){
		driver.close();
		
	}
}
