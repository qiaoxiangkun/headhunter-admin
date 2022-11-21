package com.ruoyi.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by joe on 2017/2/25.
 */
public class ConvertHelper {
    public static int toInt32(Object object) {
        return toInt32(object, 0);
    }

    public static int toInt32(Object object, int defaultVal) {
        String obj = ConvertHelper.toString(object);
        try {
            int result = Integer.parseInt(obj);
            return result;
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public static double toDouble(Object object) {
        return toDouble(object, 0);
    }

    public static double toDouble(Object object, double defaultVal) {
        String obj = ConvertHelper.toString(object);
        try {
            double result = Double.parseDouble(obj);
            return result;
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public static Date toDate(int year, int month, int day) {
        Calendar c = new GregorianCalendar(year, month, day);
        Date date = c.getTime();
        return date;
    }

    public static Date toDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar c = new GregorianCalendar(year, month - 1, day, hour, minute, second);
        Date date = c.getTime();
        return date;
    }

    public static Date toDate(Object obj) {
        String timeStr = ConvertHelper.toString(obj);

        //2012年02月25日 格式时
        if (Pattern.compile("^\\d{4}年\\d{1,2}月\\d{1,2}日$").matcher(timeStr).matches()) {
            return toDate(timeStr, "yyyy年MM月dd日");
        }
        //2012-02-25
        if (Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$").matcher(timeStr).matches()) {
            return toDate(timeStr, "yyyy-MM-dd");
        }
        //2012/02/25
        if (Pattern.compile("^\\d{4}/\\d{1,2}/\\d{1,2}$").matcher(timeStr).matches()) {
            return toDate(timeStr, "yyyy/MM/dd");
        }

        return toDate(timeStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(Object obj, String format) {
        String timeStr = ConvertHelper.toString(obj);
        if (!checkStr(timeStr)) {
            return null;
        }
        Date date = null;
        try {
            //date = sdf.parse(timeStr);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date = simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean checkStr(String str){
        if(str==null||str.equals("") || str.length()==0)
        {
            return false;
        }
        return true;
    }

    public static String formatDecimal(BigDecimal decimal) {
        if (decimal == null) {
            return "";
        }
        DecimalFormat decformat = new DecimalFormat("#,##0.00");
        return decformat.format(decimal);
    }

    public static BigDecimal toDecimal(Object value) {
        BigDecimal ret = BigDecimal.ZERO;
        if (checkStr(ConvertHelper.toString(value))) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static boolean toBool(String bool) {
        if (!checkStr(bool)) {
            return false;
        }
        if (bool.equals("1") || bool.toLowerCase().equals("true")) {
            return true;
        }
        return false;
    }

    public static List<Integer> toIntList(String str) {
        if (!checkStr(str)) {
            return new ArrayList<Integer>();
        }
        //1,2,3,4
        String[] balance_types = str.split(",");
        List<Integer> balance_typesint = new ArrayList<Integer>();
        for (String balance_typeStr : balance_types) {
            balance_typesint.add(ConvertHelper.toInt32(balance_typeStr));
        }
        return balance_typesint;
    }

    public static String toString(Object object) {
        if (object != null) {
            return object.toString();
        }
        return "";
    }

    /*
    * 将数组的参数转换成sql字符串参数，可以直接用in
    *
    * */
    public static String toSqlStrParams(String[] strList) {
        if (strList == null || strList.length == 0)
            return "";
        String str = "";
        for (String item : strList) {
            if ("".equals(str)) {
                str = "'" + item + "'";
            } else
                str += ",'" + item + "'";
        }
        return str;
    }


    public static String formatDouble(Object m) {
        double d = toDouble(m);
        return toDoubleString(d, "#,##0.00");//#,##0.00
    }

    public static String toDoubleString(Double d) {
        return toDoubleString(d, "##0.00");//#,##0.00
    }

    public static String toDoubleString(Double d, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);//格式化设置
        return decimalFormat.format(d);
    }

    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 适用于2020-02-17T09:31:24.000+0000格式转换
     * @param dateStr
     * @return
     */
    public static Date toDateFromStrWithT(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        ObjectMapper MAPPER = new ObjectMapper();
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
