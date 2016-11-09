package helper;

/**
 * Created by xinzhang on 11/8/16.
 */
public class Rule {

    private final static String DICTIONARY[] = {
        "||:::",
        ":::||",
        "::|:|",
        "::||:",
        ":|::|",
        ":|:|:",
        ":||::",
        "|:::|",
        "|::|:",
        "|:|::"
    };


    public static int getPostNum(String barNum) {
        for (int i = 0; i < DICTIONARY.length; i++) {
            if (DICTIONARY[i].equals(barNum)) {
                return i;
            }
        }
        return -1;
    }

    public static String getBarStr(int postNum) {
        return DICTIONARY[postNum];
    }

}
