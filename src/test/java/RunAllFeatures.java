import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by bzawa on 2/12/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features="src/test/java/features/ClaimsHandler.feature", tags = {})
public class RunAllFeatures {

}
