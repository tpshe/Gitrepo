package anyAut.Automation.UIanyAut.UIAction;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class DashboardPage extends ReusbleFunctions{
static String mID="";
	
	
	@FindBy(id="test_case_id" )
	WebElement testCaseID;
	
	@FindBy(id="test_case_description" )
	WebElement testCaseDesc;
	
	
	@FindBy(id="add-test-case")
	WebElement addTestCaseBtn;
	
	
	//Select Module in Testcase Module
	
	
	@FindBy(xpath="//span[@id='select2-test_case_module_id-container']")
	WebElement moduleID;
	
	@FindBy(xpath="//ul[@id='select2-test_case_module_id-results']//li")
	List<WebElement>mIDSelection;
	
	
	 public DashboardPage(WebDriver driver){
		  {
			  PageFactory.initElements(driver,this);
		  }
				
	}
	 
	 
	 
	 
	 //This method is to select module in the test case module 
	 public void selectfromDropDownmoduleIDinTC(String w3){
		 moduleID.click();
		   
		  List<WebElement> moduleIDDropdown= mIDSelection;
		  int modulesize=moduleIDDropdown.size();
		    for(int i=0;i<modulesize;i++)
		  {
			 WebElement x=moduleIDDropdown.get(i);
			 mID=x.getAttribute("innerHTML");
			  System.out.println(mID);
			  if(mID.equalsIgnoreCase(w3)){
				  x.click();
				  break;
		 }
		 
	 }
	 }
	  
	 public void addEditTestCaseTC(String w3,String id,String desc) throws InterruptedException {
			
			Thread.sleep(2000);
			selectfromDropDownmoduleIDinTC(w3);
			Thread.sleep(2000);
			testCaseID.sendKeys(id);
			testCaseDesc.clear();
			testCaseDesc.sendKeys(desc);
			addTestCaseBtn.click();
			Thread.sleep(2000);
		}
	 
	 
	
}
