import org.junit.Before;
import org.junit.Test;
import parser.PostcodeParser;
import validator.PostcodeValidator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PostcodeToBarTest {

    private PostcodeToBar postcodeToBar;
    private PostcodeParser postcodeParser;
    private PostcodeValidator postcodeValidator;


    @Before
    public void setUp() throws Exception {
        postcodeParser = new PostcodeParser();
        postcodeValidator = new PostcodeValidator();
        postcodeToBar = new PostcodeToBar(postcodeParser, postcodeValidator);
    }

    @Test
    public void shouldReturnValidBarWithFiveLength() {
        //Given
        String postcode = "12345";

        //Then
        assertThat(postcodeToBar.parsePostcodeToBar(postcode), is("|:::||::|:|::||::|::|:|:|:|"));
    }

    @Test
    public void shouldReturnValidBarWithTenLength() {
        //Given
        String postcode = "12345-2323";

        //Then
        assertThat(postcodeToBar.parsePostcodeToBar(postcode), is("|:::||::|:|::||::|::|:|:|:::|:|::||:::|:|::||:|"));
    }

    @Test
    public void shouldReturnEmptyStringIllegalPostcode() {
        //Given
        String postcode = "12345-2123";

        //Then
        assertThat(postcodeToBar.parsePostcodeToBar(postcode), is(""));
    }
}
