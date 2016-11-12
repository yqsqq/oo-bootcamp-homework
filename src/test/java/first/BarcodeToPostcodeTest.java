package first;

import org.junit.Before;
import org.junit.Test;
import first.parser.BarcodeParser;
import first.validator.BarcodeValidator;
import first.validator.Validator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BarcodeToPostcodeTest {
    private BarcodeToPostcode barcodeToPostcode;
    private BarcodeParser barcodeParser;
    private Validator barcodeValidator;


    @Before
    public void setUp() throws Exception {
        barcodeParser = new BarcodeParser();
        barcodeValidator = new BarcodeValidator();
        barcodeToPostcode = new BarcodeToPostcode(barcodeParser, barcodeValidator);
    }

    @Test
    public void shouldReturnValidBarWithSixLength() {
        //Given
        String barcode = "|" +
                ":::||" +
                "::|:|" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                ":|:|:" +
                "|";

        //Then
        assertThat(barcodeToPostcode.parseBarcodeToPostcode(barcode), is("12345"));
    }

    @Test
    public void shouldReturnValidBarWithTenLength() {
        //Given
        String barcode = "|" +
                ":::||" +
                "::|:|" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                "::|:|" +
                "::||:" +
                "::|:|" +
                "::||:" +
                ":|:|:" +
                "|";

        //Then
        assertThat(barcodeToPostcode.parseBarcodeToPostcode(barcode), is("12345-2323"));
    }

    @Test
    public void shouldReturnEmptyStringBarWithTenLengthWrongVerify() {
        //Given
        String barcode = "|" +
                ":::||" +
                "::|:|" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                "::|:|" +
                "::||:" +
                "::||:" +
                "::||:" +
                "::||:" +
                "|";

        //Then
        assertThat(barcodeToPostcode.parseBarcodeToPostcode(barcode), is(""));
    }

    @Test
    public void shouldReturnEmptyStringBarWithWrongLength() {
        //Given
        String barcode = "|" +
                ":::||" +
                "::|:|" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                "::|:|" +
                "::||:" +
                "::||:" +
                "::||:" +
                "::||:" +
                "::||:" +
                "|";

        //Then
        assertThat(barcodeToPostcode.parseBarcodeToPostcode(barcode), is(""));
    }
}
