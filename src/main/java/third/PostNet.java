package third;

import java.util.HashMap;

public class PostNet {

    public static final HashMap<Integer, String> POST_CODE_TO_BAR_CODE_MAP;

    static {
        POST_CODE_TO_BAR_CODE_MAP = new HashMap<>();
        POST_CODE_TO_BAR_CODE_MAP.put(1, ":::||");
        POST_CODE_TO_BAR_CODE_MAP.put(2, "::|:|");
        POST_CODE_TO_BAR_CODE_MAP.put(3, "::||:");
        POST_CODE_TO_BAR_CODE_MAP.put(4, ":|::|");
        POST_CODE_TO_BAR_CODE_MAP.put(5, ":|:|:");
        POST_CODE_TO_BAR_CODE_MAP.put(6, ":||::");
        POST_CODE_TO_BAR_CODE_MAP.put(7, "|:::|");
        POST_CODE_TO_BAR_CODE_MAP.put(8, "|::|:");
        POST_CODE_TO_BAR_CODE_MAP.put(9, "|:|::");
        POST_CODE_TO_BAR_CODE_MAP.put(0, "||:::");
    }

    public String transformZipCodeToBarcode(String zipCode) {
        zipCode = formatInput(zipCode);
        String rawBarCode = transform(zipCode + getCheckCode(zipCode));
        return formatRawBarcode(rawBarCode);
    }

    private String formatInput(String zipCode) {
        return zipCode.replace("-", "");
    }

    private String formatRawBarcode(String rawBarCode) {
        return "|" + rawBarCode + "|";
    }

    private String getCheckCode(String zipCode) {
        int sum = 0;
        for (int i = 0; i < zipCode.length(); i++) {
            sum += Integer.parseInt(String.valueOf(zipCode.charAt(i)));
        }
        int cd = (10 - sum % 10) % 10;
        return String.valueOf(cd);
    }

    private String transform(String zipCode) {
        char[] codes = zipCode.toCharArray();
        String result = "";
        for (int i = 0; i < codes.length; i++) {
            result += convert(Character.getNumericValue(codes[i]));
        }
        return result;
    }

    private String convert(int postCode) {

        return POST_CODE_TO_BAR_CODE_MAP.get(postCode);
    }
}
