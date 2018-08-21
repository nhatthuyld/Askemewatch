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

public class Login {
	// Declare a static driver variable
	private static WebDriver driver;

	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void Main() throws InterruptedException {
		// live http must log in by fb
		// logInFB();
		logInGmail();
		logOut();
		loginByResistedAccount();
		Thread.sleep(1000);
		logOut();

	}

	// just htpp://askmewatch
	// public void logInFB() throws InterruptedException {
	// driver.get("http://chronollection.ss-sandbox.com//login");
	// // log in with FB
	// Thread.sleep(2000);
	// clickButtonCss(".face");
	// Thread.sleep(3000);
	// // input email&pass
	// findCss("#email").sendKeys("nhatthuysynova@gmail.com");
	// findCss("#pass").sendKeys("Cud0123456789");
	// clickButtonCss("#loginbutton");
	//
	// }

	public void logInGmail() throws InterruptedException {

		driver.get("http://chronollection.ss-sandbox.com/en/login");
		Thread.sleep(4000);
		// log in with gmail
		Thread.sleep(2000);
		clickButtonCss(".google");
		Thread.sleep(2000);
		// input email & pass
		findCss("#identifierId").sendKeys("nhatthuysynova");
		clickButtonCss("#identifierNext > content");
		Thread.sleep(2000);
		findCss(".whsOnd.zHQkBf").sendKeys("Cud0123456789");
		clickButtonCss("#passwordNext > content");
	}

	public void loginByResistedAccount() throws InterruptedException {
		driver.get("http://chronollection.ss-sandbox.com/en/login");
		Thread.sleep(4000);

		findCss(
				"body > div.wrap-content > section > div > div > div > form > div.form-group.form-email.confirm > input")
				.sendKeys("nhatthuysnv@gmail.com");
		findCss(
				"body > div.wrap-content > section > div > div > div > form > div.form-group.form-pass.new > input")
				.sendKeys("123456");
		clickButtonCss("body > div.wrap-content > section > div > div > div > form > div:nth-child(5) > button");
	}

	// @AfterClass
	// public static void name() throws InterruptedException {
	// Thread.sleep(2000);
	// driver.close();
	// }

	public void logOut() throws InterruptedException {
		// click log out;
		clickButtonXpath("//*[@id='myNavbar']/ul[2]/li[2]/a/span[1]");
		Thread.sleep(3000);
		clickButtonCss("#myNavbar > ul.nav.navbar-nav.navbar-right > li.dropdown.sign-in.underline.show.open > ul > li:nth-child(5) > a");
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

}