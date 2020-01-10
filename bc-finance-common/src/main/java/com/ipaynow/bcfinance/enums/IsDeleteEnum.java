package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/26
 * description:
 */
public enum IsDeleteEnum {

    YES((byte) 0, "已删除"),
    NO((byte) 1, "未删除");

    private byte code;

    private String desc;

    IsDeleteEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

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
    }
}
