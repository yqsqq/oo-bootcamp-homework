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
}
