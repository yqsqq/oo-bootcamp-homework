package third;

import java.util.HashMap;

public class PostNet {
    public String transformZipCodeToBarcode(String zipCode) {
        return "|" +
                transform(zipCode) +
                "|";
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
        HashMap<Integer, String> postCodeToBarCodeMap = new HashMap<>();
        postCodeToBarCodeMap.put(1, ":::||");
        postCodeToBarCodeMap.put(2, "::|:|");
        postCodeToBarCodeMap.put(3, "::||:");
        postCodeToBarCodeMap.put(4, ":|::|");
        postCodeToBarCodeMap.put(5, ":|:|:");

        return postCodeToBarCodeMap.get(postCode);
    }
}
