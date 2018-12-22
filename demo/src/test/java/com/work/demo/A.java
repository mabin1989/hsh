package com.work.demo;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class A {
	public static void main(String[] args) throws Exception {
		post("3","1","3");
			

	}
	
	 public static void post(String MeterAddr ,String ReadType,String MeterType) throws Exception{
	        /**HttpClient访问网络的实现步骤：
	         *  1. 准备一个请求客户端:浏览器 
	         *  2. 准备请求方式： GET 、POST
	         *  3. 设置要传递的参数
	         *  4.执行请求
	         *  5. 获取结果
	         */
	        HttpClient client=new HttpClient();
	        PostMethod postMethod=new PostMethod("http://192.168.1.8:5012/Service/WebService.asmx/ReadMeter");
	        //3.设置请求参数
	        postMethod.setParameter("MeterAddr", MeterAddr);
	        postMethod.setParameter("ReadType", ReadType);
	        postMethod.setParameter("MeterType", MeterType);
	        //4.执行请求 ,结果码
	        int code=client.executeMethod(postMethod);
	        //5. 获取结果
	        String result=postMethod.getResponseBodyAsString();
	        System.out.println("Post请求的结果："+result);
	    }

}
