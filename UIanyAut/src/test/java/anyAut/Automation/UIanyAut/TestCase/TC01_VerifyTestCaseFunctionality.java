package anyAut.Automation.UIanyAut.TestCase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import anyAut.Automation.UIanyAut.UIAction.AUTDetailPage;
import anyAut.Automation.UIanyAut.UIAction.DashboardPage;
import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.UIAction.NavigationLinks;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC01_VerifyTestCaseFunctionality extends ReusbleFunctions{
	public static final Logger log=Logger.getLogger(TC01_VerifyTestCaseFunctionality.class.getName());
	HomePage homepage;
	HomePage registration;
	NavigationLinks navigation;
	AUTDetailPage  aut;	
	DashboardPage dashboard;
	
	
		
	@DataProvider(name="AUT")
	public String[][] getTestData(){
		String[][] testRecords=getData("TestAut.xlsx","TC003");
		return testRecords;
	}
	
	
	@BeforeTest
	public void setUp()
	{
	callURL();
	
	}
	@Test(dataProvider="AUT")
	public void VerifyAUTaddTestCaseFunctionality(String username,String pwd,String w3,String id,String desc) throws InterruptedException
	{
		log.info("*****Starting AUT adding test********");
		homepage=new HomePage(driver);
		navigation=new NavigationLinks(driver);
		aut=new AUTDetailPage(driver);
		dashboard=new DashboardPage(driver);
		homepage.logintoApplication(username, pwd);
		navigation.clickonautLinks();
		navigation.clickontestCaseslimk();
		dashboard.addEditTestCaseTC(w3,id,desc);
		Thread.sleep(2000);
		log.info("*****Ending AUT adding test********");
		}
	
	
		
	@AfterTest
	public void tearDown(){
		driver.close();
		
	}
}
