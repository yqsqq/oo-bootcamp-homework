package parser;

import org.junit.Before;
import org.junit.Test;
import parser.PostcodeParser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PostcodeParserTest {

    private PostcodeParser postcodeParser;

    @Before
    public void setUp() throws Exception {
        postcodeParser = new PostcodeParser();
    }

    @Test
    public void shouldReturnValidBarOfOne() {
        //Given
        String postcode = "1";

        //When
        String barString = postcodeParser.parsePostcode(postcode);

        //Then
        assertThat(barString, is(":::||"));
    }

    @Test
    public void shouldReturnValidBarOfTwo() {
        //Given
        String postcode = "2";

        //When
        String barString = postcodeParser.parsePostcode(postcode);

        //Then
        assertThat(barString, is("::|:|"));
    }
}
