import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhang on 11/8/16.
 */
public class FormatBarcode {

    public List<String> input(String barcode) throws Exception {
        String newBarcode = barcode.replace(" ", "");
        if (!IsLengthValid(newBarcode)) {
            throw new Exception("the length of bar code is invalid");
        }
        List<String> list = new ArrayList<>();
        for (int i=1; i<newBarcode.length()-1; i=i+5) {
            String barNum = newBarcode.substring(i, i+5);
            if (Rule.getPostNum(barNum) == -1) {
                throw new Exception("the content of bar code is invalid");
            }
            list.add(barNum);
        }
        return list;
    }

    public String output(List<String> barcodeList) {
        String barcode = "| ";
        for (String barNum: barcodeList) {
            barcode += barNum;
            barcode += " ";
        }
        return barcode + "|";
    }

    private boolean IsLengthValid(String barcode) {
        for (int len : ConstValue.CODE_LENS) {
            if (barcode.length() == (len+1) * 5 + 2) {
                return true;
            }
        }
        return false;
    }
}
