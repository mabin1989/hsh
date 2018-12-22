/**
 * 文件名：@DateUtil.java <br>
 * 包名：com.sml.spring.service.common <br>
 * 项目名：ys <br>
 * @author zlf-xtwin <br>
 */
package com.work.demo.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

import strman.Strman;

/**
* 功能：日期处理工具类 <br>
*
* @author gr <br>
* @version 2018年5月27日 上午10:41:58 <br>
*/
public class GrDateUtil {
	
	/**
	* 功能：获取日期区间的开始日期 <br>
	* 
	* @param startdate 格式为 "yyyy-MM-dd"
	* @author gr <br>
	* @version 2018年5月27日 上午10:48:26 <br>
	*/
	public static Date getStartDateForSql(String startdate) {
		return parse(startdate, "yyyy-MM-dd");
	}
	
	/**
	 * 功能：获取日期区间的结束日期(不包含) <br>
	 * 
	 * @param enddate 格式为 "yyyy-MM-dd"
	 * @author gr <br>
	 * @version 2018年5月27日 上午10:48:26 <br>
	 */
	public static Date getEndDateForSql(String enddate) {
		Date end = parse(enddate, "yyyy-MM-dd");
		end = add(end, Calendar.DAY_OF_MONTH, 1);
		end = toZero(end);
		return end;
	}
	
	/**
	 * 功能：将日期对象更新到零点 <br>
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年4月27日 上午8:00:40 <br>
	 */
	public static Date toZero(Date date) {
		if (null == date) {
			return date;
		}
		
		return parse(format(date, "yyyyMMdd") + "000000", "yyyyMMddHHmmss");
	}
	
	/**
	 * 功能：取得当前日期的某个字段值 <br>
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年4月19日 下午3:03:14 <br>
	 */
	public static int getField(int field) {
		return getField(new Date(), field);
	}
	
	/**
	 * 功能：取得日期的某个字段值 <br>
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年4月19日 下午3:00:32 <br>
	 */
	public static int getField(Date date, int field) {
		if (null == date) {
			return -1;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return c.get(field);
	}
	
	/**
	 * 功能：更新时间 <br>
	 * 
	 * @param date 要进行更新的日期对象，若该值为null，则不进行计算
	 * @param field 要进行更新的字段，如月份、年份、周、日等等，具体请参考java.util.Calendar中的常量定义，如java.util.Calendar.DAY_OF_MONTH等
	 * @param amount 要进行更新的值
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年4月27日 上午7:58:32 <br>
	 */
	public static Date set(Date date, int field, int amount) {
		if (null == date || amount == 0) {
			return date;
		}
		
		// 创建日历对象
		Calendar c = Calendar.getInstance();
		
		// 将日历时间置为参数指定的时间
		c.setTime(date);
		
		// 对时间进行偏移计算
		c.set(field, amount);
		
		// 返回计算之后的时间
		return c.getTime();
	}

	/**
	 * 功能：对日期的指定字段做偏移计算 <br>
	 * 
	 * @param date 要进行偏移计算的日期对象，若该值为null，则不进行计算
	 * @param field 要进行偏移计算的字段，如月份、年份、周、日等等，具体请参考java.util.Calendar中的常量定义，如java.util.Calendar.DAY_OF_MONTH等
	 * @param amount 要进行计算的偏移量，若该值为大于0，则给对应字段加上该值，反之则相反；若该值等于0，则不进行计算
	 * 
	 * @return 若date为null则返回null；否则，返回按上述规则计算后的日期对象
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月30日 上午8:18:06 <br>
	 */
	public static Date add(Date date, int field, int amount) {
		if (null == date || amount == 0) {
			return date;
		}
		
		// 创建日历对象
		Calendar c = Calendar.getInstance();
		
		// 将日历时间置为参数指定的时间
		c.setTime(date);
		
		// 对时间进行偏移计算
		c.add(field, amount);
		
		// 返回计算之后的时间
		return c.getTime();
	}
	
	/**
	 * 功能：按照yyyy-MM-dd HH:mm:ss格式转为日期 <br>
	 * 
	 * @param dateTime 具有yyyy-MM-dd HH:mm:ss格式的日期时间字符串，若该值不是这种格式，你将获得一个java.lang.RuntimeException
	 * 
	 * @return 若date参数为null或空串，则返回null；否则返回解析后的日期时间对象
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月27日 下午9:14:56 <br>
	 */
	public static Date parseDateTime(String dateTime) {
		return parse(dateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 功能：按照yyyy-MM-dd格式转为日期 <br>
	 * 
	 * @param date 具有yyyy-MM-dd格式的日期时间字符串，若该值不是这种格式，你将获得一个java.lang.RuntimeException
	 * 
	 * @return 若date参数为null或空串，则返回null；否则返回解析后的日期时间对象，解析后的日期对象的时间值为：00:00:00
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月27日 下午9:14:10 <br>
	 */
	public static Date parseDate(String date) {
		return parse(date, "yyyy-MM-dd");
	}
	
	/**
	 * 功能：按照指定的格式转为日期 <br>
	 * 
	 * @param date 具有format格式的日期时间字符串，若该值不是这种格式，你将获得一个java.lang.RuntimeException
	 * @param format 格式化字符串，如yyyy-MM-dd、yyyy-MM-dd HH:mm:ss等
	 * 
	 * @return 若date参数为null或空串，则返回null；否则返回解析后的日期时间对象
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月27日 下午9:11:53 <br>
	 */
	public static Date parse(String date, String format) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 功能：按照格式yyyy-MM-dd HH:mm:ss将日期对象格式化为字符串 <br>
	 * 
	 * @param date 日期对象
	 * 
	 * @return 若date为null，则返回null，否则返回具有yyyy-MM-dd HH:mm:ss格式的字符串
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月30日 上午8:45:22 <br>
	 */
	public static String formatDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 功能：按照格式yyyy-MM-dd将日期对象格式化为字符串 <br>
	 * 
	 * @param date 日期对象
	 * 
	 * @return 若date为null，则返回null，否则返回具有yyyy-MM-dd格式的字符串
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月30日 上午8:44:27 <br>
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}
	
	/**
	 * 功能：按照指定的格式将日期对象格式化为字符串 <br>
	 * 
	 * @param date 日期对象
	 * @param format 格式化字符串，如yyyy-MM-dd、yyyy-MM-dd HH:mm:ss等
	 * 
	 * @return 若date为null，则返回null，否则返回具有format指定格式的字符串
	 *
	 * @author zlf-xtwin <br>
	 * @version 2017年3月30日 上午8:40:16 <br>
	 */
	public static String format(Date date, String format) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 *
	 * 功能：获取月度的开始截至日期
	 * 
	 * @param strMonth 月度格式 yyyy-MM
	 * @return String[] 开始日期 rst[0] 截至日期 rst[1] 格式 yyyy-MM-dd HH:mm:ss
	 *
	 * @author gr
	 * @version 2017年10月11日 下午4:55:10
	 */
	public static String[] getMonthStartEnd(String strMonth) throws ParseException {
		
		String[] rst = new String[2];
		String fmt01 = "yyyy-MM";
		String fmt03 = "yyyy-MM-dd HH:mm:ss";
		
		SimpleDateFormat sdf01 = new SimpleDateFormat(fmt01);
		SimpleDateFormat sdf03 = new SimpleDateFormat(fmt03);
		
		Date date01 = sdf01.parse(strMonth);
		Calendar cl = Calendar.getInstance();
		cl.setTime(date01);
		
		cl.set(Calendar.DAY_OF_MONTH, 1);
		rst[0] = sdf03.format(cl.getTime());
		
		cl.add(Calendar.MONTH, 1);
		cl.set(Calendar.DAY_OF_MONTH, 1);
		rst[1] = sdf03.format(cl.getTime());
		
		return rst;
	}	
	
	/**
	 *
	 * 功能：获取月度的开始截至日期 Date 类型
	 * 
	 * @param currentDate 当前日期
	 * @return String[] 开始日期 rst[0] 截至日期 rst[1] 格式 yyyy-MM-dd HH:mm:ss
	 *
	 * @author gr
	 * @version 2017年10月11日 下午4:55:10
	 */
	public static Date[] getMonthStartEnd01(Date currentDate) throws ParseException {
		
		Date[] rst = new Date[2];
		currentDate = toZero(currentDate);
		
		Calendar cl = Calendar.getInstance();
		cl.setTime(currentDate);
		cl.set(Calendar.DAY_OF_MONTH, 1);
		rst[0] = cl.getTime();
		
		Calendar cl01 = Calendar.getInstance();
		cl01.setTime(currentDate);
		cl01.add(Calendar.MONTH, 1);
		cl01.set(Calendar.DAY_OF_MONTH, 1);
		rst[1] = cl01.getTime();
		
		return rst;
	}	
	
	/**
	 *
	 * 功能：获取月度的日期字符串数组
	 * 
	 * @author gr
	 * @version 2017年10月11日 下午4:55:10
	 */
	public static String[] getDaysOfMonth(Date currentDate) throws ParseException {
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(currentDate);
		int dateOfMonth =  cal.getActualMaximum(Calendar.DATE); 
		String[] days = new String[dateOfMonth];
		for (int i = 0; i < days.length; i++) {
			days[i] = Strman.leftPad(String.valueOf(i+1), "0", 2);
		}
		
		return days;
	}
	
	public static void main(String[] args) {
		String enddate = new String("2018-05-31");
		System.out.println(formatDateTime(getEndDateForSql(enddate)));
	}
}