package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
public enum StatusEnum {

    UN_NORMAL((byte) 0, "未生效"),
    NORMAL((byte)1, "已生效");

    StatusEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private byte code;

    private String desc;



    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
