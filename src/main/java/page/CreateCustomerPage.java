package page;

import elements.widget.Button;
import elements.widget.TextInput;
import model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/16/2017.
 */

public class CreateCustomerPage extends AbstractPage {

    public CreateCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "phone")
    private TextInput phone;

    @FindBy(name = "cellPhoneNumber")
    private TextInput cellPhoneNumber;

    @FindBy(name = "adr1")
    private TextInput addressFirstLine;

    @FindBy(name = "city")
    private TextInput city;

    @FindBy(name = "zipcode")
    private TextInput zipCode;

    @FindBy(name = "email")
    private TextInput email;

    @FindBy(id = "send")
    private Button sendWithEmail;

    public CreateCustomerPage setPhoneNumber(String number){
        phone.set(number);
        return this;
    }

    public CreateCustomerPage setCellPhoneNumber(String number){
        cellPhoneNumber.set(number);
        return this;
    }

    public CreateCustomerPage setAddress(String address){
        addressFirstLine.set(address);
        return this;
    }

    public CreateCustomerPage setCity(String cityValue){
        city.set(cityValue);
        return this;
    }

    public CreateCustomerPage setZipCode(String code){
        zipCode.set(code);
        return this;
    }

    public CreateCustomerPage setEmail(String emailValue){
        email.set(emailValue);
        return this;
    }

    public ConfirmCustomerInformationPage completeWithEmail(){
        sendWithEmail.click();
        return new ConfirmCustomerInformationPage(driver);
    }

    public ConfirmCustomerInformationPage enterCustomerInformationAndCompleteWithEmail(Customer customer){
        return setPhoneNumber(customer.getPhoneNUmber())
                .setCellPhoneNumber(customer.getCellPhoneNumber())
                .setAddress(customer.getAddress())
                .setCity(customer.getCity())
                .setZipCode(customer.getZipCode())
                .setEmail(customer.getEmail())
                .completeWithEmail();
    }
}
