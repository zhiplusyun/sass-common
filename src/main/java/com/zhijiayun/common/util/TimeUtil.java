/**
 * 
 */
package com.zhijiayun.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xfwang
 *
 */
public class TimeUtil {
	/**
	 * 日期格式 HH:mm
	 */
	public static final String FORMAT_HHMM  = "HH:mm";
	/**
	 * 日期格式 yyyy-MM-dd
	 */
	public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";

	/**
	 * 日期格式 yyyy年M月d日
	 */
	public static final String FORMAT_YYYYMD = "yyyy年M月d日";

	/**
	 * 日期格式 yyyy-MM-dd HH:mm
	 */
	public static final String FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	/**
	 * 日期格式 MM-dd HH:mm
	 */
	public static final String FORMAT_MMDDHHMM = "MM-dd HH:mm";

	/**
	 * 日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式 yyyyMMddHHmmssSSS
	 */
	public static final String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	/**
	 * 日期格式 yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static final String DETAIL_TIME = "yyyy-MM-dd HH:mm:ss:SSS";

	/**
	 * 转换为{@link #FORMAT_YYYYMMDDHHMMSS}的字符串格式
	 * 
	 * @param millSec
	 * @return
	 */
	public static String longToStrDate(long millSec) {
		return longToStrDate(FORMAT_YYYYMMDDHHMMSS, millSec);
	}

	public static String longToStrDate(String format, long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	public static String format(String format, Date time) {
		if(time==null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(time);
	}
	
	public static Date formatToDate(String format, Date time) {
		if(time==null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			time = sdf.parse(sdf.format(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 取得现在的时间 日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowTime() {
		SimpleDateFormat formater = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
		return formater.format(new Date());
	}

	/**
	 * 取得现在的时间 日期格式 yyyyMMddHHmmssSSS
	 */
	public static String getNowTimeS() {
		SimpleDateFormat formater = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSSSSS);
		return formater.format(new Date());
	}

	/**
	 * 日期转换 yyyy年M月d日转成yyyy-MM-dd
	 */
	public static String convertYmd(String ymd) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMD);
		SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_YYYYMMDD);
		try {
			return sdf2.format(sdf.parse(ymd));
		} catch (ParseException e) {
		}
		return null;
	}

	public static Date convertDate(String ymd, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(ymd);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 日期文字转换日期 yyyy-MM-dd HH:mm:ss转成日期
	 */
	public static Date convertDateNormal(String ymd) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
		try {
			return sdf.parse(ymd);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 日期文字转换日期 yyyy-MM-dd 转成日期
	 */
	public static Date convertDate(String ymd) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDD);
		try {
			return sdf.parse(ymd);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 日期转成日期文字yyyy-MM-dd
	 */
	public static String convertDateYmd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDD);
		return sdf.format(date);
	}

	/**
	 * 日期相加(年月日)
	 * 
	 * @param date
	 *            日期
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @return 相加后的日期
	 */
	public static Date addDate(Date date, int year, int month, int day) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.YEAR, year);
		cl.add(Calendar.MONTH, month);
		cl.add(Calendar.DAY_OF_MONTH, day);
		return cl.getTime();
	}

	/**
	 * 日期相加(时分秒)
	 * 
	 * @param date
	 *            日期
	 * @param hour
	 * @param minute
	 * @return 相加后的日期
	 */
	public static Date addDate(Date date, int hour, int minute) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.HOUR, hour);
		cl.add(Calendar.MINUTE, minute);
		return cl.getTime();
	}

	/**
	 * 获取当天最大时间时间
	 */
	public static Date getCurrentDate() {
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.DAY_OF_MONTH, 1);
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND, 0);
		return cl.getTime();
	}

	/**
	 * 获得当天0点时间
	 * 
	 * @return
	 */
	public static Date getCurrentBeginDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的00:00:00点时间，默认为当天
	 * 
	 * @return
	 */
	public static Date getCurrentBeginDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date == null ? new Date() : date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得当天23:59:59点时间
	 * 
	 * @return
	 */
	public static Date getCurrentEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

	//获取当前时间到23点59分59秒的时间
	public static long getTomorrowZeroSeconds() {
		long current = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, -1);
		long tomorrowzero = calendar.getTimeInMillis();
		long tomorrowzeroSeconds = (tomorrowzero- current) / 1000;
		return tomorrowzeroSeconds;
	}

	/**
	 * 获取指定日期的23:59:59点时间，默认为当天
	 * 
	 * @return
	 */
	public static Date getCurrentEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date == null ? new Date() : date);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

	/**
	 * 计算出两个日期之间相差的天数，7.1 - 7.2，这表示相差2天，包含了开始当天和结束当天
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return date2 - date1
	 */
	public static int dayInterval(Date d1, Date d2) {
		long time = d2.getTime() - d1.getTime();
		long day = time / (60*60*1000) / 24 + 1;
		return new Long(day).intValue();
	}

	/**
	 * 计算出两个日期之间相差的小时数
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return date2 - date1
	 */
	public static int hourInterval(Date d1, Date d2) {
		long time = d2.getTime() - d1.getTime();
		long hour = Math.abs(time / (60*60*1000));;
		return (int) hour;
	}
	
	/**
	 * 计算出两个日期之间相差的分钟数
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return date2 - date1
	 */
	public static int minuteInterval(Date d1, Date d2) {
		long time = d2.getTime() - d1.getTime();
		long minute = Math.abs(time / (60*1000));
		return (int) minute;
	}

	/**
	 * 计算出两个日期之间相差的秒数
	 *
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return date2 - date1
	 */
	public static int secondInterval(Date d1, Date d2) {
		long time = d2.getTime() - d1.getTime();
		long minute = Math.abs(time / (1000));
		return (int) minute;
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		String str = "";
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// hour中存的就是星期几了，其范围 1~7(1=星期日 7=星期六，其他类推)
		int hour = c.get(Calendar.DAY_OF_WEEK);
		switch (hour) {
			case 1:
				str = "星期日"; break;
			case 2:
				str = "星期一"; break;
			case 3:
				str = "星期二"; break;
			case 4:
				str = "星期三"; break;
			case 5:
				str = "星期四"; break;
			case 6:
				str = "星期五"; break;
			case 7:
				str = "星期六"; break;
			default:
				break;
		}
		return str;
	}


	/**
	 * 判断某一时间是否在一个区间内
	 *
	 * @param sourceTime
	 *            时间区间,半闭合,如[10:00-20:00)
	 * @param curTime
	 *            需要判断的时间 如10:00
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static boolean isInTime(String sourceTime, String curTime) {
		if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}
		if (curTime == null || !curTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
		}
		String[] args = sourceTime.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			long now = sdf.parse(curTime).getTime();
			long start = sdf.parse(args[0]).getTime();
			long end = sdf.parse(args[1]).getTime();
			if (args[1].equals("00:00")) {
				args[1] = "24:00";
			}
			if (end < start) {
				if (now >= end && now < start) {
					return false;
				} else {
					return true;
				}
			}
			else {
				if (now >= start && now < end) {
					return true;
				} else {
					return false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}

	}


	public static String DateformatTime(Date date) {
		//转换为日期
		long time = date.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		if (isToday(date)) { //今天
			return simpleDateFormat.format(date);
		} else if (isYesterday(date)) {//昨天，显示昨天
				return "昨天 " + simpleDateFormat.format(date);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
	}

	public static boolean isToday(Date date) {
		Date now = new Date();
		return (date.getYear() == now.getYear()) && (date.getMonth() == now.getMonth()) && (date.getDate() == now.getDate());
	}

	public static boolean isYesterday(Date date) {
		Date now = new Date();
		return (date.getYear() == now.getYear()) && (date.getMonth() == now.getMonth()) && (date.getDate() + 1 == now.getDate());
	}

	public static void main(String args[]) throws ParseException {
		String time1 = "2018-08-14 18:00:09";
		String time2 = "2015-07-20 00:00:09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(hourInterval(sdf.parse(time1), sdf.parse(time2)));
		Date date = sdf.parse(time1);
		System.out.println(isToday(date));
	}
}
