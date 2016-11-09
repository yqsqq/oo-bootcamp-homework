package com.yangyi.postcode.domain;

/**
 * @author yangyi
 * @date 11/8/16 9:52 PM
 */
public enum Postcode {

    CODE_1("1",":::||"),
    CODE_2("2","::|:|"),
    CODE_3("3","::||:"),
    CODE_4("4",":|::|"),
    CODE_5("5",":|:|:"),
    CODE_6("6",":||::"),
    CODE_7("7","|:::|"),
    CODE_8("8","|::|:"),
    CODE_9("9","|:|::"),
    CODE_0("0","||:::");

    private String number;

    private String barcode;

    Postcode(String number, String barcode) {
        this.number = number;
        this.barcode = barcode;
    }

    public String getNumber() {
        return number;
    }

    public String getBarcode() {
        return barcode;
    }

    public Postcode getPostcodeByNumber(String number) {
        Postcode[] enums = Postcode.values();
        for(int i=0;i<enums.length;i++) {
            if (enums[i].getNumber().equals(number)) {
                return enums[i];
            }
        }
        return null;
    }

    public Postcode getPostcodeByBarcode(String barcode) {
        Postcode[] enums = Postcode.values();
        for(int i=0;i<enums.length;i++) {
            if (enums[i].getBarcode().equals(number)) {
                return enums[i];
            }
        }
        return null;
    }
}
