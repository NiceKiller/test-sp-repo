package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import driver.WebDriverProvider;
import enums.SettlementCategories;
import helper.ScreenshotHelper;
import model.*;
import org.openqa.selenium.WebDriver;
import page.CreateCustomerPage;
import page.LoginPage;
import page.MyPagePage;
import page.SettlementPage;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bzawa on 2/12/2017.
 */
public class ClaimsStepDef implements En {

    private static final String CLAIM_NUMBER = UUID.randomUUID().toString();

    private WebDriver driver;
    private Customer customer;
    private Settlement settlement;

    @Before
    public void setUp(){
        driver = new WebDriverProvider().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            ScreenshotHelper screenshotHelper = new ScreenshotHelper();
            screenshotHelper.takeScreenShot(scenario, driver);
        }
        driver.quit();
    }

    public ClaimsStepDef() {
        createObjects();

        When("^user log in to (.+) with username (.+) and password (.+)$", (String url, String username, String password) -> {
            User user = new UserBuilder()
                    .setUsername(username)
                    .setPassword(password).createUser();
            assertThat(new LoginPage(driver).login(url, user).getMenuContainerPage().getLoginFromLoggedAs())
                    .as("Is user logged in")
                    .isEqualToIgnoringCase(user.getUsername());
        });
        And("^create new case for default customer", () -> {
            new MyPagePage(driver).createNewCase().enterCustomerInformation(customer);
        });
        Then("^add new item$", () -> {
            new SettlementPage(driver).addManually().addSettlement(settlement).completeClaim();
        });
        And("^fill customer information$", () -> {
           assertThat(new CreateCustomerPage(driver)
                   .enterCustomerInformationAndCompleteWithEmail(customer).confirmSendMail()
                   .isClaimNumberOnList(CLAIM_NUMBER)).as("Is created claim on the list")
           .isTrue();
        });
        Then("^email should be sent$", () -> {
            assertThat(new MyPagePage(driver).openClaim(CLAIM_NUMBER).openMails().isEmailSent())
            .as("Check if emails are sent, but emails are not displayed so this will always fail")
            .isTrue();
        });

    }

    private void createObjects(){
        customer = new CustomerBuilder()
                .setTitle("Mr")
                .setFirstName("Johny")
                .setSurname("Bravo")
                .setPolicyNumber("123456")
                .setClaimsNumber(CLAIM_NUMBER)
                .setPhoneNUmber("123123123")
                .setCellPhoneNumber("321321321")
                .setAddress("Street 12")
                .setCity("City")
                .setZipCode("12-121")
                .setEmail("JohnyBravo@scalepoint.com").createCustomer();

        settlement = new SettlementBuilder()
                .setText("Item")
                .setCategories(SettlementCategories.BIKES_BIKES)
                .setPrice("100")
                .setAge("1")
                .createSettlement();
    }
}
