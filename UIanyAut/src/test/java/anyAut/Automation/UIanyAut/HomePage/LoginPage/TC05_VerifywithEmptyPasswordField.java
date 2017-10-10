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

public class TC05_VerifywithEmptyPasswordField extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());
	HomePage homepage;
	String emailAddress="";
	String password="";
		
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestDataLogin1.xlsx","TC005");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
	System.out.println("Done");
			
	}
	@Test(dataProvider="loginData")
	public void verifywithemptypasswordfield(String username,String msg){
		log.info("*****Starting login with Different Records*********");
		homepage=new HomePage(driver);
		homepage.loginwithemptypasswordField(username);
		System.out.println("Done");
		//homepage.dashboadlink();
		System.out.println(homepage.pwdErrorMsg());
		//System.out.println(homepage.userErrorMsg());
		//Assert.assertEquals(homepage.userErrorMsg(),msg1);
		
		
		Assert.assertEquals(homepage.pwdErrorMsg(),msg);
		try {
			getScreenShot("TC05_VerifywithEmptyPasswordField");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending login with Different Records************");
		}


	@AfterTest
	public void tearDown(){
		driver.close();
		
	}
}

