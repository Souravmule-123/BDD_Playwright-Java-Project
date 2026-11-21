package stepdefinitions;

import com.microsoft.playwright.Page;
import helper.TestContext;
import io.cucumber.java.en.*;
import pageobject.LoginPage;

public class LoginStepDef {

    private TestContext testContext;
    private Page page;
    private LoginPage loginPage;

    public LoginStepDef(TestContext context) {
        this.testContext = context;
        this.page = testContext.getPage(); // Playwright Page
        this.loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("I launch the {string} Application")
    public void i_launch_the_application(String keys) {
        loginPage.navigateToUrl(keys);

    }

    @And("I  enter the {string} and {string}")
    public void iEnterTheAnd(String UserName, String Pwd) throws InterruptedException {
        loginPage.enterUserNameAndPwd(UserName,Pwd);
    }



}
