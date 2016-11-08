package parser;

import static constant.ConstantVariables.BARCODETOPOSTCODEMAP;

public class BarcodeParser {

    public String parseBarcodeToPostcode(String barcode) {
        return BARCODETOPOSTCODEMAP.get(barcode);
    }
}
