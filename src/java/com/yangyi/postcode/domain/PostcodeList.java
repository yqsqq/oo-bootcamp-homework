package com.yangyi.postcode.domain;

import java.util.List;

/**
 * @author yangyi
 * @date 11/8/16 9:40 PM
 */
public class PostcodeList {

    private List<Postcode> postcodeList;

    private PostcodeType postcodeType;

    PostcodeList(List<Postcode> postcodeList, PostcodeType postcodeType) {
        this.postcodeList = postcodeList;
        this.postcodeType = postcodeType;
    }

    public List<Postcode> getPostcodeList() {
        return postcodeList;
    }

    public PostcodeType getPostcodeType() {
        return postcodeType;
    }

}
