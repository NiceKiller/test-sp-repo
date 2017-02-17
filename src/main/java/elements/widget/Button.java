package elements.widget;

import elements.base.Element;
import elements.base.ImplementedBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzawa on 2/14/2017.
 */

/**
 * Button functionality
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element{

    void click();
}
