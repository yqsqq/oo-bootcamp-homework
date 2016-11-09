package first.parser;

import static first.constant.ConstantVariables.BARCODETOPOSTCODEMAP;

public class BarcodeParser {

    public String parseBarcodeToPostcode(String barcode) {
        return BARCODETOPOSTCODEMAP.get(barcode);
    }
}
