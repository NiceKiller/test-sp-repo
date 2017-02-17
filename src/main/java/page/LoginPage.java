package page;

import elements.widget.TextInput;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/12/2017.
 */
public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "j_username")
    private TextInput username;

    @FindBy(id = "j_password")
    private TextInput password;

    public MyPagePage login(String url, User user) {
        driver.navigate().to(url);
        username.set(user.getUsername());
        password.set(user.getPassword());
        password.submit();
        return new MyPagePage(driver);
    }

}
