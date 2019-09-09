package tr.gov.tubitak.bilgem.yte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class SearchInBrowser {

    static WebDriver search(String browser, String url, String keyword) {
        WebDriver wd = OpenBrowser.open(browser, url);
        // For Google: input's name="q"
        WebElement element = wd.findElement(By.name("q"));
        element.sendKeys(keyword);
        element.submit();
        return wd;
    }
}
