package first.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommonUtilsTest {

    @Test
    public void shouldReturnTrueIfVerifyLegalPostcode() {
        //Given
        String postcode = "12345";

        //Then
        assertTrue(CommonUtils.verifyPostcodeString(postcode));
    }

    @Test
    public void shouldReturnFalseIfVerifyIllegalPostcode() {
        //Given
        String postcode = "12343";

        //Then
        assertFalse(CommonUtils.verifyPostcodeString(postcode));
    }
}
