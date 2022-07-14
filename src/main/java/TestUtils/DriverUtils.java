package TestUtils;

import io.Ahmed.Gen.Gen;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverUtils {
//    static String targetWeb = "http://automationpractice.com/index.php";

    public static Properties pro = new Properties();

    public static void openBrowser(String browserName) {

        switch (browserName) {
            case "chrome":

                Gen.chromeDriverSetup();
                if (pro.getProperty("headless").equals("yes")) {
                    ChromeOptions choptions = new ChromeOptions().setHeadless(true);

                    Gen.setDriver(new ChromeDriver(choptions));
                } else {

//                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

                    Gen.chromeRunSilent();

                    ChromeOptions chromeOptions = new ChromeOptions();

                    chromeOptions.addArguments("--incognito");

                    chromeOptions.setAcceptInsecureCerts(true);

                    chromeOptions.addArguments("--disable-extensions");

                    chromeOptions.addArguments("--disable-notifications");

                    chromeOptions.addArguments("start-maximized");

                    Gen.setDriver(new ChromeDriver(chromeOptions));
                }

                break;

            case "edge":

                Gen.edgeDriverSetup();

                if (pro.getProperty("headless").equals("yes")) {
                    EdgeOptions edgeOptions = new EdgeOptions().setHeadless(true);

                    Gen.setDriver(new EdgeDriver(edgeOptions));
                } else {

                    System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                    EdgeOptions edgeOptions = new EdgeOptions();

                    edgeOptions.addArguments("--incognito");

                    edgeOptions.setAcceptInsecureCerts(true);

                    edgeOptions.addArguments("--disable-extensions");

                    edgeOptions.addArguments("--disable-notifications");

                    edgeOptions.addArguments("start-maximized");

                    Gen.setDriver(new EdgeDriver(edgeOptions));
                }


                break;

        }
        Gen.getDriver().get(pro.getProperty("targeturl"));
        Gen.pageLoadTimeout(20);

    }

    public static void closeBrowser() {
        Gen.getDriver().close();
        Gen.getDriver().quit();

    }

    public static void configureProperty() {
        //where is location ?
        try {
            InputStream location = new FileInputStream("src\\main\\resources\\config.properties");

            pro.load(location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







