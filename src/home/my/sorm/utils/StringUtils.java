package home.my.sorm.utils;
/**
 * 封装了字符串常用的操作
 * @author Administrator
 *
 */
public class StringUtils {
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0,1)+str.substring(1);
		
	}
}
