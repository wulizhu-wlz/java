package com.ipaynow.bcfinance.dto;

/**
 * @author ytw
 * @date 2019/6/20
 * description:新增商户vo
 */
public class NewMerchantDto {

    /**
     * 九盈商户号
     * */
    private Integer iotmu;

    /**
     * 商户号
     * */
    private String uioipn;

    /**
     * 商户名称
     * */
    private String mn;

    public Integer getIotmu() {
        return iotmu;
    }

    public void setIotmu(Integer iotmu) {
        this.iotmu = iotmu;
    }

    public String getUioipn() {
        return uioipn;
    }

    public void setUioipn(String uioipn) {
        this.uioipn = uioipn;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }
}
