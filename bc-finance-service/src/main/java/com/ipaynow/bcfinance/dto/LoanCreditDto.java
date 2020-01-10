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
public class LoanCreditDto {

    /**
     * 融资表id
     * */
    @NotNull
    public Long id;

    /**
     * 操作类型
     * */
    @NotNull
    public Long type;

    /**
     * 贷款编号
     * */
    @NotEmpty
    public String code;

    /**
     * 放款方支付商户号
     * */
    @NotEmpty
    public String userIdOfIPayNowOfCreditor;

    /**
     * 贷款方支付商户号
     * */
    @NotEmpty
    public String userIdOfIPayNowOfDebtor;

    /**
     * 放款方名称
     */
    @NotEmpty
    public String creditorName;

    /**
     *贷款方名称
     */
    @NotEmpty
    public String debtorName;

    /**
     * 融资申请时间
     */
    public String applyTime;

    /**
     * 实际放款时间
     * */
    @NotEmpty
    public String realLoanTime;

    /**
     * 融资金额
     */
    @NotEmpty
    public String accountDelta;

    /**
     * 利息利率
     * */
    @NotEmpty
    public String rate;


    public boolean isHistory;    //  0  当前  1  历史

}



