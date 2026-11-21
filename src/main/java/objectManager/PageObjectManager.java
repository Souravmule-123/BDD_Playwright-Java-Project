package objectManager;

import com.microsoft.playwright.Page;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.Methods;

public class PageObjectManager {

    private final Page page;

    // Page objects
    private LoginPage loginPage;
    private HomePage homePage;
    private Methods methods;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        return loginPage;
    }
    public HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage(page);
        }
        return homePage;
    }
    public Methods methods(){
        if(methods == null){
            methods = new Methods(page);
        }
        return methods;
    }
}