package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/27
 * description:
 */
public enum OperationTypeEnum {

    MERCHANT_REG((byte)0, "商户注册"),
    MERCHANT_OPEN((byte)1, "商户开通"),
    PLATFORM((byte)2, "平台注册"),
    COOPERATION((byte)3, "建立合作关系"),
    APPLY((byte) 4, "融资申请"),
    ACCEPT((byte) 5, "融资受理"),
    LOAN((byte) 6, "融资放款"),
    REPAY((byte) 7, "融资还款"),
    ASSET((byte) 8, "资产"),
    MERCHANT_MODIFY((byte) 9, "资产");

    OperationTypeEnum(Byte code, String desc) {
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