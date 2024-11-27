package web_testing_app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTesting {
    public static WebDriver localDriver;

    public static WebDriver getDriver() {
        return localDriver;
    }

    public static void initDrivers() {
        // WebDriverManager handles the driver binaries automatically
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver launchDriver(String siteUrl, String browser) {
        quitDriver(); // Ensure previous driver is closed before launching a new one

        if ("firefox".equalsIgnoreCase(browser)) {
            // Configure Firefox Options
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.startup.page", 1);
            options.addPreference("browser.startup.homepage", siteUrl);
            options.setAcceptInsecureCerts(true); // Accept insecure certificates
           

            // Create a new FirefoxDriver instance
            localDriver = new FirefoxDriver(options);
        } else if ("chrome".equalsIgnoreCase(browser)) {
            // Configure Chrome Options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("homepage=" + siteUrl);
            options.setAcceptInsecureCerts(true); // Accept insecure certificates
            

            // Create a new ChromeDriver instance
            localDriver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize the browser window and navigate to the specified URL
        localDriver.manage().window().maximize();
        localDriver.get(siteUrl);
        return localDriver;
    }

    public static void quitDriver() {
        if (localDriver != null) {
            localDriver.quit();
            localDriver = null;
        }
    }
}