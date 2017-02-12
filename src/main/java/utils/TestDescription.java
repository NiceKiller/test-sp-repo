package utils;

import org.junit.runner.Description;

/**
 * Created by Bartlomiej_Zawadzki on 9/30/2016.
 */
public class TestDescription {

    private TestDescription() {

    }

    public static String getSimpleMethodName(Description description) {
        return getSimpleMethodName(description.getMethodName());
    }

    public static String getSimpleMethodName(String fullMethodName) {
        String[] tokens = fullMethodName.split("\\[");
        return tokens[0];
    }

}
