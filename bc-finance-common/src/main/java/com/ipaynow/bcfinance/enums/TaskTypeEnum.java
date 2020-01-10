package com.ipaynow.bcfinance.enums;

public enum TaskTypeEnum {

    SUPPLY_CHAIN_CREDIT((byte)1, "供应链借款"),
    SUPPLY_CHAIN_REFUND((byte)2, "供应链还款"),
    ADVANCE_CREDIT((byte)3, "垫资借款"),
    ADVANCE_REFUND((byte)4, "垫资还款"),
    MERCHANT_USER_DATA((byte)5, "九盈用户数据"),
    MERCHANT_BUSINESS_DATA((byte)6, "商户各平台的业务数据");

    private Byte code;
    private String descript;

    TaskTypeEnum(Byte code, String descript){
        this.code = code;
        this.descript = descript;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public static TaskTypeEnum getByCode(Byte code){
        for (TaskTypeEnum value : TaskTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }
}
