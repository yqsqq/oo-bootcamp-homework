package parser;

import static constant.ConstantVariables.POSTCODETOBARCODEMAP;

public class PostcodeParser {

    public String parsePostcodeToBarcode(String postcode) {
        return POSTCODETOBARCODEMAP.get(postcode);
    }
}
