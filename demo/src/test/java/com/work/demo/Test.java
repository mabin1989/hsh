package com.work.demo;

import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Test {

	public static void main(String args[]){
		//postMethod();
		int days=0;
		Calendar calendar = Calendar.getInstance();
		  calendar.set(Calendar.YEAR, Integer.parseInt("2016-02".substring(0, 4)));
		  calendar.set(Calendar.MONTH, Integer.parseInt("2016-02".substring(5, 7))-1);
		  days= calendar.getActualMaximum(Calendar.DATE);
		  System.out.println(calendar);
		  System.out.println(days);
	}
	
	public static void postMethod() {
		String SendUrl = "https://nnfpdev.jss.com.cn/shop/buyer/allow/ecOd/queryElectricKp.action";
		String order = "{\"identity\":\"93363DCC6064869708F1F3C72A0CE72A713A9D425CD50CDE\",\"fpqqlsh\":[\"20170104160449979446\"]}";
		order = DESDZFP.encrypt(order);
		HttpClient httpclient = null;
		PostMethod post = null;
		try {
			httpclient = new HttpClient();
			post = new PostMethod(SendUrl);
			// 设置编码方式
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			// 添加参数
			post.addParameter("order", order);
			// 执行
			httpclient.executeMethod(post);
			// 接口返回信息
			String info = new String(post.getResponseBody(), "UTF-8");
			System.out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接，释放资源
			post.releaseConnection();
			((SimpleHttpConnectionManager) httpclient.getHttpConnectionManager()).shutdown();
		}
	}
}
