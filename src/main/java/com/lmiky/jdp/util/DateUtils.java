package com.lmiky.jdp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lmiky.jdp.constants.Constants;

/**
 * 日期工具类
 * @author 
 * @date 2013-5-16
 */
public class DateUtils {
	private static String beginDateTime;
	private static String endDateTime;
	static {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		beginDateTime = DateUtils.format(date, Constants.CONTEXT_KEY_FORMAT_TIME_VALUE);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		date = calendar.getTime();
		endDateTime = DateUtils.format(date, Constants.CONTEXT_KEY_FORMAT_TIME_VALUE);
	}
	
	/**
	 * 格式化日期/时间
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @param format 日期/时间格式
	 * @return
	 */
	public static String format(Date date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}
	
	/**
	 * 格式化日期，用默认的日期格式
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return format(date, Constants.CONTEXT_KEY_FORMAT_DATE_VALUE);
	}
	
	/**
	 * 格式化时间，用默认的时间格式
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		return format(date, Constants.CONTEXT_KEY_FORMAT_DATETIME_VALUE);
	}
	
	/**
	 * 字符串转时间
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parse(String date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try {
			return formater.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 字符串转时间，用默认的日期格式
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parseDate(String date) {
		return parse(date, Constants.CONTEXT_KEY_FORMAT_DATE_VALUE);
	}
	
	/**
	 * 字符串转时间，用默认的时间格式
	 * @author
	 * @date 2013-5-16
	 * @param date
	 * @return
	 */
	public static Date parseTime(String date) {
		return parse(date, Constants.CONTEXT_KEY_FORMAT_DATETIME_VALUE);
	}
	
	/**
	 * 开始时间
	 * @author lmiky
	 * @date 2014-1-25
	 * @return
	 */
	public static String getBeginDateTime() {
		return beginDateTime;
	}
	
	/**
	 * 结束时间
	 * @author lmiky
	 * @date 2014-1-25
	 * @return
	 */
	public static String getEndDateTime() {
		return endDateTime;
	}
}
