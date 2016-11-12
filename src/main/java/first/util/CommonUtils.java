package first.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {


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

    public static String addCheckCode(String postcode) {
        postcode = postcode.replace("-", "");
        int number = Integer.parseInt(postcode);
        int sum = 0;
        while (number / 10 != 0) {
            sum += number % 10;
            number = number / 10;
        }
        sum += number;
        int checkCode = (10 - sum % 10) % 10;
        return postcode + String.valueOf(checkCode);
    }
}
