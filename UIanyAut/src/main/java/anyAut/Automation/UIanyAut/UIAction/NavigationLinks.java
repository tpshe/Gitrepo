package anyAut.Automation.UIanyAut.UIAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class NavigationLinks  extends ReusbleFunctions{
	
	
	
@FindBy(xpath="//span[@class='fa fa-chevron-down']")
WebElement testPlan;

@FindBy(linkText="Test Setup")
WebElement testSetUp;

@FindBy(linkText="AUT")
WebElement aut;
	

@FindBy(linkText="Modules")
WebElement modules;

@FindBy(linkText="Test Cases")
WebElement testCases;

@FindBy(linkText="Test Steps")
WebElement testSteps;

@FindBy(linkText="Reusable Components")
WebElement reusableComponents;

@FindBy(linkText="Element Map")
WebElement elementMap;

@FindBy(linkText="Test Data")
WebElement testData;

@FindBy(linkText="User Defined Keywords")
WebElement UDK;

@FindBy(linkText="Built-In Keywords")
WebElement BIK;
@FindBy(xpath="//a[@href='http://anyaut.com/orange/add-test-steps.php']")
WebElement dashboardteststep;


public void clickondashboardteststeps(){
	
	dashboardteststep.click();
}
public NavigationLinks(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void testPlannavigationLink(){
	testPlan.click();
	testSetUp.click();
}
public void clickonmodulLinks(){
	
	//navigationLink();
	modules.click();
	
}
public void clickonautLinks() throws InterruptedException{
	
	testPlannavigationLink();
	aut.click();
	Thread.sleep(2000);
	//waitForElement(20,modules);
}
public void clickontestCaseslimk() throws InterruptedException{
	
	//navigationLink();
	testCases.click();
	Thread.sleep(2000);
}
public void clickontesttestSteps(){
	
	//navigationLink();
	testSteps.click();
}
public void reusableComponentsLinks(){
	reusableComponents.click();
}
public void clickOnElementMap() throws InterruptedException
{

Thread.sleep(2000);
elementMap.click();
}


public void clickOnTestData()
{
testData.click();

}
public void clickOnUserDefinedKeywords()
{
UDK.click();

}
public void clickOnBuiltInKeywords()
{
BIK.click();
}

}
