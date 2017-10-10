package anyAut.Automation.UIanyAut.HomePage.LoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import anyAut.Automation.UIanyAut.RegistrationPage.TC_01VerifyRegistationwithValidCredential;
import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC07_VerifywithInvalidUsername extends ReusbleFunctions{
	
	
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());
	HomePage homepage;
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
	public void verifywithinvlaidusernamefield(String usrnm1,String pwd1,String msg){
		log.info("*****Starting login with Different Records*********");
		homepage=new HomePage(driver);
		homepage.logintoApplication(usrnm1,pwd1);
		System.out.println("Done");
		//homepage.dashboadlink();
		System.out.println(homepage.userErrorMsg());
		//System.out.println(homepage.userErrorMsg());
		//Assert.assertEquals(homepage.userErrorMsg(),msg1);
		
		try {
			getScreenShot("TC07_VerifywithInvalidUsername");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(homepage.userErrorMsg(),msg);
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending login with Different Records************");
		}

	
	@AfterTest
	public void tearDown(){
		driver.close();
		
	}

}
