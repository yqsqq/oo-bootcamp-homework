package parse;

import helper.ConstValue;

import java.util.regex.Pattern;

/**
 * Created by xinzhang on 11/8/16.
 */

public class FormatPostcode {

    public String input(String postcode) throws Exception{
        String newPostcode = postcode.replace("-", "");
        if (!IsLengthValid(newPostcode)) {
            throw new Exception("the length of post code is invalid");
        }
        if (!IsContentValid(newPostcode)) {
            throw new Exception("the content of post code is invalid");
        }
        return newPostcode + calcCheckCode(newPostcode);
    }

    public String output(String postcode) {
        if (postcode.length() == 9) {
            return postcode.substring(0, 5) + "-" + postcode.substring(5);
        }
        return postcode;
    }

    private boolean IsLengthValid(String postcode) {
        for (int len : ConstValue.CODE_LENS) {
            if (postcode.length() == len) {
                return true;
            }
        }
        return false;
    }

    private boolean IsContentValid(String postcode) {
        return Pattern.matches("[0-9]*", postcode);
    }

    private int calcCheckCode (String postcode) {
        int sum = 0;
        for (int i = 0; i < postcode.length(); i++) {
            sum += postcode.charAt(i) - '0';
        }
        return sum%10 == 0 ? 0 : 10-sum%10;
    }
}
