package anyAut.Automation.UIanyAut.HomePage.LoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC04_VefifyLoginwithemptyfields extends ReusbleFunctions {
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());
	HomePage homepage;
	String emailAddress="";
	String password="";
		
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestDataLogin1.xlsx","TC004");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
			
	System.out.println("Done");
			
	}
	@Test(dataProvider="loginData")
	public void verifywithemptypasswordfield(String uname,String msg) throws IOException{
		log.info("*****Starting login with empty password field*********");
		homepage=new HomePage(driver);
		homepage.loginwithemptypasswordField(uname);
		System.out.println("Done");
		System.out.println(homepage.pwdErrorMsg());
		getScreenShot("TC04_VefifyLoginwithemptyfields");
		Assert.assertEquals(homepage.pwdErrorMsg(),msg);
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending login with empty password field*********");
		}


	@AfterTest
	public void tearDown(){
		driver.close();
		
	}
}

