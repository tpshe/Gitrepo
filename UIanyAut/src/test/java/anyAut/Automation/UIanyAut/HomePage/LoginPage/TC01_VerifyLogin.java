package anyAut.Automation.UIanyAut.HomePage.LoginPage;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.UIAction.NavigationLinks;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC01_VerifyLogin extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyLogin.class.getName());

HomePage homepage;
String emailAddress="";
String password="";
NavigationLinks navigation;
	
@BeforeTest
public void setUp()
{
callURL();
		
System.out.println("Done");
		
}
@DataProvider(name="loginData")
public String[][] getTestData(){
	String[][] testRecords=getData("TestDataLogin1.xlsx","TC001");
	return testRecords;
}
@Test(dataProvider="loginData")
public void verifywithvalidcredential(String emailAddress,String password,String runMode ) throws IOException{
	log.info("*****Starting a test with valid email address and password *********");
	log.info("user name is :" +emailAddress+ "and password is "+ password);
	homepage=new HomePage(driver);
	
	homepage.logintoApplication(emailAddress,password);
	homepage.dashboadlink();
	getScreenShot("TC01_VerifyLogin");
	Assert.assertEquals(true, homepage.dashboadlink());
	
	log.info("*****Ending  test with valid email address and password *********");
	
	}


@AfterTest
public void tearDown(){
	driver.close();
}
}
