package page;

import elements.widget.Button;
import elements.widget.TextInput;
import model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/14/2017.
 */
public class NewCustomerPage extends AbstractPage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "salutation")
    private TextInput title;

    @FindBy(name = "last_name")
    private TextInput surname;

    @FindBy(name = "first_name")
    private TextInput firstName;

    @FindBy(name = "policy_number")
    private TextInput policyNumber;

    @FindBy(name = "claim_number")
    private TextInput claimNumber;

    @FindBy(id = "continue")
    private Button continueButton;

    public NewCustomerPage setTitle(String titleText){
        title.set(titleText);
        return this;
    }

    public NewCustomerPage setSurname(String surnameText){
        surname.set(surnameText);
        return this;
    }

    public NewCustomerPage setFirstName(String firstNameText){
        firstName.set(firstNameText);
        return this;
    }

    public NewCustomerPage setPolicyNumber(String policyNumberText){
        policyNumber.set(policyNumberText);
        return this;
    }

    public NewCustomerPage setClaimNumber(String claimNumberText){
        claimNumber.set(claimNumberText);
        return this;
    }

    public SettlementPage clickContinue(){
        continueButton.click();
        return new SettlementPage(driver);
    }

    public SettlementPage enterCustomerInformation(Customer customer){
        return setTitle(customer.getTitle())
                .setSurname(customer.getSurname())
                .setFirstName(customer.getFirstName())
                .setPolicyNumber(customer.getPolicyNumber())
                .setClaimNumber(customer.getClaimsNumber())
                .clickContinue();
    }
}
