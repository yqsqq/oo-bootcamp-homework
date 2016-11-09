package com.yangyi.postcode.parse;

import com.yangyi.postcode.domain.PostcodeList;

/**
 * @author yangyi
 * @date 11/8/16 9:38 PM
 */
public interface Parser {

    public PostcodeList parse(String postcodeStr);
}
