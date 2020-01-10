package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/24
 * description:
 */
public enum ChainStatusEnum {

    CHAIN_DOWN((byte) 0, "未上链"),
    CHAIN_UP((byte) 1, "已上链");


    private Byte code;

    private String desc;

    ChainStatusEnum(Byte code, String desc) {
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

