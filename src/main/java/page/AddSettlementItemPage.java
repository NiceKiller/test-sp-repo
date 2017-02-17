package page;

import elements.widget.Button;
import elements.widget.Select;
import elements.widget.TextInput;
import enums.SettlementCategories;
import model.Settlement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/14/2017.
 */

public class AddSettlementItemPage extends AbstractPage {

    public AddSettlementItemPage(WebDriver driver) {
        super(driver);
        waitAndSwitchToWindow(2,1);
    }

    @FindBy(name = "text")
    private TextInput text;

    @FindBy(id = "categorygroup")
    private Select categoryGroup;

    @FindBy(id = "shortcut2")
    private TextInput price;

    @FindBy(id = "age_selected")
    private WebElement ageSelectedRadio;

    @FindBy(id = "category")
    private Select subCategory;

    @FindBy(id = "age_years")
    private TextInput ageYears;

    @FindBy(id = "btn_ok")
    private Button ok;

    public AddSettlementItemPage waitForDialogLoad(){
        customWaits.waitForElementPresent(text);
        return this;
    }

    public AddSettlementItemPage setText(String textValue){
        text.set(textValue);
        return this;
    }

    public AddSettlementItemPage selectCategoryGroup(SettlementCategories category){
        categoryGroup.selectByVisibleText(category.getValue());
        return this;
    }

    public AddSettlementItemPage selectSubCategoryGroup(SettlementCategories category){
        if(category.getSubCategories().getValue()!=null)
        subCategory.selectByVisibleText(category.getSubCategories().getValue());
        return this;
    }

    public AddSettlementItemPage setPrice(String priceValue){
        price.set(priceValue);
        return this;
    }

    public AddSettlementItemPage selectAgeRadioButton(){
        ageSelectedRadio.click();
        return this;
    }

    public AddSettlementItemPage setAge(String ageYearsText){
        selectAgeRadioButton();
        ageYears.set(ageYearsText);
        return this;
    }

    public SettlementPage pressOk(){
        ok.click();
        waitAndSwitchToWindow(1,0);
        return new SettlementPage(driver);
    }

    public SettlementPage addSettlement(Settlement settlement){
        return waitForDialogLoad()
                .setText(settlement.getText())
                .selectCategoryGroup(settlement.getCategories())
                .selectSubCategoryGroup(settlement.getCategories())
                .setPrice(settlement.getPrice())
                .setAge(settlement.getAge())
                .pressOk();
    }


}
