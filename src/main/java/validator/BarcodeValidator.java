package validator;


import util.CommonUtils;

import java.util.List;

import static constant.ConstantVariables.BARCODETOPOSTCODEMAP;

public class BarcodeValidator extends Validator {

    @Override
    protected boolean isInputLegal(String barcode) {
        boolean valid = false;

        if (checkInputBeginAndEnd(barcode) && checkInputLength(barcode) && checkValidBarcodes(barcode)) {
            valid = true;
        }

        return valid;
    }

    private boolean checkInputBeginAndEnd(String barcode) {
        return barcode.indexOf("|") == 0 && barcode.lastIndexOf("|") == barcode.length() - 1;
    }

    private boolean checkInputLength(String barcode) {
        return barcode.length() == 27 || barcode.length() == 47;
    }

    private boolean checkValidBarcodes(String barcode) {
        List<String> barcodes = CommonUtils.parseBarcodeToListString(barcode);
        for (String barcodeTemp : barcodes) {
            if (BARCODETOPOSTCODEMAP.get(barcodeTemp) == null) {
                return false;
            }
        }
        return true;
    }
}
