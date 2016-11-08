import java.util.regex.Pattern;

public class PostcodeValidator {

    public static final String REGEX_POSTCODE = "^[0-9]{5}$|^[0-9]{9}$|^[0-9]{5}-[0-9]{4}$";


    public boolean isEmptyString(String postcode) {
        return postcode.isEmpty();
    }

    public boolean isLegalString(String postcode) {
        return Pattern.matches(REGEX_POSTCODE, postcode);
    }
}
