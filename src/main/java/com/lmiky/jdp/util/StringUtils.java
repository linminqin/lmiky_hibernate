package com.lmiky.jdp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 字符串工具
 * @author lmiky
 * @date 2013-4-25
 */
public class StringUtils {
	private static HanyuPinyinOutputFormat SPELLFORMAT = new HanyuPinyinOutputFormat();
	static {
		SPELLFORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE); 
		SPELLFORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE); 
		SPELLFORMAT.setVCharType(HanyuPinyinVCharType.WITH_V); 
	}
	
	/**
	 * 给URL添加参数
	 * @author lmiky
	 * @date 2013-4-25
	 * @param url
	 * @param parameterName
	 * @param parameterValue
	 * @return
	 */
	public static String addUrlParameter(String url, String parameterName, String parameterValue) {
		if(url.indexOf("?") == -1) {
			url += "?";
		} else {
			url += "&";
		}
		url += parameterName + "=" + parameterValue;
		return url;
	}
	
	/**
	 * 获取请求地址URI
	 * @author lmiky
	 * @date 2014-1-15
	 * @param url
	 * @return
	 */
	public static String getRequestURI(String url) {
		if(url.indexOf("?") == -1) {
			return url;
		}
		return url.substring(0, url.indexOf("?"));
	}
	
	/**
	 * 获取URL地址参数
	 * @author lmiky
	 * @date 2014-1-15
	 * @param url
	 * @return
	 */
	public static Map<String, String[]> getUrlParameters(String url) {
		Map<String, String[]> parameterMap = new HashMap<String, String[]>();
		if(url.indexOf("?") == -1) {
			return parameterMap;
		}
		url = url.substring(url.indexOf("?") + 1);
		String[] params = url.split("&");
		for(String param : params) {
			String[] keyAndValues = param.split("=");
			String key = keyAndValues[0];
			String value = keyAndValues.length > 1 ? keyAndValues[1] : "";
			String[] values = parameterMap.get(key);
			if(values == null) {
				values = new String[]{value};
			} else {
				String[] newValues = new String[values.length + 1];
				for(int i=0; i<values.length - 1; i++) { 
					newValues[i] = values[i];
				}
				newValues[values.length] = value;
				values = newValues;
			}
			parameterMap.put(key, values);
		}
		return parameterMap;
	}
	
	/**
	 * 判断是否中文
	 * @author lmiky
	 * @date 2013-10-21
	 * @param resource
	 * @return
	 */
	public static boolean isChinese(String resource) {    
        String regex = "[\\u4e00-\\u9fa5]";    
        Pattern pattern = Pattern.compile(regex);    
        Matcher matcher = pattern.matcher(resource);    
        return matcher.find();    
    }
	
	/**
	 * 获取中文的拼音字母
	 * @author lmiky
	 * @date 2013-10-21
	 * @param chineseStr
	 * @return
	 */
	public static String chinese2Spell(String resource){  
		if(org.apache.commons.lang3.StringUtils.isBlank(resource)) {
			return "";
		}
		String ret = "";
		char[] resourceChars = resource.toCharArray();
		for (int i = 0; i < resourceChars.length; i++) {
			char c = resourceChars[i];
			if (isChinese(Character.toString(c))) {
				try {
					ret += PinyinHelper.toHanyuPinyinStringArray(c, SPELLFORMAT)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					return "";
				}
			} else {	//如果不是中文
				ret += Character.toString(c);
			}
		}
		return ret;
    } 
	
	/**
	 * 获取中文的拼音首字母
	 * @author lmiky
	 * @date 2013-10-21
	 * @param resource
	 * @return
	 */
	public static String getChineseFirstLetterl(String resource){  
		if(org.apache.commons.lang3.StringUtils.isBlank(resource)) {
			return "";
		}
		String ret = "";
		char[] resourceChars = resource.toCharArray();
		for (int i = 0; i < resourceChars.length; i++) {
			char c = resourceChars[i];
			if (isChinese(Character.toString(c))) {
				try {
					String spell = PinyinHelper.toHanyuPinyinStringArray(c, SPELLFORMAT)[0];
					ret += Character.toString(spell.charAt(0));	//拼音的第一个字母
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					return "";
				}
			} else {
				ret += Character.toString(c);
			}
		}
		return ret;
    } 
}