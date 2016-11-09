package com.yangyi.postcode.parse;

import com.yangyi.postcode.domain.PostcodeList;
import com.yangyi.postcode.domain.PostcodeType;
import com.yangyi.postcode.parse.validate.Validator;
import com.yangyi.postcode.parse.validate.ValidatorImpl;

/**
 * @author yangyi
 * @date 11/8/16 9:38 PM
 */
public class ParserImpl implements Parser {

    private Validator validator = new ValidatorImpl();

    public PostcodeList parse(String postcodeStr) {
        PostcodeType postcodeType = getPostcodeType(postcodeStr);

        boolean isValidated = validator.validate(postcodeStr, postcodeType);

        return null;
    }

    private PostcodeType getPostcodeType(String postcodeStr) {
        return PostcodeType.Number;
    }
}
