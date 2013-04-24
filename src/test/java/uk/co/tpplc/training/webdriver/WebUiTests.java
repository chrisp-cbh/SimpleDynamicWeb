package uk.co.tpplc.training.webdriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebUiTests {
	// driving chrome
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\workspace\\BricksAndMortar\\lib\\chromedriver.exe");
	}
	private static WebDriver driver;

	public WebUiTests() {

	}

	@BeforeClass
	public static void createDriver() {
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

	@Test
	public void knockOnTheFrontDoor() {
		driver.get("http://localhost:8080/SimpleDynamicWeb/");
		assertEquals("Hello, can I help you?", driver.getTitle());
	}

	@Test
	public void giveGateKeeperCanBeGivenSecretPhrase() {
		try {
			driver.get("http://localhost:8080/SimpleDynamicWeb/");
			WebElement element = driver.findElement(By
					.id("passphraseChallenge"));
			assertEquals("What is the secret phrase?", element.getText());
		} catch (Exception e) {
			fail("webdriver threw exception: " + e.toString());
		}
	}

	@Test
	public void enterCorrectPassPhraseAndChangeGreeting() {
		// try {
		driver.get("http://localhost:8080/SimpleDynamicWeb/");
		driver.findElement(By.name("passphrase")).sendKeys(
				"supercalifragilisticexpialidocious");
		driver.findElement(By.id("submit")).click();
		assertEquals("Welcome Sir, how nice to see you again!",
				driver.getTitle());
		// } catch (Exception e) {
		// fail("webdriver threw exception: " + e.toString());
		// }
	}
}