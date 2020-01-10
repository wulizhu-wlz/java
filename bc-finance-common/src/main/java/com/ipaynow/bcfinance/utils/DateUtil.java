//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ipaynow.bcfinance.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final String DATE_FOREVER = "9999-12-31";
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATETIME_HM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_FULLTIME = "yyMMddHHmmssSSS";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_YEARMONTH = "yyyy-MM";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_TRADETIME = "yyyyMMddHHmmss";
    public static final String FORMAT_TRADEDATE = "yyyyMMdd";
    public static final String FORMAT_ISODATETIME = "yyyyMMddHHmmss";
    public static final String FORMAT_ISODATE = "yyyyMMdd";
    public static final String FORMAT_ISOTIME = "yyyyMMdd";
    public static final long ND = 86400000L;
    public static final long NH = 3600000L;
    public static final long NM = 60000L;
    public static final long NS = 1000L;

    public DateUtil() {
    }

    public static Date getMinuteBefore(int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(12, -min);
        return calendar.getTime();
    }

    public static int compareOnlyByTime(String firstTime, String secondTime) {
        try {
            String e = ":";
            int pos = firstTime.indexOf(e);
            int iFirst = Integer.parseInt(firstTime.substring(0, pos)) * 10000;
            firstTime = firstTime.substring(pos + 1);
            pos = firstTime.indexOf(e);
            if(pos > 0) {
                iFirst = iFirst + Integer.parseInt(firstTime.substring(0, pos)) * 100 + Integer.parseInt(firstTime.substring(pos + 1));
            } else {
                iFirst += Integer.parseInt(firstTime) * 100;
            }

            pos = secondTime.indexOf(e);
            int iSecond = Integer.parseInt(secondTime.substring(0, pos)) * 10000;
            secondTime = secondTime.substring(pos + 1);
            pos = secondTime.indexOf(e);
            if(pos > 0) {
                iSecond = iSecond + Integer.parseInt(secondTime.substring(0, pos)) * 100 + Integer.parseInt(secondTime.substring(pos + 1));
            } else {
                iSecond += Integer.parseInt(secondTime) * 100;
            }

            return iFirst == iSecond?0:(iFirst > iSecond?1:-1);
        } catch (Exception var6) {
            return -2;
        }
    }

    public static Calendar getCalendar(String dateString) {
        Calendar calendar = Calendar.getInstance();
        String[] items = dateString.split("-");
        calendar.set(Integer.parseInt(items[0]), Integer.parseInt(items[1]) - 1, Integer.parseInt(items[2]));
        return calendar;
    }

    public static String getCertainDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, days);
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getCertainDate(String dateString, int days) {
        Calendar calendar = getCalendar(dateString);
        calendar.add(5, days);
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getCertainDate(String dateString, int days, String format) {
        Calendar calendar = getCalendar(dateString);
        calendar.add(5, days);
        return getStringFromDate(calendar.getTime(), format);
    }

    public static Date getCertainDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static String getCertainDate(String dateString, int period, int periodType) {
        Calendar calendar = getCalendar(dateString);
        switch(periodType) {
        case 1:
            calendar.add(5, period);
            break;
        case 2:
            calendar.add(2, period);
            break;
        case 3:
            calendar.add(2, period * 12);
        }

        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getCertainDatetime(String datetime, int days) {
        Date curDate = getDateFromString(datetime, "yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(5, days);
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getCertainMonth(int dif) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, dif);
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getCertainMonth(int dif, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, dif);
        return getStringFromDate(calendar.getTime(), format);
    }

    public static String getChineseDate() {
        return getChineseDate(getDate());
    }

    public static String getChineseDate(String date) {
        if(date.length() < Integer.valueOf("10").intValue()) {
            return "";
        } else {
            String year = date.substring(0, 4);
            String month = date.substring(5, 7);
            String day = date.substring(8, 10);
            String y1 = year.substring(0, 1);
            String y2 = year.substring(1, 2);
            String y3 = year.substring(2, 3);
            String y4 = year.substring(3, 4);
            String m2 = month.substring(1, 2);
            String d1 = day.substring(0, 1);
            String d2 = day.substring(1, 2);
            String cy1 = getChineseNum(y1);
            String cy2 = getChineseNum(y2);
            String cy3 = getChineseNum(y3);
            String cy4 = getChineseNum(y4);
            String cm2 = getChineseNum(m2);
            String cd1 = getChineseNum(d1);
            String cd2 = getChineseNum(d2);
            String cYear = cy1 + cy2 + cy3 + cy4 + "年";
            String cMonth = "月";
            if(Integer.parseInt(month) > 9) {
                cMonth = "十" + cm2 + cMonth;
            } else {
                cMonth = cm2 + cMonth;
            }

            String cDay = "日";
            if(Integer.parseInt(day) > 9) {
                cDay = cd1 + "十" + cd2 + cDay;
            } else {
                cDay = cd2 + cDay;
            }

            String chineseday = cYear + cMonth + cDay;
            return chineseday;
        }
    }

    public static String getChineseDayOfWeek() {
        return getChineseDayOfWeek(getDate());
    }

    public static String getChineseDayOfWeek(String strDate) {
        Calendar calendar = getCalendar(strDate);
        int week = calendar.get(7);
        String strWeek = "";
        switch(week) {
        case 1:
            strWeek = "星期日";
            break;
        case 2:
            strWeek = "星期一";
            break;
        case 3:
            strWeek = "星期二";
            break;
        case 4:
            strWeek = "星期三";
            break;
        case 5:
            strWeek = "星期四";
            break;
        case 6:
            strWeek = "星期五";
            break;
        case 7:
            strWeek = "星期六";
            break;
        default:
            strWeek = "星期一";
        }

        return strWeek;
    }

    public static String getChineseNum(String number) {
        String chinese = "";
        int x = Integer.parseInt(number);
        switch(x) {
        case 0:
            chinese = "零";
            break;
        case 1:
            chinese = "一";
            break;
        case 2:
            chinese = "二";
            break;
        case 3:
            chinese = "三";
            break;
        case 4:
            chinese = "四";
            break;
        case 5:
            chinese = "五";
            break;
        case 6:
            chinese = "六";
            break;
        case 7:
            chinese = "七";
            break;
        case 8:
            chinese = "八";
            break;
        case 9:
            chinese = "九";
        }

        return chinese;
    }

    public static String getChineseTwoDate(String date) {
        if(date.length() < 10) {
            return "";
        } else {
            String year = date.substring(0, 4);
            String month = date.substring(5, 7);
            String day = date.substring(8, 10);
            return year + "年" + month + "月" + day + "日";
        }
    }

    public static String getCustomDateTime(String customFormat) {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), customFormat);
    }

    public static String getDate() {
        return getDate(Calendar.getInstance());
    }

    public static String getDate(Calendar calendar) {
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getDateAdded(int addNum, String getDate) {
        return getCertainDate(getDate, addNum);
    }

    public static Date getDateFromString(String s) {
        return getDateFromString(s, "yyyy-MM-dd");
    }

    public static Date getDateFromString(String s, String format) {
        try {
            SimpleDateFormat e = new SimpleDateFormat(format);
            return e.parse(s);
        } catch (Exception var3) {
            return null;
        }
    }

    public static Date getDateTimeFromDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(date);

        try {
            return sdf.parse(str);
        } catch (ParseException var5) {
            return null;
        }
    }

    public static String getDatetime() {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeHm() {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd HH:mm");
    }

    public static String getDatetimeW3C() {
        return getDate() + "T" + getTime();
    }

    public static String getDatetimeZd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(12, 0);
        calendar.set(13, 0);
        return getStringFromDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public static int getDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5);
    }

    public static String getDiffTime(String beginTime, String endTime) {
        try {
            if(endTime == null || endTime.length() == 0) {
                endTime = getDatetime();
            }

            Date e = getDateFromString(endTime, "yyyy-MM-dd HH:mm:ss");
            Date bTime = getDateFromString(beginTime, "yyyy-MM-dd HH:mm:ss");
            long time = e.getTime() - bTime.getTime();
            StringBuffer sb = new StringBuffer();
            int day = (int)Math.floor((double)time / 8.64E7D);
            if(day > 0) {
                sb.append(day).append("天");
            }

            time %= 86400000L;
            int hour = (int)Math.floor((double)time / 3600000.0D);
            if(hour > 0) {
                sb.append(hour).append("小时");
            }

            time %= 3600000L;
            int minute = (int)Math.ceil((double)time / 60000.0D);
            if(minute > 0) {
                sb.append(minute).append("分钟");
            }

            return sb.toString();
        } catch (Exception var10) {
            return "";
        }
    }

    public static long getDiffTime(Date beginTime, Date endTime) {
        long diff = endTime.getTime() - beginTime.getTime();
        return diff;
    }

    public static String getFirstDateOfWeek() {
        return getFirstDateOfWeek(getDate());
    }

    public static String getFirstDateOfWeek(String dateString) {
        Calendar calendar = getCalendar(dateString);
        int iCount;
        if(calendar.get(7) == 1) {
            iCount = -6;
        } else {
            iCount = 2 - calendar.get(7);
        }

        return getCertainDate(dateString, iCount);
    }

    public static String getFulltime() {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), "yyMMddHHmmssSSS");
    }

    public static int getMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(2) + 1;
    }

    public static int getMonthDiff(String startDate, String endDate) {
        String[] startArray = startDate.split("-");
        String[] endArray = endDate.split("-");
        int startYear = Integer.parseInt(startArray[0]);
        int startMonth = Integer.parseInt(startArray[1]);
        int endYear = Integer.parseInt(endArray[0]);
        int endMonth = Integer.parseInt(endArray[1]);
        return Math.abs((endYear - startYear) * 12 + endMonth - startMonth);
    }

    public static Date getFirstDayOfMonth(Date targetDate) {
        Calendar gcLast = Calendar.getInstance();
        gcLast.setTime(targetDate);
        gcLast.set(5, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String day_first = df.format(gcLast.getTime());
        day_first = day_first + " 00:00:00";
        return getDateFromString(day_first, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getLastDayOfMonth(Date targetDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(targetDate);
        calendar.set(5, 1);
        calendar.roll(5, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = df.format(calendar.getTime());
        lastDay = lastDay + " 23:59:59";
        return getDateFromString(lastDay, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getStringFromDate(Date d, String format) {
        if(d == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(d);
        }
    }

    public static String getDateTimeFromString(String d, String format, String rtnFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat rtnf = new SimpleDateFormat(rtnFormat);

        try {
            return rtnf.format(sdf.parse(d));
        } catch (ParseException var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static String getStringFromDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(d);
    }

    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), "HH:mm:ss");
    }

    public static String getWorkDate(String date) {
        Date curDate = getDateFromString(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        int week = calendar.get(7);
        if(week == 7) {
            calendar.add(5, 2);
        } else if(week == 1) {
            calendar.add(5, 1);
        }

        return getDate(calendar);
    }

    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1);
    }

    public static String getYearMonth() {
        Calendar calendar = Calendar.getInstance();
        return getStringFromDate(calendar.getTime(), "yyyy-MM");
    }

    public static int selectDateDiff(String dateinfo) {
        return selectDateDiff(dateinfo, getDate());
    }

    public static int selectDateDiff(String first, String second) {
        boolean dif = false;

        int dif1;
        try {
            Date e = getDateFromString(first, "yyyy-MM-dd");
            Date sDate = getDateFromString(second, "yyyy-MM-dd");
            dif1 = (int)((e.getTime() - sDate.getTime()) / 86400000L);
        } catch (Exception var5) {
            dif1 = 0;
        }

        return dif1;
    }

    public static long selectMillSecDiff(String start, String end, String date_formate) {
        SimpleDateFormat dfs = new SimpleDateFormat(date_formate);
        long between = 0L;

        try {
            Date ex = dfs.parse(start);
            Date end_date = dfs.parse(end);
            between = end_date.getTime() - ex.getTime();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return between;
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    public static String getCurrentDate(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(new Date());
    }

    public static Date string2Date(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        try {
            return df.parse(date);
        } catch (ParseException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date string2Date(String date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            return df.parse(date);
        } catch (ParseException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String initDate(Date dt) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(dt) + " 00:00:00";
    }

    public static Date getMinuteDate(Date date, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, min);
        return calendar.getTime();
    }

    /** 获取某天的23点59分59秒
     *
     * @return */
    public static Date getOneDayLastTime(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return cal.getTime();
    }

    /** 获取某天的0点0分0秒
     *
     * @param  date
     * @return */
    public static Date getOneDayFirstDate(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getMinTimeOfDay(Date date) {
        return getStringFromDate(date, "yyyy-MM-dd") + " 00:00:00";
    }

    public static String getMaxTimeOfDay(Date date) {
        return getStringFromDate(date, "yyyy-MM-dd") + " 23:59:59";
    }
}
