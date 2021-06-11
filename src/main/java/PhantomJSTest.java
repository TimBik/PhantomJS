import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJSTest {

    public void phantomJS() throws InterruptedException, IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/Hans/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
        caps.setCapability("takesScreenshot", true);
        PhantomJSDriver driver = new PhantomJSDriver(caps);
        String baseUrl = "http://www.google.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/Hans/IdeaProjects/test/PhantomJS/screenshots/screenshotAfterLaunchingGoogle.jpeg"), true);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().to("https://selenium.dev//");//Launch URL

        File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("/Users/Hans/IdeaProjects/test/PhantomJS/screenshots/screenshotAfterLaunchingURL.jpeg"), true);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/div[4]/span")).click();//Click on the Projects

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("/Users/Hans/IdeaProjects/test/PhantomJS/screenshots/screenshotAfterClickingDownload.jpeg"), true);


    }

    public static void main(String[] args) throws InterruptedException, IOException {
        PhantomJSTest pj = new PhantomJSTest();
        pj.phantomJS();
    }

}