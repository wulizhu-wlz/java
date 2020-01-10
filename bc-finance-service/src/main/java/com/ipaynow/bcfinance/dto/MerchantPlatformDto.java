package com.ipaynow.bcfinance.dto;

import lombok.Data;

@Data
public class MerchantPlatformDto {
        private Long id;

        private Integer idOfTbMerchantUser;

        private String mchName;

        private String platformName;

        private String stockAmount;

        private String soldForSettlementAmount;

        private String settledForPaymentAmount;

        private String stockTurnOverRatio;

        private String returnRate;

        private String statisticalDate;

        private String assetAddress;
}
