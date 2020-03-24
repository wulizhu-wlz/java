package com.ipaynow.bcfinance.enums;

/**
 * @author ytw
 * @date 2019/6/20
 * description:
 */
public enum ExceptionEnum {
    SUCCESS("A001", "成功"),
    SIGN_FAIL("A002", "验签失败"),
    SYSTEM_ERROR("A003", "系统错误"),
    TYPE_ERROR("A004", "操作类型异常，暂不支持该业务"),
    PARAM_ERROR("A005", "参数异常"),
    DATA_ERROR("A006", "数据库异常"),
    DUP_CREDIT_DATA("A007", "放款数据重复"),
    DUP_REFUND_DATA("A008", "还款数据重复"),
    LOAN_NOT_EXIST("A009", "无匹配的融资数据"),
    CONTRACT_ADDR_NOT_EXIST("A010", "合约地址配置不存在"),
    DEPLOY_CONTRACT_CLASS_NOT_FOUND("A011", "合约部署，找不到合约Class"),
    CHAIN_ERROR("A012", "上链失败"),
    SEND_CHAIN_ERROR("A013", "上链失败"),
    NO_MERCHANT_ERROR("A014", "找不到商户信息"),
    NO_ACCOUNT_ERROR("A015", "找不到链上账户信息"),
    MERCHANT_EXISTED("A016", "商户信息已存在"),
    NO_ASSETS_ERROR("A017", "找不到资产信息"),
    CMB_CHAIN_ERROR("A018", "调用招行链失败"),
    CMB_CHAIN_ERR_MSG("A019", "调用招行链返回errorMsg"),
    USERNAME_OR_PASSWORD_NULL("A020", "用户名或密码为空"),
    FROZEN("A021", "用户已冻结"),
    CMB_NOT_FOUND_IPAYNOW_TRANS("A022","找不到ipaynow链的交易记录"),
    BLOCK_CHAIN_ACCOUNT_M_NOT_FOUND("A023","找不到商户区块链账户信息"),
    BLOCK_CHAIN_ACCOUNT_P_NOT_FOUND("A024","找不到平台区块链账户信息"),
    BLOCK_CHAIN_ACCOUNT_P_INCOMPLETE_NOT_FOUND("A025","平台区块链账户信息accAddress为空"),
    ASSETMENT_DUPLICATE("A026","商户平台统计数据重复"),
    ES_INSERT_ERROR("","");

    private String code;

    private String desc;


    ExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
