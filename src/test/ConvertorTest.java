import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by xinzhang on 11/8/16.
 */
public class ConvertorTest {

    @Test
    public void shouldReturnCorrectPostcode() throws Exception {
        Convertor convertor = new Convertor();
        String postcode = convertor.barcode2postcode("| |:|:: :|:|: |:::| :::|| ::||: :|:|: |");
        assertEquals("95713", postcode);
    }

}