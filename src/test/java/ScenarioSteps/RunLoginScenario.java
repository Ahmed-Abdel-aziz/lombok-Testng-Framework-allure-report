package ScenarioSteps;

import LoginPage.LoginElements;
import TestRunner.Runner;
import com.ahmed.excelizer.ExcelReader;
import io.Ahmed.Gen.Gen;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunLoginScenario extends Runner {

    LoginElements loginElements = new LoginElements();

    @DataProvider(name = "datareader")
    public  Object[][] readExcel(){

        return ExcelReader.loadTabularData("src\\main\\resources\\loginData.xlsx","Sheet1");
    }

    @Test(priority = 1,description = "invalid case ",dataProvider = "datareader")
    @Severity(SeverityLevel.CRITICAL)
    @Description("firstClass")
    public void invalidLogin(String username , String password , String errorMessage) throws InterruptedException {

        loginElements.loginForm(username,password);

        Gen.assertEqual(loginElements.getLoginError(),errorMessage);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("firstClass")
    public void validLogin() throws InterruptedException {

        loginElements.loginForm("qcscout2020@gmail.com","Ahmed123");

    }

}



