package com.ipaynow.bcfinance.dto;

/**
 * @author ytw
 * @date 2019/6/24
 * description:商户平台业务统计数据dto
 */
public class MerchantStatisticsDto {

    /**
     * 九盈商户号
     * */
    private String iotmu;

    /**
     * 平台名称
     * */
    private String pn;


    /**
     * 库存金额
     * */
    private String sa;

    /**
    * 已销售待结算金额
    * */
    private String sfsa;

    /**
     * 已结算待付款金额
     */
    private String sfpa;

    /**
     * 存货周转率
     */
    private String stor = "";

    /**
     * 退货率
     */
    private String rr = "";

    /**
     * 统计日期
     */
    private String sd;


    public String getIotmu() {
        return iotmu;
    }

    public void setIotmu(String iotmu) {
        this.iotmu = iotmu;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSfsa() {
        return sfsa;
    }

    public void setSfsa(String sfsa) {
        this.sfsa = sfsa;
    }

    public String getSfpa() {
        return sfpa;
    }

    public void setSfpa(String sfpa) {
        this.sfpa = sfpa;
    }

    public String getStor() {
        return stor;
    }

    public void setStor(String stor) {
        this.stor = stor;
    }

    public String getRr() {
        return rr;
    }

    public void setRr(String rr) {
        this.rr = rr;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }
}
