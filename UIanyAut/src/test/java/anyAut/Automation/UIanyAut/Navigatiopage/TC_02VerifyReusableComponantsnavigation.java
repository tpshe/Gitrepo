package anyAut.Automation.UIanyAut.Navigatiopage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.UIAction.NavigationLinks;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC_02VerifyReusableComponantsnavigation extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC_01VerifyNavigationtoTestPlanLinks.class.getName());

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
@DataProvider(name="linkData")
public String[][] getTestData(){
	String[][] testRecords=getData("TestLogin.xlsx","LoginTestData");
	return testRecords;
}
@Test(dataProvider="linkData")
public void verifywithvalidcredential(String emailAddress,String password,String runMode) throws InterruptedException
{
	log.info("*****Starting a test with navigating to the Reusable Components Links *********");
	log.info("user name is :" +emailAddress+ "and password is "+ password);
	homepage=new HomePage(driver);
	navigation=new NavigationLinks(driver);
	
	homepage.logintoApplication(emailAddress,password);
	navigation.testPlannavigationLink();
	navigation.reusableComponentsLinks();
	Thread.sleep(1000);
	navigation.clickOnElementMap();
	Thread.sleep(1000);
	navigation.clickOnTestData();
	Thread.sleep(1000);
	navigation.clickOnBuiltInKeywords();
	Thread.sleep(1000);
	navigation.clickOnUserDefinedKeywords();
	//Assert.assertEquals(true, homepage.dashboadlink());
	log.info("*****Ending a test with navigating to the Reusable Components Links *********");
	
	}


@AfterTest
public void tearDown(){
	driver.close();
}
}



 
