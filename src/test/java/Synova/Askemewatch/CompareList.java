package Synova.Askemewatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CompareList {
	// Declare a static driver variable
	private static WebDriver driver;
	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://chronollection.ss-sandbox.com");
		Thread.sleep(4000);
		// accept cookie
		clickButtonCss(".btn-cookie");

	}


	@Test
	public void testComPare() throws InterruptedException {

		// add product to compare
		driver.get("http://chronollection.ss-sandbox.com/watch/detail/1");
		Thread.sleep(5000);
		// click compare bt //*[@id="compare-prc"]
		clickButtonCss("button#compare-prc");
		Thread.sleep(3000);
		// accept pop up
		acceptAlertMessage();
		Thread.sleep(5000);

		// driver.get("https://askme.watch/watch/detail/2");
		driver.navigate().to(
				"http://chronollection.ss-sandbox.com/watch/detail/2");
		Thread.sleep(5000);
		WebElement compareBtnElm = findCss("button#compare-prc");
		if (!clickButtonCss(compareBtnElm)) {
			scrollElementIntroView(compareBtnElm, -100);
			clickButtonCss(compareBtnElm);
		}
		Thread.sleep(5000);
		// accept pop up
		acceptAlertMessage();
		Thread.sleep(5000);
		// click watch to compare
		clickButtonXpath("html/body/div[2]/div[4]/p");
		clickButtonXpath(".//*[@id='compare']");
		Thread.sleep(3000);

	}

	
	@AfterClass
	public static void name() throws InterruptedException {
		Thread.sleep(30000);
		driver.close();
	}

	public void scrollElementIntroView(WebElement element, int padding) {
		JavascriptExecutor jse = (JavascriptExecutor) this.driver;
		jse.executeScript(
				"arguments[0].scrollIntoView(true);window.scrollBy(0,"
						+ padding + ");", element);
	}

	public Boolean clickButtonXpath(String idButton) {
		try {
			WebElement itemElement = driver.findElement(By.xpath((idButton)));
			itemElement.click();
			Thread.sleep(200);
			return true;
		} catch (Exception ex) {
			System.out.println("Not found for click button:" + idButton + ":"
					+ ex.getMessage());
			return false;
		}
	}

	public static Boolean clickButtonCss(String cssSelector) {
		try {

			WebElement itemElement = driver.findElement(By
					.cssSelector((cssSelector)));
			itemElement.click();
			Thread.sleep(200);
			return true;
		} catch (Exception ex) {
			System.out.println("Not found element to click:" + cssSelector
					+ ":" + ex.getMessage());
			return false;
		}
	}

	public Boolean clickButtonCss(WebElement itemElement) {
		try {
			itemElement.click();
			Thread.sleep(200);
			return true;
		} catch (Exception ex) {
			System.out.println("Can not click on button:"
					+ itemElement.getAttribute("innerHTML") + ":"
					+ ex.getMessage());
			return false;
		}
	}

	public WebElement findXpath(String idButton) throws InterruptedException {
		try {
			WebElement itemElement = driver.findElement(By.xpath(idButton));
			return itemElement;
		} catch (Exception ex) {
			System.out.println("Not found for find button:" + idButton);

			return null;
		}
	}

	public WebElement findCss(String idButton) throws InterruptedException {
		try {
			WebElement itemElement = driver.findElement(By
					.cssSelector(idButton));
			return itemElement;
		} catch (Exception ex) {
			System.out.println("Not found for find button:" + idButton + ";"
					+ ex.getMessage());
			// System.exit(0);
			return null;
		}
	}

	public void waitForElementAppearCSS(String s) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(s)));
	}

	public void waitForElementAppearXpath(String s) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
	}

	public void equalTwoString(String s1, String s2) {
		// if (s1.equals(s2)) {
		// return true;
		// } else {
		// System.out.println("String do NOT equal:" + s1 + "\n" + s2);
		// return false;
		// }
		Assert.assertEquals("Two string are equals", s1, s2);
	}

	public void checkConsistOFQuoteString() {
		String s = driver.getCurrentUrl().trim();
		// get 'review-specification-quote' of URL
		String lastCharOfUrl = s.substring(s.length() - 27, s.length());
		// compare two String
		if (!lastCharOfUrl.equals("review-specifications-quote")) {
			System.out
					.println("URL do not consist of 'review-specifications-quote'"
							+ "\n" + lastCharOfUrl);
		} else {
			System.out.println("Url consist of 'review-specifications-quote'");
		}
	}

	public boolean acceptAlertMessage() throws InterruptedException {

		try {
			Alert alertMessage = driver.switchTo().alert();
			alertMessage.accept();
			Thread.sleep(400);
			driver.switchTo().defaultContent();
			return true;
		} catch (NoAlertPresentException Ex) {
			Thread.sleep(400);
			return false;
		}

	}

	public static void replaceToLowerCase(List<String> strings) {
		ListIterator<String> iterator = strings.listIterator();
		while (iterator.hasNext()) {
			iterator.set(iterator.next().toLowerCase());
		}
	}

	public static void scrollToBottom() throws InterruptedException {
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

}