package anyAut.Automation.UIanyAut.HomePage.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC02_VerifyLoginwithInvalidData extends ReusbleFunctions {
	HomePage homepage;
	String emailAddress="";
	String password="";
		
	@BeforeTest
	public void setUp()
	{
	callURL();
			
	System.out.println("Done");
			
	}
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestDataLogin1.xlsx","TC002");
		return testRecords;
	}
	@Test(dataProvider="loginData")
	public void verifywithinvalidcredential(String emailAddress,String password,String msg,String runMode ) throws IOException{
		log.info("*****Starting a test with valid email address and password *********");
		log.info("user name is :" +emailAddress+ "and password is "+ password);
		homepage=new HomePage(driver);
		homepage.logintoApplication(emailAddress,password);
		System.out.println(homepage.erroMsg());
		getScreenShot("TC02_VerifyLoginwithInvalidData");
		Assert.assertEquals(homepage.erroMsg(),msg);
		
		//homepage.dashboadlink();
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending  test with valid email address and password *********");
		
		}


	@AfterTest
	public void tearDown(){
		driver.close();
	}
	}

