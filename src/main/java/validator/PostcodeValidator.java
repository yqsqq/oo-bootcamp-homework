package validator;

import java.util.regex.Pattern;

import static constant.ConstantVariables.REGEX_POSTCODE;

public class PostcodeValidator {

    public boolean isEmptyPostcode(String postcode) {
        return postcode.isEmpty();
    }

    public boolean isLegalPostcode(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

}
