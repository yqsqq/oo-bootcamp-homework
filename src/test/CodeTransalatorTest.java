package test;

import main.CodeToNumber;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by clin on 11/9/16.
 */
public class CodeTransalatorTest {
    @Test
    public void shouldGetCorrectFiveNumber() {
        String code = "||:::|:::||::|:|::||::|::|::||:|";
        CodeToNumber codeToNumber = new CodeToNumber(code);
        assertThat(codeToNumber.formatter(), is("71234"));
    }

    @Test
    public void shouldGetCorrectTenNumber() {
        String code = "||:::|:::||::|:|::||::|::|::|:|::||:::||:::|:|::||:|";
        CodeToNumber codeToNumber = new CodeToNumber(code);
        assertThat(codeToNumber.formatter(), is("71234-2332"));
    }
}
