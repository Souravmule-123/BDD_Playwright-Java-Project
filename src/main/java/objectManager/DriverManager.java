package objectManager;

import com.microsoft.playwright.*;
import enums.DriverType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {

    private static final Logger log =
            LoggerFactory.getLogger(DriverManager.class);

    private static DriverManager instance;

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    private final DriverType driverType;

    private DriverManager() {
        driverType = FileReaderManager.getInstance()
                .getConfigReader()
                .getBrowser();

        log.info("Browser selected: {}", driverType);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public Page getPage() {
        if (page == null) {
            initBrowser();
        }
        return page;
    }

    private void initBrowser() {

        playwright = Playwright.create();

        switch (driverType) {

            case CHROME:
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false));
                break;

            case EDGE:
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setChannel("msedge")
                                .setHeadless(false));
                break;

            case FIREFOX:
                browser = playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false));
                break;

            case WEBKIT:
                browser = playwright.webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false));
                break;

            default:
                throw new RuntimeException("Invalid browser");
        }

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1366, 768)
        );

        page = context.newPage();
    }

    // ✅ THIS IS REQUIRED FOR YOUR PASS/FAIL LOGIC
    public void closeBrowser() {

        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        instance = null; // 🔥 important for fresh run
    }
}