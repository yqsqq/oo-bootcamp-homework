import java.util.regex.Pattern;

public class PostcodeToBar {

    private static final int VALID_STRING_LENGTH_FIVE = 5;
    public static final int VALID_STRING_LENGTH_NINE = 9;

    public boolean isEmptyString(String postcode) {
        return postcode.isEmpty();
    }

    public boolean isCorrectLength(String postcode) {
        boolean validPostcode = false;
        if (VALID_STRING_LENGTH_FIVE == postcode.length()) {
            validPostcode = true;
        } else if (VALID_STRING_LENGTH_NINE == postcode.length()) {
            validPostcode = true;
        } else if (10 == postcode.length()) {
            validPostcode = validPostcodeWithLengthTen(postcode);
        }
        return validPostcode;
    }

    private boolean validPostcodeWithLengthTen(String postcode) {
        return Pattern.matches("^[0-9]{5}-[0-9]{4}$", postcode);
    }
}
