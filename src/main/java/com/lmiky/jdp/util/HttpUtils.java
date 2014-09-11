package com.lmiky.jdp.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import com.lmiky.jdp.logger.util.LoggerUtils;

/**
 * HTTP请求工具
 * @author lmiky
 * @date 2013-11-17
 */
public class HttpUtils {
	// 编码
	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_GBK = "GBK";
	public static final String CHARSET_GB2312 = "GB2312";
	public static final String CHARSET_DEFAULT = CHARSET_UTF8;

	/**
	 * 请求反馈处理类
	 * @author lmiky
	 * @date 2014-8-7 下午2:51:15
	 */
	static class HttpResponseHandler implements ResponseHandler<String> {

		/*
		 * (non-Javadoc)
		 * @see org.apache.http.client.ResponseHandler#handleResponse(org.apache.http.HttpResponse)
		 */
		@Override
		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity entity = response.getEntity();
				return entity != null ? EntityUtils.toString(entity, CHARSET_DEFAULT) : null;
			} else {
				throw new ClientProtocolException("Unexpected response status: " + status);
			}
		}
	}

	/**
	 * 创建连接客户端
	 * @author lmiky
	 * @date 2014-8-7 上午11:07:10
	 * @return
	 */
	private static CloseableHttpClient createDefaultClient() {
		return HttpClients.createDefault();
	}

	/**
	 * 关闭连接
	 * @author lmiky
	 * @date 2014-8-7 上午11:07:04
	 * @param httpRequestBase
	 * @param httpClient
	 */
	private static void close(HttpRequestBase httpRequestBase, HttpClient httpClient) {
		// if(httpRequestBase != null) {
		// httpRequestBase.releaseConnection();
		// }
		if (httpClient != null) {
			try {
				if (httpClient instanceof CloseableHttpClient) {
					((CloseableHttpClient) httpClient).close();
				}
			} catch (IOException e) {
				LoggerUtils.logException(e);
			}
		}
	}

	/**
	 * 执行请求
	 * @author lmiky
	 * @date 2014-8-7 下午2:27:42
	 * @param httpRequestBase
	 * @return
	 */
	private static String execute(HttpRequestBase httpRequestBase) {
		CloseableHttpClient httpClient = (CloseableHttpClient) createDefaultClient();
		try {
			// 构建请求内容
			return httpClient.execute(httpRequestBase, new HttpResponseHandler());
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtils.logException(e);
			return null;
		} finally {
			// 关闭资源
			close(httpRequestBase, httpClient);
		}
	}

	/**
	 * 构建参数列表
	 * @author lmiky
	 * @date 2014-8-7 下午3:17:06
	 * @param params
	 * @return
	 */
	private static List<NameValuePair> getParamsList(Map<String, String> params) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (CollectionUtils.isEmpty(params)) {
			return nvps;
		}
		for (Map.Entry<String, String> map : params.entrySet()) {
			nvps.add(new BasicNameValuePair(map.getKey(), map.getValue()));
		}
		return nvps;
	}

	/**
	 * 方读取网址内容
	 * @author lmiky
	 * @date 2013-11-17
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String get(String url) {
		return get(url, null, null);
	}

	/**
	 * get
	 * @author lmiky
	 * @date 2014-8-7 下午3:13:45
	 * @param url
	 * @param params
	 * @return
	 */
	public static String get(String url, Map<String, String> params) {
		return get(url, params, null);
	}

	/**
	 * get
	 * @author lmiky
	 * @date 2014-8-7 下午3:14:26
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String get(String url, Map<String, String> params, String charset) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		// 设置编码
		if (StringUtils.isBlank(charset)) {
			charset = CHARSET_DEFAULT;
		}
		// 构建参数
		List<NameValuePair> nvps = getParamsList(params);
		if (!CollectionUtils.isEmpty(nvps)) {
			String formatParams = URLEncodedUtils.format(nvps, charset);
			if (url.indexOf("?") < 0) {
				url = url + "?" + formatParams;
			} else {
				url = url + "&" + formatParams;
			}
		}
		HttpGet httpGet = new HttpGet(url);
		return execute(httpGet);
	}

	/**
	 * post
	 * @author lmiky
	 * @date 2014-8-7 下午3:23:38
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(String url, Map<String, String> params) {
		return post(url, params, null);
	}

	/**
	 * post
	 * @author lmiky
	 * @date 2014-8-7 下午3:23:43
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String post(String url, Map<String, String> params, String charset) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		// 设置编码
		if (StringUtils.isBlank(charset)) {
			charset = CHARSET_DEFAULT;
		}
		try {
			// 模拟表单
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(formEntity);
			return execute(httpPost);
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.logException(e);
			return null;
		}
	}

	/**
	 * 启用默认的编码post内容体
	 * @author lmiky
	 * @date 2014-8-7 上午11:10:00
	 * @param url
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String content) throws Exception {
		return post(url, CHARSET_DEFAULT, content);
	}

	/**
	 * post内容体
	 * @author lmiky
	 * @date 2014-8-7 上午11:09:50
	 * @param url
	 * @param charset
	 * @param content
	 * @return
	 */
	public static String post(String url, String charset, String content) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		try {
			HttpPost httpPost = new HttpPost(url);
			// 构建请求内容
			StringEntity entity = new StringEntity(content, StringUtils.isBlank(charset) ? CHARSET_DEFAULT : charset);
			httpPost.setEntity(entity);
			return execute(httpPost);
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.logException(e);
			return null;
		}
	}

	/**
	 * 以将文件写入流的方式传输文件
	 * @author lmiky
	 * @date 2014-8-7 下午2:31:16
	 * @param url
	 * @param file
	 * @return
	 */
	public static String postFile(String url, File file) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		if(file == null) {
			return null;
		}
		HttpPost httpPost = new HttpPost(url);
		// 构建请求内容
		// InputStreamEntity reqEntity = new InputStreamEntity(new FileInputStream(file), -1, ContentType.APPLICATION_OCTET_STREAM); //-1表示未知文件大小
		// reqEntity.setChunked(true);
		FileEntity fileEntity = new FileEntity(file, ContentType.DEFAULT_BINARY);
		fileEntity.setChunked(true);
		httpPost.setEntity(fileEntity);
		return execute(httpPost);
	}

	/**
	 * 模拟表单，以key-value的方式传输文件
	 * @author lmiky
	 * @date 2014-8-7 下午3:35:58
	 * @param url
	 * @param file
	 * @param httpKey
	 * @return
	 */
	public static String postFile(String url, File file, String httpKey) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		if(file == null) {
			return null;
		}
		HttpPost httpPost = new HttpPost(url);
		//构建表单字段
		FileBody bin = new FileBody(file);
		HttpEntity reqEntity = MultipartEntityBuilder.create().addPart(httpKey, bin).build();
		httpPost.setEntity(reqEntity);
		return execute(httpPost);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(get("http://www.baidu.com/"));
		String data = "backEndUrl=http%3A%2F%2F218.17.162.151%3A8081%2Fopetv-queen%2Fapi%2FaccountPayList%2Fchinapay%2Fumpm%2Fnotify.do&charset=UTF-8&merId=898440348120476&orderAmount=10&orderCurrency=156&orderDescription=100030%E4%BA%8E2014%2F08%2F07+10%3A22%3A41%E7%94%B3%E8%AF%B7%E7%BC%B4%E8%B4%B9%E5%85%85%E5%80%BC&orderNumber=1408071022010212&orderTime=20140807102241&signMethod=MD5&signature=1bf1024473b7aee7db5ed2afe30fd824&transType=01&version=1.0.0";
		String respString = post("https://mgate.unionpay.com/gateway/merchant/trade", data);
		System.out.println(respString);
		File file = new File("d:/13617.jpg");
		System.out.println(postFile("http://localhost:8080/lmiky/file/upload.shtml", file, "file"));
	}
}
