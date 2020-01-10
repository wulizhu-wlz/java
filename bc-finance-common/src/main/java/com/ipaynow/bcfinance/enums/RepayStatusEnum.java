package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
public enum RepayStatusEnum {

    INIT((byte) 0, "未还款"),
    DONE((byte) 1, "已还款");


    private Byte code;

    private String desc;

    RepayStatusEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public Byte getCode() {
        return code;
    }
}

