package anyAut.Automation.UIanyAut.TestStep;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import anyAut.Automation.UIanyAut.TestCase.TC01_VerifyTestCaseFunctionality;
import anyAut.Automation.UIanyAut.UIAction.AUTDetailPage;
import anyAut.Automation.UIanyAut.UIAction.DashboardPage;
import anyAut.Automation.UIanyAut.UIAction.HomePage;
import anyAut.Automation.UIanyAut.UIAction.NavigationLinks;
import anyAut.Automation.UIanyAut.UIAction.TestCasStepPage;
import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TC01_VerifytestCaseStepFuctionlality extends ReusbleFunctions{
		public static final Logger log=Logger.getLogger(TC01_VerifyTestCaseFunctionality.class.getName());
		HomePage homepage;
		HomePage registration;
		NavigationLinks navigation;
		AUTDetailPage  aut;	
		DashboardPage dashboard;
		TestCasStepPage testStep;
		
		
			
		@DataProvider(name="AUT")
		public String[][] getTestData(){
			String[][] testRecords=getData("TestAut.xlsx","TC004");
			return testRecords;
		}
		
		
		@BeforeClass
		public void setUp()
		{
		callURL();
		
		}
		@Test(dataProvider="AUT")
		public void VerifyaddTestStepFunctionality(String username,String pwd,String w3,String w4,String tsID,String desc,String bik,String w6,String desc1,String tdenter) throws Exception 
		{
			log.info("*****Starting AUT adding test********");
			homepage=new HomePage(driver);
			navigation=new NavigationLinks(driver);
			aut=new AUTDetailPage(driver);
			testStep=new TestCasStepPage(driver);
			dashboard=new DashboardPage(driver);
			homepage.logintoApplication(username,pwd);
			navigation.clickondashboardteststeps();
			//navigation.clickontesttestSteps();
			testStep.selectfromDropDownModuleID(w3);
			testStep.selectfromDropDownTestcaseID(w4);		
		    testStep.enterteststepidanddesc(tsID,desc);
		    testStep.selectBIKtypeofelement(bik);
		    testStep.selectypeofElement( w6,desc1,tdenter);
		    
			
			}
		
				
		@AfterTest
		public void tearDown(){
			driver.close();
			
		}
}
