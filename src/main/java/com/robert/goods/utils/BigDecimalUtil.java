package com.robert.goods.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author robert
 *
 */

public class BigDecimalUtil {
	
	/**
	 * @param str
	 * @return str 除以 10
	 */
	public static String divide10(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		BigDecimal decimal = new BigDecimal(str);
		BigDecimal decimal2 = new BigDecimal(10);
		BigDecimal result = decimal.divide(decimal2, 2, RoundingMode.HALF_DOWN);
		return result.toString();
	}

	/**
	 * @param str
	 * @return str 除以 n
	 */
	public static String divide(String str,double n){
		if(StringUtils.isBlank(str)){
			return null;
		}
		BigDecimal decimal = new BigDecimal(str);
		BigDecimal decimal2 = new BigDecimal(n);
		BigDecimal result = decimal.divide(decimal2, 2, RoundingMode.HALF_DOWN);
		return result.toString();
	}

	/**
	 * @param str
	 * @return str 乘以 n
	 */
	public static String multiply (String str,double n){
		if(StringUtils.isBlank(str)){
			return null;
		}
		BigDecimal decimal = new BigDecimal(str);
		BigDecimal decimal2 = new BigDecimal(n);
		BigDecimal result = decimal.multiply(decimal2);
		return result.toString();
	}


	/**
	 * decimal1 是否小于 decimal2
	 * @param decimal1Str 数字字符
	 * @param decimal2Str 数字字符
	 * @return decimal1 < decimal2 
	 */
	public static boolean lessThanStr(String decimal1Str, String decimal2Str){
		BigDecimal decimal1 = new BigDecimal(decimal1Str);
		BigDecimal decimal2 = new BigDecimal(decimal2Str);
		return lessThan(decimal1,decimal2);
	}

	/**
	 * decimal1 是否小于 decimal2
	 * @param decimal1Str 数字字符
	 * @param decimal2Str 数字字符
	 * @return decimal1 < decimal2
	 */
	public static boolean lessThanStr(Double decimal1Str, Double decimal2Str){
		BigDecimal decimal1 = new BigDecimal(decimal1Str);
		BigDecimal decimal2 = new BigDecimal(decimal2Str);
		return lessThan(decimal1,decimal2);
	}

	/**
	 * decimal1 是否小于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 < decimal2 
	 */
	public static boolean lessThan(BigDecimal decimal1, BigDecimal decimal2){
		int compare = decimal1.compareTo(decimal2);
		if(compare == -1){
			return true;
		}
		return false;
	}

	/**
	 * decimal1 是否小于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 < decimal2 
	 */
	public static boolean lessThan(BigDecimal decimal1, int decimal2){
		return lessThan(decimal1,new BigDecimal(decimal2));
	}

	/**
	 * decimal1 是否大于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 > decimal2 
	 */
	public static boolean greaterThan(BigDecimal decimal1, BigDecimal decimal2){
		int compare = decimal1.compareTo(decimal2);
		if(compare == 1){
			return true;
		}
		return false;
	}

	/**
	 * decimal1 是否等于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 == decimal2 
	 */
	public static boolean equalTo(BigDecimal decimal1, BigDecimal decimal2){
		int compare = decimal1.compareTo(decimal2);
		if(compare == 0){
			return true;
		}
		return false;
	}

	/**
	 * decimal1 是否等于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 == decimal2 
	 */
	public static boolean equalTo(BigDecimal decimal1, int decimal2){
		return equalTo(decimal1,new BigDecimal(decimal2));
	}

	/**
	 * decimal1 是否小于等于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 <= decimal2 
	 */
	public static boolean lessThanOrEqualTo(BigDecimal decimal1, BigDecimal decimal2){
		int compare = decimal1.compareTo(decimal2);
		if(compare == -1 || compare == 0){
			return true;
		}
		return false;
	}

	/**
	 * decimal1 是否大于等于 decimal2
	 * @param decimal1
	 * @param decimal2
	 * @return decimal1 >= decimal2 
	 */
	public static boolean greaterThanOrEqualTo(BigDecimal decimal1, BigDecimal decimal2){
		int compare = decimal1.compareTo(decimal2);
		if(compare == 1 || compare == 0){
			return true;
		}
		return false;
	}
}
