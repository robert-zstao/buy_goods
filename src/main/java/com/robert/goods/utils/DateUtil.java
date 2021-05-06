package com.robert.goods.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>公共方法类</p>
 * <p>提供有关日期的实用方法集</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: NineTowns</p>
 * @author Weiwenqi
 * @version 1.0
 *
 */

public class DateUtil {
	/**
	 * yyyy-MM-dd
	 */
	static SimpleDateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * yyyyMMddHHmmss
	 */
	static SimpleDateFormat sdfLongTime = new SimpleDateFormat("yyyyMMddHHmmss");

	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String MM_dd_HH_mm_ss = "HH:mm yyyy-MM-dd";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	/**
	 * Descrption:取得当前日期时间,格式为:YYYYMMDDHHMISS
	 * 
	 * @return String
	 * @throws Exception
	 */
	public static String getTime(Date date) {
		String nowTime = "";
		try {
			nowTime = sdfLongTime.format(date);
			return nowTime;
		} catch (Exception e) {
			return nowTime;
		}
	}

	/**
	 * @date 2017-09-20
	 * @author FoxChen
	 * @description
	 */
	/**
	 * Descrption:取得当前日期时间,格式为:YYYYMMDDHHmmss
	 * 
	 * @return String
	 * @throws Exception
	 */
	public static Date getDate1(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowTime;
		try {
			nowTime = df.parse(date);
			return nowTime;
		} catch (Exception e) {
			return new Date();
		}
	}

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public static String parse(Timestamp timestamp, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(new Date(timestamp.getTime()));
	}

	public static Date parse(String dateStr, String formatStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.parse(dateStr);
	}

	// 日期转成字符串,指定日期格式
	public static String dateToStr(Date date, String format) {
		if (date != null) {
			DateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		} else {
			return null;
		}
	}

	public static final String getDateTimeStr(String dateTime) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = df.parse(dateTime);
			return df1.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	// 当前系统时间
	public static Date getCurrDates() {
		return new Date();
	}

	public static String addMinute(String dateStr, Integer minute) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
		try {
			Date date = format.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, minute);// 24小时制
			date = cal.getTime();
			System.out.println("after:" + format.format(date));
			cal = null;
			return format.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}

	}

	/**
	 * 取得与原日期相差一定天数的日期，返回Date型日期
	 *
	 * @param date 原日期
	 * @param intBetween 相差的天数
	 * @return date加上intBetween天后的日期
	 */
	public static String getDateBetween(Date date, int intBetween,String formatStr)
	{
		Calendar calo = Calendar.getInstance();
		calo.setTime(date);
		calo.add(Calendar.DATE, intBetween);
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(calo.getTime());
	}

	public static String formatDate(String formatStr, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	/**
	 * 把一个字符串类型的日期值，转换成另一种显示格式的字符串
	 * 
	 * @param newFormatStr
	 *            例如yyyy-MM-dd HH:mm:ss
	 * @param oldFormatStr
	 *            例如yyyyMMddHHmmss
	 * @param dateString
	 *            例如20160621141446
	 * @return 2016-06-21 14:14:46
	 * @throws ParseException
	 */
	public static String formatDate(String newFormatStr, String oldFormatStr, String dateString) throws ParseException {
		SimpleDateFormat oldFormat = new SimpleDateFormat(oldFormatStr);
		Date date = oldFormat.parse(dateString);
		SimpleDateFormat newFormat = new SimpleDateFormat(newFormatStr);
		return newFormat.format(date);
	}


	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 * calendar 对日期进行时间操作
	 * getTimeInMillis() 获取日期的毫秒显示形式
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 与当前日期的时间差
	 * @param smdate
	 * @return
	 * @throws ParseException
	 */
	public static int StringDaysBetweenNow(String smdate) throws ParseException{
		Date d1=sdfLongTime.parse(smdate);
		Date d3=sdfLongTime.parse(sdfLongTime.format(new Date()));
		return daysBetween(d3,d1);
	}

	/**
	 * 计算某个日期当前日期之间相差的分钟秒
	 * @throws ParseException
	 * calendar 对日期进行时间操作
	 * getTimeInMillis() 获取日期的毫秒显示形式
	 */
	public static int minuteBetweenNow(String smdate) throws ParseException
	{
		Date d1=sdfLongTime.parse(smdate);
		Date d3=sdfLongTime.parse(sdfLongTime.format(new Date()));

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(d3);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*60);
		return Integer.parseInt(String.valueOf(between_days));
	}


	/**
	 * 计算两个日期之间相差的分钟
	 * @throws ParseException
	 * calendar 对日期进行时间操作
	 * getTimeInMillis() 获取日期的毫秒显示形式
	 */
	public static int minuteBetween(String smdate,String emdate) throws ParseException
	{
		Date d1=sdfLongTime.parse(smdate);
		Date d3=sdfLongTime.parse(emdate);

		Calendar cal = Calendar.getInstance();
		//开始时间
		cal.setTime(d1);
		long time1 = cal.getTimeInMillis();
		//结束时间
		cal.setTime(d3);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*60);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/***
	 * 把yyyy-MM-dd hh:mm:ss 格式化成yyyyMMddhhmmss
	 * @param date
	 * @return
	 */
	public static String formatStrDate(String date){
		String str = date.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
		return str;
	}


	/***
	 * 把分钟转换成具体的几时几分
	 * @param minute
	 * @return
	 */
	public static String formatMinute(Integer minute){
		String minStr = "";
		//1天以上
		if(minute>=1440){
			int leftday = minute%1440;
			int day = (minute-leftday)/1440;
			int hour = 0;
			int leftMin =0;
			if(leftday<=60){
				leftMin = leftday%60;
				hour = (leftday-leftMin)/60;
			}else{
				//大于60
				leftMin = leftday%60;
				hour = (leftday-leftMin)/60;
			}
			minStr = day+"d";
			if(hour!= 0){
				minStr += hour+"h";
			}
			if(leftMin!= 0){
				minStr += leftMin+"m";
			}
		}
		//1小时以上
		if(minute<1440 && minute>=60){
			int leftMin = minute%60;
			int hour = (minute-leftMin)/60;
			minStr = hour+"h"+leftMin+"m";
		}

		if(minute < 60){
			minStr = minute+"m";
		}
		return minStr;
	}




	public static void main(String[] args) {
		System.out.println(dateToString(new Date()));
		//System.out.println("====="+formatDate("yyyy-MM-dd",new Date()));

	}
}
