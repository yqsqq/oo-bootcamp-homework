package com.yangyi.postcode.format;

import com.yangyi.postcode.domain.PostcodeList;

/**
 * @author yangyi
 * @date 11/8/16 10:21 PM
 */
public interface OutputFormater {
    public String format(PostcodeList postcodeList);
}
