package pageobject;

import com.microsoft.playwright.*;
import objectManager.FileReaderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger log =
            LoggerFactory.getLogger(LoginPage.class);
    private Page page;

    // Locators
    private final Locator username;
    private final Locator password;
    private final Locator loginBtn;

    public LoginPage(Page page) {
        this.page = page;

        this.username = page.getByPlaceholder("Username");
        this.password = page.getByPlaceholder("Password");
        this.loginBtn = page.locator("//*[@type='submit']");
    }

    public void navigateToUrl(String key) {
        String url = FileReaderManager.getInstance().getConfigReader().getApplicationUrl(key);
        page.navigate(url);
    }
    public void enterUserNameAndPwd(String user, String pwd) throws InterruptedException {
        username.fill(FileReaderManager.getInstance().getConfigReader().getSauceDemoUserName(user));
        password.fill(FileReaderManager.getInstance().getConfigReader().getSauceDemoPwd(pwd));
        loginBtn.click();
        log.info("successfully enter user name and pwd");
    }

}


