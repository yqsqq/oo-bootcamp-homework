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
        assertThat(barcode, is("|:::||::|:|::||::|::|:|:|:|"));


    }
}
