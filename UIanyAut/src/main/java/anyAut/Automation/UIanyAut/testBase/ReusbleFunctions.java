package anyAut.Automation.UIanyAut.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import anyAut.Automation.UIanyAut.excelReader.ExcelReader;
import anyAut.Automation.UIanyAut.excelReader.Excel_Reader;

public class ReusbleFunctions {
	public static final Logger log = Logger.getLogger(ReusbleFunctions.class.getName());
	public WebDriver driver;
	String url = "https://anyaut.com/orange/";
	String browser = "Chrome";
	Excel_Reader excel;

	public void callURL() {
		selectBrowser(browser);
		getURL(url);
		String log4J = "log4j.properties";
		PropertyConfigurator.configure(log4J);
	}

	public void getURL(String url) {
		log.info("Navigating to " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sheet\\Documents\\Selenium\\Driver\\chromedriver.exe");
			log.info("Creating a object of " + browser);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\sheet\\Documents\\Selenium\\Driver\\IEdriverServer.exe");
			log.info("Creating a object of " + browser);
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("IEdge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\sheet\\Documents\\Selenium\\Driver\\MicrosoftWebDriver.exe");
			log.info("Creating a object of " + browser);
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sheet\\Documents\\Selenium\\Driver\\chromedriver.exe");
			log.info("Creating a object of " + browser);
			driver = new ChromeDriver();
		}
	}

	public String[][] getData(String excelName, String sheetName) {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\anyAut\\Automation\\UIanyAut\\data\\"
				+ excelName;
		excel = new Excel_Reader(path);

		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	public void waitForElement(int timeoutseconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnDashboardLinks() {

	}

	public void getScreenShot(String fileName) throws IOException {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "//src//main//java//anyAut//Automation//UIanyAut//uiActions//screenshot//";
			File destFile = new File(
					(String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
