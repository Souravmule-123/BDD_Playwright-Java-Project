package helper;

import com.microsoft.playwright.Page;
import objectManager.PageObjectManager;

public class TestContext {

    private Page page;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager(page);
        }
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}