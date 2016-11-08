import java.util.HashMap;
import java.util.Map;

public class PostcodeParser {

    private static final Map<String, String> postcodeToBarMap = new HashMap<String, String>(){
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

    public String parsePostcode(String postcode) {
        return postcodeToBarMap.get(postcode);
    }
}
