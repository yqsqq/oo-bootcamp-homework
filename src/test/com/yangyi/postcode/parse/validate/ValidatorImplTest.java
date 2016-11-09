package com.yangyi.postcode.parse.validate;

import com.yangyi.postcode.domain.PostcodeType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author yangyi
 * @date 11/9/16 8:52 AM
 */
public class ValidatorImplTest {

    Validator validator = new ValidatorImpl();

    @Test
    public void shouldReturnTrueIf5Number() throws Exception {
        //given
        String postcode = "12345";
        //when
        boolean b = validator.validate(postcode, PostcodeType.Number);
        //then
        assertTrue(b);
    }
}