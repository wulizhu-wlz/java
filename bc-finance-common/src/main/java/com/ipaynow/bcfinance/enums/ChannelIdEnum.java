package com.ipaynow.bcfinance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChannelIdEnum {

    RESTAURANT(1, "餐厅"),
    PARTY(2,"玩乐"),
    SHOP(3,"购物"),
    HOMEPAGE(4,"首页"),
    ORDER_ROOM(5,"订房 "),
    RECOMMEND(6,"推荐"),
    ;

    private Integer code;

    private String desc;


    public static ChannelIdEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ChannelIdEnum value : ChannelIdEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
