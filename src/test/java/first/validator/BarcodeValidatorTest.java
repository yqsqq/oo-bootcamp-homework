package first.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BarcodeValidatorTest {

    private BarcodeValidator barcodeValidatorTest;

    @Before
    public void setUp() throws Exception {
        barcodeValidatorTest = new BarcodeValidator();
    }

    @Test
    public void shouldReturnFalseIfBarcodeIsEmpty() {
        //Given
        String barcode = "";

        //Then
        assertFalse(barcodeValidatorTest.validateInput(barcode));
    }

    @Test
    public void shouldReturnTrueIfBarcodeIsNotEmpty() {
        //Given
        String barcode = "|:::||::|:|::||::|::|:|:|:|";

        //Then
        assertTrue(barcodeValidatorTest.validateInput(barcode));
    }

    @Test
    public void shouldReturnTrueIfBarcodeIsLegal() {
        //Given
        String barcode = "|:::||::|:|::||::|::|:|:|:::|:|::||:::|:|::||:|";

        //Then
        assertTrue(barcodeValidatorTest.validateInput(barcode));
    }

    @Test
    public void shouldReturnFalseIfBarcodeIsIllegal() {
        //Given
        String barcode = "|:::||::|:|::||::|:||:|:|:::|:|::||:::|:|:|||:|";

        //Then
        assertFalse(barcodeValidatorTest.validateInput(barcode));
    }
}
