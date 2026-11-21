package pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private static final Logger log =
            LoggerFactory.getLogger(HomePage.class);
    private Page page;
    private final Locator Products;


    public  HomePage(Page page){
        this.page=page;
        this.Products= page.locator("//*[text()='Products']");
    }

    public void verifyText(String title){
       assertThat(Products).hasText(title);
        log.info("presented Text is: {}", title);
    }
}
