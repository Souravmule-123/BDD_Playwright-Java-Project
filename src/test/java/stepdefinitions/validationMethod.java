package stepdefinitions;

import com.microsoft.playwright.Page;
import helper.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.Methods;

public class validationMethod {
    private TestContext testContext;
    private Page page;
    private Methods methods;

    public validationMethod(TestContext context) {
        this.testContext = context;
        this.page = testContext.getPage(); // Playwright Page
        this.methods=testContext.getPageObjectManager().methods();

    }
    @Then("I want a url of the page")
    public void i_want_a_title_and_url_of_the_page() {
        methods.verifyTitleUrl();
    }

    @Then("I want move back reload the page")
    public void iWantMoveBackReloadThePage() {
        methods.verifyTheNavigationMethod();
    }

    @Then("Select the category from A To Z")
    public void selectTheCategoryFromAToZ() {
        methods.selectTheDropdown();
    }

    @Then("I verify the text is swagLabs")
    public void iVerifyTheTextIsSwagLabs() {
        methods.verifyAssertionMethod();
    }


    @Then("I click on sauce labs bagPack")
    public void iClickOnSauceLabsBackpage() {
        methods.clickMethod();
    }

    @Then("I enter the Username")
    public void iEnterTheUsername() {
        methods.enterUserName();
    }

    @And("I clear the text on the entire field")
    public void iClearTheTextOnTheEntireField() {
        methods.clearText();
    }

    @And("I enter the keyboard typing action")
    public void iEnterTheKeyboardTypingAction() {
        methods.keyboardTypeMethod();
    }

    @And("I mouseHover on Sauce Labs Backpack")
    public void iMouseHoverOnSauceLabsBackpack() {
        methods.mouseHoverSauceLabsBackpack();
    }
}
