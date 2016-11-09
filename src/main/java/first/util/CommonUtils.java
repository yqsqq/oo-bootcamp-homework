package first.util;

import java.util.ArrayList;
import java.util.List;

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

    public static String removeDashFromPostcode(String postcode) {
        int indexOfDash = postcode.indexOf("-");
        if (-1 != indexOfDash) {
            postcode = postcode.substring(0, indexOfDash) + postcode.substring(indexOfDash+1, postcode.length());
        }
        return postcode;
    }

    public static List<String> parseBarcodeToListString(String barcode) {
        List<String> barcodes = new ArrayList<>();
        barcode = barcode.substring(1);
        barcode = barcode.substring(0, barcode.length()-1);
        while (barcode.length() != 5) {
            barcodes.add(barcode.substring(0, 5));
            barcode = barcode.substring(5);
        }
        barcodes.add(barcode);
        return barcodes;
    }

    private static int transformStringToInt(String postcode) {
        int indexOfDash = postcode.indexOf("-");
        if (-1 != indexOfDash) {
            postcode = postcode.substring(0, indexOfDash) + postcode.substring(indexOfDash+1, postcode.length());
        }
        return Integer.parseInt(postcode);
    }
}
