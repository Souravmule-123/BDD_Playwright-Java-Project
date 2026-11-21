package stepdefinitions;

import com.microsoft.playwright.Page;
import helper.TestContext;
import io.cucumber.java.en.Given;
import pageobject.HomePage;

public class HomePageStepDef {
    private TestContext testContext;
    private Page page;
    private HomePage homePage;

    public HomePageStepDef(TestContext context){
        this.testContext = context;
        this.page=testContext.getPage();
        this.homePage=testContext.getPageObjectManager().getHomePage();
    }
    @Given("I launch the verify the {string} title name")
    public void i_launch_the_verify_the_title_name(String title) {
    homePage.verifyText(title);
    }

}
