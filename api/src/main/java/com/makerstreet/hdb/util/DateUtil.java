package com.makerstreet.hdb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 日期处理帮助类 
 * 1.日期+天数 
 * 2.日期+月份 
 * 3.两个日期之间的月份差
 * 
 * @author mintie
 *
 */
public class DateUtil {
	/**
	 * 获取两个时间之间相差的描述
	 * 如果传入对象为null返回 -1
	 * @param startDate 开始时间
	 * @param endDate   截止时间
	 * @return
	 */
	 public static int getmmInterval(Date startDate,Date endDate){
		 //判断日期对象是否为null 为null 返回 -1
		 if(startDate == null || endDate == null){
			 return -1;
		 }
		 long startDateL = startDate.getTime();
		 long endDatL = endDate.getTime();
		 return (int) ((endDatL - startDateL)/1000);
	}
	 
	 /**
	 * 格式化字符串转成date   返回格式为 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date getStringToDate(String date){
		if(date == ""){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 格式化日子字符串   返回格式为 yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 格式化日子字符串   返回格式为  ddMMyy
	 * @param date
	 * @return
	 */
	public static String getDateString3(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
		return simpleDateFormat.format(date);
	}
	
	/**
	 * 格式化日子字符串   返回格式为 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getDateString2(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
	/**
	 * 某日期加上天数，得到加后的日期，返回日期格式为‘yyyy-mm-dd’的字符串
	 * 
	 * @param 日期
	 * @param 累加天数
	 * @return
	 */
	public static String getDatestrByAddDays(String dateStr, int days) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.valueOf(dateStr.substring(0, 4)).intValue(), Integer
				.valueOf(dateStr.substring(5, 7)).intValue() - 1, Integer
				.valueOf(dateStr.substring(8, 10)).intValue());
		c.add(Calendar.DAY_OF_YEAR, days);

		String thedate = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return thedate;// 过滤日期和时分秒之间的空格，并提出前面的日期
	}

	/**
	 * 某日期加上月份，得到加后的日期，返回日期格式为‘yyyy-mm-dd’的字符串
	 * 
	 * @param 日期
	 * @param 累加月份
	 * @return
	 */
	public static String getDatestrByAddMonths(String dateStr, int months) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.valueOf(dateStr.substring(0, 4)).intValue(), Integer
				.valueOf(dateStr.substring(5, 7)).intValue() - 1, Integer
				.valueOf(dateStr.substring(8, 10)).intValue());
		c.add(Calendar.MONTH, months);

		String thedate = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return thedate;// 过滤日期和时分秒之间的空格，并提出前面的日期
	}
	
	
	/**
	 * 某日期加上月份，得到加后的日期
	 * 
	 * @param 日期
	 * @param 累加月份
	 * @return
	 */
	public static Date getDateByAddss(Date date, int months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		return c.getTime();// 过滤日期和时分秒之间的空格，并提出前面的日期
	}
	
	/**
	 * 某日期加上天数，得到加后的日期
	 * 
	 * @param 日期
	 * @param 累加月份
	 * @return
	 */
	public static Date getDateByAddDD(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();// 过滤日期和时分秒之间的空格，并提出前面的日期
	}

	/**
	 * 计算两个日期的月份差
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 月份差
	 * @throws ParseException
	 */
	public static int getMonthDiff(String startDate, String endDate)
			throws ParseException {
		int monthday;
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate1 = fmt.parse(startDate);
		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate1);
		int sYear = starCal.get(Calendar.YEAR);
		int sMonth = starCal.get(Calendar.MONTH);
		int sDay = starCal.get(Calendar.DAY_OF_MONTH);
		
		Date endDate1 = fmt.parse(endDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate1);
		int eYear = endCal.get(Calendar.YEAR);
		int eMonth = endCal.get(Calendar.MONTH);
		int eDay = endCal.get(Calendar.DAY_OF_MONTH);
		monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

		// 这里计算零头的情况，根据实际确定是否要加1 还是要减1
		if (sDay < eDay) {
			monthday = monthday + 1;
		}

		return monthday;
	}
	
	/** 
     * 得到两个日期相差的天数 
     */  
    public static int getDiffDay(Date endDate, Date startDate) {  
        Calendar d1 = new GregorianCalendar();  
        d1.setTime(startDate);  
        Calendar d2 = new GregorianCalendar();  
        d2.setTime(endDate);  
        int days = d2.get(Calendar.DAY_OF_YEAR)- d1.get(Calendar.DAY_OF_YEAR);  
        System.out.println("days="+days);  
        int y2 = d2.get(Calendar.YEAR);  
        if (d1.get(Calendar.YEAR) != y2) {  
            do {  
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);  
                d1.add(Calendar.YEAR, 1);  
            } while (d1.get(Calendar.YEAR) != y2);  
        }  
        return days;  
    }  
	/**
	 * 获取上个月的字符串 格式为 yyyyMMdd
	 * @return
	 */
	public static String getLastMouth(){
		//Java获取当前日期的前一个月,前一天时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);//得到前一天
		calendar.add(Calendar.MONTH, -1);//得到前一个月
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		return year+""+month+""+date;
	}
	/**
	 * 获取上三个月的字符串 格式为 yyyyMMdd
	 * @return
	 */
	public static String getLastThreeMouth(){
		//Java获取当前日期的前一个月,前一天时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);//得到前一天
		calendar.add(Calendar.MONTH, -3);//得到前一个月
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		return year+""+NumberUtil.toFormat2Bit(month)+""+date;
	}
	/**
	 * 获取指定月份的最后一天日期
	 * 
	 */
	
	public   static   Date   getLastDayOfMonth(Date   sDate1)   {  
        Calendar   cDay1   =   Calendar.getInstance();  
        cDay1.setTime(sDate1);  
        final   int   lastDay   =   cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);  
        Date   lastDate   =   cDay1.getTime();  
        lastDate.setDate(lastDay);  
        return   lastDate;  
	}  
	
	/**
	 * 获取某月的最后一天
	 * @Title:getLastDayOfMonth
	 * @Description:
	 * @param:@param year
	 * @param:@param month
	 * @param:@return
	 * @return:String
	 * @throws
	 */
	public static String getLastDayOfMonth(int year,int month)
	{
		Calendar cal = Calendar.getInstance();
		//设置年份
		cal.set(Calendar.YEAR,year);
		//设置月份
		cal.set(Calendar.MONTH, month-1);
		//获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		
		return lastDayOfMonth;
	}

	public static void main(String[] args) {
//		System.out.println(getLastDayOfMonth(2015, 4));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		String lastDayOfMonth = sdf.format(getDateByAddDD(new Date(), 1));
//		System.out.println(lastDayOfMonth);
//		System.out.println(getDiffDay(new Date(2016, 2, 26),new Date(2015, 2, 23)));
	}
}
