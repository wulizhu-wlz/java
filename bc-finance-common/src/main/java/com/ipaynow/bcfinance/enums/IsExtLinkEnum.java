package com.ipaynow.bcfinance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IsExtLinkEnum {

    Y((byte) 1, "是"),
    N((byte) 0,"否")
    ;

    private Byte code;

    private String desc;


    public static IsExtLinkEnum getByCode(Byte code) {
        if (code == null) {
            return null;
        }
        for (IsExtLinkEnum value : IsExtLinkEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
