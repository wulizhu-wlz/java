package com.ipaynow.bcfinance.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ytw
 * @date 2019/6/20
 * description:新增商户vo
 */
@Data
public class RepaymentDto {

    public RepaymentDto() {
    }

    /**
     * 还款表id
     * */
    @NotNull
    public Long id;

    /**
     * 操作类型
     * */
    @NotNull
    public Long type;

    /**
     * 融资表id
     * */
    @NotNull
    public Long idSlLoanCreditLog;

    /**
     * 本次还款金额
     * */
    @NotEmpty
    public String refundAmount;

    /**
     * 还款本金
     * */
    @NotEmpty
    public String refundPrinciple;

    /**
     * 还款利息
     */
    @NotEmpty
    public String refundRate;

    /**
     * 应还本金
     * */
    @NotEmpty
    public String shouldRefundPrinciple;

    /**
     * 应还利息
     * */
    @NotEmpty
    public String shouldRefundRate;

    /**
     * 还款申请时间
     * */
    public String applyTime;

    /**
     * 还款时间
     * */
    @NotEmpty
    public String refundDate;


    public boolean history;    //  0  当前  1  历史
}




















