package com.ipaynow.bcfinance.web.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author ytw
 * @date 2019/7/1
 * description:日期格式化器，将毫秒格式化为Date
 */
public class DateFormatter implements Formatter<Date> {

    private final Logger logger = LoggerFactory.getLogger(DateFormatter.class);
    
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        try {
            Long milliseconds = Long.valueOf(text);
            Calendar calendar = Calendar.getInstance(locale);
            calendar.setTimeInMillis(milliseconds);
            return calendar.getTime();
        } catch (Exception e) {
            logger.error("【com.ipaynow.bcfinance.config.DateFormatter日期转换失败】，text={}，milliseconds --> Date", text, e);
            throw e;
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        return String.valueOf(date.getTime());
    }

}
