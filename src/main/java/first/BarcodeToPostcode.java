package first;

import first.parser.BarcodeParser;
import first.util.CommonUtils;
import first.validator.Validator;

import java.util.List;

public class BarcodeToPostcode {
    private final BarcodeParser barcodeParser;
    private final Validator barcodeValidator;

    public BarcodeToPostcode(BarcodeParser barcodeParser, Validator barcodeValidator) {
        this.barcodeParser = barcodeParser;
        this.barcodeValidator = barcodeValidator;
    }

    public String parseBarcodeToPostcode(String barcode) {
        if (!barcodeValidator.validateInput(barcode)) {
            return "";
        }

        StringBuilder stringBuilder = parseBarcode(barcode);

        return format(stringBuilder);
    }

    private StringBuilder parseBarcode(String barcode) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> barcodes = CommonUtils.parseBarcodeToListString(barcode);
        for (String barcodeTemp : barcodes) {
            stringBuilder.append(barcodeParser.parseBarcodeToPostcode(barcodeTemp));
        }
        return stringBuilder;
    }

    private String format(StringBuilder postcode) {
        String post = postcode.toString();
        if (post.length() == 9) {
            post = post.substring(0, 5) + "-" + post.substring(5, 9);
        }
        return post;
    }
}
