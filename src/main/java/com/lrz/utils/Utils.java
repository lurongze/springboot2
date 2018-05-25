package com.lrz.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 对象转换工具类
 * @author MYLIKE
 *
 */
public class Utils {
	
	
	 /**
	   *日期格式包含年、月，如�:2011-08
	   */
	  public final static String YYYY = "yyyy";
	 /**
	   *日期格式包含年、月，如�:2011-08
	   */
	  public final static String YYYY_MM = "yyyy-MM";
	  /**
	   *日期格式包含年、�月、日，如:2011-08-01
	   */
	  public final static String YYYY_MM_DD = "yyyy-MM-dd";
	  
	  /**
	   *日期格式包含年、月、日、小时、分钟，如�:2011-08-01 12:00
	   */
	  public final static String YYYY_MM_DD_HHMM="yyyy-MM-dd HH:mm";
	  /**
	   *日期格式包含年、月、日、小时、分钟、秒，如�:2011-08-01 12:00:00
	   */
	  public final static String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	  
	  /**
	   *日期格式包含年、月、日、小时、分钟、秒，如�:2011-08-01 12:00:00
	   */
	  public final static String YYYY_MM_DD_HHMMSSSSSS = "yyyy-MM-dd HH:mm:ss.SSSS";
	  
	  
	  /**
	   *日期格式包含年、月、日、小时、分钟、秒，如�:12:00
	   */
	  public final static String HHMM = "HH:mm";
	  
	  /**
	   *日期格式包含年、月、日、小时、分钟、秒，如�:12:00:00
	   */
	  public final static String HHMMSS = "HH:mm:ss";
	  
	  /**
	   *紧凑型日期格式包含年月，如：201108
	   */
	  public final static String YYYYMM = "yyyyMM";
	  
	  /**
	   *紧凑型日期格式包含年月日，如：20110801
	   */
	  public final static String YYYYMMDD = "yyyyMMdd";
	  
	  /**
	   * 默认的日期格式
	   */
	  public final static String  DEFAULT_DATE_FORMAT = YYYY_MM_DD;
	  
	  
	  /**
	   * Double的默认格式
	   */
	  public static final String DOUBLE_FORMAT = "#0.00";
	  
	  /**
	   * Double的货币格式
	   */
	  public static final String DOUBLE_FORMAT_MONEY = "#,##0.00";
	  
	  /**
	   * Double 0
	   */
	  public static final Double MORE_THAN_ZERO = new Double("-0.00000001");

	/**
	 * 显示操作的消耗时间信息
	 * @param startTime
	 * @param endTime
	 * @param method
	 */
	public static void showTimeMsg(long startTime, long endTime, String method) {
		String msg = "方法" + method + "执行了" + (endTime - startTime) + "毫秒";
		System.out.println(msg);
	}
	/**
	 * 显示操作的消耗时间信息
	 * @param startTime
	 * @param method
	 * @return
	 */
	public static long showTimeMsg(long startTime, String method) {
		long endTime = System.currentTimeMillis();
		String msg = "方法" + method + "执行了" + (endTime - startTime) + "毫秒";
		System.out.println(msg);
		return endTime;
	}
	/**
	 * 判定对象内容是否非空
	 * @param object
	 * @return
	 */
	public static boolean isNotEmpty(Object object){
		return !isEmpty(object);
	}
	
	/**
	 * 如果是空的就返回"",而不是"null"
	 * @param object
	 * @return
	 */
	public static String getNotNull(String object){
		return getNotNull(object,"");
	}
	
	public static String getNotNull(String object,String strDefault){
		if(!isEmpty(object)){
			return object;
		}
		
		return strDefault;
	}	
	
	public static boolean isSameDate(Date date1,Date date2){
		if(date1!=null && date2!=null){
			return dateToString(date1).equals(dateToString(date2));
		}else if(date1==null && date2==null){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否相等
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isSameStr(String str1,String str2){
		str1 = transformStr(str1);
		str2 = transformStr(str2);
		
		if(isEmpty(str1)) {
			if(isEmpty(str2)) {
				return true;
			} else {
				return false;
			}
		} else {
			if(isEmpty(str2)) {
				return false;
			} else {
				return str1.equals(str2);
			}
		}
	}
	
	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零
	 * 要用到正则表达式
	 */
	public static String digitUppercase(double n){
		String fraction[] = {"角", "分"};
	    String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	    String unit[][] = {{"元", "万", "亿"},
	                 {"", "拾", "佰", "仟"}};

	    String head = n < 0? "负": "";
	    n = Math.abs(n);
	    
	    String s = "";
	    for (int i = 0; i < fraction.length; i++) {
	        s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
	    }
	    if(s.length()<1){
		    s = "整";	
	    }
	    int integerPart = (int)Math.floor(n);

	    for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
	        String p ="";
	        for (int j = 0; j < unit[1].length && n > 0; j++) {
	            p = digit[integerPart%10]+unit[1][j] + p;
	            integerPart = integerPart/10;
	        }
	        s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
	    }
	    return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
	}

	
	/**
	 * 判定对象内容是否为空
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object){
		return object == null || object.equals("");
	}
	
	
	
	/**
	 * 将Double转换为String
	 * @param value
	 * @return
	 */
	public static String doubleToString(Double value){
		return doubleToString(value, DOUBLE_FORMAT);
	}
	
	/**
	 * 使用指定的格式，将Double转换为String
	 * @param value
	 * @param format
	 * @return
	 */
	public static String doubleToString(Double value,String format){
		if(value == null)return null;
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(value);
	}
	
	public static String toString(Object object){
		String result = objectToString(object);
		if(result == null)result = "";
		return result;
	}
	
	/**
	 * 字符串截取
	 * @param content
	 * @param maxLength
	 * @return
	 */
	public static String cutString(String content,int maxLength){
		if(content!=null){
			if(content.length()>maxLength && maxLength>3){
				content = content.substring(0,maxLength-3);
				String last = content.substring(content.length()-1);
				if(last.equals(",")||last.equals("，")
						||last.equals("。")||last.equals(".")
						||last.equals("！")||last.equals("!")){
					content = content.substring(0,content.length()-1);
				}
				content = content+"...";
			}
		}
		return content;
	}
	/**
	 * 将Object转换为Long
	 * @param object
	 * @return
	 */
	public static Long objectToLong(Object object){
		if(isNotEmpty(object)){
			String str = object.toString();
			if(str.contains(".")) {
				str = str.substring(0, str.indexOf("."));
			}
			return Long.valueOf(str);
		}
		return new Long(0);
	}
	/**
	 * 将Object转换为Long
	 * @param object
	 * @return
	 */
	public static Boolean objectToBoolean(Object object){
		if(object!=null){
			return Boolean.valueOf(object.toString());
		}
		return null;
	}
	
	/**
	 * 将Object转换为Integer
	 * @param object
	 * @return
	 */
	public static Integer objectToInteger(Object object){
		if(object!=null){
			return Integer.valueOf(object.toString());
		}
		return null;
	}
	
	/**
	 * 将Object转换为String
	 * @param object
	 * @return
	 */
	public static String objectToString(Object object){
		if(object!=null){
			if(object instanceof Date){
				Date date = (Date) object;
				return dateToString(date);
			}
			return object.toString();
		}
		return null;
	}
	public static String arrayToString(Object[] array){
		if(array==null||array.length==0){
			return "";
		}else{
			String result = "";
			for(Object obj : array){
				result += obj+",";
			}
			if(result.length()>0){
				result = result.substring(0,result.length()-1);
			}
			return result;
		}
	}
	
	public static Timestamp objectToTimestamp(Object object) throws ParseException{
		if(object!=null){
			if(object instanceof Timestamp){
				return (Timestamp) object;
			}else if(object instanceof Date){
				Date date = (Date) object;
				return new Timestamp(date.getTime());
			}else {
				return stringToTimestamp(object.toString());
			}
		}else return null;
	}
	public static Date objectToDate(Object object) throws ParseException{
		if(object!=null){
			if(object instanceof Timestamp){
				return (Timestamp) object;
			}else if(object instanceof Date){
				Date date = (Date) object;
				return new Timestamp(date.getTime());
			}else {
				return stringToTimestamp(object.toString());
			}
		}else return null;
	}
	  /**
	   * 将String转换为Date，使用特定的日期格式
	   * @param string
	   * @param format
	   * @return
	   * @throws ParseException
	   */
	  public static Date stringToDate(String string,String format) throws ParseException{
		  if(Utils.isEmpty(string)){
			  return null;
		  }
		  return new SimpleDateFormat(format).parse(string);
	  }
	  
	  /**
	   * 将String转换为java.sql.Date，使用特定的日期格式
	   * @param date
	   * @param format
	   * @return
	   */
	  public static java.sql.Date GetSqlDate(String date,String format) throws ParseException {
		  if(isEmpty(date)){
			  return null;
		  }
		  SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);  
		  Date datet = bartDateFormat.parse(date);
		  if(datet!=null)
			  return new java.sql.Date(datet.getTime());  
		  else return null;
	  }
	  
	  /**
	   * 将String转换为Date，使用特定的日期格式
	   * @param string
	   * @param format
	   * @return
	   * @throws ParseException
	   */
	  public static Timestamp stringToTimestamp(String string,String format) throws ParseException{
		  if(isEmpty(string)){
			  return null;
		  }
		  Date date = new SimpleDateFormat(format).parse(string);
		  if(date!=null)
		  return new Timestamp(date.getTime());
		  else return null;
	  }
	  
	  /**
	   * 将String转换为Date
	   * @param string
	   * @return
	   * @throws ParseException
	   */
	  public static Timestamp stringToTimestamp(String string) throws ParseException{
		  return stringToTimestamp(string, DEFAULT_DATE_FORMAT);
	  }
	  
	  /**
	   * 将String转换为Date
	   * @param string
	   * @return
	   * @throws ParseException
	   */
	  public static Date stringToDate(String string) throws ParseException{
		  return stringToDate(string, DEFAULT_DATE_FORMAT);
	  }
	  
	  /**
	   * 将Date转换为String，使用特定的日期格式
	   * @param date
	   * @param format
	   * @return
	   */
	  public static String dateToString(Date date,String format){
		  if(date==null)return null;
		  return new SimpleDateFormat(format).format(date);
	  }
	  
	  /**
	   * 将Date转换为String，使用特定的日期格式
	   * @param date
	   * @param format
	   * @return
	   */
	  public static String timeToString(Date date){
		  if(date==null)return null;
		  return new SimpleDateFormat(Utils.YYYY_MM_DD_HHMMSS).format(date);
	  }
	  
	  public static int getHour(Date date){
		  if(date == null)return -1;
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  return calendar.get(Calendar.HOUR_OF_DAY);
	  }
	  
	  public static int getMinite(Date date){
		  if(date == null)return -1;
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  return calendar.get(Calendar.MINUTE);
	  }
	  
	  /**
	   * 将Date转换为String
	   * @param date
	   * @return
	   */
	  public static String dateToString(Date date){
		  return dateToString(date, DEFAULT_DATE_FORMAT);
	  }
	  /**
	   * 两个日期之间的间隔天数
	   * @param d1
	   * @param d2
	   * @return
	   */
	  public static Long getTwoDateDistance(Date  d1, Date d2){
		  if(d1==null || d2==null){
			  return null;
		  }else{
			  try {
				Date dd1 = stringToDate(dateToString(d1));
				Date dd2 = stringToDate(dateToString(d2));
				long distance = Math.abs((dd1.getTime()-dd2.getTime())/(1000*60*60*24));
				return distance;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  }
		  return null;
	  }
	  
	  public static Timestamp timeStamp(){
		  return new Timestamp(System.currentTimeMillis());
	  }
	  
	  @SuppressWarnings("deprecation")
	  public static Timestamp maxTimestamp(Timestamp time){
		  time.setHours(23);
		  time.setMinutes(59);
		  time.setSeconds(59);
		  return time;
	  }
	  
	  
	  @SuppressWarnings("deprecation")
	  public static Date minTimestamp(Timestamp time){
		  time.setHours(0);
		  time.setMinutes(0);
		  time.setSeconds(0);
		  return time;
	  }
	  
	@SuppressWarnings("deprecation")
	public static Date maxDate(Date time) {
		if(0==time.getHours()){
			time.setHours(23);
		}
		if(0==time.getMinutes()){
			time.setMinutes(59);
		}
		if(0==time.getSeconds()){
			time.setSeconds(59);
		}
		return time;
	}
	public static Date minDate(Date time) {
		if(0==time.getHours()){
			time.setHours(0);
		}
		if(0==time.getMinutes()){
			time.setMinutes(0);
		}
		if(0==time.getSeconds()){
			time.setSeconds(0);
		}
		return time;
	}
	
	  @SuppressWarnings("deprecation")
	  public static int getYear(Date date){
		  if(date==null){
			  date = new Date();
		  }
		  return date.getYear()+1900;
	  }
	
	  @SuppressWarnings("deprecation")
	  public static Long getAge(Date date){
		  if(date!=null){
			  int age = new Date().getYear()-date.getYear();
			  return Long.valueOf(age);
		  }
		  return null;
	  }
	  
	  /**
	   * 忽略大小写，判定两个字符串内容是否相同
	   * @param value1
	   * @param value2
	   * @return
	   */
	  public static boolean equalsIgnoreCase(String value1, String value2) {
		  if(value1 == null && value2 == null)return true;
		  if(value1 != null && value2 != null){
			  if(value1.toLowerCase().equals(value2.toLowerCase())){
				  return true;
			  }
		  }
		  return false;
	 }
	public static boolean endWithIgnoreCase(String value1, String value2) {
		 if(value1 == null && value2 == null)return true;
		  if(value1 != null && value2 != null){
			  if(value1.toLowerCase().endsWith(value2.toLowerCase())){
				  return true;
			  }
		  }
		  return false;
	}  
	public static String handleTelephone(String tel){
		String temp = tel;
		if(tel!=null){
			if(tel.length()>7){
				temp = tel.substring(0,3)+"****"+tel.substring(7,tel.length());
			}else if(tel.length()>4){
				temp = tel.substring(0,3)+"****";
			}
		}
		return temp;
	
	}
	/**
	 * 字符串空格+,主要针对页面传递fid
	 * 
	 * @param str
	 * @return
	 */
	public static String formatStringblank(String str) {
		if(str!=null){
			if (str.contains(" ")) {
				str = str.replace(" ", "+");
			}
	
			return str;
		}
		return str;
	}
	
	public static boolean isNumber(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	/**  
     * 判断字段是否为正浮点数正则表达式 >=0 符合返回ture 
     * @param str 
     * @return boolean 
     */  
    public static boolean isDoubleNegative(Double d) { 
        if(null==d){
        	return false;
        }
        if(d.compareTo(MORE_THAN_ZERO)<0){
        	return false;
        }
        return true;
    } 
    
	public static boolean stringToBoolean(String value) {
		if(value!=null){
			if(equalsIgnoreCase(value, "true")||equalsIgnoreCase(value, "false")){
				return Boolean.valueOf(value);
			}if(value.equals("是")){
				return true;
			}else if(value.equals("否")){
				return false;
			}else{
				try {
					int valueOf = Integer.valueOf(value);
					if(valueOf>0)return true;
					else return false;
				} catch (Exception e) {
					
				}
			}
		}
		return false;
	}
	
	public static String booleanToString(boolean bool) {
		if(bool)return "1";
		else return "0";
	}
	public static String yesOrNo(String c) {
		if(c!=null){
			return c.equals("1")?"是":"否";
		}
		return null;
	}
	
	public static Long booleanToLong(boolean bool) {
		if(bool)return 1l;
		else return 0l;
	}
	
	public static String getRandomString() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millsecond = calendar.get(Calendar.MILLISECOND);
		String ss = calendar.get(Calendar.YEAR)
				+ (month > 9 ? "" + month : "0" + month)
				+ (day > 9 ? "" + day : "0" + day)+"-"
				+ (hour > 9 ? "" + hour : "0" + hour)
				+ (minute > 9 ? "" + minute : "0" + minute)
				+ (second > 9 ? "" + second : "0" + second)+"-"
				+ (millsecond > 9 ? "" + millsecond : "0" + millsecond);
		ss += new Random().nextInt(1000);
		return ss;
	}
	public static String getDateString() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String ss = calendar.get(Calendar.YEAR)
				+ (month > 9 ? "" + month : "0" + month)
				+ (day > 9 ? "" + day : "0" + day)+"-"
				+ (hour > 9 ? "" + hour : "0" + hour)
				+ (minute > 9 ? "" + minute : "0" + minute)
				+ (second > 9 ? "" + second : "0" + second);
		return ss;
	}
	
	/**
	 * 转码
	 * @param src
	 * @return
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}
	
	public static String buildExcelName(String objectName){
		String excelName = getDateString();
		if(isEmpty(objectName)){
			excelName = "导出数据-"+excelName;
		}else{
			excelName = objectName+"-"+excelName;
		}
		return excelName;
	}
	
	public static Date getDateByDistance(Date date,int distance){
		Calendar c = Calendar.getInstance();
		if(date!=null)
		c.setTime(date);
		c.add(Calendar.DATE, distance);
		return c.getTime();
	}
	
	public static Date[] getDateRange(String text){
		Date[] dates = new Date[2];
		try {
			Date today = new Date();
			Calendar c = Calendar.getInstance();
			Date start = null;
			if(text.equals("今天")){
				dates[0] = stringToDate(dateToString(today));
				dates[1] = maxDate(today); 
			}else if(text.equals("昨天")){
				start = getDateByDistance(today, -1);
				dates[0] = stringToDate(dateToString(start));
				dates[1] = maxDate(start); 
			}else if(text.equals("过期")){
				start = getDateByDistance(today, -1);
				dates[0] = stringToDate("1900-01-01");
				dates[1] = maxDate(start); 
			}else if(text.equals("明天")){
				start = getDateByDistance(start, 1);
				dates[0] = stringToDate(dateToString(start));
				dates[1] = maxDate(start); 
			}else if(text.equals("本周")){
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-1;
				start = getDateByDistance(today, -dayOfWeek);
				dates[0] = stringToDate(dateToString(start));
				dates[1] = maxDate(getDateByDistance(start, 6)); 
			}else if(text.equals("本月")){
				start = getDateByDistance(today, c.get(Calendar.DAY_OF_MONTH)*-1+1);
				dates[0] = stringToDate(dateToString(start));
				dates[1] = maxDate(getDateByDistance(start, c.getActualMaximum(Calendar.DAY_OF_MONTH)-1)); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(dateToString(dates[0]));
//		System.out.println(dateToString(dates[1]));
		return dates;
	}
	
	public static int getMonthLastDay(Date date){
		Calendar c = Calendar.getInstance();
		if(date!=null)
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public static List<Object> objectsToList(Object...values){
		return Arrays.asList(values);
	}
	

	public static Double objectToDouble(Object object) {
		if(isNotEmpty(object)){
			return Double.valueOf(object.toString());
		}
		return new Double(0);
	}
		
	public static String[] listToArray(List<String> list) {
		if(isEmpty(list) || list.size() ==0) {
			return null;
		} else {
			String[] array = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				array[i] = list.get(i);
			}
			return array;
		}
	}
	
	public static List<String> arrayToList(String[] array) {
		if(isEmpty(array) || array.length ==0) {
			return new ArrayList<String>();
		} else {
			List<String> stringList = new ArrayList<String>();
			for (String string : array) {
				stringList.add(string);
			}
			return stringList;
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String[] stringToArray(String... str) {
		if(isEmpty(str)) {
			return null;
		}
		String[] array = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			array[i] = str[i];
		}
		
		return array;
	}
	public static String doubleToString1(double money) {
		return Utils.doubleToString(money,Utils.DOUBLE_FORMAT);
	}
	

	
	@SuppressWarnings("unchecked")
	public static boolean isListEmpty(List list) {
		if(isEmpty(list)) {
			return true;
		}
		if(list.size() == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isArrayEmpty(Object[] objs) {
		if(isEmpty(objs)) {
			return true;
		}
		if(objs.length == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 把字符串去空格，如果为null，转换为"";
	 * @param str
	 * @return
	 */
	public static String transformStr(String str) {
		return isEmpty(str)?"":str.trim();
	}
	
	public static int getRandInt() {
		 
        Random random = new Random();
 
        return random.nextInt(10);
 
    }
	
	public static String getRandomCardNumber(){
		return Utils.getExchangeCode().toString()+"C";
	}
    public static StringBuffer getExchangeCode() {
 
        StringBuffer randomValidateCode = new StringBuffer();
 
        for (int j = 0; j < 8; j++) {
            int one = getRandInt();// 获得一个随机数
            if (j == 0) {
                randomValidateCode.append(one).append("#");// 添加随机数和分隔符
            } else if (j > 0) {
                String[] all = randomValidateCode.toString().split("#");// 分割成字符串数组
                // 调用是否重复方法teseEquals
                if (Utils.teseEquals(all, one,
                        randomValidateCode) == 1) {
                    randomValidateCode.append(one).append("#");// 如果不重复就添加随机数和分隔符
                } else {
                    j--;// 如果重复的话将j-1
                }
            }
        }
        // 对得到的8位随机数用分隔符进行分割
        String[] result = randomValidateCode.toString().split("#");
        StringBuffer res = new StringBuffer();
        for (int r = 0; r < result.length; r++) {
            res.append(result[r]);
        }
        return res;
    }
 
    // 测试是否重复
    public static int teseEquals(String[] all, int one,
            StringBuffer randomValidateCode) {
        for (int i = 0; i < all.length; i++) {
            if (one == Integer.parseInt(all[i])) {
                return 0;// 重复就返回0
            }
        }
        return 1;// 不重复返回1
    }

	public static String md5(String password) {

		try {
			// 得到一个信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			// 把每一个byte 做一个与运算 0xff;
			for (byte b : result) {
				// 与运算
				int number = b & 0xff;// 加盐
				String str = Integer.toHexString(number);
				if (str.length() == 1) {
					buffer.append("0");
				}
				buffer.append(str);
			}

			// 标准的md5加密后的结果
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}
    
    public static void main(String[] args) throws ParseException, IOException {
    	System.out.println(digitUppercase(1020435214));
	}
}
