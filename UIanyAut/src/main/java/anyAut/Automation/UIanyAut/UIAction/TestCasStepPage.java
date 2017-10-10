package anyAut.Automation.UIanyAut.UIAction;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;

public class TestCasStepPage extends ReusbleFunctions {
	public static final Logger log = Logger.getLogger(TestCasStepPage.class.getName());
	static String ID = "";

	// To select module id in the test step module

	@FindBy(xpath = "//span[@id='select2-test_step_module_id-container']")
	WebElement clickmoduleid;

	@FindBy(xpath = "//ul[@id='select2-test_step_module_id-results']//li")
	List<WebElement> moduleIDSelect;

	// To select test case id in the test step module

	@FindBy(xpath = "//span[@id='select2-test_step_test_case_id-container']")
	WebElement clicktestcasefield;

	@FindBy(xpath = "//ul[@id='select2-test_step_test_case_id-results']//li")
	List<WebElement> testCaseIDSelect;

	// Test Step ID
	@FindBy(xpath = "//input[@id='test_step_id']")
	WebElement teststepID;

	@FindBy(id = "test_step_description")
	WebElement teststepdesc;

	// select a userdefined keyword or build in keyword

	@FindBy(xpath = "//input[@name='keyword_type'][2]")
	WebElement radiobttypeofkw;

	@FindBy(xpath = "//span[@id='select2-low_level_key_word-container']")
	WebElement selectBIKW;

	@FindBy(xpath = "//ul[@id='select2-low_level_key_word-results']//li")
	List<WebElement> buidinkeywordstype;

	@FindBy(xpath = "//input[@name='element_type'][2]")
	WebElement radiobttypeofelement;

	@FindBy(xpath = "//ul[@id='select2-element_type-results']//li")
	List<WebElement> elementtype;

	@FindBy(xpath = "//span[@id='select2-element_type-container']")
	WebElement selectelementID;

	@FindBy(id = "element_user_entered")
	WebElement userentertdforeID;

	@FindBy(xpath = "//input[@name='testdata_type'][2]")
	WebElement radiobttypeoftd;

	@FindBy(id = "td_user_entered")
	WebElement userentertd;

	// test step button
	@FindBy(id = "add-test-step")
	WebElement teststepbtn;

	public TestCasStepPage(WebDriver driver) {
		{
			PageFactory.initElements(driver, this);
		}
	}

	public void selectModuleIDTS(String w3) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> moduleIDDropdown = moduleIDSelect;
		int modulesize = moduleIDDropdown.size();

		for (int i = 0; i < modulesize; i++) {
			WebElement x = moduleIDDropdown.get(i);
			String mID = x.getAttribute("innerHTML");
			System.out.println(mID);
			System.out.println(mID.length());
			if (mID.contains(w3)) {
				x.click();
				break;
			}
			Thread.sleep(1000);

		}
	}

	public void selectTestCaseIDTS(String w3) throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> TestCaseIDDropdown = testCaseIDSelect;
		int testCasesize = TestCaseIDDropdown.size();

		for (int i = 0; i < testCasesize; i++) {
			WebElement x = TestCaseIDDropdown.get(i);
			ID = x.getAttribute("innerHTML");
			System.out.println(ID);
			if (ID.contains(w3)) {
				x.click();
				break;

			}

		}
	}

	public void selectBIK(String w3) throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> BIKIDDropdown = buidinkeywordstype;
		int BIKsize = buidinkeywordstype.size();

		for (int i = 0; i < BIKsize; i++) {
			WebElement x = BIKIDDropdown.get(i);
			String mID = x.getAttribute("innerHTML");
			// System.out.println(mID);
			// System.out.println(mID.length());
			if (mID.contains(w3)) {
				x.click();
				break;
			}
			Thread.sleep(1000);

		}

	}

	public void selectelement(String w3) throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> elemnetIDDropdown = elementtype;
		int BIKsize = elementtype.size();

		for (int i = 0; i < BIKsize; i++) {
			WebElement x = elemnetIDDropdown.get(i);
			String mID = x.getAttribute("innerHTML");
			// System.out.println(mID);
			// System.out.println(mID.length());
			if (mID.contains(w3)) {
				x.click();
				break;
			}
			Thread.sleep(1000);

		}

	}

	public void selectfromDropDownModuleID(String w3) throws InterruptedException {
		clickmoduleid.click();
		Thread.sleep(2000);
		selectModuleIDTS(w3);
		Thread.sleep(2000);

	}

	public void selectfromDropDownTestcaseID(String w4) throws InterruptedException {
		clicktestcasefield.click();
		Thread.sleep(2000);
		selectTestCaseIDTS(w4);
		Thread.sleep(2000);

	}

	public void enterteststepidanddesc(String tsID, String desc) {
		teststepID.sendKeys(tsID);
		teststepdesc.sendKeys(desc);
	}

	public void selectBIKtypeofelement(String bik) throws InterruptedException {
		radiobttypeofkw.click();
		selectBIKW.click();
		selectBIK(bik);
	}

	public void selectypeofElement(String w6, String desc, String tdenter) throws InterruptedException {
		radiobttypeofelement.click();
		selectelement(w6);
		userentertdforeID.sendKeys(desc);
		radiobttypeoftd.click();
		userentertd.sendKeys(tdenter);
		teststepbtn.click();
		

	}
}
