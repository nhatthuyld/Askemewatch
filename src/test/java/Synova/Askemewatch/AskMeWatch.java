package Synova.Askemewatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

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

public class AskMeWatch {
	// Declare a static driver variable
	private static WebDriver driver;

	String questionStep1 = "What is your watch knowledge level ?";
	List<String> ListOptionsStep1 = Arrays.asList("I'm a watch novice",
			"I'm a watch enthusiast");

	String questionStep2 = "Who will wear this watch ?";
	List<String> ListOptionsStep2 = Arrays.asList("A man", "A woman");

	String questionStep3_QN1 = "What kind of movement are you looking for ?";
	List<String> ListOptionsStep3_QN1 = Arrays.asList("Mechanical", "Quartz",
			"Connected");
	// if choose connected do 4a 5a and finish
	String questionStep4a_QN1 = "What about the shape ?";
	List<String> ListOptionsStep3a_QN1 = Arrays.asList("Round", "Rectangular",
			"Square");

	String questionStep5a_QN1 = "Which material do you prefer for the strap ? (QCM)";
	List<String> ListOptionsStep4a_QN1 = Arrays.asList("Metal", "Fabric",
			"Leather", "Rubber");

	String questionStep4_QN1 = "Design : which one inspires you best ?";
	List<String> ListOptionsStep4_QN1 = Arrays.asList("Simple", "Complex");

	String questionStep5_QN1 = "What kind of watch are you interested in ?";
	List<String> ListOptionsStep5_QN1 = Arrays.asList("Sporty", "Elegant",
			"Neo Vintage", "Jewelry");

	String questionStep6_QN1 = "The dial : which color(s) do you fancy ? (MCQ)";
	List<String> ListOptionsStep6_QN1 = Arrays.asList("BLUE", "BROWN", "BLACK",
			"WHITE", "GREY", "SILVER", "OPALINE", "SKELETON", "OTHER");

	String questionStep7_QN1 = "Which material do you prefer for the strap ? (MCQ)";
	List<String> ListOptionsStep7_QN1 = Arrays.asList("Metal", "Fabric",
			"Leather", "Rubber");

	String questionStep9_QN1 = "Last but not least, what is the most important criteria to you ?";
	List<String> ListOptionsStep9_QN1 = Arrays.asList(
			"Social media popularity", "brand_appeal", "Editor’s notation");

	String questionStep3_QN2 = "Watch size : what do you have in mind ?";
	List<String> ListOptionsStep3a_QN2 = Arrays.asList("S : <36",
			"M : 36 à 40", "L: 40 à 44", "XL: >44");
	List<String> ListOptionsStep3b_QN2 = Arrays.asList("S : <32",
			"M : 32 à 36", "L: 36 à 40", "XL: >40");

	String questionStep4_QN2 = "What kind of movement are you looking for ?";
	List<String> ListOptionsStep4_QN2 = Arrays.asList("Mechanical", "Quartz",
			"Springdrive", "Connected");
	// if choose connected do 5a 6a price bar and finish
	String questionStep5a_QN2 = "What about the shape ?";
	List<String> ListOptionsStep5a_QN2 = Arrays.asList("Round", "Rectangular",
			"Square");

	String questionStep6a_QN2 = "Which material do you prefer for the strap ? (MCQ)";
	List<String> ListOptionsStep6a_QN2 = Arrays.asList("Metal", "Fabric",
			"Leather", "Rubber");

	String questionStep5_QN2 = "Are in-house movements essential to you ?";
	List<String> ListOptionsStep5_QN2 = Arrays.asList("Yes",
			"Not really important");

	String questionStep6_QN2 = "The dial : which color(s) do you fancy ? (MCQ)";
	List<String> ListOptionsStep6_QN2 = Arrays.asList("BLUE", "BROWN", "BLACK",
			"WHITE", "GREY", "Beige", "Other", "SKELETON");

	String questionStep7_QN2 = "What kind of functions would like to have ?";
	List<String> ListOptionsStep7_QN2 = Arrays.asList("2/3 hands",
			"Chronograph", "GMT", "Diver", "Moonphase", "Great Complication");
	// if choose great complication do 8a and continue with 8
	String questionStep8a_QN2 = "OK, you’re a connoisseur ! :) Which complication attracts you the most ?";
	List<String> ListOptionsStep8a_QN2 = Arrays.asList(
			"Annual or perpetual calendar", "Chime or repeater", "Tourbillon",
			"Equation of time", "Rattrapante", "Dead second");

	String questionStep8_QN2 = "What kind of watch are you interested in ?";
	List<String> ListOptionsStep8_QN2 = Arrays.asList("Sporty", "Elegant",
			"Vintage", "Jewelry");

	String questionStep10_QN2 = "The case material would be : (MCQ)";
	List<String> ListOptionsStep10_QN2 = Arrays.asList("Steel", "Rose gold",
			"Yelow gold", "Grey/white gold", "Gold and steel", "Platinum",
			"High-tech");

	String questionStep11_QN2 = "Last but not least, what is the most important criteria to you ?";
	List<String> ListOptionsStep11_QN2 = Arrays.asList(
			"Social media popularity", "Brand’s appeal", "Editor’s notation");

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

	@Before
	public void setUp() throws Exception {
		// this.driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.get("https://askme.watch");
		// Thread.sleep(5000);

	}

	@Test
	public void testWatchAdvisor() throws InterruptedException {
		// click watch advisor tab
		driver.get("http://chronollection.ss-sandbox.com/watch/advisor");
		Thread.sleep(4000);
		clickButtonCss(".btn-link");
		Thread.sleep(1000);
		// choose a watch novice option and do steps without connected option
		 testWatchNovice();
		// testWatchEnthusisast();
		// testBackCaseWatchEnthusisast_connectedOption();
		//testBackCaseWatchEnthusisast_greatComplicationOption();

	}

	@Test
	public void testWatchNovice() throws InterruptedException {
		String currentQuestion;
		// step 1-choose novice option
		currentQuestion = DoSteps(questionStep1, ListOptionsStep1, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 2-choose man option
		currentQuestion = DoSteps(questionStep2, ListOptionsStep2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 3-choose merchanical option
		currentQuestion = DoSteps(questionStep3_QN1, ListOptionsStep3_QN1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 4-choose simple option
		currentQuestion = DoSteps(questionStep4_QN1, ListOptionsStep4_QN1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 5-choose sporty option
		currentQuestion = DoSteps(questionStep5_QN1, ListOptionsStep5_QN1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 6-choose blue option
		currentQuestion = DoSteps(questionStep6_QN1, ListOptionsStep6_QN1, 2);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 7-choose METAL option
		currentQuestion = DoSteps(questionStep7_QN1, ListOptionsStep7_QN1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 8-choose price filter
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 9-choose Social media popularity option
		currentQuestion = DoSteps(questionStep9_QN1, ListOptionsStep9_QN1, 0);

		int getResult = getResult();
		// click next button
		clickButtonCss("[id='next-ans']");
		// Compare results showed and result after filter
		Assert.assertEquals(getResult + 1,
				openAndGetTotalProductOfListWatchAvisor());
	}

	@Test
	public void testWatchEnthusisast() throws InterruptedException {
		String currentQuestion;
		// step 1-choose enthusiast option
		currentQuestion = DoSteps(questionStep1, ListOptionsStep1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 2-choose man option
		currentQuestion = DoSteps(questionStep2, ListOptionsStep2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 3-choose size
		currentQuestion = DoSteps(questionStep3_QN2, ListOptionsStep3a_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 4-choose kind of movement
		currentQuestion = DoSteps(questionStep4_QN2, ListOptionsStep4_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 5-choose in-house movement essential
		currentQuestion = DoSteps(questionStep5_QN2, ListOptionsStep5_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 6-choose color you fancy
		currentQuestion = DoSteps(questionStep6_QN2, ListOptionsStep6_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 7-choose kind of function
		currentQuestion = DoSteps(questionStep7_QN2, ListOptionsStep7_QN2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 8-choose kind of watch
		currentQuestion = DoSteps(questionStep8_QN2, ListOptionsStep8_QN2, 3);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 9-choose price filter
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 11-choose case material
		currentQuestion = DoSteps(questionStep10_QN2, ListOptionsStep10_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 11-most important criteria
		currentQuestion = DoSteps(questionStep11_QN2, ListOptionsStep11_QN2, 1);

		int getResult = getResult();
		// click next button
		clickButtonCss("[id='next-ans']");

		// Compare results showed and result after filter
		Assert.assertEquals(getResult + 1,
				openAndGetTotalProductOfListWatchAvisor());
	}

	@Test
	// choose connected option
	public void testBackCaseWatchEnthusisast_connectedOption()
			throws InterruptedException {
		String currentQuestion;
		// step 1-choose enthusiast option
		currentQuestion = DoSteps(questionStep1, ListOptionsStep1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 2-choose woman option
		currentQuestion = DoSteps(questionStep2, ListOptionsStep2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 3-choose size
		currentQuestion = DoSteps(questionStep3_QN2, ListOptionsStep3a_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 4-choose kind of movement -choose connection
		currentQuestion = DoSteps(questionStep4_QN2, ListOptionsStep4_QN2, 3);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 5-the shape
		currentQuestion = DoSteps(questionStep5a_QN2, ListOptionsStep5a_QN2, 0);

		// come back to step 4
		backToPreviousStep(currentQuestion);

		// step 4-choose kind of movement -choose connection
		currentQuestion = DoSteps(questionStep4_QN2, ListOptionsStep4_QN2, 3);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 5-the shape
		currentQuestion = DoSteps(questionStep5a_QN2, ListOptionsStep5a_QN2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 6-the material for strap
		currentQuestion = DoSteps(questionStep6a_QN2, ListOptionsStep6a_QN2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 7-choose price filter
		int getResult = getResult();
		// click next button
		clickButtonCss("[id='next-ans']");

		// Compare results showed and result after filter
		Assert.assertEquals(getResult + 1,
				openAndGetTotalProductOfListWatchAvisor());
	}

	@Test
	// choose great complication option
	public void testBackCaseWatchEnthusisast_greatComplicationOption()
			throws InterruptedException {
		String currentQuestion;
		// step 1-choose enthusiast option
		currentQuestion = DoSteps(questionStep1, ListOptionsStep1, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 2-choose woman option
		currentQuestion = DoSteps(questionStep2, ListOptionsStep2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 3-choose size
		currentQuestion = DoSteps(questionStep3_QN2, ListOptionsStep3a_QN2, 3);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 4-choose kind of movement
		currentQuestion = DoSteps(questionStep4_QN2, ListOptionsStep4_QN2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 5-choose movement essential
		currentQuestion = DoSteps(questionStep5_QN2, ListOptionsStep5_QN2, 0);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 6-choose color fancy
		currentQuestion = DoSteps(questionStep6_QN2, ListOptionsStep6_QN2, 2);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 7-choose kind of function-choose great complication option
		currentQuestion = DoSteps(questionStep7_QN2, ListOptionsStep7_QN2, 5);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 8-choose complication attract
		currentQuestion = DoSteps(questionStep8a_QN2, ListOptionsStep8a_QN2, 1);

		// come back to step 7
		backToPreviousStep(currentQuestion);

		// step 7-choose kind of function-choose great compalication option
		currentQuestion = DoSteps(questionStep7_QN2, ListOptionsStep7_QN2, 5);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 8-choose complication attract
		currentQuestion = DoSteps(questionStep8a_QN2, ListOptionsStep8a_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// step 9-choose kind of watch
		currentQuestion = DoSteps(questionStep8_QN2, ListOptionsStep8_QN2, 1);
		// click next button
		clickButtonCss("[id='next-ans']");

		// // step 10-choose price filter
		// choosePriceFilter();
		//
		// // step 11-choose material
		// currentQuestion = DoSteps(questionStep10_QN2, ListOptionsStep10_QN2,
		// 1);
		// // click next button
		// clickButtonCss("[id='next-ans']");
		//
		// // step 12-choose import criteria
		// currentQuestion = DoSteps(questionStep11_QN2, ListOptionsStep11_QN2,
		// 1);
		//
		// int getResult = getResult();
		// // click next button
		// clickButtonCss("[id='next-ans']");
		//
		// // Compare results showed and result after filter
		// Assert.assertEquals(getResult + 1,
		// openAndGetTotalProductOfListWatchAvisor());
	}

	public void choosePriceFilter() throws InterruptedException {
		Thread.sleep(2000);
		// get question
		String getQuestion = findCss(".ans-number.show .question-title")
				.getText().trim();

		// verify question
		Assert.assertEquals(
				"How much do you want to spend in this watch ?".toLowerCase(),
				getQuestion.toLowerCase());
		clickButtonCss("[id='next-ans']");
	}

	public String DoSteps(String titleQuestion, List listOptions,
			int selectedElement) throws InterruptedException {

		Thread.sleep(3000);

		// get question
		String getQuestion = findCss(".ans-number.show .question-title")
				.getText().trim();

		// verify question
		Assert.assertEquals(titleQuestion.toLowerCase(),
				getQuestion.toLowerCase());

		// get list of options
		List<String> getOptions = new ArrayList();
		List<WebElement> eles = driver
				.findElements(By
						.cssSelector(".ans-number.show .row.row-answer.row-answer-clear >div"));

		for (int i = 0; i < eles.size(); i++) {
			getOptions.add(eles.get(i).getText());
		}

		// compare two list
		compareTwoList(getOptions, listOptions);

		// click on selected Element
		eles.get(selectedElement).click();
		Thread.sleep(2000);

		// get question number
		return (findCss(".process-question.question.active span").getText());

	}

	public void backToPreviousStep(String currentQuestion)
			throws InterruptedException {
		Thread.sleep(3000);
		int i = Integer.valueOf(currentQuestion);
		WebElement questionbt = findCss(".process-ques li:nth-child("
				+ String.valueOf(i - 1) + ") a");
		scrollElementIntroView(questionbt, -100);
		questionbt.click();

	}

	public boolean compareTwoList(List l1, List l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		replaceToLowerCase(l1);
		replaceToLowerCase(l2);

		for (int i = 0; i < l1.size(); i++) {
			if (!l1.get(i).equals(l2.get(i))) {
				return false;
			}
		}
		return true;
	}

	public int getResult() throws NumberFormatException, InterruptedException {
		Thread.sleep(2000);
		return (Integer.valueOf(findCss("div[style='display: table;'] .result")
				.getText().replaceAll(" results", "")));
	}

	public int openAndGetTotalProductOfListWatchAvisor()
			throws InterruptedException {

		while (findCss(".item-prc.item-morewtach.hide") == null
				&& findCss(".btn-default.btn-morewatch") != null) {
			WebElement moreProductbt = findCss(".btn-default.btn-morewatch");
			scrollElementIntroView(moreProductbt, -100);
			moreProductbt.click();
			Thread.sleep(3000);
		}

		// count products
		List<WebElement> listProducts = driver.findElements(By
				.cssSelector(".row.row-prc .watch-result >div"));
		int totalProduct = listProducts.size();
		return totalProduct;
	}

	// @Test
	// public void testwatchAdvisor() throws InterruptedException {
	// // click watch advisor tab
	// clickButtonXpath("//*[@id='myNavbar']/ul[1]/li[1]/a");
	// Thread.sleep(4000);
	// // step 1
	// clickButtonXpath("//div[@value='1']");
	// clickButtonCss("#next-ans");
	// // step 2
	// clickButtonXpath(".//*[@id='quizarea']/div/div/div[2]/div/div[2]/div/div/div[1]/div");
	// clickButtonCss("#next-ans");
	// // step 3
	// clickButtonXpath(".//*[@id='quizarea']/div/div/div[2]/div/div[3]/div/div/div[3]/div");
	// clickButtonCss("#next-ans");
	// // step 4
	// clickButtonXpath(".//*[@id='quizarea']/div/div/div[2]/div/div[4]/div/div/div[1]/div");
	// clickButtonCss("#next-ans");
	// // step 5
	// clickButtonXpath(".//*[@id='quizarea']/div/div/div[2]/div/div[5]/div/div/div[3]/div");
	// clickButtonCss("#next-ans");
	// // step 5
	// clickButtonCss("#next-ans");
	// // list results
	//
	// List<WebElement> listWatchAdvisor =
	// driver.findElements(By.cssSelector(".watch-result div"));
	// int r = listWatchAdvisor.size();
	// if (r <= 0) {
	// System.out.println("No results for watch advisor");
	// return;
	// } else {
	// // click first element
	// listWatchAdvisor.get(0).click();
	// }
	// // get url
	// Thread.sleep(2000);
	// // check URL consist of 'review-specifications-quote'
	// checkConsistOFQuoteString();
	//
	// }

	@Test
	public void testPriceFinder() throws InterruptedException {
		// click price finder tab
		clickButtonXpath(".//*[@id='myNavbar']/ul[1]/li[2]/a");
		// searching
		findXpath(".//*[@id='search-watch']").sendKeys("rolex");
		clickButtonXpath(".//*[@id='button-search']");
		Thread.sleep(5000);
		// paging
		// List<WebElement> listPaging =
		// driver.findElements(By.cssSelector(".pagination
		// li"));
		// System.out.println(listPaging.size());
		// for (int i = 0; i < listPaging.size() - 3; i++) {
		// System.out.println("i:"+i);
		// // have problem can not click
		// clickButtonCss("a[rel=\"next\"]");
		// Thread.sleep(5000);
		// }
		WebElement link = findCss("a[rel=\"next\"]");
		while (link != null) {
			clickButtonCss("a[rel=\"next\"]");
			Thread.sleep(5000);
			link = findCss("a[rel=\"next\"]");
		}
		// click view detail
		// clickButtonXpath(".//*[@id='watches']/div[1]/div");
		// driver.close();
	}

	@Test
	public void testWatchFinder() throws InterruptedException {
		// click price finder tab
		clickButtonXpath(".//*[@id='myNavbar']/ul[1]/li[3]/a");
		// searching
		findXpath(".//*[@id='search-watch']").sendKeys("rolex");
		clickButtonXpath(".//*[@id='button-search']");
		Thread.sleep(5000);
		// paging
		List<WebElement> listPaging = driver.findElements(By
				.cssSelector(".row.first_step_pagination li"));
		// for(int i = 0; i < listPaging.size() - 3; i++)
		// {//have problem can not click
		// clickButtonCss(".row.first_step_pagination .boxpaging-search
		// li:last-child
		// a");
		// Thread.sleep(7000);
		// }
		// click view detail
		clickButtonXpath(".//*[@id='watches']/div[1]/div");
		Thread.sleep(2000);
		// check URL consist of 'review-specifications-quote'
		checkConsistOFQuoteString();

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

	@Test
	public void testAddToMyWishlist() throws InterruptedException {

		// log in
		logInGmail();
		// add product to my wishlist
		driver.get("http://chronollection.ss-sandbox.com/watch/detail/33?Search=A.-LANGE-&-SOHNE-LANGE-1-LANGE-1-38,5MM-191021-31000-review-specifications-quote");
		Thread.sleep(2000);
		clickButtonCss("#wishlist");

		driver.get("http://chronollection.ss-sandbox.com//watch/detail/1?Search=A.-LANGE-&-SOHNE-LANGE-1-LANGE-1-38,5MM-101021-31000-review-specifications-quote");
		Thread.sleep(2000);
		clickButtonCss("#wishlist");
		// open my wishlist
		driver.get("http://chronollection.ss-sandbox.com//usercp/wishlist");
		Thread.sleep(2000);
		clickButtonCss(".btn-link");

		// share on facebook-<bug
		// Focus on new Tab:
		// https://stackoverflow.com/questions/39449524/how-to-focus-on-second-tab-and-work-on-it-using-selenium-webdriver
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		for (String handle : handles) {

			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(500);
		findCss("[name='xhpc_message_text']").sendKeys("my watch");
		clickButtonCss("#u_0_1w");
		Thread.sleep(500);
		driver.switchTo().window(currentHandle);

	}

	public void logInFB() throws InterruptedException {
		driver.get("http://chronollection.ss-sandbox.com//login");
		// log in wtih FB
		// Thread.sleep(2000);
		// clickButtonCss(".face");
		// Thread.sleep(3000);
		// input email&pass
		findCss("#email").sendKeys("nhatthuysynova@gmail.com");
		findCss("#pass").sendKeys("Cud0123456789");
		clickButtonCss("#loginbutton");

	}

	public void logInGmail() throws InterruptedException {
		driver.get("https://askme.watch/login");
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

	// @AfterClass
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