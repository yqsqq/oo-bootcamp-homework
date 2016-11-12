package third;

import java.util.HashMap;

public class PostNet {


    public static final HashMap<Character, String> ZIPCODE_TO_BARCODE_MAP = new HashMap<Character, String>() {
        {
            put('1', ":::||");
            put('2', "::|:|");
            put('3', "::||:");
            put('4', ":|::|");
            put('5', ":|:|:");
            put('6', ":||::");
            put('7', "|:::|");
            put('8', "|::|:");
            put('9', "|:|::");
            put('0', "||:::");
        }
    };

    public String transformZipCodeToBarcode(String zipCode) {
        zipCode = zipCode.replace("-", "");
        char zipcodeWithCheckCode = addCheckCodeToRawzipcode(zipCode);
        String rawZipcode = parseZipcodeToBarcode(zipCode, zipcodeWithCheckCode);
        return formatRawBarcode(rawZipcode);
    }

    private char addCheckCodeToRawzipcode(String zipCode) {
        int sum = 0;
        for (Character zipcodeChar: zipCode.toCharArray()) {
            sum += Character.getNumericValue(zipcodeChar);
        }
        int checkCode = (10 - sum % 10) % 10;
        return Character.valueOf(String.valueOf(checkCode).charAt(0));
    }

    private String parseZipcodeToBarcode(String zipcode, char zipcodeWithCheckCode) {
        StringBuilder barcode = new StringBuilder();
        for (Character zipcodeChar: zipcode.toCharArray()) {
            barcode.append(ZIPCODE_TO_BARCODE_MAP.get(zipcodeChar));
        }
        barcode.append(ZIPCODE_TO_BARCODE_MAP.get(zipcodeWithCheckCode));
        return barcode.toString();
    }

    private String formatRawBarcode(String zipcode) {
        return "|" + zipcode + "|";
    }
}
