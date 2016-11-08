package parser;

import static constant.ConstantVariables.POSTCODETOBARMAP;

public class PostcodeParser {



    public String parsePostcode(String postcode) {
        return POSTCODETOBARMAP.get(postcode);
    }
}
