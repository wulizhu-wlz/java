package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/21
 * description:
 */
public enum  AccountTypeEnum {

    PLANTFORM((byte)0, "平台账号"),
    MERCHANT((byte)1, "商户账号");


    AccountTypeEnum(Byte code, String desc) {
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
    }}
