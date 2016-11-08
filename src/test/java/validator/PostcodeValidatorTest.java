package validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostcodeValidatorTest {

    private Validator postcodeValidator;

    @Before
    public void setUp() throws Exception {
        postcodeValidator = new PostcodeValidator();
    }

    @Test
    public void shouldReturnFalseIfPostcodeIsEmpty() {
        //Given
        String postcode = "";

        //Then
        assertFalse(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeIsNotEmpty() {
        //Given
        String postcode = "12345";

        //Then
        assertTrue(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsFive() {
        //Given
        String postcode = "12345";

        //Then
        assertTrue(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsNine() {
        //Given
        String postcode = "123456789";

        //Then
        assertTrue(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnTrueIfPostcodeLengthIsTenWithDash() {
        //Given
        String postcode = "12345-6789";

        //Then
        assertTrue(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeLengthIsTenWithoutDash() {
        //Given
        String postcode = "1234567890";

        //Then
        assertFalse(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeLengthIsNotFiveOrNineOrTen() {
        //Given
        String postcode = "123456";

        //Then
        assertFalse(postcodeValidator.validateInput(postcode));
    }

    @Test
    public void shouldReturnFalseIfPostcodeIsIllegalString() {
        //Given
        String postcode = "123123-123";

        //Then
        assertFalse(postcodeValidator.validateInput(postcode));
    }
}
