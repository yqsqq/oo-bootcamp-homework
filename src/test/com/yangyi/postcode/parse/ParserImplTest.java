package com.yangyi.postcode.parse;

import com.yangyi.postcode.domain.PostcodeList;
import com.yangyi.postcode.domain.PostcodeType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yangyi
 * @date 11/8/16 9:51 PM
 */
public class ParserImplTest {

    private Parser parser = new ParserImpl();

    @Test
    public void shouldReturn5Barcode() throws Exception {
        //given
        String postcode = "95173";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Barcode);
        assertEquals(postcodeList.getPostcodeList().size(), 5);
    }

    @Test
    public void shouldReturn9Barcode() throws Exception {
        //given
        String postcode = "95173-1234";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Barcode);
        assertEquals(postcodeList.getPostcodeList().size(), 9);
    }

    @Test
    public void shouldReturn10Barcode() throws Exception {
        //given
        String postcode = "9517301234";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Barcode);
        assertEquals(postcodeList.getPostcodeList().size(), 10);
    }

    @Test
    public void shouldReturn5NumberPostcode() throws Exception {
        //given
        String postcode = "|:::||:::||:::||:::||:::|||";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Number);
        assertEquals(postcodeList.getPostcodeList().size(), 5);
    }

    @Test
    public void shouldReturn9NumberPostcode() throws Exception {
        //given
        String postcode = "|:::||:::||:::||:::||:::||:::||:::||:::||:::|||";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Number);
        assertEquals(postcodeList.getPostcodeList().size(), 9);
    }

    @Test
    public void shouldReturn10NumberPostcode() throws Exception {
        //given
        String postcode = "|:::||:::||:::||:::||:::||:::||:::||:::||:::||:::|||";
        //when
        PostcodeList postcodeList = parser.parse(postcode);
        //then
        assertEquals(postcodeList.getPostcodeType(), PostcodeType.Number);
        assertEquals(postcodeList.getPostcodeList().size(), 10);
    }
}