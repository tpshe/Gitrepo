package anyAut.Automation.UIanyAut.AUTPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.UIAction.AUTDetailPage;
import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.UIAction.NavigationLinks;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC01_VerifyAUTaddFunctionality extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyAUTaddFunctionality.class.getName());
	HomePage homepage;
	HomePage registration;
	NavigationLinks navigation;
	AUTDetailPage  aut;	
	
	
		
	@DataProvider(name="AUT")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestAut.xlsx","TC002");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
	System.out.println("Done");
			
	}
	@Test(dataProvider="AUT")
	public void VerifyAUTaddmoduleFunctionality(String username,String pwd,String module,String mID,String mDescription) throws InterruptedException
	{
		log.info("*****Starting AUT adding test********");
		homepage=new HomePage(driver);
		navigation=new NavigationLinks(driver);
		aut=new AUTDetailPage(driver);
		homepage.logintoApplication(username, pwd);
		navigation.clickonautLinks();
		navigation.clickonmodulLinks();
		Thread.sleep(2000);
		aut.addEditModules(module,mID,mDescription);
		Thread.sleep(5000);
		
		
		
		System.out.println("Done");
		//homepage.dashboadlink();
		//System.out.println(homepage.userErrorMsg());
		//System.out.println(homepage.userErrorMsg());
		//Assert.assertEquals(homepage.userErrorMsg(),msg1);
	/*	try {
			getScreenShot("TC_01VerifyRegistationwithValidCredential");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Assert.assertEquals(homepage.userErrorMsg(),msg);
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending  AUT adding test********");
		}

	@Test(dataProvider="AUT",enabled=false)
	public void VerifyAUTaddFunctionality(String username,String pwd,String autName,String url,String industry) throws InterruptedException
	{
		log.info("*****Starting AUT adding test********");
		homepage=new HomePage(driver);
		navigation=new NavigationLinks(driver);
		aut=new AUTDetailPage(driver);
		homepage.logintoApplication(username, pwd);
		navigation.clickonautLinks();
		navigation.clickonmodulLinks();
		Thread.sleep(2000);
		aut.addEditModules("Login", "anyAut_Login", "This module is for Login functionality");
		
		
		
		
		System.out.println("Done");
		//homepage.dashboadlink();
		//System.out.println(homepage.userErrorMsg());
		//System.out.println(homepage.userErrorMsg());
		//Assert.assertEquals(homepage.userErrorMsg(),msg1);
	/*	try {
			getScreenShot("TC_01VerifyRegistationwithValidCredential");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Assert.assertEquals(homepage.userErrorMsg(),msg);
		//Assert.assertEquals(true, homepage.dashboadlink());
		log.info("*****Ending  AUT adding test********");
		}



	@AfterTest
	public void tearDown(){
		driver.close();
		
	}
}
