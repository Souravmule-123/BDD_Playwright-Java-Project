package helper;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import objectManager.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class Hooks {

    private static final Logger log =
            LoggerFactory.getLogger(Hooks.class);

    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        testContext.setPage(
                DriverManager.getInstance().getPage());
    }

    @After
    public void tearDown(Scenario scenario) {

        //  Step 1: Take screenshot FIRST if failed
        if (scenario.isFailed()) {

            log.info("❌ FAILED → capturing screenshot");

            if (testContext.getPage() != null
                    && !testContext.getPage().isClosed()) {

                byte[] screenshot = testContext.getPage().screenshot();

                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
        }

        //  Step 2: Close browser AFTER screenshot
        log.info("🔄 Closing browser");
        DriverManager.getInstance().closeBrowser();
    }
}