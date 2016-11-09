package test;

import main.NumberToCode;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParityCheckCodeTest {

    @Test
    public void shouldGetCorrectCodeWithFiveDigits() {
        String code = "71234";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.calcParityCheckCode(), is('3'));
    }

    @Test
    public void shouldGetCorrectCodeWithNineDigits() {
        String code = "712342332";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.calcParityCheckCode(), is('3'));
    }

    @Test
    public void shouldGetCorrectCodeWithTenDigits() {
        String code = "712-342332";
        NumberToCode numberToCode = new NumberToCode(code);
        assertThat(numberToCode.calcParityCheckCode(), is('3'));
    }
}