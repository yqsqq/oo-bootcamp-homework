import parser.PostcodeParser;
import util.CommonUtils;
import validator.PostcodeValidator;

public class PostcodeToBarcode {

    private final PostcodeParser postcodeParser;
    private final PostcodeValidator postcodeValidator;

    public PostcodeToBarcode(PostcodeParser postcodeParser, PostcodeValidator postcodeValidator) {
        this.postcodeParser = postcodeParser;
        this.postcodeValidator = postcodeValidator;
    }

    public String parsePostcodeToBarcode(String postcode) {
        if (validatePostcode(postcode)) {
            return "";
        }

        StringBuilder stringBuilder = parsePostcode(postcode);

        return formatBar(stringBuilder);
    }

    private StringBuilder parsePostcode(String postcode) {
        StringBuilder stringBuilder = new StringBuilder();
        postcode = CommonUtils.removeDashFromPostcode(postcode);
        for (int index = 0; index < postcode.length(); ++index) {
            stringBuilder.append(postcodeParser.parsePostcodeToBarcode(String.valueOf(postcode.charAt(index))));
        }
        return stringBuilder;
    }

    private boolean validatePostcode(String postcode) {
        boolean valid = false;
        if (!postcodeValidator.validateInput(postcode)) {
            valid = true;
        }
        if (!CommonUtils.verifyPostcodeString(postcode)) {
            valid = true;
        }
        return valid;
    }

    private String formatBar(StringBuilder bar) {
        bar.insert(0, "|");
        bar.append("|");
        return bar.toString();
    }
}
