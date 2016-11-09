package com.yangyi.postcode.domain;

/**
 * @author yangyi
 * @date 11/8/16 9:42 PM
 */
public enum PostcodeType {

    Number("Number"),
    Barcode("Barcode");

    private String type;

    PostcodeType(String type) {
        this.type = type;
    }
}
