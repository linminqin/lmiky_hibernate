package com.lmiky.jdp.logger.model;

/**
 * 操作类别
 * @author lmiky
 * @date 2014年7月15日 下午10:16:19
 */
public class OperateType {
	//通用
	public static final String OPE_TYPE_ADD = "add";
	public static final String OPE_TYPE_UPDATE = "update";
	public static final String OPE_TYPE_DELETE = "delete";
	public static final String OPE_TYPE_BATCHDELETE = "batchdelete";
	public static final String OPE_TYPE_SORT = "sort";	//排序
	public static final String OPE_TYPE_LOGIN = "login";
	public static final String OPE_TYPE_LOGOUT = "logout";
	
	//内容管理
	public static final String OPE_TYPE_CMS_RESOURCE_PUBLISH = "cms_resource_publish";	//文章发布
	public static final String OPE_TYPE_CMS_RESOURCE_UNPUBLISH = "cms_resource_unpublish";	//取消文章发布
}
