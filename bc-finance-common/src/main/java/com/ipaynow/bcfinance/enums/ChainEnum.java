package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/27
 * description:
 */
public enum  ChainEnum {

    IPAYNOW((byte)1, "现在支付链"),
    CMB((byte)2, "招行链"),;


    ChainEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Byte code;

    private String desc;

    public Byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
