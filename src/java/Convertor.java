import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhang on 11/8/16.
 */
public class Convertor {

    private FormatBarcode formatBarcode;
    private FormatPostcode formatPostcode;

    public Convertor() {
        formatBarcode = new FormatBarcode();
        formatPostcode = new FormatPostcode();
    }

    public String postcode2barcode(String postcode) throws Exception {
        String newPostcode = formatPostcode.input(postcode);
        List<String> barcodeList = new ArrayList<>();
        for (int i = 0; i < newPostcode.length(); i++) {
            barcodeList.add(Rule.getBarNum(newPostcode.charAt(i) - '0'));
        }
        return formatBarcode.output(barcodeList);
    }

    public String barcode2postcode(String barcode) throws Exception {
        List<String> barcodeList = formatBarcode.input(barcode);
        String postcode = "";
        for (String barNum : barcodeList) {
            postcode += Rule.getPostNum(barNum);
        }
        return formatPostcode.output(postcode);
    }

    //temp test, will add unit test tomorrow
    public static void main(String[] args) throws Exception {
        Convertor convertor = new Convertor();
        System.out.println(convertor.barcode2postcode("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |"));
        System.out.println(convertor.postcode2barcode("95713"));
    }

}
