package validator;

import java.util.regex.Pattern;

import static constant.ConstantVariables.REGEX_POSTCODE;

public class PostcodeValidator extends Validator{


    protected boolean isLegalPostcode(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

}
