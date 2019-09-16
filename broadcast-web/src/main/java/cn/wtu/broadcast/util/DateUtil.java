package cn.wtu.broadcast.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description: 日期时间帮助类，提供日期时间常用方法封装
 * @author huangjiakui
 * @date 2018年12月04日
 *
 */
public class DateUtil {
	public final static SimpleDateFormat sdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMMdd");
	public final static SimpleDateFormat sdFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat sdFormatSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static String format(Date date, SimpleDateFormat sdf) {
		return sdf.format(date);
	}

	public static String getNow() {
		return sdFormat3.format(new Date());
	}

	public static String getDate(Date date) {
		return sdFormat1.format(date);
	}

	public static String getDateForInt(long i) {
		if (i > 0) {
			return sdFormat3.format(new Date(i * 1000L));
		} else {
			return "";
		}
	}

	public static Date parse(String date) {
		try {
			return sdFormat2.parse(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	public static Date parse(String date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static int getWeekOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;

		return w == 0 ? 7 : w;
	}

	/**
	 * 获得 当前 或者参数时间是今年的第几周
	 * 
	 * @param dt
	 * @return
	 */
	public static int getWeekIndex(Date dt) {
		if (dt == null) {
			dt = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		long time = 0;
		try {
			// 今年 1月1号 0点
			time = sdf.parse(sdf.format(dt)).getTime();
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		}
		if (time == 0) {
			return -1;
		}
		// 从今年1月1号到现在过去的时间
		long lapsed = System.currentTimeMillis() - time + getWeekOfDate(new Date(time)) * 86400000;

		// 这个星期已经过去的时间
		long remainder = lapsed % (86400000 * 7);

		return (int) ((lapsed - remainder) / (86400000 * 7) + (remainder == 0 ? 0 : 1));
	}

	/**
	 * 获得 榜单批次号
	 * 
	 * @param time
	 *            如果time为空 则返回当期批次号 如果是今年第一周 则检查去年的最后一周
	 * @return
	 */
	public static int getBatchid(long time) {
		// 本周是今年的第几周
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int index = DateUtil.getWeekIndex(time == 0 ? null : new Date(time));
		int year = Integer.valueOf(sdf.format(time == 0 ? new Date() : new Date(time)));
		// 如果是第一周 则检查去年的最后一周
		if (index == 1) {
			index = DateUtil.getWeekIndex(time == 0 ? null : new Date(time - (8640000 * 7)));
			year -= 1;
		}
		return year * 100 + index;
	}

	/**
	 * 作者: yong.chen@rogrand.com <br/>
	 * 生成日期 ：2013年11月5日 Date
	 * 
	 * @param date
	 *            开始时间
	 * @param addTime
	 *            增加时间数量
	 * @param unit
	 *            时间单位 时 分 秒 日 月 年 等
	 * @return
	 */

	public static Date addTime(Date date, int addTime, int unit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(unit, addTime);
		return cal.getTime();
	}

	/**
	 * 获取时间date1与date2相差的秒数
	 * 
	 * @param date1
	 *            起始时间
	 * @param date2
	 *            结束时间
	 * @return 返回相差的秒数
	 */
	public static int getOffsetSeconds(Date date1, Date date2) {
		int seconds = (int) ((date2.getTime() - date1.getTime()) / 1000);
		return seconds;
	}

	/**
	 * 获取时间date1与date2相差的分钟数
	 * 
	 * @param date1
	 *            起始时间
	 * @param date2
	 *            结束时间
	 * @return 返回相差的分钟数
	 */
	public static int getOffsetMinutes(Date date1, Date date2) {
		return getOffsetSeconds(date1, date2) / 60;
	}

	/**
	 * 获取时间date1与date2相差的小时数
	 * 
	 * @param date1
	 *            起始时间
	 * @param date2
	 *            结束时间
	 * @return 返回相差的小时数
	 */
	public static int getOffsetHours(Date date1, Date date2) {
		return getOffsetMinutes(date1, date2) / 60;
	}

	/**
	 * 获取时间date1与date2相差的天数数
	 * 
	 * @param date1
	 *            起始时间
	 * @param date2
	 *            结束时间
	 * @return 返回相差的天数
	 */
	public static int getOffsetDays(Date date1, Date date2) {
		return getOffsetHours(date1, date2) / 24;
	}

	/**
	 * 获取时间date1与date2相差的周数
	 * 
	 * @param date1
	 *            起始时间
	 * @param date2
	 *            结束时间
	 * @return 返回相差的周数
	 */
	public static int getOffsetWeeks(Date date1, Date date2) {
		return getOffsetDays(date1, date2) / 7;
	}


	public static Date getCustomTime(Integer hour){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

}
