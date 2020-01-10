package com.ipaynow.bcfinance.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * ClassName:MoneyUtil
 * Description:
 * Author:coder
 * Date: 2016/9/9 14:38
 */
public class MoneyUtil {


    public static Long yuan2cent(String value) {
        BigDecimal amountBigDecimal = new BigDecimal(value);
        BigDecimal baseNumber = new BigDecimal("100");
        return amountBigDecimal.multiply(baseNumber).longValue();
    }

    public static BigDecimal cent2yuan(String value) {
        BigDecimal amountBigDecimal = new BigDecimal(value);
        BigDecimal baseNumber = new BigDecimal("100");
        return amountBigDecimal.divide(baseNumber, 2, RoundingMode.DOWN);
    }


    @Deprecated
    public static String transferCNYH(String value) {
        if("CNY".equalsIgnoreCase(value)){
            return "CNH";
        }
        if("CNH".equalsIgnoreCase(value)){
            return "CNY";
        }
        if(value.contains("CNY")){
            return value.replaceAll("CNY", "CNH");
        }
        if(value.contains("CNH")){
            return value.replaceAll("CNH", "CNY");
        }
        return value;
    }

    public static String toCNY(String value) {

        if("CNH".equalsIgnoreCase(value)){
            return "CNY";
        }

        if(value.contains("CNH")){
            return value.replaceAll("CNH", "CNY");
        }
        return value;
    }

    public static String toCNH(String value) {
        if("CNY".equalsIgnoreCase(value)){
            return "CNH";
        }

        if(value.contains("CNY")){
            return value.replaceAll("CNY", "CNH");
        }

        return value;
    }

    /**
     * 获取与源币种对应的汇率 支持 “USD/CNY 6.8887”  “USDCNY 6.8841” 两种形式
     *
     * 例如 参数为 "USD","USD/CNY 6.8887"返回"USD/CNY 6.8887"
     *     参数为 "CNY","USD/CNY 6.8887"返回"CNY/USD 0.1452"
     **/
    public static String getFxRate(String baseCurr, String fxRate) {

        String currencyPair = fxRate.split(" ")[0];
        if(currencyPair.length()<6){
            return null;
        }
        String baseCurrency = currencyPair.substring(0, 3);//前3位作为主货币
        //判断是否是基准货币，如果是直接返回汇率，不是则需要处理汇率
        if (baseCurrency.equals(baseCurr)) {
            return fxRate;
        }

        String quoteCurrency = currencyPair.substring(currencyPair.length() - 3);//后3位作为兑换货币
        if(baseCurr.equalsIgnoreCase(baseCurr)){

            BigDecimal currencyRate = new BigDecimal(fxRate.split(" ")[1]);
            BigDecimal afterRate = BigDecimal.valueOf(1).divide(currencyRate, 4, BigDecimal.ROUND_HALF_UP);
            StringBuilder sb = new StringBuilder();
            sb.append(quoteCurrency);
            if(fxRate.contains("/")){
                sb.append("/");
            }
            sb.append(baseCurrency);
            sb.append(" ");
            sb.append(afterRate);

            return sb.toString();
        }

        return null;

    }


    /**
     * 获取与源币种对应的汇率 currencyPair支持 “USD/CNY”、“USDCNY” 两种形式，rate为 6.8841 形式
     *
     * 例如 参数为 "USD","USDCNY",6.8887"返回"6.8887"
     *     参数为 "CNY","USD/CNY",6.8887"返回"0.1452"
     **/
    public static String getRate(String baseCurr, String currencyPair, String rate) {

        if(currencyPair.length()<6){
            return null;
        }
        String baseCurrency = currencyPair.substring(0, 3);//前3位作为主货币
        //判断是否是基准货币，如果是直接返回汇率，不是则需要处理汇率
        if (baseCurrency.equals(baseCurr)) {
            return rate;
        }

        String quoteCurrency = currencyPair.substring(currencyPair.length() - 3);//后3位作为兑换货币
        if(baseCurr.equalsIgnoreCase(baseCurr)){

            BigDecimal currencyRate = new BigDecimal(rate);
            BigDecimal afterRate = BigDecimal.valueOf(1).divide(currencyRate, 4, BigDecimal.ROUND_HALF_UP);

            return afterRate.toString();
        }

        return null;

    }

    public static void main(String[] args) {
        String result = getFxRate("CNY","USD/CNY 6.8887");
        System.out.println(result);

        String result2 = getRate("CNY","USD/CNY","6.8887");
        System.out.println(result2);

        String result3 = getFxRate("USD","USD/CNY 6.8887");
        System.out.println(result3);

        String result4 = getRate("USD","USD/CNY","6.8887");
        System.out.println(result4);

    }


}
