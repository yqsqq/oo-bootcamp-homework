import parser.PostcodeParser;
import util.CommonUtils;
import validator.PostcodeValidator;

public class PostcodeToBar {

    private final PostcodeParser postcodeParser;
    private final PostcodeValidator postcodeValidator;

    public PostcodeToBar(PostcodeParser postcodeParser, PostcodeValidator postcodeValidator) {
        this.postcodeParser = postcodeParser;
        this.postcodeValidator = postcodeValidator;
    }


    public String parsePostcodeToBar(String postcode) {
        if (!postcodeValidator.validatePostcode(postcode)) {
            return "";
        }
        if (!CommonUtils.verifyPostcodeString(postcode)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        postcode = CommonUtils.removeDashFromPostcode(postcode);
        for (int index = 0; index < postcode.length(); ++index) {
            stringBuilder.append(postcodeParser.parsePostcode(String.valueOf(postcode.charAt(index))));
        }
        return formatBar(stringBuilder);
    }

    private String formatBar(StringBuilder bar) {
        bar.insert(0, "|");
        bar.append("|");
        return bar.toString();
    }
}
