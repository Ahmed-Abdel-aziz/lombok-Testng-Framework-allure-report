package TestRunner;


import TestUtils.DriverUtils;
import io.Ahmed.Gen.Gen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Runner {

    @BeforeMethod(description = "Browser is running",alwaysRun = true)
    public void startBrowser(){

        DriverUtils.configureProperty();
        DriverUtils.openBrowser(DriverUtils.pro.getProperty("browser"));
    }


    @AfterMethod(description = "Browser is closed",alwaysRun = true)
    public void quitBrowser(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            Gen.takeScreenShot("target");

        }
        DriverUtils.closeBrowser();
    }
}
