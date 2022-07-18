package pageObjects.nopCommercemvn.adminmvn;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommercemvn.usermvn.*;

public class PageGeneratorManager {

    public static AdminPageObject getAdminPage(WebDriver driver) {
        return new AdminPageObject(driver);
    }

}
