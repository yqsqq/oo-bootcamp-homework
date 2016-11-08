package constant;

import java.util.HashMap;
import java.util.Map;

public class ConstantVariables {

    public static final Map<String, String> POSTCODETOBARCODEMAP = new HashMap<String, String>(){
        {
            put("1", ":::||");
            put("2", "::|:|");
            put("3", "::||:");
            put("4", ":|::|");
            put("5", ":|:|:");
            put("6", ":||::");
            put("7", "|:::|");
            put("8", "|::|:");
            put("9", "|:|::");
            put("0", "||:::");
        }
    };

    public static final String REGEX_POSTCODE = "^[0-9]{5}$|^[0-9]{9}$|^[0-9]{5}-[0-9]{4}$";


}
