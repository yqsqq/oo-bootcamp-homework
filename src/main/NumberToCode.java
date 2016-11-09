package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clin on 11/8/16.
 */
public class NumberToCode {

    private char[] value;
    private static Map<Character, String> translateMap = new HashMap<Character, String>();
    static {
        translateMap.put('1', ":::||");
        translateMap.put('2', "::|:|");
        translateMap.put('3', "::||:");
        translateMap.put('4', ":|::|");
        translateMap.put('5', ":|:|:");
        translateMap.put('6', ":||::");
        translateMap.put('7', "|:::|");
        translateMap.put('8', "|::|:");
        translateMap.put('9', "|:|::");
        translateMap.put('0', "||:::");
    }

    public NumberToCode(String code) {
        code = code.replaceAll("\\-", "");
        value = code.toCharArray();
    }

    public char calcParityCheckCode() {
        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += Character.getNumericValue(value[i]);
        }
        int intResult = 10 -sum%10;
        char result = (char) (intResult + '0');
        return result;
    }

    public String formatter() {
        String result = "|";
        for (int i = 0; i < value.length; i++) {
            result += translateMap.get(value[i]);
        }
        result += translateMap.get(calcParityCheckCode());
        result += "|";
        return result;
    }
}
