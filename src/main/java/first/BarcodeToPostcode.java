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
        List<String> barcodes = CommonUtils.parseBarcodeToListString(barcode);

        if (!checkCodeCorrect(barcodes)) {
            return "";
        }

        StringBuilder stringBuilder = parseBarcode(barcodes);

        return format(stringBuilder);
    }

    private boolean checkCodeCorrect(List<String> barcodes) {
        int sum = 0;
        for (String barcode : barcodes) {
            sum += Integer.valueOf(barcodeParser.parseBarcodeToPostcode(barcode));
        }
        return sum % 10 == 0;
    }

    private StringBuilder parseBarcode(List<String> barcodes) {
        StringBuilder stringBuilder = new StringBuilder();
        barcodes.remove(barcodes.size()-1);
        for (String barcode : barcodes) {
            stringBuilder.append(barcodeParser.parseBarcodeToPostcode(barcode));
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
