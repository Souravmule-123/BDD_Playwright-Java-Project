package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Methods {
    private static final Logger log =
            LoggerFactory.getLogger(Methods.class);
    private Page page;
    private final Locator dropDownNameAtoZ;
    private final Locator swagLabs;
    private final Locator sauceLabBagpack;
    private final Locator userName;

    public Methods(Page page) {
        this.page = page;

    this.dropDownNameAtoZ= page.locator(".product_sort_container");
    this.swagLabs=page.locator(".app_logo");
    this.sauceLabBagpack=page.getByText("Sauce Labs Backpack");
    this.userName=page.getByPlaceholder("Username");
    }

    public void verifyTitleUrl() {
        String url = page.title();
        log.info("our title is{}", url);
        String u = page.url();
        log.info("our url is{}", u);

    }
    public void verifyTheNavigationMethod() {
        page.reload();
        log.info("page reload successfully");
        page.goBack();
        log.info("page goBack successfully");
        page.goForward();
        log.info("page goForward successfully");
    }
    public void selectTheDropdown() {
        dropDownNameAtoZ.waitFor();
        dropDownNameAtoZ.selectOption("az"); //value
        dropDownNameAtoZ.selectOption(new SelectOption().setLabel("Price (low to high)")); //text
        dropDownNameAtoZ.selectOption(new SelectOption().setIndex(1)); // index
    }
    public void verifyAssertionMethod() {
        String text=swagLabs.textContent();
        log.info(text);
     assertThat(swagLabs).containsText("Labs");
    }
    public void clickMethod() {
        sauceLabBagpack.click();
    }
    public void enterUserName() {
    userName.fill("standard_user");
    }
    public void clearText() {
        userName.clear();
    }
    public void keyboardTypeMethod() {
        userName.type("SouravSourav");
    }
    public void mouseHoverSauceLabsBackpack() {
        sauceLabBagpack.hover();
        log.info("text{}" , sauceLabBagpack.textContent());
    }
}
