package first;

import first.parser.PostcodeParser;
import first.util.CommonUtils;
import first.validator.Validator;

public class PostcodeToBarcode {

    private final PostcodeParser postcodeParser;
    private final Validator postcodeValidator;

    public PostcodeToBarcode(PostcodeParser postcodeParser, Validator postcodeValidator) {
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
        postcode = CommonUtils.addCheckCode(postcode);
        for (int index = 0; index < postcode.length(); ++index) {
            stringBuilder.append(postcodeParser.parsePostcodeToBarcode(String.valueOf(postcode.charAt(index))));
        }
        return stringBuilder;
    }

    private boolean validatePostcode(String postcode) {
        return !postcodeValidator.validateInput(postcode);
    }

    private String formatBar(StringBuilder bar) {
        bar.insert(0, "|");
        bar.append("|");
        return bar.toString();
    }
}
