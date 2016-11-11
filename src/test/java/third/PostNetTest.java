package third;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PostNetTest {

    @Test
    public void shouldReturnBarcodeGiven5DigitsZipCode() {
        //Given
        String zipCode = "12345";
        PostNet postNet = new PostNet();


        //When
        String barcode = postNet.transformZipCodeToBarcode(zipCode);

        //Then
        assertThat(barcode, is("|:::||::|:|::||::|::|:|:|::|:|:|"));
    }

    @Test
    public void shouldReturnBarcodeGiven9DigitsZipCode() {
        //Given
        String zipCode = "103456789";
        PostNet postNet = new PostNet();


        //When
        String barcode = postNet.transformZipCodeToBarcode(zipCode);

        //Then
        assertThat(barcode, is("|:::||" +
                "||:::" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                ":||::" +
                "|:::|" +
                "|::|:" +
                "|:|::" +
                "|:::|" +
                "|"));
    }

    @Test
    public void shouldReturnBarcodeGiven10DigitsZipCode() {
        //Given
        String zipCode = "10345-6789";
        PostNet postNet = new PostNet();


        //When
        String barcode = postNet.transformZipCodeToBarcode(zipCode);

        //Then
        assertThat(barcode, is("|:::||" +
                "||:::" +
                "::||:" +
                ":|::|" +
                ":|:|:" +
                ":||::" +
                "|:::|" +
                "|::|:" +
                "|:|::" +
                "|:::|" +
                "|"));
    }

    @Test
    public void shouldReturnBarcodeGiven5DigitsZipCodeAndCheckCodeIs0() {
        //Given
        String zipCode = "00000";
        PostNet postNet = new PostNet();


        //When
        String barcode = postNet.transformZipCodeToBarcode(zipCode);

        //Then
        assertThat(barcode, is("|||:::" +
                "||:::" +
                "||:::" +
                "||:::" +
                "||:::" +
                "||:::" +
                "|"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnErrorGivenIllegalCharacter() {
        //Given
        String zipCode = "kjjjjdddd";
        PostNet postNet = new PostNet();


        //When
        String barcode = postNet.transformZipCodeToBarcode(zipCode);

        //Then
    }

}
