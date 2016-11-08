package validator;

import java.util.regex.Pattern;

import static constant.ConstantVariables.REGEX_POSTCODE;

public class PostcodeValidator {

    public boolean validatePostcode(String postcode) {
        return !isEmptyPostcode(postcode) && isLegalPostcode(postcode);
    }

    private boolean isEmptyPostcode(String postcode) {
        return postcode.isEmpty();
    }

    private boolean isLegalPostcode(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

}
