package tr.gov.tubitak.bilgem.yte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class OpenBrowser {

    static WebDriver open(String browser, String url) {
        WebDriver driver = null;
        String webdriver, webdriverPath;

        try {
            if (browser.toLowerCase().equals("chrome")) {
                webdriver = "webdriver.chrome.driver";
                webdriverPath = "/Users/fatihsaracoglu/IdeaProjects/downloadimages/src/main/java/tr/gov/tubitak/bilgem/yte/drivers/chromedriver";
                System.setProperty(webdriver, webdriverPath);
                driver = new ChromeDriver();
            } else if (browser.toLowerCase().equals("firefox")) {
                webdriver = "webdriver.gecko.driver";
                webdriverPath = "/Users/fatihsaracoglu/IdeaProjects/downloadimages/src/main/java/tr/gov/tubitak/bilgem/yte/drivers/geckodriver";
                System.setProperty(webdriver, webdriverPath);
                driver = new FirefoxDriver();
            }
            driver.get(url);
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred while opening browser...");
        }
        return driver;
    }
}
