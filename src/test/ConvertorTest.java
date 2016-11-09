import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by xinzhang on 11/8/16.
 */
public class ConvertorTest {

    private Convertor convertor;

    @Before
    public void setUp() {
        convertor = new Convertor();
    }

    @Test
    public void shouldReturn5DigitPostcode() throws Exception {
        String postcode = convertor.barcode2postcode("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |");
        assertEquals("95713", postcode);
    }

    @Test
    public void shouldReturn5DigitBarcode() throws Exception {
        String barcode = convertor.postcode2barcode("95713");
        assertEquals("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |", barcode);
    }

    @Test
    public void shouldReturn10DigitPostcode() throws Exception {
        String barcode = convertor.barcode2postcode("| |:|:: :|:|: |:::| :::|| ::||: :::|| ::|:| ::||: :|::| :|:|: |");
        assertEquals("95713-1234", barcode);
    }

    @Test
    public void shouldConvert9DigitPostcode29DigitBarcode() throws Exception {
        String barcode = convertor.postcode2barcode("957131234");
        assertEquals("| |:|:: :|:|: |:::| :::|| ::||: :::|| ::|:| ::||: :|::| :|:|: |", barcode);
    }

    @Test
    public void shouldConvert10DigitPostcode29DigitBarcode() throws Exception {
        String barcode = convertor.postcode2barcode("95713-1234");
        assertEquals("| |:|:: :|:|: |:::| :::|| ::||: :::|| ::|:| ::||: :|::| :|:|: |", barcode);
    }

}