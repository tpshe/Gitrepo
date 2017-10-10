package anyAut.Automation.UIanyAut.UIAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import anyAut.Automation.UIanyAut.testBase.ReusbleFunctions;
//
public class HomePage extends ReusbleFunctions {
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
// Webelement for the Login page usa

@FindBy(id="username")
WebElement username;

@FindBy(id="password")
WebElement pwd;

@FindBy(id="singlebutton")
WebElement signButton;


@FindBy(linkText="Dashboard")
WebElement dbdlink;

@FindBy(css="a.user-profile")
WebElement userProfile;

@FindBy(xpath="//a[@href='logout.php']")
WebElement logout;


//WebElements for the Regisration Page 

@FindBy(css="a.register-button")
WebElement register;

@FindBy(id="firstname")
WebElement firstName;

@FindBy(id="lastname")
WebElement lastName;


@FindBy(id="email")
WebElement emailID;


@FindBy(id="password")
WebElement Pwd;

@FindBy(id="confirmpassword")
WebElement CoPpwd;

@FindBy(xpath=".//*[@id='singlebutton']")
WebElement proceedBtn;


@FindBy(id="company")
WebElement company;

@FindBy(id="designation")
WebElement designation;

@FindBy(id="phone")
WebElement phone;

@FindBy(id = "country")
WebElement mySelectObj;



@FindBy(name="register")
WebElement registerBtn;
//Error message for entering invalid password or email
@FindBy(xpath="//div[@id='alert-error']")
WebElement errorMessage;
//Error message for leaving username and password blank


@FindBy(xpath="//label[@id='username-error']")
WebElement usernameErromsg;

@FindBy(xpath="//label[@id='password-error']")
WebElement passwordErrorMsg;

//method for the Login page 
  public HomePage(WebDriver driver){
	  {
		  PageFactory.initElements(driver,this);
	  }
	
	
}
public void logintoApplication(String usernm,String password ){
	log.info("Entered username is "+username + " and the onject is "+ username.toString());
	username.sendKeys(usernm);	
	log.info("Entered password  is "+pwd + " and the onject is "+ pwd.toString());
	pwd.sendKeys(password);
	signButton.click();
	
}
public void logintoAppwithEmptyfield(){
	signButton.click();
}
public void loginwithemptypasswordField(String usernm){
	log.info("Entered username is "+username + " and the object is "+ username.toString());
	username.sendKeys(usernm);	
	signButton.click();
}

public void loginwithemptyusernameField(String password){
	log.info("Entered password  is "+password + " and the object is "+ password.toString());
	pwd.sendKeys(password);	
	signButton.click();
}
public void loginwithinvalidusernameField(String unm){
	log.info("Entered password  is "+unm+ " and the object is "+ unm.toString());
	pwd.sendKeys(unm);	
	signButton.click();
}
public boolean dashboadlink(){
 try{
	// waitFor(300,dbdlink);
 dbdlink.isDisplayed(); 
 return true;
 }
 catch(Exception e){
	 return false;
 }
 
	
}
public boolean verifyLogOutDisplay(){
	try{
		
		userProfile.click();
		waitForElement(30,logout);
	logout.isDisplayed();
	log.info("log out is dispay and the object is "+log.toString());
	return true;
	}
catch(Exception e){
	return false;
}
}

public void clickOnLogout(){
	verifyLogOutDisplay();
	logout.click();
	log.info("Click on Logout and the object is "+ logout.toString());
	
}
//Method for the error message

public String erroMsg()
{
	
	String eMSG=errorMessage.getText();
	return eMSG;
	
}
//Method for the wrong email id

public String userErrorMsg()
{
	
	String eMSG=usernameErromsg.getText();
	return eMSG;
	
}
public String pwdErrorMsg()
{
	
	String eMSG=passwordErrorMsg.getText();
	return eMSG;
	
}


//method for the Registration page 
public void verifyRegistration(String fstnm,String lnm,String email,String pwd,String CPwd){
	register.click();
	firstName.sendKeys(fstnm);
	lastName.sendKeys(lnm);
	emailID.sendKeys(email);
	Pwd.sendKeys(pwd);
	CoPpwd.sendKeys(CPwd);
	proceedBtn.click();
	
}

public void contactInformation(String com,String des,String pn,String country){
	company.clear();
	company.sendKeys(com);
	designation.clear();
	designation.sendKeys(des);
	phone.clear();
	phone.sendKeys(pn);
	Select obj=new Select(mySelectObj);
	obj.selectByValue(country);
	registerBtn.click();
}
public String registrationMessage(){
	return null;
	
}

}
