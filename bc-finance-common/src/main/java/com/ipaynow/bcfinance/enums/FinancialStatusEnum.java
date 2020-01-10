package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/21
 * description:
 */
public enum FinancialStatusEnum {

    INIT((byte) 0, "初始化"),
    FAILED((byte) 1, "失败"),
    SUCCESS((byte) 2, "成功");


    FinancialStatusEnum(byte code, String desc) {
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
    }

}
