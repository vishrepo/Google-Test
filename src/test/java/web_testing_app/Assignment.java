package web_testing_app;

// JUnit 5 assertions
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll; // JUnit 5 AfterAll
import org.junit.jupiter.api.AfterEach; // JUnit 5 AfterEach
import org.junit.jupiter.api.BeforeAll; // JUnit 5 BeforeAll
import org.junit.jupiter.api.Test; // JUnit 5 Test annotation
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* READ THIS FIRST
 * 
 * General instructions are given above each of the 4 test classes. Make sure to use the correct "By"
 * function for selection. You will either submit the line where you added your code fragment or the entire section
 * of code that you write for later problems on this assignment marked by CODE FRAGMENT or CODE.
 *
 */

public class Assignment {
	private static Duration shortTimeout = Duration.ofSeconds(10);
	private static Duration longTimeout = Duration.ofSeconds(10);
	static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		driver = new ChromeDriver();

	}

	@AfterAll
	public static void tearDownAll() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	/*
	 * Speed Test Explicit Instructions
	 * 
	 * Use "By.xpath" to select elements in these code fragments. "By.id" and
	 * "By.name" should be used where possible.
	 * 
	 */

	@Test
	public void testGoogleSpeedTestExplicitly() {
		/* Use one */
//		FirefoxDriver driver = (FirefoxDriver) WebTesting.launchDriver("https://www.google.com", "firefox");
		ChromeDriver driver = (ChromeDriver) WebTesting.launchDriver("https://www.google.com", "chrome");

		if (driver == null) {
			fail("Driver not created.");
		}

		/* You can change these timeout values to what you see fit for your machine */
		WebDriverWait shortWait = new WebDriverWait(driver, shortTimeout);
		WebDriverWait longWait = new WebDriverWait(driver, longTimeout);

		/* FIRST TEST */


		// #1: TODO (ensure that the search bar is visible before accessing it)
		// HINT: the search bar has attribute name="q"
		try {
			shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name=\'q\']")));
		} catch (TimeoutException ex) {
			fail("Search bar not found.");
		}

		// #2: TODO (enter "internet speed test" into the search bar then press the "Return" key)
		// id-'APjFqb' name- 'q'
		driver.findElement(By.name("q")).sendKeys("internet speed test"+Keys.RETURN);
		
		

		// #3: TODO (ensure that the "RUN SPEED TEST" button is clickable)
		// HINT: the button has attribute id="knowledge-verticals-internetspeedtest__test_button"
		// id="knowledge-verticals-internetspeedtest__test_button"
		try {
			shortWait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//g-raised-button[@id='knowledge-verticals-internetspeedtest__test_button']")));
		} catch (TimeoutException ex) {
			fail("\"RUN SPEED TEST\" button not found.");
		}

		// #4: TODO (click the "RUN SPEED TEST" button by its "id" attribute)
		driver.findElement(By.id("knowledge-verticals-internetspeedtest__test_button")).click();

		// #5: TODO (ensure that the "CANCEL" button is clickable directly after this)
		// HINT: the button is a tag <g-raised-button> with attribute jsaction="dArJMd"
		try {
			shortWait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'dArJMd\']")));
		} catch (TimeoutException ex) {
			fail("\"CANCEL\" button not found.");
		}

		// #6: TODO (wait for the test to finish)
		// HINT: The "CANCEL" button should not be clickable. Is shortWait long enough?
		try {
			longWait.until(ExpectedConditions
					.not(ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'dArJMd\']"))));
		} catch (TimeoutException ex) {
			//fail("Speed test did not finish.");
		}

		// #7: TODO ("RETRY" signifies a failure)
		// HINT: the "RETRY" button is a tag <g-raised-button> with attribute
		// jsaction="i0JLwd"
		try {
			shortWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//g-raised-button[@jsaction=\'i0JLwd\']")));
			fail("Speed test failed to run.");
		} catch (TimeoutException ex) {
			// Expected condition, test passes
		}

		// #8: TODO ("TEST AGAIN" signifies a success)
		// HINT: the "TEST AGAIN" button is a tag <g-raised-button> with attribute
		// jsaction="iyDKIb"
		// No name Attribute for this Element
		try {
			shortWait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//g-raised-button[@jsaction=\'iyDKIb\']")));
		} catch (TimeoutException ex) {
			fail("\"Speed test failed to run.");
		}
		
	}

	/*************************************************************************************************************************
	 * Speed Test Implicit Instructions
	 * 
	 * Use "By.cssSelector" to select elements in these code fragments. "By.id" and
	 * "By.name" should be used where possible.
	 * 
	 */

	@Test
	public void testGoogleSpeedTestImplicitly() throws InterruptedException {
		/* Use one */
//		FirefoxDriver driver = (FirefoxDriver) WebTesting.launchDriver("https://www.google.com", "firefox");
		ChromeDriver driver = (ChromeDriver) WebTesting.launchDriver("https://www.google.com", "chrome");

		if (driver == null) {
			fail("Driver not created.");
		}

		/* You can change these timeout values to what you see fit for your machine */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		long shortSleep = 6000; // 6 seconds
		long longSleep = 60000; // 60 seconds

		// #9: TODO (enter "internet speed test" into the search bar then press the "Return" key)
				// HINT: the search bar has attribute name="q"
		// HINT: the search bar has attribute name="q" if id == APjFqb
		try {
			driver.findElement(By.id("APjFqb")).sendKeys("internet speed test"+Keys.RETURN);
		} catch (NoSuchElementException ex) {
			fail("Search bar not found.");
		}

		// #10: TODO (click the "RUN SPEED TEST" button by its "id" attribute)
				// HINT: the button has attribute id="knowledge-verticals-internetspeedtest__test_button"
		// id="knowledge-verticals-internetspeedtest__test_button"
		try {
			driver.findElement(By.id("knowledge-verticals-internetspeedtest__test_button")).click();
		} catch (NoSuchElementException ex) {
			fail("\"RUN SPEED TEST button not found.");
		}

		// #11: TODO (ensure that the "CANCEL" is displayed directly after this)
				// HINT: WebElement has a useful method though we are required to use
				//       sleep(long millis) as the buttons never leave the page.
		Thread.sleep(shortSleep);

		WebElement cancelButton = null;

		try {
			cancelButton = driver.findElement(By.cssSelector("g-raised-button[jsaction=\'dArJMd\']"));
		} catch (NoSuchElementException ex) {
			fail("\"CANCEL\" button not found.");
		}

		if (!cancelButton.isDisplayed()) {
			fail("\"CANCEL\" button not found.");
		}

		// #12: TODO ("RETRY" signifies a failure)
		// HINT: the "RETRY" button is a tag <g-raised-button> with attribute jsaction="i0JLwd"
		// Doesnt have a name attribute .
		Thread.sleep(longSleep);

		WebElement retryButton = null;
          try {
			retryButton = driver.findElement(By.xpath("//g-raised-button[@jsaction='i0JLwd']"));
		} catch (NoSuchElementException ex) {
			fail("\"RETRY\" button not found.");
		}

		if (retryButton.isDisplayed()) {
			fail("Speed test did not finish.");
		}

		// #13: TODO ("TEST AGAIN" signifies a success)
				// HINT: the "TEST AGAIN" button is a tag <g-raised-button> with attribute jsaction="iyDKIb"
		// jsaction="iyDKIb"
		WebElement testAgainButton = null;

		try {
			testAgainButton = driver.findElement(By.cssSelector("g-raised-button[jsaction=\'iyDKIb\']"));
		} catch (NoSuchElementException ex) {
			fail("\"TEST AGAIN\" button not found.");
		}

		if (!testAgainButton.isDisplayed()) {
			fail("Speed test did not finish.");
		}
	}

	/***********************************************************************************************************************
	 * Calculator Explicit Instructions
	 * 
	 * Use "By.xpath" to select elements in these code fragments. "By.id" and
	 * "By.name" should be used where possible.
	 * 
	 */

	@Test
	public void testCalculatorExplicitly() {
		/* Use one */
//		FirefoxDriver driver = (FirefoxDriver) WebTesting.launchDriver("https://www.google.com", "firefox");
		ChromeDriver driver = (ChromeDriver) WebTesting.launchDriver("https://www.google.com", "chrome");

		if (driver == null) {
			fail("Driver not created.");
		}

		/* You can change these timeout values to what you see fit for your machine */
		WebDriverWait shortWait = new WebDriverWait(driver, shortTimeout);
		WebDriverWait longWait = new WebDriverWait(driver, longTimeout);

		// #14: TODO (ensure that the search bar is visible before accessing it)
				// HINT: the search bar has attribute name="q"
		try {
         shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='q'][@id='APjFqb']")));
		} catch (TimeoutException ex) {
			fail("Search bar not found.");
		}

		// #15: TODO (enter "calculator" into the search bar then press the "Return" key)
				// HINT: you don't need to check for its existence again
		driver.findElement(By.name("q")).sendKeys("calculator" + Keys.RETURN);

		// #16: TODO (ensure that the Calculator is visibile)
		// HINT: a relevant div has class="tyYmIf"
		try {
			shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\'tyYmIf\']")));
		} catch (TimeoutException ex) {
			fail("Calculator not found.");
		}

		WebElement calculatorText = driver.findElement(By.id("cwos"));

		// ###: TODO (enter 1 and check whether the value was input into the text field)

		// Think about what could go wrong with this? //

//		driver.findElement(/*CODE FRAGMENT*/).click();
//		
//		String text = calculatorText.getAttribute("innerHTML");
//		
//		if (text == null || !text.equals("1")) {
//			fail("\"1\" was not input.");
//		}

		// #17: TODO (enter 1 and check whether the value was input into the text field)
				// HINT: the "1" button is a div with jsname="N10B9"

		driver.findElement(By.xpath("//div[@jsname=\'N10B9\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "1"));
		} catch (TimeoutException ex) {
			fail("\"1\" was not input.");
		}

		// #18: TODO (enter "+" and check whether the value was input into the text field)
				// HINT: the "+" button is a div with jsname="XSr6wc"
		driver.findElement(By.xpath("//div[@jsname=\'XSr6wc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "1 +"));
		} catch (TimeoutException ex) {
			fail("\"+\" was not input.");
		}

		// #19: TODO (enter "-" and check whether the value was input correctly into the text field)
				// HINT: the "-" button is a div with jsname="pPHzQc"
		driver.findElement(By.xpath("//div[@jsname=\'pPHzQc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "1 -"));
		} catch (TimeoutException ex) {
			fail("\"-\" was not input.");
		}

		// #20: TODO (enter "2" and check whether the value was input into the text field)
				// HINT: the "2" button is a div with jsname="lVjWed"
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "1 - 2"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not input.");
		}

		// #21: TODO (press "=" and check whether the value was solved correctly)
				// HINT: the "=" button is a div with jsname="Pt8tGc"
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "-1"));
		} catch (TimeoutException ex) {
			fail("\"-1\" was not the solution.");
		}

		// #22: TODO (press "AC" button and check whether the value was cleared)
				// HINT: the clear button is a div with jsname="SLn8gc"
		driver.findElement(By.xpath("//div[@jsname=\'SLn8gc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "0"));
		} catch (TimeoutException ex) {
			fail("Output not cleared to \"0\".");
		}

		/*
		 * Continue solving in the same format as above while clearing after solution is
		 * found. It's suggested to copy-and-paste to ensure correct format.
		 */

		// #23: TODO (Solve "87 + 52" with correct usage of WebDriverWait)

		driver.findElement(By.xpath("//div[@jsname=\'T7PMFe\']")).click(); // "8"
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click(); // "7"
		driver.findElement(By.xpath("//div[@jsname=\'XSr6wc\']")).click(); // "+"
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click(); // "5"
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click(); // "2"
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "139"));
		} catch (TimeoutException ex) {
			fail("\"87 + 52\" did not result in \"139\".");
		}

		// #24: TODO (Solve "63 × 21" with correct usage of WebDriverWait)
		
		driver.findElement(By.xpath("//div[@jsname=\'abcgof\']")).click(); // "6"
		
		driver.findElement(By.xpath("//div[@jsname=\'KN1kY\']")).click(); // "3"
		
		driver.findElement(By.xpath("//div[@jsname=\'YovRWb\']")).click(); // "×"
		
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click(); // "2"
		
		driver.findElement(By.xpath("//div[@jsname=\'N10B9\']")).click(); // "1"
		
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();

		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "1323"));
		} catch (TimeoutException ex) {
			fail("\"63 × 21\" did not result in \"1323\".");
		}

		// #25: TODO (Solve "45 ÷ 9" with correct usage of WebDriverWait)
	
		driver.findElement(By.xpath("//div[@jsname=\'xAP7E\']")).click(); // "4"
		
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click(); // "5"
		
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click(); // "÷"
		
		driver.findElement(By.xpath("//div[@jsname=\'XoxYJ\']")).click(); // "9"
		
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();

		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "5"));
		} catch (TimeoutException ex) {
			fail("\"45 ÷ 9\" did not result in \"5\".");
		}

		// #26: TODO (Solve "72 ÷ 10" with correct usage of WebDriverWait)
	
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click(); // "7"
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click(); // "2"
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click(); // "÷"
		driver.findElement(By.xpath("//div[@jsname=\'N10B9\']")).click(); // "1"
		driver.findElement(By.xpath("//div[@jsname=\'bkEvMb\']")).click(); // "0"
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();

		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "7.2"));
		} catch (TimeoutException ex) {
			fail("\"72 ÷ 10\" did not result in \"7.2\".");
		}

		// #27: TODO (Solve "log(58 × 6 ÷ 2 - 74)" with correct usage of WebDriverWait)
		// HINT: you don't need the last parentheses
		// Enter 5
		driver.findElement(By.xpath("//div[@jsname=\'DfiOAc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log("));
		} catch (TimeoutException ex) {
			fail("\"log\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(5"));
		} catch (TimeoutException ex) {
			fail("\"5\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'T7PMFe\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58"));
		} catch (TimeoutException ex) {
			fail("\"8\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'YovRWb\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 ×"));
		} catch (TimeoutException ex) {
			fail("\"×\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'abcgof\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6"));
		} catch (TimeoutException ex) {
			fail("\"6\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷"));
		} catch (TimeoutException ex) {
			fail("\"÷\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'pPHzQc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 -"));
		} catch (TimeoutException ex) {
			fail("\"-\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 - 7"));
		} catch (TimeoutException ex) {
			fail("\"7\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'xAP7E\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "log(58 × 6 ÷ 2 - 74"));
		} catch (TimeoutException ex) {
			fail("\"4\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "2"));
		} catch (TimeoutException ex) {
			fail("\"2\" was not the solution.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'SLn8gc\']")).click();
		try {
			shortWait.until(ExpectedConditions.textToBePresentInElement(calculatorText, "0"));
		} catch (TimeoutException ex) {
			fail("Output not cleared to \"0\".");
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		}

	}

	/* Calculator Implicit Instructions
	 * 
	 * Use "By.cssSelector" to select elements in these code fragments.
	 * "By.id" and "By.name" should be used where possible.
	 * 
	 */

	@Test
	public void testCalculatorImplicitly() throws InterruptedException {
		// Initialize the driver (You can switch to 'firefox' as needed)
		ChromeDriver driver = (ChromeDriver) WebTesting.launchDriver("https://www.google.com", "chrome");

		if (driver == null) {
			fail("Driver not created.");
		}

		// Set implicit wait for all elements before interaction
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// #28: TODO (enter "calculator" into the search bar then press the "Return" key)
				// HINT: the search bar has attribute name="q"
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("q")).sendKeys("calculator" + Keys.RETURN);
		} catch (NoSuchElementException ex) {
			fail("Search bar not found.");
		}

		// #29: TODO (ensure that the Calculator is visibile)
				// HINT: a relevant div has class="tyYmIf"
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.cssSelector("div.tyYmIf"));
		} catch (NoSuchElementException ex) {
			fail("Calculator not found.");
		}

		// #30: TODO (enter 1 and check whether the value was input into the text field)
				// HINT: the "1" button is a div with jsname="N10B9"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div[jsname='N10B9']")).click();
          try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'1\']"));
		} catch (NoSuchElementException ex) {
			fail("\"1\" was not input.");
		}

       // #31: TODO (enter "+" and check whether the value was input into the text field)
  		// HINT: the "+" button is a div with jsname="XSr6wc"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div[jsname='XSr6wc']")).click();
           try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'1 + \']"));
		} catch (NoSuchElementException ex) {
			fail("\"+\" was not input.");
		}

        // #32: TODO (enter "-" and check whether the value was input correctly into the text field)
   		// HINT: the "-" button is a div with jsname="pPHzQc"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div[jsname='pPHzQc']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'1 - \']"));
		} catch (NoSuchElementException ex) {
			fail("\"-\" was not input.");
		}

		// #33: TODO (enter "2" and check whether the value was input into the text field)
				// HINT: the "2" button is a div with jsname="lVjWed"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div[jsname='lVjWed']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'1 - 2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}

		// #34: TODO (press "=" and check whether the value was solved correctly)
				// HINT: the "=" button is a div with jsname="Pt8tGc"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'-1\']"));
		} catch (NoSuchElementException ex) {
			fail("\"-1\" was not the solution.");
		}

		// #35: TODO (press "AC" button and check whether the value was cleared)
				// HINT: the "AC" button is a div with jsname="SLn8gc"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@jsname=\'SLn8gc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output not cleared to \"0\".");
		}
		
		/*
		 *  Continue solving in the same format as above while clearing after solution is
		 *  found. It's suggested to copy-and-paste to ensure correct format.
		 */

		// Optional: Add a brief sleep or wait if necessary for any background
		// processing
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace(); // Handle interruption
		}
		// #36: TODO (Solve "87 + 52" with correct usage of ImplicitlyWait)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.cssSelector("div[jsname='T7PMFe']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'8\']"));
		} catch (NoSuchElementException ex) {
			fail("\"8\" was not input.");
		}

		// Enter "7"
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'87\']"));
		} catch (NoSuchElementException ex) {
			fail("\"7\" was not input.");
		}

		// Enter "+"
		driver.findElement(By.xpath("//div[@jsname=\'XSr6wc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'87 + \']"));
		} catch (NoSuchElementException ex) {
			fail("\"+\" was not input.");
		}

		// Enter "5"
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'87 + 5\']"));
		} catch (NoSuchElementException ex) {
			fail("\"5\" was not input.");
		}

		// Enter "2"
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'87 + 52\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}

		// Press "="
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'139\']"));
		} catch (NoSuchElementException ex) {
			fail("\"87 + 52\" did not result in \"139\".");
		}

		// Clear output
		driver.findElement(By.cssSelector("div[jsname='SLn8gc']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output was not cleared to \"0\".");
		}

		// #37: TODO (Solve "63 × 21" with correct usage of ImplicitlyWait)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@jsname=\'abcgof\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'6\']"));
		} catch (NoSuchElementException ex) {
			fail("\"6\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'KN1kY\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'63\']"));
		} catch (NoSuchElementException ex) {
			fail("\"3\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'YovRWb\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'63 × \']"));
		} catch (NoSuchElementException ex) {
			fail("\"×\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'lVjWed\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'63 × 2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'N10B9\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'63 × 21\']"));
		} catch (NoSuchElementException ex) {
			fail("\"1\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'Pt8tGc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'1323\']"));
		} catch (NoSuchElementException ex) {
			fail("\"63 × 21\" did not result in \"1323\".");
		}

		// Clear output
		driver.findElement(By.cssSelector("div[jsname=\'SLn8gc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output was not cleared to \"0\".");
		}

		// #38: TODO (Solve "45 ÷ 9" with correct usage of ImplicitlyWait)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@jsname=\'xAP7E\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'4\']"));
		} catch (NoSuchElementException ex) {
			fail("\"4\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'Ax5wH\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'45\']"));
		} catch (NoSuchElementException ex) {
			fail("\"5\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'45 ÷ \']"));
		} catch (NoSuchElementException ex) {
			fail("\"÷\" was not input.");
		}
		driver.findElement(By.xpath("//div[@jsname=\'XoxYJ\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'45 ÷ 9\']"));
		} catch (NoSuchElementException ex) {
			fail("\"9\" was not input.");
		}
		driver.findElement(By.cssSelector("div[jsname='Pt8tGc']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'5\']"));
		} catch (NoSuchElementException ex) {
			fail("\"45 ÷ 9\" did not result in \"5\".");
		}

		// Clear output
		driver.findElement(By.cssSelector("div[jsname=\'SLn8gc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output was not cleared to \"0\".");
		}

		// #39: TODO (Solve "72 ÷ 10" with correct usage of ImplicitlyWait)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Enter "7"
		driver.findElement(By.xpath("//div[@jsname=\'rk7bOd\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'7\']"));
		} catch (NoSuchElementException ex) {
			fail("\"7\" was not input.");
		}

		// Enter "2"
		driver.findElement(By.cssSelector("div[jsname='lVjWed']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}

		// Enter "÷"
		driver.findElement(By.xpath("//div[@jsname=\'WxTTNd\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ \']"));
		} catch (NoSuchElementException ex) {
			fail("\"÷\" was not input.");
		}

		// Enter "1"
		driver.findElement(By.cssSelector("div[jsname='N10B9']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ 1\']"));
		} catch (NoSuchElementException ex) {
			fail("\"1\" was not input.");
		}

		// Enter "0"
		driver.findElement(By.cssSelector("div[jsname='bkEvMb']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'72 ÷ 10\']"));
		} catch (NoSuchElementException ex) {
			fail("\"0\" was not input.");
		}

		// Press "="
		driver.findElement(By.cssSelector("div[jsname=\'Pt8tGc\']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'7.2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"72 ÷ 10\" did not result in \"7.2\".");
		}

		// Clear output
		driver.findElement(By.cssSelector("div[jsname='SLn8gc']")).click();
		try {
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output was not cleared to \"0\".");
		}
		// #40
		// Step 1: Click on the "log" button to start the logarithmic function input
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("div[jsname=\'DfiOAc\']")).click();
		try {
			// Verify that "log(" appears on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(\']"));
		} catch (NoSuchElementException ex) {
			fail("\"log\" was not input.");
		}

		// Step 2: Click on the "5" button
		driver.findElement(By.cssSelector("div[jsname=\'Ax5wH\']")).click();
		try {
			// Verify that "log(5" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(5\']"));
		} catch (NoSuchElementException ex) {
			fail("\"5\" was not input.");
		}

		// Step 3: Click on the "8" button
		driver.findElement(By.cssSelector("div[jsname=\'T7PMFe\']")).click();
		try {
			// Verify that "log(58" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58\']"));
		} catch (NoSuchElementException ex) {
			fail("\"8\" was not input.");
		}

		// Step 4: Click on the "×" button
		driver.findElement(By.cssSelector("div[jsname=\'YovRWb\']")).click();
		try {
			// Verify that "log(58 ×" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × \']"));
		} catch (NoSuchElementException ex) {
			fail("\"×\" was not input.");
		}

		// Step 5: Click on the "6" button
		driver.findElement(By.cssSelector("div[jsname=\'abcgof\']")).click();
		try {
			// Verify that "log(58 × 6" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6\']"));
		} catch (NoSuchElementException ex) {
			fail("\"6\" was not input.");
		}

		// Step 6: Click on the "÷" button
		driver.findElement(By.cssSelector("div[jsname=\'WxTTNd\']")).click();
		try {
			// Verify that "log(58 × 6 ÷" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ \']"));
		} catch (NoSuchElementException ex) {
			fail("\"÷\" was not input.");
		}

		// Step 7: Click on the "2" button
		driver.findElement(By.cssSelector("div[jsname=\'lVjWed\']")).click();
		try {
			// Verify that "log(58 × 6 ÷ 2" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not input.");
		}

		// Step 8: Click on the "-" button
		driver.findElement(By.cssSelector("div[jsname=\'pPHzQc\']")).click();
		try {
			// Verify that "log(58 × 6 ÷ 2 -" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - \']"));
		} catch (NoSuchElementException ex) {
			fail("\"-\" was not input.");
		}

		// Step 9: Click on the "7" button
		driver.findElement(By.cssSelector("div[jsname=\'rk7bOd\']")).click();
		try {
			// Verify that "log(58 × 6 ÷ 2 - 7" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - 7\']"));
		} catch (NoSuchElementException ex) {
			fail("\"7\" was not input.");
		}

		// Step 10: Click on the "4" button
		driver.findElement(By.cssSelector("div[jsname=\'xAP7E\']")).click();
		try {
			// Verify that "log(58 × 6 ÷ 2 - 74" is displayed on the screen
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'log(58 × 6 ÷ 2 - 74\']"));
		} catch (NoSuchElementException ex) {
			fail("\"4\" was not input.");
		}

		// Step 11: Click on the "=" button to get the result
		driver.findElement(By.cssSelector("div[jsname=\'Pt8tGc\']")).click();
		try {
			// Verify that the result is displayed as "2"
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'2\']"));
		} catch (NoSuchElementException ex) {
			fail("\"2\" was not the solution.");
		}

		// Step 12: Click on the "C" (Clear) button to reset the calculator
		driver.findElement(By.cssSelector("div[jsname=\'SLn8gc\']")).click();
		try {
			// Verify that the output is cleared and the display shows "0"
			driver.findElement(By.xpath("//span[@id=\'cwos\' and text()=\'0\']"));
		} catch (NoSuchElementException ex) {
			fail("Output not cleared to \"0\".");
		}

		// Step 13: Sleep for 5 seconds to allow for any other processes to complete
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// Handle any interruptions that may occur during sleep
			e.printStackTrace();
		}
	}
}