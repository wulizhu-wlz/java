package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/21
 * description:
 */
public enum CreditStatusEnum {
    INIT((byte)0,"初始化"),
    APPLY((byte)1, "融资申请"),
    ACCEPT((byte)2,"融资受理"),
    LOAN((byte)3, "融资放款");


    CreditStatusEnum(byte code, String desc) {
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
