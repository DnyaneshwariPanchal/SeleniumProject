package com.orgHrm.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orgHrm.constant.Constant;

public class PredefinedAction {

	protected static WebDriver driver;
	private static Wait<WebDriver> wait;

	static public void setup(String url) {
		System.out.print("STEP-LAUNCH Chrome BROWSER");
		System.setProperty("webdriver.chrome.driver", Constant.CHROMEPATH);
		driver = new ChromeDriver();

		System.out.print("STEP-LOAD URL");
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	static public void setup() {
		// setup("http://automationbykrishna.com/");
		setup("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	static public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	static public void closeBrowser() {
		driver.close();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public enum Locator {
		XPATH, ID, NAME, CLASSNAME, TAGNAME, PARTIALLINKTEXT, LINKTEXT, CSS
	}

	protected List<WebElement> getAllElement(Locator locatoryType, String locatorvalue, boolean iswaitRequired) {
		List<WebElement> listofElements = null;

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		switch (locatoryType) {

		case XPATH:
			if (iswaitRequired)
				listofElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorvalue)));
			else
				listofElements = driver.findElements(By.xpath(locatorvalue));
			break;

		case ID:
			if (iswaitRequired)
				listofElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorvalue)));
			else
				listofElements = driver.findElements(By.id(locatorvalue));
			break;

		case NAME:
			if (iswaitRequired)
				listofElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorvalue)));
			else
				listofElements = driver.findElements(By.name(locatorvalue));
			break;

		case CLASSNAME:
			if (iswaitRequired)
				listofElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorvalue)));
			else
				listofElements = driver.findElements(By.className(locatorvalue));
			break;

		case LINKTEXT:
			if (iswaitRequired)
				listofElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorvalue)));
			else
				listofElements = driver.findElements(By.linkText(locatorvalue));
			break;

		}
		return listofElements;
	}

	protected WebElement getElement(Locator locatoryType, String locatorvalue, boolean iswaitRequired) {
		WebElement e = null;

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		switch (locatoryType) {

		case XPATH:
			if (iswaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			else
				e = driver.findElement(By.xpath(locatorvalue));
			break;

		case ID:
			if (iswaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
			else
				e = driver.findElement(By.id(locatorvalue));
			break;

		case NAME:
			if (iswaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			else
				e = driver.findElement(By.name(locatorvalue));
			break;

		case CLASSNAME:
			if (iswaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorvalue)));
			else
				e = driver.findElement(By.className(locatorvalue));
			break;

		case LINKTEXT:
			if (iswaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorvalue)));
			else
				e = driver.findElement(By.linkText(locatorvalue));
			break;

		}
		return e;
	}

	protected void mouseHover(String locatoryType, String locatorvalue, boolean iswaitRequired) {
		// WebElement e =getElement(locatoryType,locatorvalue,isWaitRequired)
		Actions action = new Actions(driver);

	}

	protected List<String> listOfAllElementText(Locator locatoryType, String locatorvalue, boolean iswaitRequired) {
		List<WebElement> listOfElement = getAllElement(locatoryType, locatorvalue, iswaitRequired);

		List<String> listOfElementText = new ArrayList<String>();

		for (WebElement element : listOfElement) {
			listOfElementText.add(element.getText());
		}

		return listOfElementText;
	}

	protected List<String> getAllElementText(List<WebElement> listOfElements) {

		List<String> listOfElementText = new ArrayList<String>();
		for (WebElement element : listOfElements) {
			listOfElementText.add(element.getText());
		}
		return listOfElementText;
	}

	protected void mouseHover(WebElement e) {
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform();
	}

	protected void mouseHover(Locator locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		mouseHover(e);
	}

	protected void clickOnElement(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}

	protected void clickOnElement(String locator, boolean isWaitRequired) {
		WebElement e = getElement(locator, isWaitRequired);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}

	protected void clickOnElement(Locator locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, false);
		clickOnElement(e);
	}

	protected WebElement getElement(String locator, boolean isWaitRequired) {

		String locatorType = locator.split("]:-")[0].replace("[", "");
		String locatorvalue = locator.split("]:-")[1];
		WebElement e = null;

		switch (locatorType) {
		case "xpath":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
			else
				e = driver.findElement(By.xpath(locatorvalue));
			break;

		case "id":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
			else
				e = driver.findElement(By.id(locatorvalue));
			break;

		case "name":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			else
				e = driver.findElement(By.name(locatorvalue));
			break;

		case "classname":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorvalue)));
			else
				e = driver.findElement(By.className(locatorvalue));
			break;

		case "linktext":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorvalue)));
			else
				e = driver.findElement(By.linkText(locatorvalue));
			break;
		}
		return e;
	}

//	protected boolean isElementDisplayed(String locator, boolean isWaitRequired) {
//		try {
//			WebElement e = getElement(locator,isWaitRequired);
//			e.isDisplayed();
//		} catch (NoSuchElementException ne) {
//			return false;
//		}
//		return isWaitRequired;
//	}

	protected void scrollToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", e);
		// js.executeScript("window.scrollBy(150,300)");
	}

	protected void setText(String locator, boolean isWaitRequired, String textToBeEnter) {
		WebElement e = getElement(locator, isWaitRequired);
		//wait.until(d -> e.isDisplayed());
		if (!e.isDisplayed()) {
			scrollToElement(e);
		}
		e.sendKeys(textToBeEnter);

	}

	protected String getText(String locator, boolean isWaitRequired, String value) {
		WebElement e = getElement(locator, isWaitRequired);
		return e.getAttribute("value");
	}

}
