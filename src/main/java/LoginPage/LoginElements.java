package LoginPage;

import io.Ahmed.Gen.Gen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class LoginElements {

    By signIn = By.linkText("Sign in");

    By signIn1 = By.linkText("Si");

    By emailTextBox = By.id("email");

    By passwordTextBox = By.id("passwd");

    By submitButton = By.id("SubmitLogin");

    By loginErrorMessage = By.xpath("//li[text()='Invalid email address.']");

    public WebElement clickSignInButton() throws InterruptedException {

        try {
            return Gen.findBy(signIn1);
        } catch (Exception e) {

            Thread.sleep(2000);

            return Gen.findBy(signIn);
        }
    }


    public WebElement enterEmail() throws InterruptedException {


        Gen.waitToBeVisibleBy(emailTextBox, 10);
        return Gen.findBy(emailTextBox);
    }

    public WebElement enterPassword() {
        return Gen.findBy(passwordTextBox);
    }

    public WebElement clickSubmit() {
        Gen.waitToBeVisibleBy(submitButton, 5);
        return Gen.findBy(submitButton);
    }

    public String getLoginError() {
        Gen.waitToBeVisibleBy(loginErrorMessage, 5);
        return Gen.findBy(loginErrorMessage).getText();
    }

    @Step("login form steps {},{}")
    public void loginForm(String username, String password) throws InterruptedException {
        // click on sign in
        Gen.click(clickSignInButton());

        //login action
        Gen.clearWrite(enterEmail(), username);
        Gen.clearWrite(enterPassword(), password);
        Gen.click(clickSubmit());
    }
}