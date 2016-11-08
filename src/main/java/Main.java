import parser.BarcodeParser;
import parser.PostcodeParser;
import validator.BarcodeValidator;
import validator.PostcodeValidator;

public class Main {

    public static void main(String args[]) {
        PostcodeToBarcode postcodeToBarcode = new PostcodeToBarcode(new PostcodeParser(), new PostcodeValidator());
        BarcodeToPostcode barcodeToPostcode = new BarcodeToPostcode(new BarcodeParser(), new BarcodeValidator());

        System.out.println("Postcode [12345] to Barcode...");
        String barcode = postcodeToBarcode.parsePostcodeToBarcode("12345");
        System.out.println(barcode);
        System.out.println("##############################################");
        System.out.println("Barcode to Postcode...");
        System.out.println(barcodeToPostcode.parseBarcodeToPostcode(barcode));
        System.out.println("");
        System.out.println("Postcode [12345-2323] to Barcode...");
        barcode = postcodeToBarcode.parsePostcodeToBarcode("12345-2323");
        System.out.println(barcode);
        System.out.println("##############################################");
        System.out.println("Barcode to Postcode...");
        System.out.println(barcodeToPostcode.parseBarcodeToPostcode(barcode));
    }

}
