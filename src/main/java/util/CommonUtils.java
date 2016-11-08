package util;

public class CommonUtils {

    public static boolean verifyPostcodeString(String postcode) {
        int code = transformStringToInt(postcode);
        int sum = 5;
        while (code / 10 != 0) {
            sum += code % 10;
            code = code / 10;
        }
        sum += code;
        return sum % 10 == 0;
    }

    private static int transformStringToInt(String postcode) {
        int indexOfDash = postcode.indexOf("-");
        if (-1 != indexOfDash) {
            postcode = postcode.substring(0, indexOfDash) + postcode.substring(indexOfDash+1, postcode.length());
        }
        return Integer.parseInt(postcode);
    }

}
