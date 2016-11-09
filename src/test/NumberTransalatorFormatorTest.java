package test;


import main.NumberToCode;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by clin on 11/9/16.
 */
public class NumberTransalatorFormatorTest {
    @Test
    public void shouldGetCorrectBarCodeWhenFiveNumber() {
        String code = "71234";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.formatter(), is("||:::|:::||::|:|::||::|::|::||:|"));
    }

    @Test
    public void shouldGetCorrectBarCodeWhenNineNumber() {
        String code = "712342332";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.formatter(), is("||:::|:::||::|:|::||::|::|::|:|::||:::||:::|:|::||:|"));
    }

    @Test
    public void shouldGetCorrectBarCodeWhenTenNumber() {
        String code = "71234-2332";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.formatter(), is("||:::|:::||::|:|::||::|::|::|:|::||:::||:::|:|::||:|"));
    }
}
