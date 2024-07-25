package com.qa.pageObjects;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public Logger logger;
	public Properties pro;
	public FileInputStream fis;
	public ExtentReports extentReport;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	public static Date date = new Date();
	public static String actualDate = sdf.format(date);
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		try {
			// Log4j
			logger = Logger.getLogger("ECommerce");
			PropertyConfigurator.configure("./Configurations/log4j.properties");
			fis = new FileInputStream("./Configurations/propertyFile.properties");
			pro = new Properties();
			pro.load(fis);

			if ((browser.equals("chrome"))) {
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				logger.info("URL is entered");
				getDriver().manage().window().maximize();
				logger.info("Chrome-Browser::Maximizing the window");

			} else if (browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());

				//driver.get(pro.getProperty("baseURL"));
				logger.info("URL is entered");
				getDriver().manage().window().maximize();
				logger.info("Firefox-Browser::Maximizing the window");
			} 
			
			else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
				logger.info("URL is entered");
				getDriver().manage().window().maximize();
				logger.info("Edge-Browser::Maximizing the window");
			} else {
				logger.info("Browser choice is not mentioned properly");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		getDriver().get(pro.getProperty("baseURL"));
	}

	@AfterClass
	public void tearDown() {
		getDriver().close();
	}
}
