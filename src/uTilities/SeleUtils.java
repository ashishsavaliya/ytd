package uTilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class SeleUtils extends ExcelUtils
{
	public static WebDriver driver;

	@Parameters({ "BrowserName" })
	@BeforeSuite
	public void Openbrowser(String strbrowsername)
	{
		if (strbrowsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (strbrowsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (strbrowsername.equalsIgnoreCase("firefoxe"))
		{
			System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		implicitWait();

	}

	public void openURL(String url)
	{
		driver.get(url);
	}

	public void click(By locator)
	{
		explicitWait(locator);
		driver.findElement(locator).click();
	}

	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void explicitWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void pageVerify(String actual, String expected, String FailMessage)
	{
		SoftAssert st = new SoftAssert();
		st.assertEquals(actual, expected, FailMessage);
		st.assertAll();
	}

	public String getText(By locator)
	{
		WebElement webElement = driver.findElement(locator);
		String strText = webElement.getText().trim();
		return strText;
	}

	public void entertext(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}

	public void dateofbirth(By locator, String values, String visibletext, int index)
	{
		Select dob = new Select(driver.findElement(locator));
		if (values != null)
		{
			dob.selectByValue(values);
		}
		else if (visibletext != null)
		{
			dob.selectByVisibleText(visibletext);
		}
		else
		{
			dob.selectByIndex(index);
		}
	}

	// public void dateofbirth1(By locator, String values)
	// {
	// Select dob = new Select(driver.findElement(locator));
	// dob.selectByValue(values);
	// }

	// @AfterSuite(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}	
}
