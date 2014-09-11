package com.lmiky.jdp.util;

import java.util.ResourceBundle;


import com.lmiky.jdp.constants.Constants;

/**
 * 资源文件工具栏
 * @author lmiky
 * @date 2013-4-16
 */ 
public class PropertiesUtils {
	
	/**
     * @author lmiky
     * @date 2013-4-16
     * @param file 资源文件
     * @param bundleKey
     * @return
     */
    public static String getStringValue(String file, String key) {
        return ResourceBundle.getBundle(file).getString(key);
    }
	
    /**
     * @author lmiky
     * @date 2013-4-16
     * @param file
     * @param key
     * @return
     */
    public static int getIntValue(String file, String key) {
        return Integer.parseInt(getStringValue(file, key));
    }

    /**
     * @author lmiky
     * @date 2013-4-16
     * @param file
     * @param key
     * @return
     */
    public static long getLongValue(String file, String key) {
        return Long.parseLong(getStringValue(file, key));
    }

    /**
     * @author lmiky
     * @date 2013-4-16
     * @param file
     * @param key
     * @return
     */
    public static float getFloatValue(String file, String key) {
        return Float.parseFloat(getStringValue(file, key));
    }

    /**
     * @author lmiky
     * @date 2013-4-16
     * @param file
     * @param key
     * @return
     */
    public static double getDoubleValue(String file, String key) {
        return Double.parseDouble(getStringValue(file, key));
    }

    /**
     * @author lmiky
     * @date 2013-10-18
     * @param file
     * @param key
     * @return
     */
    public static boolean getBooleanValue(String file, String key) {
        return Boolean.parseBoolean(getStringValue(file, key));
    }
    
    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-4-16
     * @param key
     * @return
     */
    public static int getIntContextValue(String key) {
        return getIntValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }

    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-4-16
     * @param key
     * @return
     */
    public static long getLongContextValue(String key) {
        return getLongValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }

    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-4-16
     * @param key
     * @return
     */
    public static float getFloatContextValue(String key) {
        return getFloatValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }
    
    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-4-16
     * @param key
     * @return
     */
    public static double getDoubleContextValue(String key) {
        return getDoubleValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }

    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-4-16
     * @param key
     * @return
     */
    public static String getStringContextValue(String key) {
        return getStringValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }
    
    /**
     * 获取环境配置文件
     * @author lmiky
     * @date 2013-10-18
     * @param key
     * @return
     */
    public static boolean getBooleanContextValue(String key) {
        return getBooleanValue(Constants.PROPERTIES_KEY_CONTEXT_FILE, key);
    }

}
