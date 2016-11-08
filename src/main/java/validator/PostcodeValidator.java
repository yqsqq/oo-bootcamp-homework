package validator;

import java.util.regex.Pattern;

import static constant.ConstantVariables.REGEX_POSTCODE;

public class PostcodeValidator extends Validator{

    protected boolean isInputLegal(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

}
