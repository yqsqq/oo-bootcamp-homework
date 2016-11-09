package com.yangyi.postcode.parse.validate;

import com.yangyi.postcode.domain.PostcodeType;

/**
 * @author yangyi
 * @date 11/9/16 8:49 AM
 */
public interface Validator {

    public boolean validate(String postcodeStr, PostcodeType postcodeType);
}
