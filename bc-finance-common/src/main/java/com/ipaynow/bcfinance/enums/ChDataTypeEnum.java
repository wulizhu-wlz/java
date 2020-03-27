package com.ipaynow.bcfinance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChDataTypeEnum {

    /** 每个频道下面的数据类型，由频道id拼接一位数字构成；例如 订房-主要房型 为51; 订房-房型促销信息 为52; **/
    RESTAURANT(1, "餐厅"),
    RESTAURANT_MAIN(11, "餐厅主要信息"),
    RESTAURANT_CUISINE(12, "餐厅菜系信息"),
    PARTY(2,"玩乐"),
    SHOP(3,"购物"),
    HOMEPAGE(4,"首页"),
    HOMEPAGE_POOL(42,"首页无边泳池"),
    HOMEPAGE_SKY_PARK(43,"首页空中花园"),
    HOMEPAGE_STRATEGY(46,"首页攻略"),
    ORDER_ROOM(5,"订房"),
    RECOMMEND(6,"推荐"),
    RESERVATIONS_MAIN(51,"主要房型"),
    RESERVATIONS_PROMOTION(52,"房型促销信息"),
    SHOP_BRAND(31,"品牌"),
    SHOP_BRAND_RECOMMEND(32,"品牌推荐"),
    PARTY_INFO(21,"玩乐信息"),
    PARTY_DISCOUNT(22,"玩乐优惠"),
    ROOM_INFO(51,"房间信息"),
    ROOM_PROMOTION(52,"房间优惠"),
    RECOMMEND_INFO(61,"推荐")
    ;

    private Integer code;

    private String desc;


    public static ChDataTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ChDataTypeEnum value : ChDataTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
