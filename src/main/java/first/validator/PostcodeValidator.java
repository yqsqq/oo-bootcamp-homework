package first.validator;

import java.util.regex.Pattern;

import static first.constant.ConstantVariables.REGEX_POSTCODE;

public class PostcodeValidator extends Validator{

    protected boolean isInputLegal(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }

}
