import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostcodeToBarTest {

    private PostcodeToBar postcodeToBar;

    @Before
    public void setUp() throws Exception {
        postcodeToBar = new PostcodeToBar();
    }

    @Test
    public void shouldReturnTrueIfPostcodeIsEmpty() {
        //Given
        String postcode = "";

        //Then
        assertTrue(postcodeToBar.isEmptyString(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeIsNotEmpty() {
        //Given
        String postcode = "postcode";

        //Then
        assertFalse(postcodeToBar.isEmptyString(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsFive() {
        //Given
        String postcode = "12345";

        //Then
        assertTrue(postcodeToBar.isCorrectLength(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsNine() {
        //Given
        String postcode = "123456789";

        //Then
        assertTrue(postcodeToBar.isCorrectLength(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsTenWithDash() {
        //Given
        String postcode = "12345-6789";

        //Then
        assertTrue(postcodeToBar.isCorrectLength(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeLengthIsTenWithoutDash() {
        //Given
        String postcode = "1234567890";

        //Then
        assertFalse(postcodeToBar.isCorrectLength(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeLengthIsNotFiveOrNineOrTen() {
        //Given
        String postcode = "123456";

        //Then
        assertFalse(postcodeToBar.isCorrectLength(postcode));
    }
}
