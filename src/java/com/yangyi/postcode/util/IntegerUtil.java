package com.yangyi.postcode.util;

/**
 * @author yangyi
 * @date 11/8/16 10:43 PM
 */
public class IntegerUtil {

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
