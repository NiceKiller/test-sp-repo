package elements.widget;

import elements.base.ElementImpl;
import org.openqa.selenium.WebElement;

/**
 * Button wrapper.
 */
public class ButtonImpl extends ElementImpl implements Button {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ButtonImpl(WebElement element) {
        super(element);
    }
}
