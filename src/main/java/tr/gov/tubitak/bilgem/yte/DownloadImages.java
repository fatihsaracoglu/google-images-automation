package tr.gov.tubitak.bilgem.yte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


class DownloadImages {

    static void download(String browser, String url, String keyword, int number) {
        WebDriver wd = SearchInBrowser.search(browser, url, keyword);
        //WebElement close_button = wd.findElement(By.cssSelector("svg.lBjYod"));
        Set<String> links = new LinkedHashSet<String>();
        try {
            for (int i = 0; i < number; i++) {
                WebElement image = wd.findElement(By.cssSelector("div[data-ri=\"" + i + "\"]"));
                image.click();
                List<WebElement> largeImages = wd.findElements(By.cssSelector("img.irc_mi"));
                TimeUnit.MILLISECONDS.sleep(500);
                for (WebElement element : largeImages) {
                    String imageSRC = element.getAttribute("src");
                    links.add(imageSRC);
                }
            }
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred while getting image source...");
        }

        wd.close();

        Iterator<String> itr = links.iterator();
        int counter = 0;
        while(itr.hasNext() && counter <= number) {
            System.out.println("Saving...");
            saveFile(itr.next(), String.valueOf(counter));
            counter++;
        }
    }

    private static void saveFile(String src, String fileName) {
        try {
            URL imageURL = new URL(src);
            System.out.println(imageURL);
            BufferedImage saveImage = ImageIO.read(imageURL);
            ImageIO.write(saveImage, "png", new File("/Users/fatihsaracoglu/IdeaProjects/downloadimages/src/main/java/tr/gov/tubitak/bilgem/yte/images/" + fileName + ".png"));
            System.out.println("Saved!");
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred while saving the image...");
        }
    }
}
